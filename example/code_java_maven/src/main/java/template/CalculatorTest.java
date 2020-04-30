package template;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void add_one_and_one() {
        assertEquals(calculator.add(1, 1), 2);
    }

    //TODO write your own tests

}

