package com.hva.lcs.util;

import static com.hva.lcs.util.LcsInputString.LcsPosition.END;
import static com.hva.lcs.util.LcsInputString.LcsPosition.START;

public class LcsTestSetFactory {

    public LcsTestSetFactory() {

    }


    public static LcsTestSet CreateTestSet(String lcs, int size) {
        String a = new LcsInputString('+', size).insertLcs(lcs, START);
        String b = new LcsInputString('-', size).insertLcs(lcs, END);
        return new LcsTestSet(a, b, lcs);
    }

}
