package com.bkonecsni.logicgame.runner;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.exceptions.NoSuchImageException;
import com.bkonecsni.logicgame.parsers.MapParserImpl;
import com.bkonecsni.logicgame.parsers.SymbolsParser;
import com.bkonecsni.logicgame.parsers.TypesParser;
import com.bkonecsni.logicgame.parsers.ValidationParser;
import net.openhft.compiler.CachedCompiler;
import net.openhft.compiler.CompilerUtils;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class LogicGame {

    private SymbolsParser symbolsParser = new SymbolsParser();
    private TypesParser typesParser = new TypesParser();
    private MapParserImpl mapParserImpl = new MapParserImpl();
    private ValidationParser validationParser = new ValidationParser();

    public List<GameDefinition> parse() throws Exception {
        List<GameDefinition> gameDefinitions = new ArrayList<>();
        Map<String, Integer> gameLevelNumberMap = createGameLevelNumberMapFromProperty();

        for (String gameName : gameLevelNumberMap.keySet()) {
            GameDefinition gameDefinition = new GameDefinition();
            String fileUrlPrefixForGame = "games/" + gameName + "/" + gameName;

            CharStream symbolsInput = CharStreams.fromFileName(fileUrlPrefixForGame + "_symbols.txt");
            symbolsParser.parse(symbolsInput, gameDefinition);

            CharStream typesInput = CharStreams.fromFileName(fileUrlPrefixForGame + "_types.txt");
            String typesCode = typesParser.parse(typesInput, gameDefinition);

            StringBuilder sb = new StringBuilder();
            sb.append("package games." + gameName + ";\n\n");
            appendImports(sb);
            sb.append(typesCode);

            parseMaps(gameLevelNumberMap, gameName, gameDefinition, sb);

            PrintWriter out = null;
            try {
                out = new PrintWriter("generated/games/"+ gameName +"/"+ gameName +".java");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            out.println(sb.toString());
            out.close();

            CharStream validationInput = CharStreams.fromFileName(fileUrlPrefixForGame + "_validation.txt");
            validationParser.parse(validationInput, gameDefinition);

            for (int i=0; i<10; i++) {
                ImageIcon imageIcon = getImageScaledIcon(i);
                gameDefinition.getNumberIconMap().put(i, imageIcon);
            }

            gameDefinitions.add(gameDefinition);
        }

        return gameDefinitions;
    }

    private void parseMaps(Map<String, Integer> gameLevelNumberMap, String gameName, GameDefinition gameDefinition, StringBuilder sb) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Integer mumberOfMaps = gameLevelNumberMap.get(gameName);

        for (int i=1; i <= mumberOfMaps; i++) {
            String actualLevel = "level" + i;
            String className = "Level_" + i;
            CharStream mapInput = CharStreams.fromFileName("games/" + gameName + "/maps/" + gameName + "_" + actualLevel + ".txt");

            String levelCode = "class " + className + " extends LevelBase {\n\n" + mapParserImpl.parse(mapInput, gameDefinition) + "}\n\n";
            sb.append(levelCode);

//            Class aClass = CompilerUtils.CACHED_COMPILER.loadFromJava(className, levelCode);
//            CachedCompiler cc = new CachedCompiler();
//            Runnable runner = (Runnable) aClass.newInstance();
//            runner.run();

            LevelBase level = null;//(LevelBase) Class.forName("Level_"+i).newInstance(); //level.init();
            gameDefinition.getMaps().put(actualLevel, level);
        }
    }

    private Map<String, Integer> createGameLevelNumberMapFromProperty() throws IOException {
        Map<String, Integer> gameLevelNumberMap = new HashMap<>();
        Properties properties = getLoadedProperties();
        String games = properties.getProperty("games");

        List<String> gameList = Arrays.asList(games.split(","));
        for (String game : gameList) {
            String[] gameProperty = game.split(":");
            String gameName = gameProperty[0];
            Integer numberOfMaps = Integer.valueOf(gameProperty[1]);

            gameLevelNumberMap.put(gameName, numberOfMaps);
        }

        return gameLevelNumberMap;
    }

    private Properties getLoadedProperties() throws IOException {
        Properties properties = new Properties();
        InputStream input = new FileInputStream("src/main/resources/games.properties");
        properties.load(input);
        return properties;
    }

    private ImageIcon getImageScaledIcon(int number) {
        Image image;
        String path = "src/main/resources/images/numbers/"+ number + ".png";

        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new NoSuchImageException(path);
        }

        Image scaledImage = image.getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING);
        return new ImageIcon(scaledImage);
    }

    private void appendImports(StringBuilder sb) {
        sb.append("import com.bkonecsni.logicgame.domain.common.Item;\n" +
                "import com.bkonecsni.logicgame.domain.map.TileBase;\n" +
                "import com.bkonecsni.logicgame.domain.map.LevelBase;\n" +
                "import com.bkonecsni.logicgame.domain.map.UnMutableTile;\n\n" +
                "import java.awt.Point;\n" +
                "import java.awt.Color;\n" +
                "import java.util.List;\n" +
                "import java.util.Arrays;\n\n");
    }
}
