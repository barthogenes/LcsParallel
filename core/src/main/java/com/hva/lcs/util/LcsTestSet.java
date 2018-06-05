package com.hva.lcs.util;

public class LcsTestSet {
    
    private String stringA;
    private String stringB;
    private String lcs;
    private int testSetSize;

    public LcsTestSet(String a, String b, String answer) {
        this(a, b, answer, Math.max(a.length(), b.length()));
    }

    private LcsTestSet(String a, String b, String answer, int testSetSize) {
        this.stringA = a;
        this.stringB = b;
        this.lcs = answer;
        this.testSetSize = testSetSize;
    }

    public String getStringA() {
        return stringA;
    }
    public String getStringB() {
        return stringB;
    }
    public String getLcs() {
        return lcs;
    }
    public int getTestSetSize() {
        return testSetSize;
    }
}
