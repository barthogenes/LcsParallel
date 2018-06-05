package com.hva.parallel_computing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SerialLcsTest
{
    @Test
    void findLongestCommonSubsequence()
    {
        // Arrange
        String a = "BDCABA";
        String b = "ABCBDAB";
        SerialLcs serialLcs = new SerialLcs();

        // Act
        String lcs = serialLcs.findLongestCommonSubsequence(a, b);

        // Assert
        assertEquals("BDAB", lcs);
    }
}
