package com.bkonecsni.logicgame.compilers.util;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import statementlist.statementListLexer;
import statementlist.statementListParser;
import statementlist.statementListParser.*;

public class StatementListCompilerUtil {

    public static StatementListContext parseStatementList(CharStream statementListInput) {
        statementListLexer statementListLexer = new statementListLexer(statementListInput);
        statementListLexer.reset();
        CommonTokenStream statementListTokens = new CommonTokenStream(statementListLexer);
        statementListParser statementListParser = new statementListParser(statementListTokens);

        return statementListParser.statementList();
    }
}
