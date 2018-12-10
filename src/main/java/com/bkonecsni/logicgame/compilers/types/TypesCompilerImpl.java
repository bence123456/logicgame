package com.bkonecsni.logicgame.compilers.types;

import com.bkonecsni.logicgame.visitors.GameDefinition;
import com.bkonecsni.logicgame.compilers.util.StatementListCompilerUtil;
import com.bkonecsni.logicgame.visitors.types.ComplexTypesVisitor;
import com.bkonecsni.logicgame.visitors.types.TypesVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import statementlist.statementListParser.*;
import types.typesLexer;
import types.typesParser;
import types.typesParser.TypesContext;

import java.util.Map;

public class TypesCompilerImpl implements TypesCompiler {

    @Override
    public Map<String, String> compile(CharStream input, GameDefinition gameDefinition) {
        TypesContext typesContext = parseTypes(input);
        TypesVisitor typesVisitor = new TypesVisitor(gameDefinition);

        return typesVisitor.visitTypes(typesContext);
    }

    @Override
    public String compile(CharStream input, GameDefinition gameDefinition, String typeName) {
        StatementListContext statementListContext = StatementListCompilerUtil.parseStatementList(input);
        ComplexTypesVisitor complexTypesVisitor = new ComplexTypesVisitor(gameDefinition);

        return complexTypesVisitor.createComplexTypeJavaCode(typeName, statementListContext);
    }

    private TypesContext parseTypes(CharStream typesInput) {
        typesLexer typesLexer = new typesLexer(typesInput);
        CommonTokenStream typesTokens = new CommonTokenStream(typesLexer);
        typesParser typesParser = new typesParser(typesTokens);

        return typesParser.types();
    }
}
