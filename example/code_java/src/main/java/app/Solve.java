package app;

import template.Fibonacci;

public class Solve {

    public static void main(String[] args) {

        int min = 0;
        int max = 20;

        try {
            for (long n = min; n < max; n++) {
                long userValue = Fibonacci.fibonacci(n);
                long expectedValue = success.Fibonacci.fibonacci(n);
                if (expectedValue != userValue) {
                    Logger.logNoMatch(n, expectedValue, userValue);
                    System.exit(1);
                }
            }
            // all test passed successfully
            Logger.logSuccess();
        } catch (RuntimeException e) {
            Logger.logException(e);
            System.exit(1);
        }
    }

}
