package application.controller;

import application.model.Department;
import application.model.Priorities;
import application.model.Status;
import application.model.Ticket;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;

public class Tickets_Controller {

    public File datei = new File("tickets.csv");

    public TextField nameTxtField;
    public TextArea descriptionTxtField;
    public ComboBox auftragComboBox;
    public ComboBox<Status> statusComboBox;
    public ComboBox<Priorities> priorityComboBox;
    public Button cancelButton;

    public static ObservableList<Ticket> dataObeservable =
            FXCollections.observableArrayList();


    public void initialize() {
        dataObeservable = Ticket.loadList();
    }

    public void saveTicket(ActionEvent actionEvent) {
    }

    public void cancelTicket(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
