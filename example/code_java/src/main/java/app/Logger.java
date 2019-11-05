package app;

public class Logger {


    public static void logCurrentTest(long received, long n) {
        System.err.println("> fibonacci(" + n + ") = " + received);
    }

    public static void logNoMatch(long expected) {
        System.err.println("----------------------------------------------------");
        System.err.println("The result does not match the expected value: " + expected);
        System.err.println("----------------------------------------------------");
    }

    public static void logException(Exception e) {
        System.err.println("----------------------------------------------------");
        System.err.println("An error occurred during runtime.");
        System.err.println("Details:");
        System.err.println(e.getMessage());
    }

    public static void logException(Throwable throwable) {
        System.err.println("----------------------------------------------------");
        System.err.println("Something bad happened!");
        System.err.println(throwable.getMessage());
        throwable.printStackTrace();
        System.err.println("----------------------------------------------------");
    }

    public static void logSuccess() {
        System.out.println("Everything went well, good job!");
        System.out.println("----------------------------------------------------");
    }
}
