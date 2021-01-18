package application.controller;

import application.MyFXMLLoader;
import application.model.Priorities;
import application.model.Ticket;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.*;

public class Controller {

    public ListView<Ticket> ticketListView;
    public AnchorPane contentPane;
    public TextField filterNameTxtFlied;//filtern nach Name des todos
    public ComboBox fitlerStatusComboBox;//filtern nach Status
    public ComboBox filterPriorityComboBox;//filtern nach Priorität
    public File ticketdatei = new File("tickets.csv");
    public File statusDatei = new File("stati.csv");

    public boolean newTicket = false;
    Ticket selected;

    Tickets_Controller tc = new Tickets_Controller();


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

    public void initialize() {
        Tickets_Controller.dataObeservable = Ticket.loadList();
        ticketListView.setItems(Tickets_Controller.dataObeservable);
    }


    public void ticket_listViewClicked(MouseEvent mouseEvent) {

        selected = ticketListView.getSelectionModel().getSelectedItem();
        System.out.println("TEST: du hast auf " + selected.id + " - " + selected.name + " geclickt");

        MyFXMLLoader loader = new MyFXMLLoader();
        Parent root = loader.loadFXML("view/tickets.fxml");
        tc = (Tickets_Controller) loader.controller;
        tc.nameTxtField.setText(selected.name);
        tc.descriptionTxtField.setText(selected.description);
        tc.statusComboBox.setItems(Stati_Controller.dataObeservable);
        tc.statusComboBox.setValue(selected.status);
        tc.priorityComboBox.setItems(Priorities_Controller.dataObeservable);
        tc.priorityComboBox.setValue(selected.priority);

        contentPane.getChildren().add(root);
    }

    public void newClicked(ActionEvent actionEvent) {

        MyFXMLLoader loader = new MyFXMLLoader();
        Parent root = loader.loadFXML("view/tickets.fxml");
        tc = (Tickets_Controller) loader.controller;
        contentPane.getChildren().add(root);

        tc.statusComboBox.setItems(Stati_Controller.dataObeservable);
        tc.priorityComboBox.setItems(Priorities_Controller.dataObeservable);

        newTicket = true;
    }

    public void deleteClicked(ActionEvent actionEvent) {
        //@todo bug when zwischendrinnen mehrmals gelöscht wird dan wird mal die liste so klein das hohe values -1 noch immer länger als liste sind
        /*
        if(selected.valueINT - 1 != Tickets_Controller.dataObeservable.size()){
            int i = selected.valueINT;
            while(i <= Tickets_Controller.dataObeservable.size()){
                --Tickets_Controller.dataObeservable.get(i).valueINT;
                ++i;
            }
        }

        Tickets_Controller.dataObeservable.remove(selected.valueINT - 1);
        Ticket.saveTicketsToFile(ticketdatei, Tickets_Controller.dataObeservable);
*/
    }

    public void saveClicked(ActionEvent actionEvent) {

        Ticket mTicket = new Ticket();
        mTicket.name = tc.nameTxtField.getText();
        mTicket.description = tc.descriptionTxtField.getText();
        mTicket.status = tc.statusComboBox.getValue();
        mTicket.priority = tc.priorityComboBox.getValue();

        if (mTicket.status == null || mTicket.priority == null) {
            mTicket.status = Stati_Controller.dataObeservable.get(0);
            mTicket.priority = Priorities_Controller.dataObeservable.get(0);
        }

        if (newTicket == true) {
            mTicket.id = Tickets_Controller.dataObeservable.get((Tickets_Controller.dataObeservable.size() - 1)).id + 1;
            Tickets_Controller.dataObeservable.add(mTicket);
            newTicket = false;
        } else {
            mTicket.id = selected.id;
            Tickets_Controller.dataObeservable.set(mTicket.id - 1, mTicket);
        }
        Ticket.saveTicketsToFile(ticketdatei, Tickets_Controller.dataObeservable);


    }
}

/**
 * Copyright © 2020 ArminDevelopments Inc. | All rights reserved. Terms of Use | Privacy Policy |
 * 1-111-Austria (1-111-111-1111)
 */