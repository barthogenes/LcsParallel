package com.hva.lcs.model.tablelog;

public class TableOperation {

    private int cellX;
    private int cellY;

    public TableOperation(int x, int y) {
        cellX = x;
        cellY = y;
    }

    public int getX() {
        return cellX;
    }

    public int getY() {
        return cellY;
    }

}
