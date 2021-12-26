package ru.geekbrains.lesson4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    public TextArea mainTextArea;
    public TextField mainTextField;


    public void clickButton(ActionEvent actionEvent) {
        if (!mainTextField.getText().equals("")){
            mainTextArea.appendText(mainTextField.getText() + "\n");
            mainTextField.setText("");
            mainTextField.requestFocus(); //для фокуса на поле
        }

    }
}
