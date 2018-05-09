package com.calc;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

import java.awt.*;

public class Controller {
    @FXML
    private Text output;
    private long number1 = 0;
    private String operator="";
    Model model = new Model();
    boolean start = true;
    @FXML
    private void processNumpad(ActionEvent event){
        if (start){
            output.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText()+value);
    }
    @FXML
    private void processOperator(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (!"=".equals(value)){
            if (!operator.isEmpty()) { return; }

            operator = value;
            number1 = Long.parseLong(output.getText());
            output.setText("");
        } else {
            if (operator.isEmpty()) { return; }
            long result = model.calculation(number1, Long.parseLong(output.getText()), operator);
            output.setText(String.valueOf(result));
            operator = "";
            start = true;
        }
    }
}
