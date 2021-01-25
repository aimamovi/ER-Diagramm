package application.model;

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

public class Status {

    public int id;
    public String name = "";

    private static final ObservableList<Status> dataObeservable =
            FXCollections.observableArrayList();

    public Status(int status_id, String name) {
        this.id = status_id;
        this.name = name;
    }

    public Status() {
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }


    public static ObservableList<Status> loadList(){
        ObservableList<Status> list = FXCollections.observableArrayList();

        try {
            Connection connection = AccessDb.getConncection();
            Statement statement = null;

            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM stati");

            while(result.next()){
                Status p = new Status(result.getInt("status_id"), result.getString("name"));
                list.add(p);
            }
        }catch (SQLException throwables){
        }

        return list;
    }

    public void delete() {

        try {
            Connection connection = AccessDb.getConncection();

            Statement statement = null;

            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM stati WHERE status_id = " + id);

        } catch (SQLException throwables) {
        }
    }

    public static ObservableList<Status> loadFile(File datei) {

        dataObeservable.clear();

        String row;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(datei));
            try {
                while ((row = br.readLine()) != null) {
                    String[] data = row.split(";");
                    Status b = new Status();

                    b.id = Integer.parseInt(data[0]);
                    b.name = data[1];
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

    }
}
