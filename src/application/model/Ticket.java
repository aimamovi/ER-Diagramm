package application.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ticket {


    public int valueINT;
    public String name = "";
    public String description = "";
    public int status;
    public int priority;

    public static final ObservableList<Ticket> dataObeservable =
            FXCollections.observableArrayList();

    @Override
    public String toString() {
        return valueINT + " - " + name;
    }

    public static ObservableList<Ticket> loadFile(File datei) {

        dataObeservable.clear();

        String row;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(datei));
            try {
                while ((row = br.readLine()) != null) {
                    String[] data = row.split(";");
                    Ticket b = new Ticket();

                    b.valueINT = Integer.parseInt(data[0]);
                    b.name = data[1];
                    b.description = data[2];
                    b.status = Integer.parseInt(data[3]);
                    b.priority = Integer.parseInt(data[4]);
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
