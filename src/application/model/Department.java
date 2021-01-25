package application.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.text.html.ListView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Department {
    public int id;
    public String name = "";

    public static final ObservableList<Department> dataObeservable =
            FXCollections.observableArrayList();

    public Department(int department_id, String name) {
        this.id = department_id;
        this.name = name;
    }

    public Department(){
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }

    public static Department getById(int id){
        Department obj = null;
        try {
            Connection connection = AccessDb.getConncection();
            Statement statement = null;

            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Departments WHERE id =" + id);

            while (result.next() == true) {
                obj = new Department(result.getInt("department_id"), result.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ObservableList<Department> loadList(){
        ObservableList<Department> list = FXCollections.observableArrayList();

        try {
            Connection connection = AccessDb.getConncection();
            Statement statement = null;

            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Departments");

            while(result.next()){
                Department p = new Department(result.getInt("department_id"), result.getString("name"));
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
            statement.executeUpdate("DELETE FROM Departments WHERE department_id = " + id);

        } catch (SQLException throwables) {
        }
    }


    public static ObservableList<Department> loadFile(File datei) {

        dataObeservable.clear();

        String row;
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(datei));
            try {
                while ((row = br.readLine()) != null) {
                    String[] data = row.split(";");
                    Department b = new Department();

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
