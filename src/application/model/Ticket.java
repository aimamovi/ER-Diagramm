package application.model;

import application.controller.Priorities_Controller;
import application.controller.Stati_Controller;
import application.controller.Tickets_Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

public class Ticket {


    public int valueINT;
    public String name = "";
    public String description = "";
    public Status status = new Status();
    public Priorities priority = new Priorities();

    public static ObservableList<Ticket> dataObeservable =
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
                    b.status.valueINT = Integer.parseInt(data[3]);
                    b.status.valueSTRING = Stati_Controller.getValueString(b.status.valueINT);
                    b.priority.valueINT = Integer.parseInt(data[4]);
                    b.priority.valueSTRING = Priorities_Controller.getValueString(b.priority.valueINT);
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

    public static void saveTicketsToFile(File datei, ObservableList<Ticket> dataObservableLo) {
        //ganze dataObervable einfach immer neu reinschreiben

        int i = 0;
        String text = "";

        while (i < dataObservableLo.size()) {
            text += dataObservableLo.get(i).valueINT + ";" + dataObservableLo.get(i).name + ";" +
                    dataObservableLo.get(i).description + ";" + dataObservableLo.get(i).status.valueINT + ";" + dataObservableLo.get(i).priority.valueINT + "\n";
            ++i;
        }

        Writer writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(datei)); //kein true für append damit es ersetzt
            writer.write(text);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
