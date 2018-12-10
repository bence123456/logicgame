package com.bkonecsni.logicgame.visitors.validation;

import com.bkonecsni.logicgame.visitors.GameDefinition;
import com.bkonecsni.logicgame.visitors.util.VisitorUtil;
import org.apache.commons.lang3.StringUtils;

public class ValidationClassCodeCreator {

    String createJavaClassCode(String statements, GameDefinition gameDefinition) {
        StringBuilder sb = new StringBuilder();

        String gameName = gameDefinition.getGameName();
        sb.append(VisitorUtil.BASE_PACKAGE + gameName + ".validation;");
        appendImport(sb);
        sb.append("public class " + StringUtils.capitalize(gameName) + "Validation extends ValidationBase {");

        sb.append("public boolean areWinConditionsApply(LevelBase map) {");
        sb.append(statements + "}}");

        String formattedValidationJavaCode = VisitorUtil.formatJavaCode(sb.toString());

        return formattedValidationJavaCode;
    }

    private void appendImport(StringBuilder sb) {
        sb.append("import com.bkonecsni.logicgame.domain.common.Item;" +
                "import com.bkonecsni.logicgame.domain.map.LevelBase;" +
                "import com.bkonecsni.logicgame.domain.map.TileBase;" +
                "import com.bkonecsni.logicgame.domain.validation.ValidationBase;" +
                "import java.util.ArrayList;" +
                "import java.util.List;"
        );
    }
}
