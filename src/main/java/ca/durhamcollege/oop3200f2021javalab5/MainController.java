package ca.durhamcollege.oop3200f2021javalab5;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onSampleButtonClick() {
        welcomeText.setText("Welcome to Java Lab 5!");
    }
}