package com.bkonecsni.logicgame.visitors.util;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;

import java.io.ByteArrayInputStream;

public class VisitorUtil {

    public static final String BASE_DIR = "com.bkonecsni.logicgame.gamecode.";
    public static final String BASE_PACKAGE = "package " + BASE_DIR;
    public static final String BASE_IMPORT = "import " + BASE_DIR;

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
