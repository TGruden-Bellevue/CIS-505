import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GrudenGradeBookApp extends Application {
    private TextField firstNameField;
    private TextField lastNameField;
    private TextField courseField;
    private ComboBox<String> gradeComboBox;
    private TextArea resultsArea;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Grade Book App");

        // Create the form fields
        firstNameField = new TextField();
        lastNameField = new TextField();
        courseField = new TextField();
        gradeComboBox = new ComboBox<>();
        gradeComboBox.getItems().addAll("A", "B", "C", "D", "F");

        // Create labels
        Label firstNameLabel = new Label("First Name:");
        Label lastNameLabel = new Label("Last Name:");
        Label courseLabel = new Label("Course:");
        Label gradeLabel = new Label("Grade:");

        // Create buttons
        Button clearButton = new Button("Clear");
        Button viewButton = new Button("View Grades");
        Button saveButton = new Button("Save");

        // Add button actions
        clearButton.setOnAction(e -> clearForm());
        viewButton.setOnAction(e -> viewGrades());
        saveButton.setOnAction(e -> saveGrade());

        // Create results area
        resultsArea = new TextArea();
        resultsArea.setEditable(false);

        // Layout the form
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
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
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void clearForm() {
        firstNameField.clear();
        lastNameField.clear();
        courseField.clear();
        gradeComboBox.getSelectionModel().clearSelection();
    }

    private void viewGrades() {
        // This will be implemented to read and display the grades from the file
    }

    private void saveGrade() {
        // This will be implemented to save the grade to a file
    }

    public static void main(String[] args) {
        launch(args);
    }
}
