package com.example.calculator;

public class Aggregator {
    private final Logger logger;
    private final Validator validator;
    private final Executor executor;

    public Aggregator(
            Logger input,
            Validator validator,
            Executor executor
    ) {
        this.logger = input;
        this.validator = validator;
        this.executor = executor;
    }

    public void start() throws Exception {
        String[] operationParts = logger.getOperationParts();

        validator.validate(operationParts);

        boolean isRomanFormat = !operationParts[0].matches("\\d+");
        int result = executor.execute(operationParts, isRomanFormat);

        validator.validateResult(result, isRomanFormat);

        logger.showResult(result, isRomanFormat);
    }
}
