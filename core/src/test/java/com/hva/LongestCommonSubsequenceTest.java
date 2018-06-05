package com.hva;

import com.hva.lcs.implementation.LcsSequential;
import com.hva.lcs.model.lengthtable.interfaces.ILengthTable;
import com.hva.lcs.model.LcsTestSet;
import com.hva.lcs.model.lengthtable.implementation.LengthTable;
import org.junit.Assert;
import org.junit.Test;

public class LongestCommonSubsequenceTest {

    public LongestCommonSubsequenceTest() {

    }

    @Test
    public void findLongestCommonSubsequence() {
        LcsTestSet testSet = new LcsTestSet("ADH", 15);

        // Arrange
        String a = testSet.getStringA();
        String b = testSet.getStringB();
        String expectedOutput = "ADH";
        String result;
        ILengthTable lengthTable = new LengthTable();

        // Act
        result = new LcsSequential(lengthTable).findLongestCommonSubsequence(a, b, false, true);

        // Assert
        Assert.assertEquals(expectedOutput, result);
    }

}