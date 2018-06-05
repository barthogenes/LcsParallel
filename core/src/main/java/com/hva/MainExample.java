package com.hva;

import com.hva.lcs.implementation.LcsAlgorithm;
import com.hva.lcs.implementation.LcsConcurrentDiagonal;
import com.hva.lcs.implementation.LcsSequential;
import com.hva.lcs.model.lengthtable.implementation.LengthTable;
import com.hva.lcs.model.lengthtable.interfaces.ILengthTable;

public class MainExample {

    public static void main(String[] args) {
        exampleSequential();

        exampleConcurrent();
    }

    public static void exampleSequential() {
        String a = "BDCABA";
        String b = "ABCBDAB";
        String lcsAnswer = "BDAB";

        ILengthTable lengthTable = new LengthTable();
        LcsAlgorithm lcs = new LcsSequential(lengthTable);

        System.out.println(a);
        System.out.println(b);
        System.out.println(lcs.findLongestCommonSubsequence(a, b, false, true));
        System.out.println();
    }


    public static void exampleConcurrent() {
        String a = "BDCABA";
        String b = "ABCBDAB";
        String lcsAnswer = "BDAB";

        ILengthTable lengthTable = new LengthTable();

        LcsAlgorithm lcs = new LcsConcurrentDiagonal(lengthTable, 1, 500);

        System.out.println(a);
        System.out.println(b);
        System.out.println(lcs.findLongestCommonSubsequence(a, b, false, true));
        System.out.println();
    }
}
