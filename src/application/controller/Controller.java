package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;

public class Controller {


    public Button ButtonDepartments;
    public Button ButtonUser;
    public Button ButtonComments;
    public Button ButtonPriorities;
    public Button ButtonTickets;
    public Button ButtonStati;
    public Button ButtonOrders;

    public void ButtonClickDepartments(ActionEvent actionEvent) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/departments.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Departments");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void ButtonClickUser(ActionEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/user.fxml"));
            Stage stage = new Stage();
            stage.setTitle("User");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ButtonClickComments(ActionEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/comments.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Comments");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ButtonClickPriorities(ActionEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/priorities.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Priorities");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ButtonClickTickets(ActionEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/tickets.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Tickets");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ButtonClickStati(ActionEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/stati.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Stati");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ButtonClickOrders(ActionEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/orders.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Orders");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/**
 * Copyright © 2020 ArminDevelopments Inc. | All rights reserved. Terms of Use | Privacy Policy |
 * 1-111-Austria (1-111-111-1111)
 */