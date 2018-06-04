package com.hva.gui.controller;

import com.hva.lcs.model.tablelog.CellReadAction;
import com.hva.lcs.model.tablelog.CellWriteAction;
import com.hva.lcs.model.tablelog.LengthTableWithLogging;
import com.hva.lcs.model.tablelog.TableOperation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class TableGridPane extends GridPane {

    private LengthTableWithLogging lengthTable;

    public void setupLengthsTable(LengthTableWithLogging lengthTable) {
        // Preserve and re-add the gridline node to keep gridlines visible
        Node node = getChildren().get(0);
        getChildren().clear();
        getChildren().add(0, node);

        // Setting up string axes
        addCell(0, 0, "");

        addCell(1, 0, "");
        for (int x = 1; x < lengthTable.getColumnCount(); x++) {
            addCell(x+1, 0, lengthTable.getStringA().charAt(x-1) + "");
        }
        addCell(0, 1, "");
        for (int y = 1; y < lengthTable.getRowCount(); y++) {
            addCell(0, y+1, lengthTable.getStringB().charAt(y-1) + "");
        }


        // Filling table with values
        for (int y = 0; y < lengthTable.getRowCount(); y++)
        {
            for(int x = 0; x < lengthTable.getColumnCount(); x++)
            {
                addCell(x+1, y+1, lengthTable.get(x, y) + "");
            }
        }
    }

    public void addCell(int x, int y, String text) {
        Label temp = new Label(text);
        temp.setPrefWidth(50);
        temp.setPrefHeight(50);
        temp.setAlignment(Pos.CENTER);
        setConstraints(temp, x, y);
        getChildren().add(temp);
    }

    public void setCell(int x, int y, String text) {
        getCell(x, y).setText(text);
    }

    public Label getCell(int x, int y) {
        int columnIndex, rowIndex = 0;
        for (Node node : getChildren()) {
            if (node.hasProperties()) {
                columnIndex = GridPane.getColumnIndex(node);
                rowIndex = GridPane.getRowIndex(node);
                if (columnIndex == x && rowIndex == y) {
                    return (Label) node;
                }
            }
        }
        return null;
    }

    public void refreshTable() {
        for (int y = 1; y < lengthTable.getRowCount(); y++)
        {
            for(int x = 1; x < lengthTable.getColumnCount(); x++)
            {
                setCell(x, y, lengthTable.get(x, y) + "");
            }
        }
    }

    private Background greenBackground = new Background(new BackgroundFill(Color.GREEN, null, null));
    private Background redBackground = new Background(new BackgroundFill(Color.RED, null, null));

    public void applyAction(TableOperation action) {
        CellReadAction readAction;
        CellWriteAction writeAction;

        int x = action.getX()+1;
        int y = action.getY()+1;
        if (action instanceof CellReadAction) {
            getCell(x, y).setBackground(greenBackground);
        }

        if (action instanceof CellWriteAction) {
            writeAction = (CellWriteAction) action;
            getCell(x, y).setBackground(redBackground);
            setCell(x, y, writeAction.getValueWritten()+ "");
        }
    }

}
