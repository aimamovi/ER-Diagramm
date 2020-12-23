package application.model;

import application.controller.Departments_Controller;
import application.controller.User_Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class User {
    public int valueINT;
    public String titel = "";
    public String name = "";
    public String strase = "";
    public int plz;
    public String ort = "";
    public Department abteilung = new Department();

    public static final ObservableList<User> dataObeservable =
            FXCollections.observableArrayList();

    @Override
    public String toString() {
        return valueINT + " - " + name;
    }

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

                    b.valueINT = Integer.parseInt(data[0]);
                    b.titel = data[1];
                    b.name = data[2];
                    b.strase = data[3];
                    b.plz = Integer.parseInt(data[4]);
                    b.ort = data[5];
                    b.abteilung.valueINT = Integer.parseInt(data[6]);
                    b.abteilung.valueSTRING = Departments_Controller.getValueString(b.abteilung.valueINT);

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
