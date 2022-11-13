package com.example.dictionaryapplication;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class DictionaryApplication extends Application {
    private Dictionary dict;

    public static void main(String[] args) {
        launch(DictionaryApplication.class);
    }

    @Override
    public void init() throws Exception {
        this.dict = new Dictionary();
    }

    @Override
    public void start(Stage stage) throws Exception {
        InputView inputView = new InputView(dict);
        StudyView studyView = new StudyView(dict);

        BorderPane layout = new BorderPane();

        // Create header menu
        HBox header = new HBox();
        header.setSpacing(10);

        Button newButton = new Button("Add new words");
        Button studyButton = new Button("Study");

        header.getChildren().addAll(newButton, studyButton);
        layout.setTop(header);

        layout.setCenter(inputView.getView());

        // Switch to the Input View
        newButton.setOnAction((event) -> {
            layout.setCenter(inputView.getView());
        });

        // Switch to the Study View
        studyButton.setOnAction((event) -> {
            layout.setCenter(studyView.getView());
        });

        // Create the layout
        Scene view = new Scene(layout, 300, 300);
        stage.setScene(view);
        stage.show();
    }
}
