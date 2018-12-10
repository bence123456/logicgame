package com.bkonecsni.logicgame.main;

import com.bkonecsni.logicgame.parsers.map.MapParserImpl;
import com.bkonecsni.logicgame.parsers.symbols.SymbolsParserImpl;
import com.bkonecsni.logicgame.parsers.types.TypesParserImpl;
import com.bkonecsni.logicgame.parsers.validation.ValidationParserImpl;
import com.bkonecsni.logicgame.visitors.GameDefinition;
import com.bkonecsni.logicgame.visitors.util.VisitorUtil;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.io.filefilter.PrefixFileFilter;

import java.io.*;
import java.util.*;
import java.util.List;

public class LogicGame {

    private SymbolsParserImpl symbolsParser = new SymbolsParserImpl();
    private TypesParserImpl typesParser = new TypesParserImpl();
    private MapParserImpl mapParserImpl = new MapParserImpl();
    private ValidationParserImpl validationParser = new ValidationParserImpl();
    private GameInfoClassCodeCreator gameInfoClassCodeCreator = new GameInfoClassCodeCreator();

    private static final String COMMON_DIR_PATH = "src/main/java/com/bkonecsni/logicgame/gamecode/";

    public void createGameInfoList() throws Exception {
        Map<String, Integer> gameLevelNrMap = createGameLevelNrMapFromProperty();

        for (String gameName : gameLevelNrMap.keySet()) {
            StringBuilder initCodeSb = new StringBuilder();
            StringBuilder importCodeSb = new StringBuilder();

            GameDefinition gameDefinition = new GameDefinition(gameName);
            String urlPrefix = "games/" + gameName + "/" + gameName;

            compileGame(gameLevelNrMap, gameName, gameDefinition, urlPrefix, initCodeSb, importCodeSb);
            writeGameInfoJavaFile(gameName, initCodeSb, importCodeSb);
        }
    }

    private void writeGameInfoJavaFile(String gameName, StringBuilder initCodeBuilder, StringBuilder importCodeBuilder) {
        String directoryName = COMMON_DIR_PATH + gameName;
        String className = StringUtils.capitalize(gameName) + "GameInfo";
        String fileName = className + ".java";
        String gameInfoCode = gameInfoClassCodeCreator.createClassCode(gameName, initCodeBuilder.toString(), importCodeBuilder.toString());

        writeFile(gameInfoCode, directoryName, fileName);
    }

    private void compileGame(Map<String, Integer> gameLevelNumberMap, String gameName, GameDefinition gameDefinition, String fileUrlPrefixForGame, StringBuilder initCodeBuilder, StringBuilder importCodeBuilder) throws Exception {
        compileSymbols(gameDefinition, fileUrlPrefixForGame, initCodeBuilder);
        compileTypes(gameName, gameDefinition, fileUrlPrefixForGame);
        compileValidationHandler(gameName, gameDefinition, fileUrlPrefixForGame, initCodeBuilder, importCodeBuilder);
        compileMaps(gameLevelNumberMap, gameName, gameDefinition, initCodeBuilder, importCodeBuilder);
    }

    private void compileSymbols(GameDefinition gameDefinition, String fileUrlPrefixForGame, StringBuilder initCodeBuilder) throws IOException {
        CharStream symbolsInput = CharStreams.fromFileName(fileUrlPrefixForGame + "_symbols.txt");
        symbolsParser.parse(symbolsInput, gameDefinition, initCodeBuilder);
    }

    private void compileTypes(String gameName, GameDefinition gameDefinition, String fileUrlPrefixForGame) throws IOException {
        String directoryName = COMMON_DIR_PATH + gameName + "/types";

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

    private void compileValidationHandler(String gameName, GameDefinition gameDefinition, String fileUrlPrefixForGame,
                                          StringBuilder initCodeBuilder, StringBuilder importCodeBuilder) throws IOException {

        CharStream validationInput = CharStreams.fromFileName(fileUrlPrefixForGame + "_validation.txt");
        String validationCode = validationParser.parse(validationInput, gameDefinition);
        String directoryName = COMMON_DIR_PATH + gameName + "/validation";
        String className = StringUtils.capitalize(gameName) + "Validation";
        String fileName = className + ".java";
        writeFile(validationCode, directoryName, fileName);

        importCodeBuilder.append(VisitorUtil.BASE_IMPORT + gameName + ".validation." + className + ";");
        initCodeBuilder.append("validationHandler = new " + className + "();");
    }

    private void compileMaps(Map<String, Integer> gameLevelNumberMap, String gameName, GameDefinition gameDefinition,
                             StringBuilder initCodeBuilder, StringBuilder importCodeBuilder) throws Exception {
        Integer numberOfMaps = gameLevelNumberMap.get(gameName);
        initCodeBuilder.append("maps = Arrays.asList(");

        for (int i=1; i <= numberOfMaps; i++) {
            String actualLevel = "level" + i;
            String className = "Level" + i;
            CharStream mapInput = CharStreams.fromFileName("games/" + gameName + "/maps/" + gameName + "_" + actualLevel + ".txt");

            String levelCode = mapParserImpl.parse(mapInput, gameDefinition, className);
            String directoryName = COMMON_DIR_PATH + gameName + "/levels";
            writeFile(levelCode, directoryName, className + ".java");

            importCodeBuilder.append(VisitorUtil.BASE_IMPORT + gameName + ".levels." + className + ";");
            String comma = i == numberOfMaps ? "" : ",";
            initCodeBuilder.append("new " + className + "()" + comma );
        }

        initCodeBuilder.append(");");
    }

    private Map<String, Integer> createGameLevelNrMapFromProperty() throws IOException {
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
}
