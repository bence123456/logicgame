package com.bkonecsni.logicgame.parsers.validation;

import com.bkonecsni.logicgame.runner.GameDefinition;
import com.bkonecsni.logicgame.parsers.util.StatementListParserUtil;
import com.bkonecsni.logicgame.visitors.validation.ValidationVisitor;
import org.antlr.v4.runtime.CharStream;
import statementlist.statementListParser.*;

public class ValidationParserImpl implements ValidationParser {

    @Override
    public String parse(CharStream input, GameDefinition gameDefinition) {
        StatementListContext validationContext = StatementListParserUtil.getStatementListContext(input);
        ValidationVisitor validationVisitor = new ValidationVisitor(gameDefinition);

        return validationVisitor.visitStatementList(validationContext);
    }
}
