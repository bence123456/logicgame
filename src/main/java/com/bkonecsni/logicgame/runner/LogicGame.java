package com.bkonecsni.logicgame.runner;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.domain.map.CommonComplexTile;
import com.bkonecsni.logicgame.domain.map.LevelBase;
import com.bkonecsni.logicgame.domain.map.TileBase;
import com.bkonecsni.logicgame.domain.validation.ValidationBase;
import com.bkonecsni.logicgame.exceptions.NoSuchImageException;
import com.bkonecsni.logicgame.parsers.map.MapParserImpl;
import com.bkonecsni.logicgame.parsers.symbols.SymbolsParserImpl;
import com.bkonecsni.logicgame.parsers.types.TypesParserImpl;
import com.bkonecsni.logicgame.parsers.validation.ValidationParserImpl;
import net.openhft.compiler.CompilerUtils;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.io.filefilter.PrefixFileFilter;

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

    public List<GameDefinition> createGameDefinitionList() throws Exception {
        List<GameDefinition> gameDefinitions = new ArrayList<>();
        Map<String, Integer> gameLevelNumberMap = createGameLevelNumberMapFromProperty();

        for (String gameName : gameLevelNumberMap.keySet()) {
            GameDefinition gameDefinition = new GameDefinition(gameName);
            String fileUrlPrefixForGame = "games/" + gameName + "/" + gameName;

            parseGame(gameLevelNumberMap, gameName, gameDefinition, fileUrlPrefixForGame);
            defineNumberIconMap(gameDefinition);
            postProcessGameDefinition(gameDefinition);

            gameDefinitions.add(gameDefinition);
        }

        return gameDefinitions;
    }

    private void postProcessGameDefinition(GameDefinition gameDefinition) {
        for (LevelBase map : gameDefinition.getMaps().values()) {
            ValidationBase validationHandler = gameDefinition.getValidationHandler();
            validationHandler.setMap(map);

            for (TileBase tileBase : map.getTileList()) {
                if (tileBase instanceof CommonComplexTile) {
                    CommonComplexTile commonComplexTile = (CommonComplexTile) tileBase;
                    commonComplexTile.setMap(map);
                }
            }
        }
    }

    private void parseGame(Map<String, Integer> gameLevelNumberMap, String gameName, GameDefinition gameDefinition, String fileUrlPrefixForGame) throws Exception {
        parseSymbols(gameDefinition, fileUrlPrefixForGame);
        parseTypes(gameName, gameDefinition, fileUrlPrefixForGame);
        parseAndLoadValidationHandler(gameName, gameDefinition, fileUrlPrefixForGame);
        parseMaps(gameLevelNumberMap, gameName, gameDefinition);
    }

    private void parseSymbols(GameDefinition gameDefinition, String fileUrlPrefixForGame) throws IOException {
        CharStream symbolsInput = CharStreams.fromFileName(fileUrlPrefixForGame + "_symbols.txt");
        symbolsParser.parse(symbolsInput, gameDefinition);
    }

    private void parseTypes(String gameName, GameDefinition gameDefinition, String fileUrlPrefixForGame) throws IOException {
        String directoryName = "src/main/java/gamecode/" + gameName + "/types";

        parseCommonTypes(directoryName, gameDefinition, fileUrlPrefixForGame);
        parseComplexTypes(gameName, gameDefinition, fileUrlPrefixForGame, directoryName);
    }

    private void parseComplexTypes(String gameName, GameDefinition gameDefinition, String fileUrlPrefixForGame, String directoryName) throws IOException {
        File directory = new File(StringUtils.substringBeforeLast(fileUrlPrefixForGame, "/"));
        File[] files = directory.listFiles((FileFilter) new PrefixFileFilter(gameName + "_complex"));
        List<File> complexTypeFiles = Arrays.asList(files);

        for (File complexTypeFile : complexTypeFiles) {
            CharStream complexTypesInput = CharStreams.fromFileName(complexTypeFile.getAbsolutePath());
            String typeName = StringUtils.substringAfterLast(StringUtils.removeEnd(complexTypeFile.getName(), ".txt"), "_");
            String typeCode = typesParser.parse(complexTypesInput, gameDefinition, typeName);

            writeFile(typeCode, directoryName, typeName + "Tile.java");
        }
    }

    private void parseCommonTypes(String directoryName, GameDefinition gameDefinition, String fileUrlPrefixForGame) throws IOException {
        CharStream typesInput = CharStreams.fromFileName(fileUrlPrefixForGame + "_types.txt");
        Map<String, String> typeNameCodeMap = typesParser.parse(typesInput, gameDefinition);

        for (String typeName : typeNameCodeMap.keySet()) {
            String typeCode = typeNameCodeMap.get(typeName);
            String fileName = typeName + "Tile.java";

            writeFile(typeCode, directoryName, fileName);
        }
    }

    private void parseAndLoadValidationHandler(String gameName, GameDefinition gameDefinition, String fileUrlPrefixForGame) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        CharStream validationInput = CharStreams.fromFileName(fileUrlPrefixForGame + "_validation.txt");
        String validationCode = validationParser.parse(validationInput, gameDefinition);
        String directoryName = "src/main/java/gamecode/" + gameName + "/validation";
        String className = StringUtils.capitalize(gameName) + "Validation";
        String fileName = className + ".java";
        writeFile(validationCode, directoryName, fileName);

        Class validationClass = CompilerUtils.CACHED_COMPILER.loadFromJava("gamecode." + gameName + ".validation." + className, validationCode);
        ValidationBase validationHandler = (ValidationBase) validationClass.newInstance();
        gameDefinition.setValidationHandler(validationHandler);
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

    private void defineNumberIconMap(GameDefinition gameDefinition) {
        for (int i=0; i<10; i++) {
            ImageIcon imageIcon = getImageScaledIcon(i);
            gameDefinition.getNumberIconMap().put(i, imageIcon);
        }
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
