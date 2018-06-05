package com.hva.lcs.implementation;

import com.hva.lcs.model.lengthtable.interfaces.ILengthTable;

public class LcsSequential extends LcsAlgorithm {

    public LcsSequential(ILengthTable lengthTable) {
        super(lengthTable);
    }

    protected void compare() {
        for (int i = 1; i < lengthTable.getRowCount(); i++){
            for (int j = 1; j < lengthTable.getColumnCount(); j++){
                if (isMatch(j, i))
                {
                    handleMatch(j, i);
                }
                else
                {
                    handleMismatch(j, i);
                }
            }
        }
    }







}
