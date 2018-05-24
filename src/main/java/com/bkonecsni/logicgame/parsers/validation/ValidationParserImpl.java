package com.bkonecsni.logicgame.parsers.validation;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import com.bkonecsni.logicgame.visitors.validation.SimpleValidationVisitor;
import com.bkonecsni.logicgame.visitors.validation.ValidationVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import validation.simple.simple_validationLexer;
import validation.simple.simple_validationParser;
import validation.validationLexer;
import validation.validationParser;
import validation.validationParser.ValidationContext;

public class ValidationParserImpl implements ValidationParser {

    @Override
    public String parse(CharStream input, GameDefinition gameDefinition, boolean simpleValidation) {
        if (simpleValidation) {
            simple_validationParser.ValidationContext validationContext = getSimpleValidationContext(input);
            SimpleValidationVisitor simpleValidationVisitor = new SimpleValidationVisitor(gameDefinition);

            return simpleValidationVisitor.visitValidation(validationContext);
        } else {
            ValidationContext validationContext = getValidationContext(input);
            ValidationVisitor validationVisitor = new ValidationVisitor(gameDefinition);

            return validationVisitor.visitValidation(validationContext);
        }
    }

    private ValidationContext getValidationContext(CharStream validationInput) {
        validationLexer validationLexer = new validationLexer(validationInput);
        CommonTokenStream validationTokens = new CommonTokenStream(validationLexer);
        validationParser validationParser = new validationParser(validationTokens);

        return validationParser.validation();
    }

    private simple_validationParser.ValidationContext getSimpleValidationContext(CharStream validationInput) {
        simple_validationLexer validationSimpleLexer = new simple_validationLexer(validationInput);
        CommonTokenStream validationTokens = new CommonTokenStream(validationSimpleLexer);
        simple_validationParser validationSimpleParser = new simple_validationParser(validationTokens);

        return validationSimpleParser.validation();
    }
}
