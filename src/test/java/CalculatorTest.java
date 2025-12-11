
import CloudComputing.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Calculator Unit Tests")
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("Setting up new Calculator instance for test...");
    }

    @Nested
    @DisplayName("Addition Tests")
    class AdditionTests {

        @Test
        @DisplayName("Adding two positive numbers")
        void testAddPositiveNumbers() {
            double result = calculator.add(5, 3);
            assertEquals(8, result, "5 + 3 should equal 8");
        }

        @Test
        @DisplayName("Adding two negative numbers")
        void testAddNegativeNumbers() {
            double result = calculator.add(-5, -3);
            assertEquals(-8, result, "-5 + (-3) should equal -8");
        }

        @Test
        @DisplayName("Adding positive and negative number")
        void testAddMixedNumbers() {
            double result = calculator.add(10, -3);
            assertEquals(7, result, "10 + (-3) should equal 7");
        }

        @Test
        @DisplayName("Adding zero")
        void testAddWithZero() {
            double result = calculator.add(5, 0);
            assertEquals(5, result, "5 + 0 should equal 5");
        }
    }

    @Nested
    @DisplayName("Subtraction Tests")
    class SubtractionTests {

        @Test
        @DisplayName("Subtracting two positive numbers")
        void testSubtractPositiveNumbers() {
            double result = calculator.subtract(10, 4);
            assertEquals(6, result, "10 - 4 should equal 6");
        }

        @Test
        @DisplayName("Subtracting resulting in negative")
        void testSubtractResultingNegative() {
            double result = calculator.subtract(4, 10);
            assertEquals(-6, result, "4 - 10 should equal -6");
        }

        @Test
        @DisplayName("Subtracting zero")
        void testSubtractZero() {
            double result = calculator.subtract(5, 0);
            assertEquals(5, result, "5 - 0 should equal 5");
        }
    }

    @Nested
    @DisplayName("Multiplication Tests")
    class MultiplicationTests {

        @Test
        @DisplayName("Multiplying two positive numbers")
        void testMultiplyPositiveNumbers() {
            double result = calculator.multiply(4, 5);
            assertEquals(20, result, "4 * 5 should equal 20");
        }

        @Test
        @DisplayName("Multiplying by zero")
        void testMultiplyByZero() {
            double result = calculator.multiply(100, 0);
            assertEquals(0, result, "100 * 0 should equal 0");
        }

        @Test
        @DisplayName("Multiplying negative numbers")
        void testMultiplyNegativeNumbers() {
            double result = calculator.multiply(-3, -4);
            assertEquals(12, result, "-3 * -4 should equal 12");
        }

        @Test
        @DisplayName("Multiplying positive and negative")
        void testMultiplyMixedSigns() {
            double result = calculator.multiply(5, -3);
            assertEquals(-15, result, "5 * -3 should equal -15");
        }
    }

    @Nested
    @DisplayName("Division Tests")
    class DivisionTests {

        @Test
        @DisplayName("Dividing two positive numbers")
        void testDividePositiveNumbers() {
            double result = calculator.divide(20, 4);
            assertEquals(5, result, "20 / 4 should equal 5");
        }

        @Test
        @DisplayName("Dividing with decimal result")
        void testDivideWithDecimalResult() {
            double result = calculator.divide(7, 2);
            assertEquals(3.5, result, 0.001, "7 / 2 should equal 3.5");
        }

        @Test
        @DisplayName("Division by zero should throw exception")
        void testDivideByZero() {
            ArithmeticException exception = assertThrows(
                    ArithmeticException.class,
                    () -> calculator.divide(10, 0),
                    "Division by zero should throw ArithmeticException"
            );
            assertEquals("Division by zero is not allowed!", exception.getMessage());
        }

        @Test
        @DisplayName("Dividing zero by a number")
        void testDivideZero() {
            double result = calculator.divide(0, 5);
            assertEquals(0, result, "0 / 5 should equal 0");
        }
    }

    @Nested
    @DisplayName("Power Tests")
    class PowerTests {

        @Test
        @DisplayName("Calculate power with positive exponent")
        void testPowerPositive() {
            double result = calculator.power(2, 3);
            assertEquals(8, result, "2^3 should equal 8");
        }

        @Test
        @DisplayName("Calculate power with zero exponent")
        void testPowerZeroExponent() {
            double result = calculator.power(5, 0);
            assertEquals(1, result, "5^0 should equal 1");
        }

        @Test
        @DisplayName("Calculate power with negative exponent")
        void testPowerNegativeExponent() {
            double result = calculator.power(2, -1);
            assertEquals(0.5, result, 0.001, "2^-1 should equal 0.5");
        }
    }

    @Nested
    @DisplayName("Square Root Tests")
    class SquareRootTests {

        @Test
        @DisplayName("Square root of positive number")
        void testSquareRootPositive() {
            double result = calculator.squareRoot(16);
            assertEquals(4, result, "√16 should equal 4");
        }

        @Test
        @DisplayName("Square root of zero")
        void testSquareRootZero() {
            double result = calculator.squareRoot(0);
            assertEquals(0, result, "√0 should equal 0");
        }

        @Test
        @DisplayName("Square root of negative should throw exception")
        void testSquareRootNegative() {
            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> calculator.squareRoot(-4),
                    "Square root of negative should throw IllegalArgumentException"
            );
            assertEquals("Cannot calculate square root of negative number!", exception.getMessage());
        }
    }

    @Nested
    @DisplayName("Modulo Tests")
    class ModuloTests {

        @Test
        @DisplayName("Modulo with remainder")
        void testModuloWithRemainder() {
            double result = calculator.modulo(10, 3);
            assertEquals(1, result, "10 % 3 should equal 1");
        }

        @Test
        @DisplayName("Modulo with no remainder")
        void testModuloNoRemainder() {
            double result = calculator.modulo(10, 5);
            assertEquals(0, result, "10 % 5 should equal 0");
        }

        @Test
        @DisplayName("Modulo by zero should throw exception")
        void testModuloByZero() {
            assertThrows(
                    ArithmeticException.class,
                    () -> calculator.modulo(10, 0)
            );
        }
    }

    @Nested
    @DisplayName("Absolute Value Tests")
    class AbsoluteValueTests {

        @Test
        @DisplayName("Absolute value of positive number")
        void testAbsolutePositive() {
            double result = calculator.absoluteValue(5);
            assertEquals(5, result, "|5| should equal 5");
        }

        @Test
        @DisplayName("Absolute value of negative number")
        void testAbsoluteNegative() {
            double result = calculator.absoluteValue(-5);
            assertEquals(5, result, "|-5| should equal 5");
        }

        @Test
        @DisplayName("Absolute value of zero")
        void testAbsoluteZero() {
            double result = calculator.absoluteValue(0);
            assertEquals(0, result, "|0| should equal 0");
        }
    }
}
