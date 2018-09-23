package com.bkonecsni.logicgame.visitors.util;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;

import java.io.ByteArrayInputStream;

public class VisitorUtil {

    public static final String END_BRACE = "}";
    public static final String D_END_BRACE = "}}";

    public static String formatJavaCode(String stringToFormat) {
        CompilationUnit compilationUnit = null;

        try {
            compilationUnit = JavaParser.parse(new ByteArrayInputStream(stringToFormat.getBytes()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return compilationUnit.toString();
    }
}
