package com.bkonecsni.logicgame.compilers.validation;

import com.bkonecsni.logicgame.visitors.GameDefinition;
import com.bkonecsni.logicgame.compilers.util.StatementListCompilerUtil;
import com.bkonecsni.logicgame.visitors.validation.ValidationVisitor;
import org.antlr.v4.runtime.CharStream;
import statementlist.statementListParser.*;

public class ValidationCompilerImpl implements ValidationCompiler {

    @Override
    public String compile(CharStream input, GameDefinition gameDefinition) {
        StatementListContext validationContext = StatementListCompilerUtil.parseStatementList(input);
        ValidationVisitor validationVisitor = new ValidationVisitor(gameDefinition);

        return validationVisitor.visitStatementList(validationContext);
    }
}
