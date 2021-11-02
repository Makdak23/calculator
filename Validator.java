package com.example.calculator;

import java.util.Arrays;

public class Validator {
    private final Errors errors;
    private final Convertor convertor;
    private final String[] validOperators;
    private final int maxNumber;

    public Validator(
            Errors errors,
            Convertor convertor,
            String[] validOperators,
            int maxNumber
    ) {
        this.errors = errors;
        this.convertor = convertor;
        this.validOperators = validOperators;
        this.maxNumber = maxNumber;
    }

    // operationsParts is split input string
    public void validate(String[] operationParts) throws Exception {
        if (operationParts.length != 3) {
            throw new Exception(errors.invalidArgumentsLength + operationParts.length);
        }

        boolean hasArabic = false;
        boolean hasRoman = false;

        String[] numbers = { operationParts[0], operationParts[2] };
        for (int i = 0; i < numbers.length; i++) {
            int number;

            String stringNumber = numbers[i];
            if (stringNumber.matches("\\d+")) {
                number = Integer.parseInt(stringNumber);

                hasArabic = true;
            } else {
                number = convertor.toArabic(stringNumber);

                hasRoman = true;
            }

            if (number > maxNumber) {
                throw new Exception(i == 0 ? errors.invalidFirstArgument : errors.invalidThirdArgument);
            }

        }

        if (hasArabic && hasRoman) {
            throw new Exception(errors.numbersDifferentFormat);
        }

        if (!Arrays.asList(validOperators).contains(operationParts[1])) {
            throw new Exception(errors.invalidOperator);
        }
    }

    public void validateResult(int result, boolean isRomanFormat) throws Exception {
        if (isRomanFormat && result < 0) {
            throw new Exception(errors.romanNumberNegative);
        }
    }
}
