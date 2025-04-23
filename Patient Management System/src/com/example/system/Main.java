package com.example.system;

//import javafx.application.*;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.stage.*;
//
//
//import java.io.IOException;
//
//public class HelloApplication extends Application {
//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Java FX first Project");
//        TextField tf= new TextField();
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
//}
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField nameInput = new TextField();
        nameInput.setPromptText("Enter patient name");

        TextField hrInput = new TextField();
        hrInput.setPromptText("Enter heart rate");

        Button addButton = new Button("Add Patient");

        VBox patientList = new VBox(10);

        addButton.setOnAction(e -> {
            String name = nameInput.getText();
            int heartRate;

            try {
                heartRate = Integer.parseInt(hrInput.getText());
                Patient patient = new Patient(name, heartRate);
                PatientCard card = new PatientCard(patient);
                patientList.getChildren().add(card);

                nameInput.clear();
                hrInput.clear();
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Heart rate must be a number.");
                alert.showAndWait();
            }

        });

        VBox layout = new VBox(10, nameInput, hrInput, addButton, new Separator(), patientList);
        layout.setStyle("-fx-padding: 20;");

        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Patient Info Viewer");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
