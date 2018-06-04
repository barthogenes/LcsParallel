package com.hva.lcs.implementation;

import com.hva.lcs.model.lengthtable.interfaces.ILengthTable;
import com.hva.lcs.model.lengthtable.implementation.LengthTable;
import org.junit.Assert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
class LcsConcurrentTest {


    @Test
    void findLongestCommonSubsequence() {
        // Arrange
        String a = "BDCABA";
        String b = "ABCBDAB";
        ILengthTable lengthTable = new LengthTable();
        LcsAlgorithm lcs = new LcsConcurrentDiagonal(lengthTable, 4, 500);
        String expected = "BDAB";
        String result;

        // Act
        result = lcs.findLongestCommonSubsequence(a, b, false, true);

        // Assert
        Assert.assertEquals(expected, result);
    }

}