package app;

import java.util.concurrent.CompletableFuture;
import java.util.Random;

import io.deadlock.java.helper.DeadlockJavaHelper;
import template.Calculator;


public class Solve {

    private final static String OPERATION_ADD = "add";
    private final static String OPERATION_SUBTRACT = "subtract";
    private final static String OPERATION_MULTIPLY = "multiply";
    private final static String OPERATION_DIVIDE = "divide";
    private final static String OPERATION_MODULO = "modulo";

    private static int runTest(int a, int b) {

        Calculator userInstance = new Calculator();
        success.Calculator solvedInstance = new success.Calculator();

        int receivedSum = userInstance.add(a, b);
        int expectedSum = solvedInstance.add(a, b);
        checkTestResult(OPERATION_ADD, expectedSum, receivedSum, a, b);

        int receivedSubtract = userInstance.subtract(a, b);
        int expectedSubtract = solvedInstance.subtract(a, b);
        checkTestResult(OPERATION_SUBTRACT, expectedSubtract, receivedSubtract, a, b);

        int receivedMultiply = userInstance.multiply(a, b);
        int expectedMultiply = solvedInstance.multiply(a, b);
        checkTestResult(OPERATION_MULTIPLY, expectedMultiply, receivedMultiply, a, b);

        int receivedDivide = userInstance.divide(a, b);
        int expectedDivide = solvedInstance.divide(a, b);
        checkTestResult(OPERATION_DIVIDE, expectedDivide, receivedDivide, a, b);

        int receivedModulo = userInstance.modulo(a, b);
        int expectedModulo = solvedInstance.modulo(a, b);
        checkTestResult(OPERATION_MODULO, expectedModulo, receivedModulo, a, b);

        return 0;
    }

    private static int checkTestResult(String operation, int expected, int received, int a, int b) {
        if (expected != received) {
            Logger.logCurrentTest(operation, expected, received, a, b);
            System.err.println("Received value is not correct.");
            System.err.println("Try again.");
            System.exit(1);
        }

        return 0;
    }

    public static void main(String[] args) throws Exception {

        Random random = new Random();
        int a = random.nextInt();
        int b = random.nextInt();

        // Wrap execution in runnable to simplify stacktrace
        int result = CompletableFuture.supplyAsync(() -> {
            System.out.println();
            System.out.println("Running your tests..");
            DeadlockJavaHelper.createTestRunner("template").execute();

            runTest(a, b);
            runTest(-a, b);
            runTest(a, -b);
            runTest(-a, -b);
            runTest(0, b);
            runTest(a, 0);

            Logger.logSuccess();
            return 0;
        }).exceptionally(throwable -> {
            Logger.logException(throwable);
            throwable.printStackTrace();
            return -1;
        }).get();

        // Exit app with result code
        System.exit(result);
    }

}