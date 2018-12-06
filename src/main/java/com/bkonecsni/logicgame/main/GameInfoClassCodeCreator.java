package com.bkonecsni.logicgame.main;

import com.bkonecsni.logicgame.visitors.util.VisitorUtil;
import org.apache.commons.lang3.StringUtils;

public class GameInfoClassCodeCreator {

    public String createClassCode(String gameName, String initCode, String importCode) {
        StringBuilder sb = new StringBuilder();
        appendPackage(sb, gameName);
        appendInitialImport(sb);

        sb.append(importCode);
        sb.append("public class " + StringUtils.capitalize(gameName) + "GameInfo extends AbstractGameInfo {");
        appendInitCode(sb, initCode, gameName);

        sb.append("}");

        return VisitorUtil.formatJavaCode(sb.toString());
    }

    public void appendPackage(StringBuilder sb, String gameName) {
        sb.append(VisitorUtil.BASE_PACKAGE + gameName + ";");
    }

    public void appendInitCode(StringBuilder sb, String initCode, String gameName) {
        sb.append("public void init() {");
        sb.append("gameName = \"" + gameName + "\";");
        sb.append(initCode);
        sb.append("postProcessGameDefinition();");
        sb.append("}");
    }

    public void appendInitialImport(StringBuilder sb) {
        sb.append("import com.bkonecsni.logicgame.domain.common.AbstractGameInfo;" +
                    "import java.util.Arrays;"
        );
    }


}
