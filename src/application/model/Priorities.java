package application.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Priorities {

    public int id;
    public String name = "";

    //public static final ObservableList<Priorities> dataObeservable =
     //       FXCollections.observableArrayList();

    public Priorities(int priority_id, String name) {
        this.id = priority_id;
        this.name = name;
    }

    public Priorities() {

    }

    public static Priorities getById(int id){
        Priorities obj = null;
        try {
            Connection connection = AccessDb.getConncection();
            Statement statement = null;

            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM priorities WHERE priority_id =" + id);

            while (result.next() == true) {
                obj = new Priorities(result.getInt("priority_id"), result.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }


    public void update() {
        try {
            Connection connection = AccessDb.getConncection();

            PreparedStatement statement = null;
            statement = connection.prepareStatement("UPDATE priorities SET name = ? WHERE prioirity_id = " + id);
            statement.setString(1, name);
            statement.setInt(2, id);

            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return id + " - " + name;
    }

    public void delete() {

        try {
            Connection connection = AccessDb.getConncection();

            Statement statement = null;

            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM priorities WHERE priority_id = " + id);

        } catch (SQLException throwables) {
        }
    }

    public static ObservableList<Priorities> loadList() {
        ObservableList<Priorities> list = FXCollections.observableArrayList();

        try {
            Connection connection = AccessDb.getConncection();
            Statement statement = null;

            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM priorities");

            while (result.next()) {
                Priorities p = new Priorities(result.getInt("priority_id"), result.getString("name"));
                list.add(p);
            }
        } catch (SQLException throwables) {
        }

        return list;
    }
/*
    public static ObservableList<Priorities> loadFile(File datei) {

        dataObeservable.clear();

        String row = "";
        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader(datei));
            try {
                while ((row = br.readLine()) != null) {
                    String[] data = row.split(";");
                    Priorities a = new Priorities();

                    a.id = Integer.parseInt(data[0]);
                    a.name = data[1];
                    dataObeservable.add(a);
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
    }
*/
}
