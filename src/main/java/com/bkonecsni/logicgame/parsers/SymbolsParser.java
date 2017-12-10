package com.bkonecsni.logicgame.parsers;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.exceptions.NoSuchImageException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import symbols.symbolsLexer;
import symbols.symbolsParser;
import symbols.symbolsParser.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SymbolsParser extends CommonParser implements Parser {

    @Override
    public void parse(CharStream input, GameDefinition gameDefinition) {
        parseSymbols(input, gameDefinition);
    }

    private void parseSymbols(CharStream symbolsInput, GameDefinition gameDefinition) {
        if (symbolsInput.size() > 10) {
            symbolsLexer symbolsLexer = new symbolsLexer(symbolsInput);
            CommonTokenStream symbolsTokens = new CommonTokenStream(symbolsLexer);
            symbolsParser symbolsParser = new symbolsParser(symbolsTokens);
            SymbolsContext symbolsContext = symbolsParser.symbols();

            for (ParseTree symbolChild : symbolsContext.children) {
                String symbolName = symbolChild.getChild(0).getText();
                String symbolPath = symbolChild.getChild(2).getText();

                ImageIcon imageIcon = getImageScaledIcon(symbolPath);

                gameDefinition.getSymbolsMap().put(symbolName, imageIcon);
            }
        }
    }

    private ImageIcon getImageScaledIcon(String symbolPath) {
        Image image;

        try {
            image = ImageIO.read(new File(symbolPath));
        } catch (IOException e) {
            throw new NoSuchImageException(symbolPath);
        }

        Image scaledImage = image.getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING);
        return new ImageIcon(scaledImage);
    }
}
