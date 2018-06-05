package com.hva.parallel_computing;

import com.hva.lcs.LcsAlgorithm;

public class SerialLcs extends LcsAlgorithm {

    @Override
    public String findLongestCommonSubsequence(String a, String b) {
        String lcs = "";
        boolean match;
        int limit = 0;
        for (int i = 0; i < a.length(); i++) {
            for (int j = limit; j < b.length(); j++) {
                match = a.charAt(i) == b.charAt(j);
                if (match) {
                    lcs += b.charAt(j);
                    limit = j+1;
                    break;
                }
            }
        }
        return lcs;
    }
}
