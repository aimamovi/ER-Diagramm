package application.controller;

import application.model.Department;
import application.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class User_Controller {
    public ListView<User> listViewUser;

    public Button save;
    public Button cancel;

    public File datei = new File("users.csv");

    public void initialize() {
        listViewUser.setItems(User.loadFile(datei));
    }

    public void saveClicked(ActionEvent actionEvent) {
    }

    public void cancelClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }
}
