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

public class SymbolsParser implements Parser {

    @Override
    public void parse(CharStream input, GameDefinition gameDefinition) {
        if (input.size() > 10) {
            SymbolsContext symbolsContext = getSymbolsContext(input);
            parseSymbols(gameDefinition, symbolsContext);
        }
    }

    private SymbolsContext getSymbolsContext(CharStream symbolsInput) {
        symbolsLexer symbolsLexer = new symbolsLexer(symbolsInput);
        CommonTokenStream symbolsTokens = new CommonTokenStream(symbolsLexer);
        symbolsParser symbolsParser = new symbolsParser(symbolsTokens);
        return symbolsParser.symbols();
    }

    private void parseSymbols(GameDefinition gameDefinition, SymbolsContext symbolsContext) {
        for (SymbolContext symbolContext : symbolsContext.symbol()) {
            String symbolName = symbolContext.SYMBOL().getText();
            String symbolPath = symbolContext.PATH().getText();

            ImageIcon imageIcon = getImageScaledIcon(symbolPath);

            gameDefinition.getSymbolsMap().put(symbolName, imageIcon);
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
