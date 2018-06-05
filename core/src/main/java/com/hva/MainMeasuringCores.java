package com.hva;

public class MainMeasuringCores {

    public static void main(String[] args) {
//        String lcs = "ADH";
//
//        int[] testSetSizes = new int[]{100, 1000, 2500, 5000};
//        LcsTestSet testSet1 = new LcsTestSet(lcs, testSetSizes[0]);
//        LcsTestSet testSet2 = new LcsTestSet(lcs, testSetSizes[1]);
//        LcsTestSet testSet3 = new LcsTestSet(lcs, testSetSizes[2]);
//        LcsTestSet testSet4 = new LcsTestSet(lcs, testSetSizes[3]);
//
//        EventProfiler ep = new EventProfiler(true);
//
//        testSequential(new LengthTable(), testSet4.getStringA(), testSet4.getStringB());
//        ep.log("Warmup");
//
//        int repeatCount = 4;
//
//        for (int j = 1; j < 7; j++) {
//            for (int i = 0; i < repeatCount; i++) {
//                testConcurrentDiagonal(new LengthTable(), j, 1500, testSet1.getStringA(), testSet1.getStringB());
//                ep.log("Concurrent " + j + " thread " + testSetSizes[0]);
//            }
//
//            for (int i = 0; i < repeatCount; i++) {
//                testConcurrentDiagonal(new LengthTable(), j, 1500, testSet2.getStringA(), testSet2.getStringB());
//                ep.log("Concurrent " + j + " thread " + testSetSizes[1]);
//            }
//
//            for (int i = 0; i < repeatCount; i++) {
//                testConcurrentDiagonal(new LengthTable(), j, 1500, testSet3.getStringA(), testSet3.getStringB());
//                ep.log("Concurrent " + j + " thread " + testSetSizes[2]);
//            }
//
//            for (int i = 0; i < repeatCount; i++) {
//                testConcurrentDiagonal(new LengthTable(), j, 1500, testSet4.getStringA(), testSet4.getStringB());
//                ep.log("Concurrent " + j + " thread " + testSetSizes[3]);
//            }
//        }

    }

//    public static void testSequential(ILengthTable lengthTable, String a, String b) {
//        LcsAlgorithm lcsSequential = new LcsSequential(lengthTable);
//        lcsSequential.findLongestCommonSubsequence(a, b, false, false);
//    }
//
//    public static void testConcurrentDiagonal(ILengthTable lengthTable, int threadCount, int queuSize, String a, String b) {
//        LcsAlgorithm lcsConcurrentDiagonal = new LcsConcurrentDiagonal(lengthTable, threadCount, queuSize);
//        lcsConcurrentDiagonal.findLongestCommonSubsequence(a, b, false, false);
//    }
}
