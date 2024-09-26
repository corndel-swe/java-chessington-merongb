package com.corndel.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangleTests {

    @Test

    public void checkArea() {
        Rectangle rectangle = new Rectangle(15,20);

        assertEquals(300, rectangle.getArea());
    }

    @Test
    public void checkPerimeter() {
        Rectangle rectangle = new Rectangle(15,20);

        assertEquals(70, rectangle.getPerimeter());
    }
}
