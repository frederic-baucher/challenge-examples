package success;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

// some test examples.
public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void add_one_and_one() {
        assertEquals(calculator.add(1, 1), 2);
    }

    @Test
    public void subtract_one_and_one() {
        assertEquals(calculator.subtract(1, 1), 0);
    }

    @Test
    public void multiplication_of_zero() {
        assertEquals(0, calculator.multiply(10, 0));
        assertEquals(0, calculator.multiply(0, 10));
        assertEquals(0, calculator.multiply(0, 0));
    }

    @Test
    public void multiplication_of_one() {
        assertEquals(0, calculator.multiply(1, 0));
        assertEquals(1, calculator.multiply(1, 1));
        assertEquals(7, calculator.multiply(1, 7));
        assertEquals(12, calculator.multiply(1, 12));
    }

    @Test
    public void divide_by_one() {
        assertEquals(0, calculator.divide(0, 1));
        assertEquals(12, calculator.divide(12, 1));
    }

    @Test
    public void divide_by_two() {
        assertEquals(0, calculator.divide(0, 2));
        assertEquals(6, calculator.divide(12, 2));
    }

    @Test
    public void divide_by_ten() {
        assertEquals(0, calculator.divide(0, 10));
        assertEquals(10, calculator.divide(100, 10));
        assertEquals(6, calculator.divide(60, 10));
    }

    @Test
    public void divide_by_zero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(54, 0));
        assertThrows(ArithmeticException.class, () -> calculator.divide(112, 0));
    }

    @Test
    public void modulo_two() {
        assertEquals(0, calculator.modulo(4, 2));
        assertEquals(0, calculator.modulo(12, 2));
    }

    @Test
    public void modulo_zero() {
        assertThrows(ArithmeticException.class, () -> calculator.modulo(4, 0));
        assertThrows(ArithmeticException.class, () -> calculator.modulo(12, 0));
    }

}
