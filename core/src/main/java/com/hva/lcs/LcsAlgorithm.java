package com.hva.lcs;

import com.hva.lcs.util.LcsTestSet;

public abstract class LcsAlgorithm {
    public abstract String findLongestCommonSubsequence(String a, String b);
    public String runOn(LcsTestSet testSet){
        String lcs = findLongestCommonSubsequence(testSet.getStringA(), testSet.getStringB());
        assert lcs == testSet.getLcs();
        return lcs;
    }
}
