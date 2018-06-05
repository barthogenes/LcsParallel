package com.hva.lcs.model;

import com.hva.lcs.model.lengthtable.implementation.LengthTable;
import com.hva.lcs.model.lengthtable.interfaces.ILengthTable;
import org.junit.Assert;
import org.junit.Test;

public class LengthTableSequentialTest {

    public LengthTableSequentialTest() {

    }

    @Test
    public void testToString() throws Exception {
        // Arrange
        String a = "ABC";
        String b = "DEF";
        ILengthTable test = new LengthTable();
        test.setStrings(a, b);
        String result;
        String expected =  "  |   | A | B | C | \n" +
                           "--------------------\n" +
                           "  | 0 | 0 | 0 | 0 | \n" +
                           "--------------------\n" +
                           "D | 0 | -1| -1| -1| \n" +
                           "--------------------\n" +
                           "E | 0 | -1| -1| -1| \n" +
                           "--------------------\n" +
                           "F | 0 | -1| -1| -1| \n";

        // Act
        result = test.toString();

        // Assert
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testToString2() throws Exception {
        // Arrange
        String a = "ABCD";
        String b = "EF";
        ILengthTable test = new LengthTable();
        test.setStrings(a, b);
        String result;
        String expected = "  |   | A | B | C | D | \n" +
                          "------------------------\n" +
                          "  | 0 | 0 | 0 | 0 | 0 | \n" +
                          "------------------------\n" +
                          "E | 0 | -1| -1| -1| -1| \n" +
                          "------------------------\n" +
                          "F | 0 | -1| -1| -1| -1| \n";

        // Act
        result = test.toString();

        // Assert
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testToString3() throws Exception {
        // Arrange
        String a = "AB";
        String b = "CDEF";
        ILengthTable test = new LengthTable();
        test.setStrings(a, b);
        String result;
        String expected = "  |   | A | B | \n" +
                          "----------------\n" +
                          "  | 0 | 0 | 0 | \n" +
                          "----------------\n" +
                          "C | 0 | -1| -1| \n" +
                          "----------------\n" +
                          "D | 0 | -1| -1| \n" +
                          "----------------\n" +
                          "E | 0 | -1| -1| \n" +
                          "----------------\n" +
                          "F | 0 | -1| -1| \n";

        // Act
        result = test.toString();

        // Assert
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSet1() throws Exception {
        // Arrange
        String a = "ABC";
        String b = "DEF";
        ILengthTable test = new LengthTable();
        test.setStrings(a, b);
        test.set(1, 0, 1);
        String result;
        String expected = "  |   | A | B | C | \n" +
                          "--------------------\n" +
                          "  | 0 | 1 | 0 | 0 | \n" +
                          "--------------------\n" +
                          "D | 0 | -1| -1| -1| \n" +
                          "--------------------\n" +
                          "E | 0 | -1| -1| -1| \n" +
                          "--------------------\n" +
                          "F | 0 | -1| -1| -1| \n";

        // Act
        result = test.toString();

        // Assert
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSet2() throws Exception {
        // Arrange
        String a = "ABC";
        String b = "DEF";
        ILengthTable test = new LengthTable();
        test.setStrings(a, b);
        test.set(0, 1, 1);
        String result;
        String expected = "  |   | A | B | C | \n" +
                          "--------------------\n" +
                          "  | 0 | 0 | 0 | 0 | \n" +
                          "--------------------\n" +
                          "D | 1 | -1| -1| -1| \n" +
                          "--------------------\n" +
                          "E | 0 | -1| -1| -1| \n" +
                          "--------------------\n" +
                          "F | 0 | -1| -1| -1| \n";

        // Act
        result = test.toString();

        // Assert
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSet3() throws Exception {
        // Arrange
        String a = "ABC";
        String b = "DEF";
        ILengthTable test = new LengthTable();
        test.setStrings(a, b);
        test.set(2, 2, 1);
        String result;
        String expected = "  |   | A | B | C | \n" +
                          "--------------------\n" +
                          "  | 0 | 0 | 0 | 0 | \n" +
                          "--------------------\n" +
                          "D | 0 | -1| -1| -1| \n" +
                          "--------------------\n" +
                          "E | 0 | -1| 1 | -1| \n" +
                          "--------------------\n" +
                          "F | 0 | -1| -1| -1| \n";

        // Act
        result = test.toString();

        // Assert
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSet4() throws Exception {
        // Arrange
        String a = "ABC";
        String b = "DEF";
        ILengthTable test = new LengthTable();
        test.setStrings(a, b);
        test.set(0, 0, 1);
        String result;
        String expected = "  |   | A | B | C | \n" +
                          "--------------------\n" +
                          "  | 1 | 0 | 0 | 0 | \n" +
                          "--------------------\n" +
                          "D | 0 | -1| -1| -1| \n" +
                          "--------------------\n" +
                          "E | 0 | -1| -1| -1| \n" +
                          "--------------------\n" +
                          "F | 0 | -1| -1| -1| \n";

        // Act
        result = test.toString();

        // Assert
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetAndSet() {
        // Arrange
        String a = "ABC";
        String b = "DEF";
        ILengthTable test = new LengthTable();
        test.setStrings(a, b);
        test.set(0, 2, 5);
        int result;
        int expected = 5;

        // Act
        result = test.get(0, 2);

        // Assert
        Assert.assertEquals(expected, result);
    }

    private int[][] table = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 1},
            {0, 1, 1, 1, 1, 2, 2},
            {0, 1, 1, 2, 2, 2, 2},
            {0, 1, 1, 2, 2, 3, 3},
            {0, 1, 2, 2, 2, 3, 3},
            {0, 1, 2, 2, 3, 3, 4},
            {0, 1, 2, 2, 3, 4, 4}
    };

//    @Test
//    public void setAll() {
//        // Arrange
//        String a = "BDCABA";
//        String b = "ABCBDAB";
//        LengthTableSequential test = new LengthTableSequential(a, b);
//        test.setTable(table);
//        String result;
//        String expected = "  |   | B | D | C | A | B | A | \n" +
//                          "--------------------------------\n" +
//                          "  | 0 | 0 | 0 | 0 | 0 | 0 | 0 | \n" +
//                          "--------------------------------\n" +
//                          "A | 0 | 0 | 0 | 0 | 1 | 1 | 1 | \n" +
//                          "--------------------------------\n" +
//                          "B | 0 | 1 | 1 | 1 | 1 | 2 | 2 | \n" +
//                          "--------------------------------\n" +
//                          "C | 0 | 1 | 1 | 2 | 2 | 2 | 2 | \n" +
//                          "--------------------------------\n" +
//                          "B | 0 | 1 | 1 | 2 | 2 | 3 | 3 | \n" +
//                          "--------------------------------\n" +
//                          "C | 0 | 1 | 2 | 2 | 2 | 3 | 3 | \n" +
//                          "--------------------------------\n" +
//                          "A | 0 | 1 | 2 | 2 | 3 | 3 | 4 | \n" +
//                          "--------------------------------\n" +
//                          "B | 0 | 1 | 2 | 2 | 3 | 4 | 4 | \n";
//
//        // Act
//        result = test.toString();
//
//        // Assert
//        Assert.assertEquals(expected, result);
//    }
//
//    @Test
//    public void readLcs1() {
//        // Arrange
//        String a = "BDCABA";
//        String b = "ABCBDAB";
//        LengthTableSequential test = new LengthTableSequential(a, b);
//        test.setTable(table);
//        String resultLeftUp;
//        String resultUpLeft;
//        String expectedLeftUp = "BDAB";
//        String expectedUpLeft = "BCBA";
//
//        // Act
//        resultLeftUp = test.readLcsLeftUp(false);
//        resultUpLeft = test.readLcsLeftUp(true);
//
//        // Assert
//        Assert.assertEquals(expectedLeftUp, resultLeftUp);
//        Assert.assertEquals(expectedUpLeft, resultUpLeft);
//    }

}