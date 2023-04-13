package com.example.javalab3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.converter.LocalDateStringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PersonalDataParseView {
    @FXML private TextField inputName;
    @FXML private DatePicker inputDate;
    @FXML private Label outputName;
    @FXML private Label outputAge;
    @FXML private Label errorText;

    /**
     * when you click on the button, the function is called and performs all the necessary actions to obtain the initials, gender and age of a person, and also throws a warning if the date of birth is entered incorrectly, catches all the exceptions in the code and displays the error code in the appropriate field on the screen
     */
    public void onParseButtonClicked() {
        try {
            LocalDate date = inputDate.getValue();
            if (date == null) throw new RuntimeException("Data is null...");

            PersonalDataParse parser = new PersonalDataParse(inputName.getText(), date.toString());

            outputName.setText(parser.getInitials());
            outputAge.setText(parser.getGender() + " " + parser.getAge() + parser.spellingYears(parser.getAge()));
            errorText.setText("SUCCESS!");
        }
        catch (RuntimeException e) {
            errorText.setText(e.getMessage());
        }
    }
}
