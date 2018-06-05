package com.hva.lcs.model.lengthtable.interfaces;

import com.hva.lcs.model.Slice;

import java.util.ArrayList;

public interface ILengthTable {

    void setStrings(String a, String b);

    void set(int column, int row, int value);

    int get(int column, int row);

    char[] getCharacters(int column, int row);

    String readLcsLeftUp(boolean upLeft);

    ArrayList<Slice> getDiagonalPoints();

    String getStringA();
    String getStringB();

    int getRowCount();
    int getColumnCount();

}
