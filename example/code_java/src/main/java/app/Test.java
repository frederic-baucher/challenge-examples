package app;

import template.Fibonacci;

public class Test {

    public static void main(String[] args) {
        int min = 0;
        int max = 3;

        try {
            for (long n = min; n < max; n++) {
                Logger.log("Input : " + n + " - Output : " + Fibonacci.fibonacci(n));
            }
        } catch (RuntimeException e) {
            Logger.logException(e);
        }
    }

    public static long fibonacci(long n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
