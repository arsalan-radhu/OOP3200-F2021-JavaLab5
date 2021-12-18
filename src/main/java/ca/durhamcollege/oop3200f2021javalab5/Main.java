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
        Label poundsLabel = new Label("/kilograms");
        Label inchesLabel = new Label("/meters");
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

    }

    public static void main(String[] args) {
        launch();
    }
}