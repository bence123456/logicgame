package com.bkonecsni.logicgame.visitors.types;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.parsers.util.StatementListParserUtil;
import com.bkonecsni.logicgame.visitors.statementlist.CommonStatementListVisitor;
import statementlist.statementListParser.*;

public class TypesClassCodeCreator {

    private GameDefinition gameDefinition;

    private CommonStatementListVisitor statementListVisitor;

    public TypesClassCodeCreator(GameDefinition gameDefinition) {
        this.gameDefinition = gameDefinition;
        statementListVisitor = new CommonStatementListVisitor(gameDefinition);
    }

    public String createTileCodeForCommonPlayableType(String className, String initCode) {
        StringBuilder sb = new StringBuilder();

        appendImportsAndClassHeader(sb, className, "CommonTile", false);
        appendConstructor(sb, className);

        appendOverride(sb);
        sb.append("public void init() {" + initCode + "}}");

        return sb.toString();
    }

    public String createTileCodeForUnMutableType(String className) {
        StringBuilder sb = new StringBuilder();

        appendImportsAndClassHeader(sb, className, "UnMutableTile", true);
        appendConstructor(sb, className);
        sb.append("}");

        return sb.toString();
    }

    public String createComplexTileClassCode(String className, String statementListContext) {
        StringBuilder sb = new StringBuilder();

        appendImportsAndClassHeader(sb, className, "CommonComplexTile", false);
        appendConstructor(sb, className);

        String handleStateCode = createHandleStateCode(statementListContext);
        sb.append("public void handleState(){ " + handleStateCode + "}}");

        return sb.toString();
    }

    private String createHandleStateCode(String statementListContextString) {
        StatementListContext statementListContext = StatementListParserUtil.getStatementListContext(statementListContextString);

        return statementListVisitor.visitStatementList(statementListContext);
    }

    private void appendImportsAndClassHeader(StringBuilder sb, String className, String parentClassName, boolean unMutable) {
        sb.append("package gamecode." + gameDefinition.getGameName() + ".types;");
        appendImports(sb, unMutable);
        sb.append("public class " + className + " extends " + parentClassName + " {");
    }

    private void appendConstructor(StringBuilder sb, String className) {
        sb.append("public " + className +"(Point position, Point size, List<Item> itemList) {" +
                "super(position, size, itemList); }");
    }

    private void appendOverride(StringBuilder sb) {
        sb.append("@Override ");
    }

    private void appendImports(StringBuilder sb, boolean unMutable) {
        String importString = unMutable ? "import com.bkonecsni.logicgame.domain.map.UnMutableTile;" +
                "import com.bkonecsni.logicgame.domain.common.Item;" +
                "import java.awt.Point;" + "import java.util.List;" :

                "import com.bkonecsni.logicgame.domain.common.Item;" +
                        "import com.bkonecsni.logicgame.domain.map.CommonTile;" +
                        "import com.bkonecsni.logicgame.domain.map.CommonComplexTile;" +
                        "import com.bkonecsni.logicgame.domain.types.TypeStatement;" +
                        "import com.bkonecsni.logicgame.domain.types.equation.Condition;" +
                        "import com.bkonecsni.logicgame.domain.types.equation.Update;" +
                        "import java.awt.Color;" + "import java.awt.Point;" +
                        "import java.util.Arrays;" + "import java.util.List;";

        sb.append(importString);
    }
}
