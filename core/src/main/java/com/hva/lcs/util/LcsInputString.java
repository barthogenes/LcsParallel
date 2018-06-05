package com.hva.lcs.util;

public class LcsInputString {

    private final char fillCharacter;
    private final int size;

    public enum LcsPosition {
        START,
        END
    }

    public LcsInputString(char fillCharacter, int size) {
        this.fillCharacter = fillCharacter;
        this.size = size;
    }

    private String generateLetterString(char letter, int length) {
        StringBuffer outputBuffer = new StringBuffer(length);
        for (int i = 0; i < length; i++){
            outputBuffer.append(letter);
        }
        return outputBuffer.toString();
    }

    public String insertLcs(String lcs, LcsPosition position) {
        String inputString = generateLetterString(fillCharacter, size - lcs.length());
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
