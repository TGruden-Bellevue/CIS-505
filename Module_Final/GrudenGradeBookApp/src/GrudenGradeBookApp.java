
/* Citations 

Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th
ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021

Payne, D., (2021). CSD 405 Intermediate Java Programming. Bellevue University, all
rights reserved

Java classes and objects. (n.d.-b). https://www.w3schools.com/

*/




import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GrudenGradeBookApp extends Application {
    private TextField firstNameField;
    private TextField lastNameField;
    private TextField courseField;
    private ComboBox<String> gradeComboBox;
    private TextArea resultsArea;

    @Override
    public void start(Stage primaryStage) {
        firstNameField = new TextField();
        lastNameField = new TextField();
        courseField = new TextField();
        gradeComboBox = new ComboBox<>();
        gradeComboBox.getItems().addAll("A", "B", "C", "D", "F");

        Label firstNameLabel = new Label("First Name:");
        Label lastNameLabel = new Label("Last Name:");
        Label courseLabel = new Label("Course:");
        Label gradeLabel = new Label("Grade:");

        Button clearButton = new Button("Clear");
        Button viewButton = new Button("View Grades");
        Button saveButton = new Button("Save");

        clearButton.setOnAction(e -> clearForm());
        viewButton.setOnAction(e -> viewGrades());
        saveButton.setOnAction(e -> saveGrade());

        resultsArea = new TextArea();
        resultsArea.setEditable(false);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(firstNameLabel, 0, 0);
        grid.add(firstNameField, 1, 0);
        grid.add(lastNameLabel, 0, 1);
        grid.add(lastNameField, 1, 1);
        grid.add(courseLabel, 0, 2);
        grid.add(courseField, 1, 2);
        grid.add(gradeLabel, 0, 3);
        grid.add(gradeComboBox, 1, 3);
        grid.add(clearButton, 0, 4);
        grid.add(viewButton, 1, 4);
        grid.add(saveButton, 2, 4);
        grid.add(resultsArea, 0, 5, 3, 1);

        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setTitle("Grade Book App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void clearForm() {
        firstNameField.clear();
        lastNameField.clear();
        courseField.clear();
        gradeComboBox.getSelectionModel().clearSelection();
    }

    private void saveGrade() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String course = courseField.getText();
        String grade = gradeComboBox.getValue();

        if (firstName.isEmpty() || lastName.isEmpty() || course.isEmpty() || grade == null) {
            showAlert("Validation Error", "All fields are required.");
            return;
        }

        Student student = new Student(firstName, lastName, course, grade);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("grades.csv", true))) {
            writer.write(student.toCSV());
            writer.newLine();
        } catch (IOException e) {
            showAlert("File Error", "Error writing to file.");
        }

        clearForm();
    }

    private void viewGrades() {
        resultsArea.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader("grades.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                resultsArea.appendText(line);
                resultsArea.appendText("\n");
            }
        } catch (IOException e) {
            showAlert("File Error", "Error reading from file.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
