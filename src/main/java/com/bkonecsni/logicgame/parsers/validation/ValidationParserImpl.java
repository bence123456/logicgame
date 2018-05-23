package com.bkonecsni.logicgame.parsers.validation;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.visitors.validation.ValidationVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import validation.validationLexer;
import validation.validationParser;
import validation.validationParser.ValidationContext;

public class ValidationParserImpl implements ValidationParser {

    @Override
    public String parse(CharStream input, GameDefinition gameDefinition) {
        ValidationContext validationContext = getValidationContext(input);
        ValidationVisitor validationVisitor = new ValidationVisitor(gameDefinition);

        return validationVisitor.visitValidation(validationContext);
    }

    private ValidationContext getValidationContext(CharStream validationInput) {
        validationLexer validationLexer = new validationLexer(validationInput);
        CommonTokenStream validationTokens = new CommonTokenStream(validationLexer);
        validationParser validationParser = new validationParser(validationTokens);

        return validationParser.validation();
    }
}
