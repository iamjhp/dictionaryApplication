package com.example.dictionaryapplication;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class StudyView {
    private Dictionary dict;
    private String word;

    public StudyView(Dictionary dict) {
        this.dict = dict;
        this.word = dict.getRandomWord();
    }

    public Parent getView() {
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);

        Label toTranslate = new Label("Translate this word: " + this.word);
        TextField translationField = new TextField();
        Button checkButton = new Button("Check");
        Label message = new Label("");

        layout.add(toTranslate, 0, 0);
        layout.add(translationField, 0, 1);
        layout.add(checkButton, 0, 3);
        layout.add(message, 0, 4);

        checkButton.setOnAction((event) -> {
            String translation = translationField.getText();

            if (dict.get(this.word).equals(translation)) {
                message.setText("Correct answer! " + this.word + " <-> " + translation);
                this.word = this.dict.getRandomWord();
            } else {
                message.setText("Wrong! Try again");
            }

            toTranslate.setText("Translate this word: " + this.word);
            translationField.clear();
        });

        return layout;
    }
}
