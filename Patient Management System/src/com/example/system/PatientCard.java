package com.example.system;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PatientCard extends VBox {
    public PatientCard(Patient patient) {
        Label nameLabel = new Label("Name: " + patient.getName());
        Label hrLabel = new Label("Heart Rate: " + patient.getHeartRate() + " bpm");

        this.getChildren().addAll(nameLabel, hrLabel);
        this.setSpacing(5);
        this.setStyle("-fx-padding: 10; -fx-border-color: gray; -fx-border-radius: 5;");
    }
}

