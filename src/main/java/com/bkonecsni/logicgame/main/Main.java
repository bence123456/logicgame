package com.bkonecsni.logicgame.main;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.map.Map;
import com.bkonecsni.logicgame.domain.map.Tile;
import com.bkonecsni.logicgame.domain.types.BorderType;
import com.bkonecsni.logicgame.domain.types.Type;
import com.bkonecsni.logicgame.domain.types.TypeStatement;
import com.bkonecsni.logicgame.domain.types.Update;
import com.bkonecsni.logicgame.domain.validation.LooseStatement;
import com.bkonecsni.logicgame.domain.validation.Validation;
import com.bkonecsni.logicgame.domain.validation.WinStatement;
import com.sun.javafx.css.Rule;
import map.mapLexer;
import map.mapParser;
import map.mapParser.MapContext;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.apache.commons.lang3.StringUtils;
import symbols.symbolsLexer;
import symbols.symbolsParser;
import symbols.symbolsParser.SymbolsContext;
import types.typesLexer;
import types.typesParser;
import types.typesParser.TypesContext;
import validation.validationLexer;
import validation.validationParser;
import validation.validationParser.ValidationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    private static java.util.Map<String, String> symbolsMap = new HashMap<>();
    //private static List<Symbol> symbolList = new ArrayList<>();

    private static List<Type> typeList = new ArrayList<>();
    private static java.util.Map<String, Type> typesMap = new HashMap<>();

    private static List<Tile> map = new ArrayList<>();

    private static List<WinStatement> winStatementList = new ArrayList<>();
    private static List<LooseStatement> looseStatementList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        CharStream typesInput = CharStreams.fromFileName("games/parks/parks_types.txt");
        CharStream symbolsInput = CharStreams.fromFileName("games/parks/parks_symbols.txt");
        CharStream mapInput = CharStreams.fromFileName("games/parks/maps/parks_level1.txt");
        CharStream validationInput = CharStreams.fromFileName("games/parks/parks_validation.txt");

        parseSymbols(symbolsInput);

        parseTypes(typesInput);



        mapLexer mapLexer = new mapLexer(mapInput);
        CommonTokenStream mapTokens = new CommonTokenStream(mapLexer);
        mapParser mapParser = new mapParser(mapTokens);
        MapContext mapContext = mapParser.map();


        validationLexer validationLexer = new validationLexer(validationInput);
        CommonTokenStream validationTokens = new CommonTokenStream(validationLexer);
        validationParser validationParser = new validationParser(validationTokens);
        ValidationContext validationContext = validationParser.validation();
    }

    private static void parseSymbols(CharStream symbolsInput) {
        symbolsLexer symbolsLexer = new symbolsLexer(symbolsInput);
        CommonTokenStream symbolsTokens = new CommonTokenStream(symbolsLexer);
        symbolsParser symblosParser = new symbolsParser(symbolsTokens);
        SymbolsContext symbolsContext = symblosParser.symbols();

        for (ParseTree symbolChild : symbolsContext.children) {
            String symbolName = symbolChild.getChild(0).getText();
            String symbolPath = symbolChild.getChild(2).getText();
            symbolsMap.put(symbolName, symbolPath);
        }
    }

    private static void parseTypes(CharStream typesInput) {
        typesLexer typesLexer = new typesLexer(typesInput);
        CommonTokenStream typesTokens = new CommonTokenStream(typesLexer);
        typesParser typesParser = new typesParser(typesTokens);
        TypesContext typesContext = typesParser.types();

        typesMap.put("Type0", new BorderType());
        for (ParseTree typeChild : typesContext.children) {
            String typeName = "Type" + typeChild.getChild(0).getChild(1).getText();
            List<TypeStatement> typeStatementList = createTypeStatementList(typeChild.getChild(1));
            Type type = new Type(typeStatementList);
            typesMap.put(typeName, type);
        }
    }

    private static List<TypeStatement> createTypeStatementList(ParseTree typeChild) {
        typesParser.TypedefContext typedefContext = (typesParser.TypedefContext) typeChild;

        List<TypeStatement> typeStatementList = new ArrayList<>();

        for (ParseTree typedef : typedefContext.children) {
            typesParser.TypestatementContext typestatementContext = (typesParser.TypestatementContext) typedef;
            TypeStatement typeStatement = new TypeStatement();

            for (ParseTree statement : typestatementContext.children) {
                if (statement instanceof typesParser.Parens_nrContext) {
                    int comparableItemIndex = Integer.parseInt(statement.getChild(1).getText());
                    typeStatement.setComparableItemIndex(comparableItemIndex);
                }
                if (statement instanceof typesParser.ItemContext) {
                    Item item = createItem(statement.getText());
                    typeStatement.setItemToCompare(item);
                }
                if (statement instanceof typesParser.UpdatestatementContext) {
                    List<Update> updateList = new ArrayList<>();
                    typesParser.UpdatestatementContext updatestatementContext = (typesParser.UpdatestatementContext) statement;

                    Integer itemToUpdateIndex = Integer.valueOf(updatestatementContext.parens_nr().children.get(1).getText());
                    Item newItem = createItem(updatestatementContext.item().getText());
                    Update update = new Update(itemToUpdateIndex, newItem);
                    updateList.add(update);
                    typeStatement.setUpdateList(updateList);
                }
            }
            typeStatementList.add(typeStatement);
        }

        return typeStatementList;
    }

    public static Item createItem(String itemAsString) {
        Item item = null;

        if (StringUtils.isNumeric(itemAsString)) {
            item = new Item(null, Integer.valueOf(itemAsString), null, null);
        } else if(itemAsString.length() == 1) {
            item = new Item(itemAsString.charAt(0), null, null, null);
        } else if(itemAsString.startsWith("S")) {
            item = new Item(null, null, itemAsString, null);
        } else if(itemAsString.startsWith("#")) {
            item = new Item(null, null, null, Integer.parseInt(itemAsString.substring(1), 16));
        }

        return item;
    }

}
