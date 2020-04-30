package success;

public class Calculator {

    /**
     * Called when you Run your code.
     */
    public static void main() {
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        int result = 0;
        try {
            result = a / b;
        } catch (ArithmeticException e) {
            System.out.println("You should not divide a number by zero");
        }
        return result;
    }

    public int modulo(int a, int b) {
        int result = 0;
        try {
            result = a % b;
        } catch (ArithmeticException e) {
            System.out.println("You should not divide a number by zero");
        }
        return result;
    }

}
