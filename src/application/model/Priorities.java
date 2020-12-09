package application.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Priorities {

    public int valueINT;
    public String valueSTRING = "";

    public static final ObservableList<Priorities> dataObeservable =
            FXCollections.observableArrayList();

    @Override
    public String toString() {
        return valueINT + " - " + valueSTRING;
    }

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

                    a.valueINT = Integer.parseInt(data[0]);
                    a.valueSTRING = data[1];
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

}
