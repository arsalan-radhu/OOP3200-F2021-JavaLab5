package ca.durhamcollege.oop3200f2021javalab5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main extends Application {

    // Set height and width attributes
    public static int WIDTH = 550;
    public static int HEIGHT = 350;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Java Lab 5");

        //SETTING THE STAGE
        primaryStage.setHeight(HEIGHT);
        primaryStage.setWidth(WIDTH);
        primaryStage.setMaxHeight(HEIGHT);
        primaryStage.setMaxWidth(WIDTH);
        primaryStage.setMinHeight(HEIGHT);
        primaryStage.setMinWidth(WIDTH);

        // LABEL CONTROLS
        Label weightLabel = new Label("   My Weight: ");
        Label heightLabel = new Label("   My Height: ");
        Label kgLabel = new Label("/kilograms");
        Label meterLabel = new Label("/meters");
        Label bmiLabel = new Label("      My BMI: ");
        Label bmiStringLabel = new Label("");
        bmiStringLabel.setWrapText(true);
        bmiStringLabel.setMaxWidth(500);

        // TEXT FIELDS
        TextField weightInput = new TextField();
        TextField heightInput = new TextField();
        TextField bmiOutput = new TextField();

        // BUTTON
        Button calculateBMI = new Button("Calculate BMI");

        // OUTPUT
        bmiOutput.setEditable(false);

        // SETTING FONT
        Font font = Font.font("Helvetica", FontWeight.NORMAL, 20);

        // SETTING FONT TO ATTRIBUTES
        weightLabel.setFont(font);
        heightLabel.setFont(font);
        kgLabel.setFont(font);
        meterLabel.setFont(font);
        bmiLabel.setFont(font);
        bmiStringLabel.setFont(font);
        calculateBMI.setFont(font);

        // BUTTON HANDLER/ BMI CALCULATIONS
        calculateBMI.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                boolean isValid = true;
                double bmi;
                String bmiString;
                String bmiOut;
                String bmiResult = "";
                String errorMessage = "";

                // VALIDATE INPUT EMPTY OR NOT
                if(heightInput.getText() == null || heightInput.getText().trim().isEmpty())
                {
                    errorMessage += "Height should not be empty!\n ";
                    isValid = false;
                }
                if(weightInput.getText() == null || weightInput.getText().trim().isEmpty())
                {
                    errorMessage+= "Weight should not be empty!\n ";
                    isValid = false;
                }

                if(isValid)
                {
                    // CHECK INPUT IS NUMERIC OR NOT
                    double attemptParse;
                    try
                    {
                        attemptParse = Double.parseDouble(weightInput.getText());
                        attemptParse = Double.parseDouble(heightInput.getText());
                    }
                    catch (NumberFormatException numberFormatException)
                    {
                        errorMessage += "NUMERIC input only!\n ";
                        isValid = false;
                    }
                }

                if(isValid)
                {
                    // CHECK INPUT IS WITHIN ACCEPTABLE RANGE
                    double MAX_HEIGHT = 2.51; // Tallest person on Earth
                    double MIN_HEIGHT = 0.54; // Shortest person on Earth
                    double MAX_WEIGHT = 635; // Heaviest person on Earth
                    double MIN_WEIGHT = 2; // Lightest person on Earth
                    if(Double.parseDouble(heightInput.getText()) > MAX_HEIGHT && Double.parseDouble(heightInput.getText()) < MIN_HEIGHT)
                    {
                        errorMessage += "Height should be between "+ MAX_HEIGHT + " and "+ MIN_HEIGHT+". \n";
                        isValid = false;
                    }
                    else if(Double.parseDouble(weightInput.getText()) > MAX_WEIGHT && Double.parseDouble(weightInput.getText()) < MIN_WEIGHT)
                    {
                        errorMessage += "Weight should be between "+ MAX_WEIGHT + " and "+ MIN_WEIGHT+". \n";
                        isValid = false;
                    }
                }

                // PRINT ERROR MESSAGE
                if(!errorMessage.trim().isEmpty())
                {
                    errorMessage += "Please try again!";
                }
                bmiStringLabel.setText(errorMessage);

                // IF INPUT IS VALID, CALCULATE BMI
                if (isValid == true)
                {
                    bmi = (Double.parseDouble(weightInput.getText())) /
                            (Double.parseDouble(heightInput.getText()) * Double.parseDouble(heightInput.getText()));
                    bmiString = String.format("%.1f", bmi);
                    bmiOut = String.format("With a bmi of %.1f you are considered ", bmi);

                    // RESULT OF BMI CALCULATIONS
                    if (bmi < 18.5)
                    {
                        bmiResult = "Underweight.";
                    }
                    else if (bmi >= 18.5 && bmi <= 24.9)
                    {
                        bmiResult = "Normal.";
                    }
                    else if (bmi >= 25 && bmi <= 29.9)
                    {
                        bmiResult = "Overweight.";
                    }
                    else if(bmi > 30)
                    {
                        bmiResult = "Obese.";
                    }

                    // RESULT
                    bmiOutput.setText(bmiString);
                    bmiStringLabel.setText(bmiOut + bmiResult);
                }
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}