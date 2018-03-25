package com.bkonecsni.logicgame.parsers;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.domain.types.Type;
import com.bkonecsni.logicgame.domain.types.TypeStatement;
import com.bkonecsni.logicgame.exceptions.TypeAlreadyDefinedException;
import com.bkonecsni.logicgame.visitors.TypesVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import types.typesLexer;
import types.typesParser;
import types.typesParser.LoopContext;
import types.typesParser.TypedeclContext;
import types.typesParser.TypedefContext;
import types.typesParser.TypesContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TypesParser implements Parser {

    @Override
    public void parse(CharStream input, GameDefinition gameDefinition) {
        TypesContext typesContext = getTypesContext(input);
        TypesVisitor typesVisitor = new TypesVisitor(gameDefinition);

        Map<String, String> typesMap = gameDefinition.getTypesMap();
        typesMap.put("Type0", "");    // border, unmutable types

        parseTypes(typesContext, typesMap, typesVisitor);
    }

    private void parseTypes(TypesContext typesContext, Map<String, String> typesMap, TypesVisitor typesVisitor) {
        for (TypedeclContext typedeclContext : typesContext.typedecl()) {
            String typeName = "Type" + typedeclContext.typehead().NUMBER().getText();
            if (typesMap.containsKey(typeName)) {
                throw new TypeAlreadyDefinedException(typeName);
            }

            TypedefContext typedefContext = typedeclContext.typedef();
            LoopContext loopContext = typedefContext.loop();
//            List<TypeStatement> typeStatementList = (loopContext != null) ? typesVisitor.visitLoop(loopContext) : typesVisitor.visitTypedef(typedefContext);

            String typeActCode = typesVisitor.visitTypedef(typedefContext);
            typesMap.put(typeName, typeActCode);
        }
    }

    private TypesContext getTypesContext(CharStream typesInput) {
        typesLexer typesLexer = new typesLexer(typesInput);
        CommonTokenStream typesTokens = new CommonTokenStream(typesLexer);
        typesParser typesParser = new typesParser(typesTokens);
        return typesParser.types();
    }
}
