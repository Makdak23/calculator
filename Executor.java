package com.example.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Executor {
    private final Convertor convertor;
    private final String[] validOperators;

    public Executor(Convertor convertor, String[] validOperators) {
        this.convertor = convertor;
        this.validOperators = validOperators;
    }

    public int execute(String[] operationParts, boolean isRomanFormat) throws Exception {
        String operator = operationParts[1];
        int num1 = isRomanFormat ? this.convertor.toArabic(operationParts[0]) : Integer.parseInt(operationParts[0]);
        int num2 = isRomanFormat ? this.convertor.toArabic(operationParts[2]) : Integer.parseInt(operationParts[2]);

        List<String> validOperatorsList = Arrays.asList(this.validOperators);

        if (validOperatorsList.contains("+") && Objects.equals(operator, "+")) {
            return num1 + num2;
        }

        if (validOperatorsList.contains("-") && Objects.equals(operator, "-")) {
            return num1 - num2;
        }

        if (validOperatorsList.contains("*") && Objects.equals(operator, "*")) {
            return num1 * num2;
        }

        if (validOperatorsList.contains("/") && Objects.equals(operator, "/")) {
            return num1 / num2;
        }

        throw new Exception("Unexpected error in 'Executor.execute'");
    }
}
