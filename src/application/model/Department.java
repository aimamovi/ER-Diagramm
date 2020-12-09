package application.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.text.html.ListView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Department {
    public int valueINT;
    public String valueSTRING = "";

    public static final ObservableList<Department> dataObeservable =
            FXCollections.observableArrayList();

    @Override
    public String toString() {
        return valueINT + " - " + valueSTRING;
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

                    b.valueINT = Integer.parseInt(data[0]);
                    b.valueSTRING = data[1];
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
