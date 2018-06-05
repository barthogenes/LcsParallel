package com.hva.lcs.model.tablelog;

import com.hva.lcs.model.lengthtable.interfaces.AbstractLengthTable;
import com.hva.lcs.model.lengthtable.interfaces.LengthTableDecorator;

import java.util.ArrayList;
import java.util.List;

public class LengthTableWithLogging extends LengthTableDecorator {

    private List<TableOperation> actionsLog;

    public LengthTableWithLogging(AbstractLengthTable lengthTable) {
        super(lengthTable);
        actionsLog = new ArrayList<TableOperation>();
    }

    public List<TableOperation> getActionsLog() {
        return actionsLog;
    }

    public synchronized void set(int column, int row, int value) {
        lengthTable.set(column, row, value);
        actionsLog.add(new CellWriteAction(column, row, value));
    }

    public synchronized int get(int column, int row) {
        int valueRead = lengthTable.get(column, row);
        actionsLog.add(new CellReadAction(column, row, valueRead));
        return valueRead;
    }

}
