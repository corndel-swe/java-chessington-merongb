package com.corndel.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathsTests {

    @Test
    public void checkPI () {
        assertEquals(3.14, Maths.getPI());
    }

    @Test
    public void checkMax() {
        assertEquals(10, Maths.max(10,7));
    }

    @Test
    public void roundReturnsWholeNumber() {
        assertEquals(5, Maths.round(5));
    }

    @Test
    public void roundsDown() {
        assertEquals(5, Maths.round(5.4));
    }

    @Test
    public void roundsUp() {
        assertEquals(6, Maths.round(5.5));
    }

    @Test
    public void returnsFactorialSum() {
        assertEquals(3628800, Maths.factorial(10));
    }

    @Test
    public void returns0IfFibonacciIs0() {
        assertEquals(0, Maths.fibonacci(0));
    }

    @Test
    public void returns1IfFibonacciIs1() {
        assertEquals(1, Maths.fibonacci(1));
    }

    @Test
    public void returnsFibonnaci() {
        assertEquals(13, Maths.fibonacci(7));
        assertEquals(21, Maths.fibonacci(8));
        assertEquals(34, Maths.fibonacci(9));
    }


}
