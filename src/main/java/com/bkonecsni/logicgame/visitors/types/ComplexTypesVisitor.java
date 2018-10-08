package com.bkonecsni.logicgame.visitors.types;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.exceptions.InvalidReturnStatementUsageException;
import com.bkonecsni.logicgame.exceptions.TypeAlreadyDefinedException;
import com.bkonecsni.logicgame.visitors.statementlist.CommonStatementListVisitor;
import com.bkonecsni.logicgame.visitors.statementlist.SupportedType;
import com.bkonecsni.logicgame.visitors.util.VisitorUtil;
import statementlist.statementListParser.*;

import java.util.Map;
import java.util.Set;

public class ComplexTypesVisitor extends CommonStatementListVisitor {

    private TypesClassCodeCreator codeCreator;

    public ComplexTypesVisitor(GameDefinition gameDefinition) {
        super(gameDefinition);
        codeCreator = new TypesClassCodeCreator(gameDefinition);
    }

    public String createComplexTypeJavaCode(String typeName, StatementListContext statementListContext) {
        handleDefinedTypes(typeName);
        putItemListAndThisAsDefinedVariable();

        String handleStateCode = visitStatementList(statementListContext);
        String complexTileClassCode = codeCreator.createComplexTileClassCode(typeName + "Tile", handleStateCode);

        return VisitorUtil.formatJavaCode(complexTileClassCode);
    }

    @Override
    public String visitStatementList(StatementListContext statementListContext) {
        putItemListAndThisAsDefinedVariable();

        return visitStatements(statementListContext);
    }

    @Override
    public String visitReturnStatement(ReturnStatementContext ctx) {
        throw new InvalidReturnStatementUsageException();
    }

    private void putItemListAndThisAsDefinedVariable() {
        Map<String, SupportedType> definedVariablesTypeMap = helper.getDefinedVariablesTypeMap();
        definedVariablesTypeMap.put("itemList", SupportedType.LIST);
        definedVariablesTypeMap.put("this", SupportedType.TILE);
    }

    private void handleDefinedTypes(String typeName) {
        Set<String> definedTypes = gameDefinition.getDefinedTypes();

        if (definedTypes.contains(typeName)) {
            throw new TypeAlreadyDefinedException(typeName);
        }

        definedTypes.add(typeName);
    }
}
