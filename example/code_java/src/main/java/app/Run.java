package app;

import template.Fibonacci;

public class Run {

    public static void main(String[] args) {
        try {
            Fibonacci.main();
        } catch (RuntimeException e) {
            Logger.logException(e);
        }
    }

}
