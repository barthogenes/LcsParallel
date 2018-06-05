package com.hva.lcs.implementation;

import com.hva.lcs.model.lengthtable.interfaces.ILengthTable;
import com.hva.lcs.util.EventProfiler;

public abstract class LcsAlgorithm {

    protected ILengthTable lengthTable;
    protected EventProfiler eventProfiler;

    public LcsAlgorithm(ILengthTable lengthTable) {
        this.lengthTable = lengthTable;
    }

    public String findLongestCommonSubsequence(String a, String b, boolean upLeft, boolean showLog) {
        // Init LengthTable
        lengthTable.setStrings(a, b);

        // Init profiler
        eventProfiler = new EventProfiler(showLog);
        eventProfiler.start();

        compare();
        eventProfiler.log("Compared");

        String lcs = lengthTable.readLcsLeftUp(upLeft);
        eventProfiler.log("Reconstructed");

        return lcs;
    }

    protected abstract void compare();

    public int getDiagonalCell(int x, int y) {
        return lengthTable.get(x - 1, y - 1);
    }

    public int getCellAbove(int x, int y) {
        return lengthTable.get(x, y-1);
    }

    public int getCellLeft(int x, int y) {
        return lengthTable.get(x-1, y);
    }

    public boolean isMatch(int column, int row) {
        return lengthTable.getCharacters(column, row)[0] == lengthTable.getCharacters(column, row)[1];
    }

    public void handleMatch(int matchX, int matchY) {
        // Get left upper diagonal cell and add it to the value of the matching cell
        lengthTable.set(
                matchX,
                matchY,
                lengthTable.get(matchX - 1, matchY - 1) + 1);

    }

    public void handleMismatch(int missX, int missY) {
        // Get cell above and left of mismatch cell and assign the highest one to the mismatch cell
        int max = Math.max(lengthTable.get(missX - 1, missY), lengthTable.get(missX, missY - 1));
        lengthTable.set(
                missX,
                missY,
                max);

    }

}
