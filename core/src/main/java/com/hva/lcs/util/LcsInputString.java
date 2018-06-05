package com.hva.lcs.util;

public class LcsInputString {

    public enum LcsPosition {
        START,
        END
    }

    private String inputString;

    public LcsInputString(char fillCharacter, int size) {
        this.inputString = generateLetterString(fillCharacter, size);
    }

    private String generateLetterString(char letter, int length) {
        StringBuffer outputBuffer = new StringBuffer(length);
        for (int i = 0; i < length; i++){
            outputBuffer.append(letter);
        }
        return outputBuffer.toString();
    }

    public String insertLcs(String lcs, LcsPosition position) {
        switch (position) {
            case START:
                return lcs + inputString;
            case END:
                return inputString + lcs;
            default:
                throw new IllegalArgumentException("No valid placement given!");
        }
    }
}
