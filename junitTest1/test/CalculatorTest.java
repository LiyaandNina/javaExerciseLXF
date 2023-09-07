import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    public void setUp(){
        this.calculator = new Calculator();
    }

    @AfterEach
    public void tearDown(){
        this.calculator = null;
    }

    @org.junit.jupiter.api.Test
    void add() {
        assertAll(() -> assertEquals(100, this.calculator.add(100)),
                () -> assertEquals(150, this.calculator.add(50)),
                () -> assertEquals(130, this.calculator.add(-20)));
    }

    @org.junit.jupiter.api.Test
    void sub() {
        assertAll(() -> assertEquals(-100, this.calculator.sub(100)),
                () -> assertEquals(-150, this.calculator.sub(50)),
                () -> assertEquals(-130, this.calculator.sub(-20)));
    }
}