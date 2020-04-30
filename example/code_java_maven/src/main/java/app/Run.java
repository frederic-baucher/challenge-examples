package app;

import io.deadlock.java.helper.DeadlockJavaHelper;
import template.*;

public class Run {
    public static void main(String[] args) {
        try {
            System.out.println("Running your tests..");
            DeadlockJavaHelper.createTestRunner("template").execute();

            Calculator.main();
        } catch (Throwable t) {
            Logger.logException(t);
        }
    }
}