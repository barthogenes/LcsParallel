package com.hva.parallel_computing;


import com.hva.lcs.util.EventProfiler;
import com.hva.lcs.util.LcsTestSet;
import com.hva.lcs.util.LcsTestSetFactory;

import java.util.ArrayList;

import static com.hva.lcs.util.LcsInputString.LcsPosition.START;

public class MainMeasuring {

    public static void main(String[] args) {
        // Init profiler
        EventProfiler eventProfiler = new EventProfiler(true);

        // testSet sizes
        int[] testSetSizes = new int[]{10000, 100000, 1000000, 10000000};

        // Init algorithms
        SerialLcs serialLcs = new SerialLcs();
        String lcs = "ABC";

        // Create test sets
        ArrayList<LcsTestSet> testSets = new ArrayList<>();
        for (int testSetSize : testSetSizes) {
            testSets.add(LcsTestSetFactory.CreateTestSet(lcs, testSetSize));
        }

        // Start solving test sets
        eventProfiler.start();
        for (LcsTestSet testSet : testSets) {
            serialLcs.runOn(testSet);
            eventProfiler.log("Finished test set with size of " + testSet.getTestSetSize());
        }
    }
}
