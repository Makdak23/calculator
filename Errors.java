package com.example.calculator;

public class Errors {
    public String invalidArgumentsLength;
    public String invalidFirstArgument;
    public String invalidOperator;
    public String invalidThirdArgument;
    public String numbersDifferentFormat;
    public String romanNumberNegative;

    public Errors(
            String invalidArgumentsLength,
            String invalidFirstArgument,
            String invalidOperator,
            String invalidThirdArgument,
            String numbersDifferentFormat,
            String romanNumberNegative
    ) {
        this.invalidArgumentsLength = invalidArgumentsLength;
        this.invalidFirstArgument = invalidFirstArgument;
        this.invalidOperator = invalidOperator;
        this.invalidThirdArgument = invalidThirdArgument;
        this.numbersDifferentFormat = numbersDifferentFormat;
        this.romanNumberNegative = romanNumberNegative;
    }
}
