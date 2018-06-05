package com.hva.lcs.model;

import java.io.Serializable;

public class TablePoint implements Serializable {

    private int column;
    private int row;

    public TablePoint(int column, int row) {
        this.column = column;
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString() {
        return "column = " + column + ", row = " + row;
    }
}
