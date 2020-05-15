package com.codeassignment.problem1;

import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

public class TestSpellNumber {

    @Test
    public void whenConvertNumberToWords() {

        String expectedResult = "twelve thousand three hundred and forty five ";
        assertEquals(expectedResult, SpellNumber.convertToWords(12345));
    }


    @Test
    public void whenConvertNumberToWords_InputMismatchException() {

        Exception exception = assertThrows(InputMismatchException.class, () -> {
            SpellNumber.convertToWords(-12345);
        });

        String expectedMessage = "please enter valid data";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
