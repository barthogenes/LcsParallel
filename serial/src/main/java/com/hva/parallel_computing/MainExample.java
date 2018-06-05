package com.hva.parallel_computing;


import com.hva.lcs.LcsAlgorithm;

public class MainExample {

    public static void main(String[] args) {
        String a = "BDCABA";
        String b = "ABCBDAB";
        String lcs = "BDAB";

        LcsAlgorithm serialLcs = new SerialLcs();

        System.out.println(a);
        System.out.println(b);
        System.out.println(serialLcs.findLongestCommonSubsequence(a, b));
        System.out.println();
    }
}
