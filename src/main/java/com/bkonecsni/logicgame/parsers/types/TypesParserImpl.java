package com.bkonecsni.logicgame.parsers.types;

import com.bkonecsni.logicgame.visitors.GameDefinition;
import com.bkonecsni.logicgame.parsers.util.StatementListParserUtil;
import com.bkonecsni.logicgame.visitors.types.ComplexTypesVisitor;
import com.bkonecsni.logicgame.visitors.types.TypesVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import statementlist.statementListParser.*;
import types.typesLexer;
import types.typesParser;
import types.typesParser.TypesContext;

import java.util.Map;

public class TypesParserImpl implements TypesParser {

    @Override
    public Map<String, String> parse(CharStream input, GameDefinition gameDefinition) {
        TypesContext typesContext = getTypesContext(input);
        TypesVisitor typesVisitor = new TypesVisitor(gameDefinition);

        return typesVisitor.visitTypes(typesContext);
    }

    @Override
    public String parse(CharStream input, GameDefinition gameDefinition, String typeName) {
        StatementListContext statementListContext = StatementListParserUtil.getStatementListContext(input);
        ComplexTypesVisitor complexTypesVisitor = new ComplexTypesVisitor(gameDefinition);

        return complexTypesVisitor.createComplexTypeJavaCode(typeName, statementListContext);
    }

    private TypesContext getTypesContext(CharStream typesInput) {
        typesLexer typesLexer = new typesLexer(typesInput);
        CommonTokenStream typesTokens = new CommonTokenStream(typesLexer);
        typesParser typesParser = new typesParser(typesTokens);

        return typesParser.types();
    }
}
