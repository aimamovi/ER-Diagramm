package application.model;

import application.controller.Departments_Controller;
import application.controller.User_Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
    public int id;
    public String name = "";
    public String titel = "";
    public String strase = "";
    public int plz;
    public String ort = "";
    public String land = "";
    public Department abteilung = new Department();

    public static final ObservableList<User> dataObeservable =
            FXCollections.observableArrayList();

    public User(int user_id, String name, String titel, String street, String zip, String city, String country, int department_id) {
        this.id = user_id;
        this.name = name;
        this.titel = titel;
        this.strase = street;
        this.plz = Integer.parseInt(zip);
        this.ort = city;
        this.land = country;
        /*
        this.abteilung.id = department;
        this.abteilung.name = Departments_Controller.getValueString(department);
         */
        this.abteilung = Department.getById(department_id);

    }

    public User() {
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }

    public static ObservableList<User> loadList() {
        ObservableList<User> list = FXCollections.observableArrayList();

        try {
            Connection connection = AccessDb.getConncection();
            Statement statement = null;

            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM users");

            //@todo es tut iwie ned die user rauslesen ka warum
            while (result.next() == true) {
                User p = new User(result.getInt("user_id"), result.getString("name"), result.getString("titel"), result.getString("Street"), result.getString("zip"), result.getString("city"), result.getString("country"), result.getInt("department_id"));
                list.add(p);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    public void delete() {

        try {
            Connection connection = AccessDb.getConncection();

            Statement statement = null;

            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM users WHERE user_id = " + id);

        } catch (SQLException throwables) {
        }
    }
/*
    public static ObservableList<User> loadFile(File datei) {

        dataObeservable.clear();

        String row;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(datei));
            try {
                while ((row = br.readLine()) != null) {
                    String[] data = row.split(";");
                    User b = new User();

                    b.id = Integer.parseInt(data[0]);
                    b.titel = data[1];
                    b.name = data[2];
                    b.strase = data[3];
                    b.plz = Integer.parseInt(data[4]);
                    b.ort = data[5];
                    b.abteilung.id = Integer.parseInt(data[6]);
                    b.abteilung.name = Departments_Controller.getValueString(b.abteilung.id);

                    dataObeservable.add(b);
                }
            } finally {
                if (br != null) {
                    br.close();
                }
            }
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

        return dataObeservable;
    }*/
}
