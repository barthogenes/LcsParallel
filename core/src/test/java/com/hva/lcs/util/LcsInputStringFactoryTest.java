package com.hva.lcs.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LcsInputStringFactoryTest {

    @Test
    void createInputStringWithLcsPlacedAtBeginning() {
        // Arrange
        String lcs = "ABC";
        LcsPositionWithinString position = LcsPositionWithinString.START;
        char fillCharacter = '+';
        int length = 10;

        // Act
        String inputString = LcsInputStringFactory.createInputString(lcs, position, fillCharacter, length);

        // Assert
        assertEquals("ABC+++++++", inputString);
    }

    @Test
    void createInputStringWithLcsPlacedAtEnd() {
        // Arrange
        String lcs = "ABC";
        LcsPositionWithinString position = LcsPositionWithinString.END;
        char fillCharacter = '+';
        int length = 10;

        // Act
        String inputString = LcsInputStringFactory.createInputString(lcs, position, fillCharacter, length);

        // Assert
        assertEquals("+++++++ABC", inputString);
    }

    @Test
    void generateLetterString() {
        // Arrange
        char fillCharacter = '+';
        int length = 5;

        // Act
        String generatedString = LcsInputStringFactory.generateLetterString(fillCharacter, length);

        // Assert
        assertEquals("+++++", generatedString);
    }
}