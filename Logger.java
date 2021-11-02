package com.example.calculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Logger {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final String inputText;
    private final String outputText;
    private final Convertor convertor;

    public Logger(
            Convertor convertor,
            String inputText,
            String outputText
    ) {
        this.convertor = convertor;
        this.inputText = inputText;
        this.outputText = outputText;
    }

    // shows output message and return input's string split on parts
    public String[] getOperationParts() throws Exception {
        System.out.println(inputText);

        return this.reader.readLine().split(" ");
    }

    public void showResult(int result, boolean isRomanFormat) {
        String formattedResult = isRomanFormat ? convertor.toRoman(result) : Integer.toString(result);

        System.out.println(outputText + formattedResult);
    }
}
