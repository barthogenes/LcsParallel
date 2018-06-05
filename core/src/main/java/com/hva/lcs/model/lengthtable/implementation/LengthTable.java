package com.hva.lcs.model.lengthtable.implementation;

import com.hva.lcs.model.lengthtable.interfaces.AbstractLengthTable;

public class LengthTable extends AbstractLengthTable {

    private int[][] lengths;

    public LengthTable() {
        super();
    }

    protected void initTable() {
        // Adding an extra row and column for holding the zeroes
        this.lengths = new int[a.length()+1][b.length()+1];
    }

    public void set(int column, int row, int value) {
        this.lengths[column][row] = value;
    }

    public int get(int column, int row) {
        return this.lengths[column][row];
    }

    public int getColumnCount() {
        return lengths.length;
    }

    public int getRowCount() {
        return lengths[0].length;
    }

    public void setTable(int[][] table) {
        lengths = table;
    }

    public String getStringA() { return this.a; }

    public String getStringB() { return this.b; }

}
