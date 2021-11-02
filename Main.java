package com.example.calculator;

import java.util.Arrays;

public class Main {
    static int MAX_VALID_NUMBER = 10;
    static String[] VALID_OPERATORS = { "+", "-", "/", "*" };

    public static void main(String[] args) throws Exception {
        Errors errors = new Errors(
                "Неправильно указаны аргументы, должно быть 3 аргумента. Пример: 2 + 2. Указано аргументов: ",
                "Неправильный первый аргумент, должен быть числом арабским или римским. Максимальное значение: " + MAX_VALID_NUMBER,
                "Неправильный второй аргумент (оператор), должен быть: +, -, *, /",
                "Неправильный третий аргумент, должен быть числом арабским или римским. Максимальное значение: " + MAX_VALID_NUMBER,
                "Неправильный формат чисел, оба должны быть либо арабскими, либо римскими цифрами",
                "Римские цифры не могут быть ниже 0"
        );

        Convertor convertor = new Convertor();

        Aggregator aggregator = new Aggregator(
                new Logger(
                        convertor,
                        "Пожалуйста введите арифметическое выражение:",
                        "Результат: "
                ),
                new Validator(
                        errors,
                        convertor,
                        VALID_OPERATORS,
                        MAX_VALID_NUMBER
                ),
                new Executor(
                        convertor,
                        VALID_OPERATORS
                )
        );
        aggregator.start();
    }
}
