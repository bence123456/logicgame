package com.bkonecsni.logicgame.runner;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.exceptions.NoSuchImageException;
import com.bkonecsni.logicgame.parsers.map.MapParserImpl;
import com.bkonecsni.logicgame.parsers.symbols.SymbolsParserImpl;
import com.bkonecsni.logicgame.parsers.types.TypesParserImpl;
import com.bkonecsni.logicgame.parsers.validation.ValidationParserImpl;
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

    private SymbolsParserImpl symbolsParser = new SymbolsParserImpl();
    private TypesParserImpl typesParser = new TypesParserImpl();
    private MapParserImpl mapParserImpl = new MapParserImpl();
    private ValidationParserImpl validationParser = new ValidationParserImpl();

    public List<GameDefinition> parse() throws Exception {
        List<GameDefinition> gameDefinitions = new ArrayList<>();
        Map<String, Integer> gameLevelNumberMap = createGameLevelNumberMapFromProperty();

        for (String gameName : gameLevelNumberMap.keySet()) {
            GameDefinition gameDefinition = new GameDefinition(gameName);
            String fileUrlPrefixForGame = "games/" + gameName + "/" + gameName;

            CharStream symbolsInput = CharStreams.fromFileName(fileUrlPrefixForGame + "_symbols.txt");
            symbolsParser.parse(symbolsInput, gameDefinition);

            CharStream typesInput = CharStreams.fromFileName(fileUrlPrefixForGame + "_types.txt");
            Map<String, String> typeNameCodeMap = typesParser.parse(typesInput, gameDefinition);

            for (String typeName : typeNameCodeMap.keySet()) {
                String typeCode = typeNameCodeMap.get(typeName);
                String directoryName = "src/main/java/gamecode/" + gameName + "/types";
                String fileName = typeName + "Tile.java";

                writeFile(typeCode, directoryName, fileName);
            }

            parseMaps(gameLevelNumberMap, gameName, gameDefinition);

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


    private void writeFile(String value, String directoryName, String fileName){
        File directory = new File(directoryName);
        directory.mkdirs();

        File file = new File(directoryName + "/" + fileName);
        try{
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(value);
            bw.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private void parseMaps(Map<String, Integer> gameLevelNumberMap, String gameName, GameDefinition gameDefinition) throws Exception {
        Integer numberOfMaps = gameLevelNumberMap.get(gameName);

        for (int i=1; i <= numberOfMaps; i++) {
            String actualLevel = "level" + i;
            String className = "Level" + i;
            CharStream mapInput = CharStreams.fromFileName("games/" + gameName + "/maps/" + gameName + "_" + actualLevel + ".txt");

            String levelCode = mapParserImpl.parse(mapInput, gameDefinition, className);
            String directoryName = "src/main/java/gamecode/" + gameName + "/levels";
            writeFile(levelCode, directoryName, className + ".java");

            Class levelClass = CompilerUtils.CACHED_COMPILER.loadFromJava("gamecode." + gameName + ".levels." + className, levelCode);
            LevelBase level = (LevelBase) levelClass.newInstance();
            level.init();

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
}
