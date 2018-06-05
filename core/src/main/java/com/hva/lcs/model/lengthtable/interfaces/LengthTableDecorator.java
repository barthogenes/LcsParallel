package com.hva.lcs.model.lengthtable.interfaces;

import com.hva.lcs.model.Slice;

import java.util.ArrayList;

public abstract class LengthTableDecorator implements ILengthTable {

    protected AbstractLengthTable lengthTable;

    public LengthTableDecorator(AbstractLengthTable lengthTable) {
        this.lengthTable = lengthTable;
    }

    public void set(int column, int row, int value) {
        lengthTable.set(column, row, value);
    }

    public int get(int column, int row) {
        return lengthTable.get(column, row);
    }

    public char[] getCharacters(int column, int row) {return lengthTable.getCharacters(column, row);}

    public String readLcsLeftUp(boolean upLeft) {
        return lengthTable.readLcsLeftUp(upLeft);
    }

    public ArrayList<Slice> getDiagonalPoints() {
        return lengthTable.getDiagonalPoints();
    }

    public int getRowCount() {
        return lengthTable.getRowCount();
    }

    public int getColumnCount() {
        return  lengthTable.getColumnCount();
    }

    public String getStringA() {
        return lengthTable.getStringA();
    }

    public String getStringB() {
        return lengthTable.getStringB();
    }

    public void setStrings(String a, String b) {
        lengthTable.setStrings(a, b);
    }
}
