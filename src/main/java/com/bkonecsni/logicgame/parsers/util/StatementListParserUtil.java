package com.bkonecsni.logicgame.parsers.util;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import statementlist.statementListLexer;
import statementlist.statementListParser;
import statementlist.statementListParser.*;

public class StatementListParserUtil {

    public static StatementListContext getStatementListContext(CharStream statementListInput) {
        statementListLexer statementListLexer = new statementListLexer(statementListInput);
        statementListLexer.reset();
        CommonTokenStream statementListTokens = new CommonTokenStream(statementListLexer);
        statementListParser statementListParser = new statementListParser(statementListTokens);

        return statementListParser.statementList();
    }
}
