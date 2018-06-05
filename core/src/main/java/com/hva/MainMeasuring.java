package com.hva;

import com.hva.lcs.implementation.LcsAlgorithm;
import com.hva.lcs.implementation.LcsConcurrentDiagonal;
import com.hva.lcs.implementation.LcsSequential;
import com.hva.lcs.model.lengthtable.implementation.LengthTable;
import com.hva.lcs.model.lengthtable.interfaces.ILengthTable;
import com.hva.lcs.model.LcsTestSet;
import com.hva.lcs.util.EventProfiler;

public class MainMeasuring {

    public static void main(String[] args) {
        String lcs = "ADH";

        int[] testSetSizes = new int[]{10, 100, 1000, 10000};
        LcsTestSet testSet1 = new LcsTestSet(lcs, testSetSizes[0]);
        LcsTestSet testSet2 = new LcsTestSet(lcs, testSetSizes[1]);
        LcsTestSet testSet3 = new LcsTestSet(lcs, testSetSizes[2]);
        LcsTestSet testSet4 = new LcsTestSet(lcs, testSetSizes[3]);

        EventProfiler ep = new EventProfiler(true);

        testSequential(new LengthTable(), testSet4.getStringA(), testSet4.getStringB());
        ep.log("Warmup");

        int repeatCount = 4;

        // Sequential
        for (int i = 0; i < repeatCount; i++) {
            testSequential(new LengthTable(), testSet1.getStringA(), testSet1.getStringB());
            ep.log("Sequential " + testSetSizes[0]);
        }

        for (int i = 0; i < repeatCount; i++) {
            testSequential(new LengthTable(), testSet2.getStringA(), testSet2.getStringB());
            ep.log("Sequential " + testSetSizes[1]);
        }

        for (int i = 0; i < repeatCount; i++) {
            testSequential(new LengthTable(), testSet3.getStringA(), testSet3.getStringB());
            ep.log("Sequential " + testSetSizes[2]);
        }

        for (int i = 0; i < repeatCount; i++) {
            testSequential(new LengthTable(), testSet4.getStringA(), testSet4.getStringB());
            ep.log("Sequential " + testSetSizes[3]);
        }


        // Concurrent 1 thread
        for (int i = 0; i < repeatCount; i++) {
            testConcurrentDiagonal(new LengthTable(), 1, 1500, testSet1.getStringA(), testSet1.getStringB());
            ep.log("Concurrent 1 thread " + testSetSizes[0]);
        }

        for (int i = 0; i < repeatCount; i++) {
            testConcurrentDiagonal(new LengthTable(), 1, 1500, testSet2.getStringA(), testSet2.getStringB());
            ep.log("Concurrent 1 thread " + testSetSizes[1]);
        }

        for (int i = 0; i < repeatCount; i++) {
            testConcurrentDiagonal(new LengthTable(), 1, 1500, testSet3.getStringA(), testSet3.getStringB());
            ep.log("Concurrent 1 thread " + testSetSizes[2]);
        }

        for (int i = 0; i < repeatCount; i++) {
            testConcurrentDiagonal(new LengthTable(), 1, 1500, testSet4.getStringA(), testSet4.getStringB());
            ep.log("Concurrent 1 thread " + testSetSizes[3]);
        }


        // Concurrent 4 threads
        for (int i = 0; i < repeatCount; i++) {
            testConcurrentDiagonal(new LengthTable(), 4, 1500, testSet1.getStringA(), testSet1.getStringB());
            ep.log("Concurrent 4 threads " + testSetSizes[0]);
        }

        for (int i = 0; i < repeatCount; i++) {
            testConcurrentDiagonal(new LengthTable(), 4, 1500, testSet2.getStringA(), testSet2.getStringB());
            ep.log("Concurrent 4 threads " + testSetSizes[1]);
        }

        for (int i = 0; i < repeatCount; i++) {
            testConcurrentDiagonal(new LengthTable(), 4, 1500, testSet3.getStringA(), testSet3.getStringB());
            ep.log("Concurrent 4 threads " + testSetSizes[2]);
        }

        for (int i = 0; i < repeatCount; i++) {
            testConcurrentDiagonal(new LengthTable(), 4, 1500, testSet4.getStringA(), testSet4.getStringB());
            ep.log("Concurrent 4 threads " + testSetSizes[3]);
        }

    }

    public static void testSequential(ILengthTable lengthTable, String a, String b) {
        LcsAlgorithm lcsSequential = new LcsSequential(lengthTable);
        lcsSequential.findLongestCommonSubsequence(a, b, false, false);
    }

    public static void testConcurrentDiagonal(ILengthTable lengthTable, int threadCount, int queuSize, String a, String b) {
        LcsAlgorithm lcsConcurrentDiagonal = new LcsConcurrentDiagonal(lengthTable, threadCount, queuSize);
        lcsConcurrentDiagonal.findLongestCommonSubsequence(a, b, false, false);
    }
}
