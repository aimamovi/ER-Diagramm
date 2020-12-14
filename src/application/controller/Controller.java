package application.controller;

import application.MyFXMLLoader;
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

    public ListView ticketListView;
    public AnchorPane contentPane;

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

    public void ticket_listViewClicked(MouseEvent mouseEvent) {
        MyFXMLLoader loader = new MyFXMLLoader();
        Parent root = loader.loadFXML("view/tickets.fxml");
        contentPane.getChildren().add(root);

        Tickets_Controller controller = (Tickets_Controller) loader.getController();
    }
}

/**
 * Copyright © 2020 ArminDevelopments Inc. | All rights reserved. Terms of Use | Privacy Policy |
 * 1-111-Austria (1-111-111-1111)
 */