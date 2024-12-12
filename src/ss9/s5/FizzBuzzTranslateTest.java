package ss9.s5;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTranslateTest {
    @Test
    void testDivisibleBy3() {
        FizzBuzzTranslate fizzBuzz = new FizzBuzzTranslate();
        String result = fizzBuzz.translate(3);
        assertEquals("Fizz", result);
    }
    @Test
    void testDivisibleBy5() {
        FizzBuzzTranslate fizzBuzz = new FizzBuzzTranslate();
        String result = fizzBuzz.translate(5);
        assertEquals("Buzz", result);
    }
    @Test
    void testDivisibleBy3And5() {
        FizzBuzzTranslate fizzBuzz = new FizzBuzzTranslate();
        String result = fizzBuzz.translate(15);
        assertEquals("FizzBuzz", result);
    }
    @Test
    void testNotDivisibleBy3Or5() {
        FizzBuzzTranslate fizzBuzz = new FizzBuzzTranslate();
        String result = fizzBuzz.translate(2);
        assertEquals("hai", result);
    }
    @Test
    void testContain3() {
        FizzBuzzTranslate fizzBuzz = new FizzBuzzTranslate();
        String result = fizzBuzz.translate(13);
        assertEquals("Fizz", result);
    }
    @Test
    void testContain5() {
        FizzBuzzTranslate fizzBuzz = new FizzBuzzTranslate();
        String result = fizzBuzz.translate(52);
        assertEquals("Buzz", result);
    }
    @Test
    void testReadNumberOne() {
        FizzBuzzTranslate fizzBuzz = new FizzBuzzTranslate();
        String result = fizzBuzz.translate(1);
        assertEquals("một", result);
    }
    @Test
    void testReadNumberTwentyTwo() {
        FizzBuzzTranslate fizzBuzz = new FizzBuzzTranslate();
        String result = fizzBuzz.translate(22);
        assertEquals("hai mươi hai", result);
    }
    @Test
    void testReadNumberOneHundred() {
        FizzBuzzTranslate fizzBuzz = new FizzBuzzTranslate();
        String result = fizzBuzz.translate(100);
        assertEquals("", result);
    }

}
