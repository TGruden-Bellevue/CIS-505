/* Citations 

Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th
ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021

Payne, D., (2021). CSD 405 Intermediate Java Programming. Bellevue University, all
rights reserved

Java classes and objects. (n.d.-b). https://www.w3schools.com/

YouTube. (2020, October 6). How to setup javafx environment in visual studio code?. YouTube. https://www.youtube.com/watch?v=H67COH9F718 

Connecting to. BRUIN Connect - Sign In. (n.d.). https://bellevue.mediaspace.kaltura.com/media/JavaFX+Intro/1_tv5kbdpm/6624231 

*/


import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GrudenEnhancedFutureValueApp extends Application {

    // Constants
    private static final int MONTHS_IN_YEAR = 12;

    // GUI components
    private TextField txtMonthlyPayment, txtInterestRate;
    private ComboBox<Integer> cbYears;
    private Button btnClear, btnCalculate;
    private Label lblFutureValueDate, lblInterestRateHint;
    private TextArea txtResults;

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Set the title of the primary stage
        primaryStage.setTitle("Gruden Enhanced Future Value");

        // Create a grid pane for organizing UI components
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Create text fields, combo box, buttons, labels, and text area
        txtMonthlyPayment = new TextField();
        txtInterestRate = new TextField();
        cbYears = new ComboBox<>();
        btnClear = new Button("Clear");
        btnCalculate = new Button("Calculate");
        lblFutureValueDate = new Label("Calculation as of " + getCurrentDate());
        txtResults = new TextArea();
        lblInterestRateHint = new Label();

        // Populate ComboBox with years 1-30
        for (int i = 1; i <= 30; i++) {
            cbYears.getItems().add(i);
        }

        // Set event handlers for buttons
        btnClear.setOnAction(e -> clearFormFields());
        btnCalculate.setOnAction(e -> calculateResults());

        // Add components to the grid pane
        gridPane.add(new Label("Monthly Payment:"), 0, 0);
        gridPane.add(txtMonthlyPayment, 1, 0);
        gridPane.add(new Label("Interest Rate:"), 0, 1);
        gridPane.add(txtInterestRate, 1, 1);
        gridPane.add(lblInterestRateHint, 1, 2);
        gridPane.add(new Label("Years:"), 0, 2);
        gridPane.add(cbYears, 1, 2);

        // Create a horizontal box for action buttons
        HBox actionBtnContainer = new HBox(10);
        actionBtnContainer.setAlignment(Pos.CENTER);
        actionBtnContainer.getChildren().addAll(btnClear, btnCalculate);
        gridPane.add(actionBtnContainer, 1, 3);

        // Align the future value date label and results text area in the center
        GridPane.setHalignment(lblFutureValueDate, HPos.CENTER);
        gridPane.add(lblFutureValueDate, 0, 4, 2, 1);
        gridPane.add(txtResults, 0, 5, 2, 1);
        GridPane.setHalignment(txtResults, HPos.CENTER);

        // Set red text under the interest rate box
        lblInterestRateHint.setText("11.1% as 11.1");
        lblInterestRateHint.setTextFill(Color.RED);
        lblInterestRateHint.setFont(Font.font("Arial", 10));

        // Create the scene and set it to the stage
        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to clear form fields
    private void clearFormFields() {
        txtMonthlyPayment.setText("");
        txtInterestRate.setText("");
        cbYears.getSelectionModel().clearSelection();
        txtResults.setText("");
        lblFutureValueDate.setText("Calculation as of " + getCurrentDate());
    }

    // Method to calculate future value
    private void calculateResults() {
        try {
            double monthlyPayment = Double.parseDouble(txtMonthlyPayment.getText());
            double rate = Double.parseDouble(txtInterestRate.getText());
            int years = cbYears.getValue();

            double futureValue = calculateFutureValue(monthlyPayment, rate, years);
            txtResults.setText("The future value is " + String.format("%.2f", futureValue));
            lblFutureValueDate.setText("Calculation as of " + getCurrentDate());
        } catch (NumberFormatException e) {
            txtResults.setText("Please enter valid numeric values.");
        }
    }

    // Method to calculate future value based on monthly payment, interest rate, and years
    private double calculateFutureValue(double monthlyPayment, double rate, int years) {
        int months = years * MONTHS_IN_YEAR;
        double interestRate = 1 + rate / 100;
        double presentValue = monthlyPayment * months;
        return presentValue * Math.pow(interestRate, months);
    }

    // Method to get current date in MM/dd/yyyy format
    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormat.format(new Date());
    }
}
