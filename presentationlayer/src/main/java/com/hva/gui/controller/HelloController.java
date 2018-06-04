package com.hva.gui.controller;

import com.hva.lcs.implementation.LcsAlgorithm;
import com.hva.lcs.implementation.LcsConcurrentDiagonal;
import com.hva.lcs.model.lengthtable.implementation.LengthTable;
import com.hva.lcs.model.tablelog.ActionReplayer;
import com.hva.lcs.model.tablelog.LengthTableWithLogging;
import com.hva.lcs.model.tablelog.TableOperation;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloController
{
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @FXML private TableGridPane tableGridPane;
    @FXML private TextField textFieldA;
    @FXML private TextField textFieldB;
    @FXML private TextField textFieldLcs;
    @FXML private Button showTableButton;
    @FXML private Label actionTotalLabel;
    @FXML private Label actionNumberLabel;

    private LengthTableWithLogging lengthTable;
    private ActionReplayer actionReplayer;

    @FXML
    private void setupLengthsTableAndActionReplayer() {
        String a = textFieldA.getText();
        String b = textFieldB.getText();
        lengthTable = new LengthTableWithLogging(new LengthTable());
        lengthTable.setStrings(a, b);

        tableGridPane.setupLengthsTable(lengthTable);
        LcsAlgorithm lcs = new LcsConcurrentDiagonal(lengthTable, 1, 500);
        textFieldLcs.setText(lcs.findLongestCommonSubsequence(a, b, false, true));

        actionReplayer = new ActionReplayer(lengthTable.getActionsLog());

        actionTotalLabel.setText(actionReplayer.getActionsTotal() + "");

    }

    @FXML
    private void nextAction() {
        TableOperation action = actionReplayer.getNextAction();
        if (action != null) {
            tableGridPane.applyAction(action);
            actionNumberLabel.setText(actionReplayer.getActionNumber() + "");
        }
    }

    @FXML
    private void previousAction() {
        TableOperation action = actionReplayer.getPreviousAction();
        if (action != null) {
            tableGridPane.applyAction(action);
            actionNumberLabel.setText(actionReplayer.getActionNumber() + "");
        }
    }







}
