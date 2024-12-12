package ss9.s3;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NextDayCalculatorTest {
    @Test
    void testNormalDay() {
        NextDayCalculator calculator = new NextDayCalculator();
        String result = calculator.getNextDay(1, 1, 2018);
        assertEquals("2/1/2018", result);
    }

    @Test
    void testEndOfMonth() {
        NextDayCalculator calculator = new NextDayCalculator();
        String result = calculator.getNextDay(31, 1, 2018);
        assertEquals("1/2/2018", result);
    }

    @Test
    void testEndOfApril() {
        NextDayCalculator calculator = new NextDayCalculator();
        String result = calculator.getNextDay(30, 4, 2018);
        assertEquals("1/5/2018", result);
    }

    @Test
    void testEndOfFebruary2018() {
        NextDayCalculator calculator = new NextDayCalculator();
        String result = calculator.getNextDay(28, 2, 2018);
        assertEquals("1/3/2018", result);
    }

    @Test
    void testEndOfFebruary2020() {
        NextDayCalculator calculator = new NextDayCalculator();
        String result = calculator.getNextDay(29, 2, 2020);
        assertEquals("1/3/2020", result);
    }

    @Test
    void testEndOfYear() {
        NextDayCalculator calculator = new NextDayCalculator();
        String result = calculator.getNextDay(31, 12, 2018);
        assertEquals("1/1/2019", result);
    }
}
