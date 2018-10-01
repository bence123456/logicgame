package com.bkonecsni.logicgame.parsers.util;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import statementlist.statementListLexer;
import statementlist.statementListParser;
import statementlist.statementListParser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class StatementListParserUtil {

    public static StatementListContext getStatementListContext(CharStream statementListInput) {
        statementListLexer statementListLexer = new statementListLexer(statementListInput);
        statementListLexer.reset();
        CommonTokenStream statementListTokens = new CommonTokenStream(statementListLexer);
        statementListParser statementListParser = new statementListParser(statementListTokens);

        return statementListParser.statementList();
    }

    public static StatementListContext getStatementListContext(String statementListInput) {
        InputStream stream = new ByteArrayInputStream(statementListInput.getBytes(StandardCharsets.UTF_8));

        CharStream charStream = null;
        try {
            charStream = CharStreams.fromStream(stream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return getStatementListContext(charStream);
    }
}
