package app;

public class Logger {

    public static void logCurrentTest(String operation, int expected, int received, int a, int b) {
        System.err.println("> " + operation + "(" + a + "," + b + ") = " + received);
        System.err.println("> expected = " + expected);
        System.err.println("----------------------------------------------------");
    }

    public static void logSuccess() {
        System.out.println("Everything went well, good job!");
        System.out.println("----------------------------------------------------");
    }

    public static void logException(Throwable throwable) {
        System.err.println("----------------------------------------------------");
        System.err.println("Something bad happened!");
        System.err.println(throwable.getMessage());
        throwable.printStackTrace();
        System.err.println("----------------------------------------------------");
    }
}
