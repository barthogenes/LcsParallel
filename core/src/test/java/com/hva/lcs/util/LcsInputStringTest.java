package com.hva.lcs.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LcsInputStringTest {

    @Test
    void insertLcs() {
        // Arrange
        LcsInputString inputString = new LcsInputString('+', 10);

        // Act
        String result1 = inputString.insertLcs("ABC", LcsInputString.LcsPosition.START);
        String result2 = inputString.insertLcs("ABC", LcsInputString.LcsPosition.END);

        // Assert
        assertEquals("ABC+++++++", result1);
        assertEquals("+++++++ABC", result2);
    }
}