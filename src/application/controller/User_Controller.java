package application.controller;

import application.MyFXMLLoader;
import application.model.Department;
import application.model.Priorities;
import application.model.Status;
import application.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class User_Controller {
    public ListView<User> listViewUser;

    public static final ObservableList<User> dataObeservable =
            FXCollections.observableArrayList();

    public Button save;
    public Button cancel;

    public File datei = new File("users.csv");
    public ComboBox abteilungComboBox;
    public TextField titelTxtField;
    public TextField streetTxtField;
    public TextField plzTxtField;
    public TextField ortTxtField;
    public TextField countryTxtField;
    public TextField nameTxtField;
    User selected;


    public void initialize() {
        dataObeservable.setAll(User.loadList());

        listViewUser.setItems(dataObeservable);

    }

    public void saveClicked(ActionEvent actionEvent) {
    }

    public void cancelClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    public void user_listView_clicked(MouseEvent mouseEvent) {

        selected = listViewUser.getSelectionModel().getSelectedItem();
        System.out.println("TEST: du hast auf " + selected.id + " - " + selected.name + " geclickt");
        abteilungComboBox.setItems(Department.dataObeservable);
        abteilungComboBox.setValue(selected.abteilung);

        nameTxtField.setText(selected.name);
        titelTxtField.setText(selected.titel);
        streetTxtField.setText(selected.strase);
        plzTxtField.setText(String.valueOf(selected.plz));
        ortTxtField.setText(selected.ort);
        //countryTxtField.setText();    land gibts nu ned bruuh

    }
}
