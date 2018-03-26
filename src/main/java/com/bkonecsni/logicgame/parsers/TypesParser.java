package com.bkonecsni.logicgame.parsers;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.visitors.TypesVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import types.typesLexer;
import types.typesParser;
import types.typesParser.TypesContext;

public class TypesParser implements Parser {

    @Override
    public String parse(CharStream input, GameDefinition gameDefinition) {
        TypesContext typesContext = getTypesContext(input);
        TypesVisitor typesVisitor = new TypesVisitor(gameDefinition);

        return typesVisitor.visitTypes(typesContext);
    }

    private TypesContext getTypesContext(CharStream typesInput) {
        typesLexer typesLexer = new typesLexer(typesInput);
        CommonTokenStream typesTokens = new CommonTokenStream(typesLexer);
        typesParser typesParser = new typesParser(typesTokens);

        return typesParser.types();
    }
}
