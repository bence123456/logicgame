package com.bkonecsni.logicgame.visitors.types;

import com.bkonecsni.logicgame.visitors.GameDefinition;
import com.bkonecsni.logicgame.visitors.statementlist.CommonStatementListVisitor;
import com.bkonecsni.logicgame.visitors.util.VisitorUtil;

public class TypesClassCodeCreator {

    private GameDefinition gameDefinition;

    private CommonStatementListVisitor statementListVisitor;

    public TypesClassCodeCreator(GameDefinition gameDefinition) {
        this.gameDefinition = gameDefinition;
        statementListVisitor = new CommonStatementListVisitor(gameDefinition);
    }

    public String createTileCodeForCommonPlayableType(String className, String initCode) {
        StringBuilder sb = new StringBuilder();

        appendImportsAndClassHeader(sb, className, "CommonTile", TypeVariation.COMMON);
        appendConstructor(sb, className);

        appendOverride(sb);
        sb.append("public void init() {" + initCode + "}}");

        return sb.toString();
    }

    public String createTileCodeForUnMutableType(String className) {
        StringBuilder sb = new StringBuilder();

        appendImportsAndClassHeader(sb, className, "UnMutableTile", TypeVariation.UNMUTABLE);
        appendConstructor(sb, className);
        sb.append("}");

        return sb.toString();
    }

    public String createComplexTileClassCode(String className, String handleStateCode) {
        StringBuilder sb = new StringBuilder();

        appendImportsAndClassHeader(sb, className, "CommonComplexTile", TypeVariation.COMPLEX);
        appendConstructor(sb, className);

        sb.append("public void handleState(){ " + handleStateCode + "}}");

        return sb.toString();
    }

    private void appendImportsAndClassHeader(StringBuilder sb, String className, String parentClassName, TypeVariation typeVariation) {
        sb.append(VisitorUtil.BASE_PACKAGE + gameDefinition.getGameName() + ".types;");
        appendImports(sb, typeVariation);
        sb.append("public class " + className + " extends " + parentClassName + " {");
    }

    private void appendConstructor(StringBuilder sb, String className) {
        sb.append("public " + className +"(Point position, Point size, List<Item> itemList) {" +
                "super(position, size, itemList); }");
    }

    private void appendOverride(StringBuilder sb) {
        sb.append("@Override ");
    }

    private void appendImports(StringBuilder sb, TypeVariation typeVariation) {
        if (TypeVariation.UNMUTABLE.equals(typeVariation)) {
            sb.append("import com.bkonecsni.logicgame.domain.map.UnMutableTile;" +
                    "import com.bkonecsni.logicgame.domain.common.Item;" +
                    "import com.bkonecsni.logicgame.domain.common.Point;" + "import java.util.List;");

        } else if (TypeVariation.COMMON.equals(typeVariation)){
            sb.append("import com.bkonecsni.logicgame.domain.common.Item;" +
                    "import com.bkonecsni.logicgame.domain.common.Point;" +
                    "import com.bkonecsni.logicgame.domain.map.CommonTile;" +
                    "import com.bkonecsni.logicgame.domain.types.TypeStatement;" +
                    "import com.bkonecsni.logicgame.domain.types.equation.Condition;" +
                    "import com.bkonecsni.logicgame.domain.types.equation.Update;" +
                    "import java.util.Arrays;" + "import java.util.List;");

        } else if (TypeVariation.COMPLEX.equals(typeVariation)) {
            sb.append("import com.bkonecsni.logicgame.domain.common.Item;" +
                    "import com.bkonecsni.logicgame.domain.common.Point;" +
                    "import com.bkonecsni.logicgame.domain.map.TileBase;" +
                    "import com.bkonecsni.logicgame.domain.map.CommonComplexTile;" +
                    "import java.util.ArrayList;" + "import java.util.List;");
        }
    }
}
