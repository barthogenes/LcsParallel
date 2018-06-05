package com.hva.lcs.implementation;

import com.hva.lcs.model.lengthtable.implementation.LengthTable;
import com.hva.lcs.model.lengthtable.interfaces.ILengthTable;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class LcsSequentialTest {
    @Test
    void findLongestCommonSubsequence() {
        // Arrange
        String a = "BDCABA";
        String b = "ABCBDAB";
        ILengthTable lengthTable = new LengthTable();
        LcsAlgorithm lcs = new LcsSequential(lengthTable);
        String expected = "BDAB";
        String result;

        // Act
        result = lcs.findLongestCommonSubsequence(a, b, false, true);


        // Assert
        Assert.assertEquals(expected, result);
    }

}