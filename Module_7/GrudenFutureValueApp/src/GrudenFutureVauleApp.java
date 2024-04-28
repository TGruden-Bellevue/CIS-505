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
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.*;

public class GrudenFutureVauleApp extends Application {

    private TextField textField1, textField2; // declare other controls similarly
    private Label lblMonthlyPayment = new Label("Monthly Payment:");
    private Label lblInterestRate = new Label("Interest Rate:");
    private ComboBox<Integer> yearsComboBox = new ComboBox<>();
    private Button btnClear = new Button("Clear");
    private Button btnCalculate = new Button("Calculate");
    private TextArea resultArea = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        // Create controls
        textField1 = new TextField();
        textField2 = new TextField();
        // create other controls similarly
        
        // Set text for labels and buttons
        
        // Create GridPane and configure
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        gridPane.setHgap(5.5);
        gridPane.setVgap(5.5);
        
        // Add controls to the GridPane
        gridPane.add(lblMonthlyPayment, 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(lblInterestRate, 0, 1);
        gridPane.add(textField2, 1, 1);
        
        // Add ComboBox for years
        gridPane.add(new Label("Years:"), 0, 2);
        for (int i = 1; i <= 30; i++) { // Add years from 1 to 30
            yearsComboBox.getItems().add(i);
        }
        yearsComboBox.setValue(1); // Set default value
        gridPane.add(yearsComboBox, 1, 2);
        
        // Add red text to the right side of the screen
        Text redText = new Text("Enter 11.1% as 11.1");
        redText.setFill(Color.RED);
        GridPane.setHalignment(redText, HPos.RIGHT);
        gridPane.add(redText, 0, 3, 2, 1); // Span 2 columns
        
        // Group buttons in an HBox
        HBox actionBtnContainer = new HBox();
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        actionBtnContainer.setSpacing(10);
        actionBtnContainer.getChildren().add(btnClear);
        actionBtnContainer.getChildren().add(btnCalculate);
        gridPane.add(actionBtnContainer, 1, 4);
        
        // Add TextArea for displaying results
        gridPane.add(resultArea, 0, 5, 2, 1);
        GridPane.setHalignment(resultArea, HPos.CENTER);
        resultArea.setEditable(false);
        resultArea.setPrefRowCount(5);
        
        // Set action for Calculate button
        btnCalculate.setOnAction(e -> calculateFutureValue());
        
        // Set stage title
        primaryStage.setTitle("GrudenFutureValueApp");

        // Set scene
        primaryStage.setScene(new Scene(gridPane, 400, 300));
        primaryStage.show();
    }
    
    // Method to calculate future value
    private void calculateFutureValue() {
        try {
            double monthlyPayment = Double.parseDouble(textField1.getText());
            double interestRate = Double.parseDouble(textField2.getText()) / 100.0; // Convert interest rate to decimal
            int years = yearsComboBox.getValue();
    
            // Calculate future value
            double futureValue = monthlyPayment * Math.pow(1 + interestRate, years);
    
            // Display result in TextArea
            resultArea.setText("Future Value: $" + String.format("%.2f", futureValue));
        } catch (NumberFormatException e) {
            resultArea.setText("Invalid input. Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}


    