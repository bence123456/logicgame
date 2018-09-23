package com.bkonecsni.logicgame.visitors.validation;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayInputStream;

public class ValidationClassCodeCreator {

    String createValidationClassCode(String statements, GameDefinition gameDefinition) {
        StringBuilder sb = new StringBuilder();

        String gameName = gameDefinition.getGameName();
        sb.append("package gamecode." + gameName + ".validation;");
        appendImport(sb);
        sb.append("public class " + StringUtils.capitalize(gameName) + "Validation extends ValidationBase {");

        sb.append("public boolean areWinConditionsApply() {");
        sb.append(statements + "}}");

        String formattedValidationJavaCode = formatJavaCode(sb);

        return formattedValidationJavaCode;
    }

    private String formatJavaCode(StringBuilder sb) {
        String validationJavaCode = sb.toString();
        CompilationUnit compilationUnit = null;

        try {
            compilationUnit = JavaParser.parse(new ByteArrayInputStream(validationJavaCode.getBytes()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return compilationUnit.toString();
    }

    private void appendImport(StringBuilder sb) {
        sb.append("import com.bkonecsni.logicgame.domain.common.Item;" +
                "import com.bkonecsni.logicgame.domain.map.TileBase;" +
                "import com.bkonecsni.logicgame.domain.validation.ValidationBase;" +
                "import java.awt.Color;" +
                "import java.util.ArrayList;" +
                "import java.util.Arrays;" +
                "import java.util.List;"
        );
    }
}
