package com.hva.lcs.model.tablelog;

public class CellWriteAction extends TableOperation {

    private int valueWritten;

    public CellWriteAction(int x, int y, int valueWritten) {
        super(x, y);
        this.valueWritten = valueWritten;
    }

    public int getValueWritten() {
        return valueWritten;
    }

}
