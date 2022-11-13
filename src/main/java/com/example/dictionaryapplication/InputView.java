package com.example.dictionaryapplication;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InputView {
    private Dictionary dict;

    public InputView(Dictionary dict) {
        this.dict = dict;
    }

    public Parent getView() {
        GridPane layout = new GridPane();

        Label word = new Label("Word:");
        TextField wordField = new TextField();

        Label translatedWord = new Label("Translation:");
        TextField translationField = new TextField();

        Button addButton = new Button("add");

        layout.add(word, 0, 0);
        layout.add(wordField, 0, 1);
        layout.add(translatedWord, 0,2);
        layout.add(translationField, 0, 3);
        layout.add(addButton, 0, 4);

        addButton.setOnAction((event) -> {
            String newWord = wordField.getText();
            String newTranslation = translationField.getText();
            dict.add(newWord, newTranslation);

            wordField.clear();
            translationField.clear();
        });

        return layout;
    }
}
