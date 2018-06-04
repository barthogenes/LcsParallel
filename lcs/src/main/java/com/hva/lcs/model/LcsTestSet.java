package com.hva.lcs.model;

import com.hva.lcs.util.RandomUtil;

public class LcsTestSet {
    
    private String stringA;
    private String stringB;
    private String lcs;

    public LcsTestSet(String a, String b, String answer) {
        this.stringA = a;
        this.stringB = b;
        this.lcs = answer;
    }
    
    public LcsTestSet(String lcs, int stringLength) {
        this.lcs = lcs;
        this.stringA = "";
        this.stringB = "";
        
        String tempLcs = this.lcs;
        while (tempLcs.length() > 0) {
            this.stringA += RandomUtil.getRandomLengthString('+');
            this.stringA += tempLcs.substring(0, 1);
            tempLcs = tempLcs.substring(1);
        }
        
        if (stringA.length() < stringLength) {
            for (int i = 0; i < stringLength - stringA.length(); i++) {
                this.stringA += '+';
            }
        }
        
        tempLcs = this.lcs;
        while (tempLcs.length() > 0) {
            this.stringB += RandomUtil.getRandomLengthString('-');
            this.stringB += tempLcs.substring(0, 1);
            tempLcs = tempLcs.substring(1);
        }
        
        if (stringB.length() < stringLength) {
            for (int i = 0; i < stringLength - stringB.length(); i++) {
                this.stringB += '-';
            }
        }     
    }

    public String getStringA() {
        return stringA;
    }

    public void setStringA(String stringA) {
        this.stringA = stringA;
    }

    public String getStringB() {
        return stringB;
    }

    public void setStringB(String stringB) {
        this.stringB = stringB;
    }

    public String getLcs() {
        return lcs;
    }

    public void setLcs(String lcs) {
        this.lcs = lcs;
    }
    
    
    
}
