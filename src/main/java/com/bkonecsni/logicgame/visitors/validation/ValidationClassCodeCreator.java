package com.bkonecsni.logicgame.visitors.validation;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import org.apache.commons.lang3.StringUtils;

import static com.bkonecsni.logicgame.visitors.util.VisitorUtil.D_TAB;
import static com.bkonecsni.logicgame.visitors.util.VisitorUtil.TAB;

public class ValidationClassCodeCreator {

    String createValidationClassCode(String statements, GameDefinition gameDefinition) {
        StringBuilder sb = new StringBuilder();

        String gameName = gameDefinition.getGameName();
        sb.append("package gamecode." + gameName + ".validation;\n\n");

        appendImport(sb);
        sb.append("public class " + StringUtils.capitalize(gameName) + "Validation extends ValidationBase {\n\n");
        sb.append(TAB + "public boolean areWinConditionsApply() {\n");

        sb.append(D_TAB + statements + "\n" + TAB + "}\n}");

        return sb.toString();
    }

    private void appendImport(StringBuilder sb) {
        sb.append("import com.bkonecsni.logicgame.domain.common.Item;\n" +
                "import com.bkonecsni.logicgame.domain.map.TileBase;\n" +
                "import com.bkonecsni.logicgame.domain.validation.ValidationBase;\n\n" +
                "import java.awt.Color;\n" +
                "import java.util.ArrayList;\n" +
                "import java.util.Arrays;\n" +
                "import java.util.List;\n"
        );
    }
}
