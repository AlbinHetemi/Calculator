package com.example.cactttuscalculator2022javafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {
    @FXML
    private TextField txtResult;

    @FXML
    private Button btnClear;

    private double result = 0;

    private String lastOperator = "";
    private String operator = "";


    public void btnNumeberClick(ActionEvent actionEvent) {

        if (!operator.isEmpty()) {
            txtResult.setText("0");
            operator = "";
        }

        Button btn = (Button) actionEvent.getTarget();
//        System.out.println(txtResult.getText() + btn.getText());
        if (txtResult.getText().equals("0")) {
            txtResult.setText(btn.getText());
        } else {
            txtResult.setText(txtResult.getText() + btn.getText());
        }

    }

    private void resetForm() {
        txtResult.setText("0");
        lastOperator = operator = "";
        result = 0;
    }

    public void btnPik(ActionEvent actionEvent) {
        if (txtResult.getText().contains(".")) {
            txtResult.setText(txtResult.getText() + ".");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("U thirr");

//        btnClear.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                resetForm();
//            }
//        });

        btnClear.setOnAction(actionEvent -> resetForm());

//        btnClear.setOnAction(CalculatorController :: btnNumeberClick);
    }

    public void onOperantClick(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getTarget();
        double vlera = Double.parseDouble(txtResult.getText());

        operator = btn.getText();
        switch (lastOperator) {
            case "+" -> {
                result += vlera;
            }
            case "-" -> {
                result -= vlera;
            }
            case "x" -> {
                result *= vlera;
            }
            case "/" -> {
                if (vlera != 0) {
                    result /= vlera;
                } else {
                    result = result >= 0 ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
                }
            }
            default -> {
                result = vlera;
            }
        }
        txtResult.setText(String.valueOf(result));
        lastOperator = operator;
    }
}
