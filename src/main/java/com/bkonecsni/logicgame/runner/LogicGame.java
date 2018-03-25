package com.bkonecsni.logicgame.runner;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.exceptions.NoSuchImageException;
import com.bkonecsni.logicgame.parsers.map.MapParserImpl;
import com.bkonecsni.logicgame.parsers.SymbolsParser;
import com.bkonecsni.logicgame.parsers.TypesParser;
import com.bkonecsni.logicgame.parsers.ValidationParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.List;

public class LogicGame {

    private SymbolsParser symbolsParser = new SymbolsParser();
    private TypesParser typesParser = new TypesParser();
    private MapParserImpl mapParserImpl = new MapParserImpl();
    private ValidationParser validationParser = new ValidationParser();

    public List<GameDefinition> parse() throws IOException {
        List<GameDefinition> gameDefinitions = new ArrayList<>();
        Map<String, Integer> gameLevelNumberMap = createGameLevelNumberMapFromProperty();

        for (String gameName : gameLevelNumberMap.keySet()) {
            GameDefinition gameDefinition = new GameDefinition();
            String fileUrlPrefixForGame = "games/" + gameName + "/" + gameName;

            CharStream symbolsInput = CharStreams.fromFileName(fileUrlPrefixForGame + "_symbols.txt");
            symbolsParser.parse(symbolsInput, gameDefinition);

            CharStream typesInput = CharStreams.fromFileName(fileUrlPrefixForGame + "_types.txt");
            typesParser.parse(typesInput, gameDefinition);

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

    private void parseMaps(Map<String, Integer> gameLevelNumberMap, String gameName, GameDefinition gameDefinition) throws IOException {
        Integer mumberOfMaps = gameLevelNumberMap.get(gameName);
        for (int i=1; i <= mumberOfMaps; i++) {
            String actualLevel = "level" + i;
            CharStream mapInput = CharStreams.fromFileName("games/" + gameName + "/maps/" + gameName + "_" + actualLevel + ".txt");
            mapParserImpl.parse(mapInput, gameDefinition, actualLevel, gameName);
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
