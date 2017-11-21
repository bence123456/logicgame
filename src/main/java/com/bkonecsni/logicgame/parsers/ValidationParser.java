package com.bkonecsni.logicgame.parsers;

import com.bkonecsni.logicgame.domain.common.GameDefinition;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import validation.validationLexer;
import validation.validationParser;
import validation.validationParser.*;

public class ValidationParser extends CommonParser implements Parser {

    @Override
    public void parse(CharStream input, GameDefinition gameDefinition) {
        parseValidation(input, gameDefinition);
    }

    private void parseValidation(CharStream validationInput, GameDefinition gameDefinition) {
        ValidationContext validationContext = getValidationContext(validationInput);
    }

    private ValidationContext getValidationContext(CharStream validationInput) {
        validationLexer validationLexer = new validationLexer(validationInput);
        CommonTokenStream validationTokens = new CommonTokenStream(validationLexer);
        validationParser validationParser = new validationParser(validationTokens);
        return validationParser.validation();
    }
}
