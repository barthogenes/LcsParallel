package com.hva.parallel_computing;


import com.hva.lcs.util.EventProfiler;
import com.hva.lcs.util.LcsTestSet;

import java.util.ArrayList;

import static com.hva.lcs.util.LcsInputStringFactory.LcsPositionWithinString;
import static com.hva.lcs.util.LcsInputStringFactory.LcsPositionWithinString.START;
import static com.hva.lcs.util.LcsInputStringFactory.LcsPositionWithinString.END;

public class MainMeasuring {

    public static void main(String[] args) {
        // Init profiler
        EventProfiler eventProfiler = new EventProfiler(true);

        // testSet sizes
        int[] testSetSizes = new int[]{10, 100, 1000, 10000};

        // Init algorithms
        SerialLcs serialLcs = new SerialLcs();
        String lcs = "ABC";

        // Create input strings
        ArrayList<LcsTestSet> testSets = new ArrayList<>();
        String tempA;
        String tempB;
        for (int testSetSize : testSetSizes) {
            tempA = LcsInputStringFactory.createInputString(lcs, START, '+', testSetSize);
            tempB = LcsInputStringFactory.createInputString(lcs, END, '-', testSetSize);
            testSets.add(new LcsTestSet(tempA, tempB, lcs));
        }

        eventProfiler.start();
        for (LcsTestSet testSet : testSets) {
            serialLcs.runOn(testSet);
            eventProfiler.log("Finished testset with size of " + testSet.getTestSetSize());
        }
    }
}
