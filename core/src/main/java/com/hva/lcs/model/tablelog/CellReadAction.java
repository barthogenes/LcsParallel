package com.hva.lcs.model.tablelog;

public class CellReadAction extends TableOperation {

    private int valueRead;

    public CellReadAction(int x, int y, int valueRead) {
        super(x, y);
        this.valueRead = valueRead;
    }

    public int getValueRead() {
        return valueRead;
    }

}
