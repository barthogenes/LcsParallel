package com.hva.lcs.model.lengthtable.implementation;

import com.hva.lcs.model.lengthtable.interfaces.AbstractLengthTable;

import java.util.concurrent.atomic.AtomicIntegerArray;

// TODO: Not implemented yet
public class AtomicLengthTable extends AbstractLengthTable {

    private String a;
    private String b;
    protected AtomicIntegerArray[][] lengths;

    public AtomicLengthTable() {
        super();
    }

    public String getStringA() { return this.a; }

    public String getStringB() { return this.b; }

    public void setTable(int[][] table) {

    }

    protected void initTable() {

    }

    public void clearTable() {
        this.lengths = new AtomicIntegerArray[a.length()+1][b.length()+1];
        for (int i = 1; i < lengths.length; i++) {
            for (int j = 1; j < lengths[0].length; j++) {
                lengths[i][j].set(0, 0);
            }
        }


//        for (int i = 1; i < lengths.length; i++) {
//            for (int j = 1; j < lengths[0].length; j++) {
//                lengths[i][j] = -1;
//            }
//        }
    }

    public void set(int x, int y, int value) {

    }

    public int get(int x, int y) {
        return 0;
    }

}
