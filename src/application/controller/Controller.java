package application.controller;

import application.MyFXMLLoader;
import application.model.Ticket;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;

public class Controller {

    public ListView<Ticket> ticketListView;
    public AnchorPane contentPane;
    public TextField filterNameTxtFlied;//filtern nach Name des todos
    public ComboBox fitlerStatusComboBox;//filtern nach Status
    public ComboBox filterPriorityComboBox;//filtern nach Priorität
    public File datei = new File("tickets.csv");



    public static ObservableList<Ticket> dataObeservable =
            FXCollections.observableArrayList();

    public void editStatiClicked(ActionEvent actionEvent) {
        MyFXMLLoader loader = new MyFXMLLoader();
        loader.loadFXML("view/stati.fxml", "Stati bearbeiten");
    }

    public void editPrioritesClicked(ActionEvent actionEvent) {
        MyFXMLLoader loader = new MyFXMLLoader();
        loader.loadFXML("view/priorities.fxml", "Prioritäten bearbeiten");
    }

    public void editDepartmentsClicked(ActionEvent actionEvent) {
        MyFXMLLoader loader = new MyFXMLLoader();
        loader.loadFXML("view/departments.fxml", "Departments bearbeiten");
    }

    public void editUsersClicked(ActionEvent actionEvent) {
        MyFXMLLoader loader = new MyFXMLLoader();
        loader.loadFXML("view/user.fxml", "User bearbeiten");
    }

    public void initialize(){
        dataObeservable = Ticket.loadFile(datei);

        ticketListView.setItems(dataObeservable);

    }


    public void ticket_listViewClicked(MouseEvent mouseEvent) {

        MyFXMLLoader loader = new MyFXMLLoader();
        Parent root = loader.loadFXML("view/tickets.fxml");
        contentPane.getChildren().add(root);

        Ticket selected;


        selected = ticketListView.getSelectionModel().getSelectedItem();
        System.out.println("TEST: du hast auf " + selected.valueINT + " geclickt");




        /*
        NummerTxtField.setText(selected.nummer);
        BeschreibungTxtField.setText(selected.name);
        LagerTxtFeld.setText(selected.lagerplatz);
        PreisTxtFeld.setText(Double.toString(selected.preis));
        indexShown.setText(String.valueOf(selected.index));
*/

       Tickets_Controller controller = (Tickets_Controller) loader.getController();
    }

    public void newClicked(ActionEvent actionEvent) {

        MyFXMLLoader loader = new MyFXMLLoader();
        Parent root = loader.loadFXML("view/tickets.fxml");
        AnchorPane.setBottomAnchor(root, 0.0);
        AnchorPane.setTopAnchor(root, 0.0);
        AnchorPane.setLeftAnchor(root, 0.0);
        AnchorPane.setRightAnchor(root, 0.0);
        contentPane.getChildren().add(root);

        Tickets_Controller controller = (Tickets_Controller) loader.getController();
        //controller.(null);
    }

    public void deleteClicked(ActionEvent actionEvent) {
    }

    public void saveClicked(ActionEvent actionEvent) {
    }
}

/**
 * Copyright © 2020 ArminDevelopments Inc. | All rights reserved. Terms of Use | Privacy Policy |
 * 1-111-Austria (1-111-111-1111)
 */