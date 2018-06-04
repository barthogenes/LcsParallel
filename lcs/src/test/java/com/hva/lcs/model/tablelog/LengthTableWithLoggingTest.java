package com.hva.lcs.model.tablelog;

import com.hva.lcs.model.lengthtable.implementation.LengthTable;
import org.junit.Assert;
import org.junit.Test;

public class LengthTableWithLoggingTest {

    @Test
    public void getActionsLog1() throws Exception {
        // Arrange
        String a = "ABC";
        String b = "DEF";
        LengthTableWithLogging test = new LengthTableWithLogging(new LengthTable());
        test.setStrings(a, b);
        int result;
        int expected = 0;

        // Act
        result = test.getActionsLog().size();

        // Assert
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getActionsLog2() throws Exception {
        // Arrange
        String a = "ABC";
        String b = "DEF";
        LengthTableWithLogging test = new LengthTableWithLogging(new LengthTable());
        test.setStrings(a, b);

        CellReadAction result;
        CellReadAction expected = new CellReadAction(1, 2, -1);

        // Act
        test.get(1, 2);
        result = (CellReadAction) test.getActionsLog().get(0);

        // Assert
        Assert.assertEquals(expected.getX(), result.getX());
        Assert.assertEquals(expected.getY(), result.getY());
        Assert.assertEquals(expected.getValueRead(), result.getValueRead());
    }

    @Test
    public void getActionsLog3() throws Exception {
        // Arrange
        String a = "ABC";
        String b = "DEF";
        LengthTableWithLogging test = new LengthTableWithLogging(new LengthTable());
        test.setStrings(a, b);
        CellWriteAction result;
        CellWriteAction expected = new CellWriteAction(1, 2, 5);

        // Act
        test.set(1, 2, 5);
        result = (CellWriteAction) test.getActionsLog().get(0);

        // Assert
        Assert.assertEquals(expected.getX(), result.getX());
        Assert.assertEquals(expected.getY(), result.getY());
        Assert.assertEquals(expected.getValueWritten(), result.getValueWritten());
    }

}