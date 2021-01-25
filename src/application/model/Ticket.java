package application.model;

import application.controller.Priorities_Controller;
import application.controller.Stati_Controller;
import application.controller.Tickets_Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ticket {


    public int id;
    public String name = "";
    public String description = "";
    public Priorities priority = new Priorities();
    public Status status = new Status();

    public static ObservableList<Ticket> dataObeservable =
            FXCollections.observableArrayList();


    public Ticket() {
    }

    public Ticket(int ticket_id, String name, String desc, int priority_id, int status_id, int order_id) {
        this.id = ticket_id;
        this.name = name;
        this.description = desc;
        this.priority.id = priority_id;
        this.priority.name = Priorities_Controller.getValueString(priority_id);
        this.status.id = status_id;
        this.status.name = Stati_Controller.getValueString(status_id);

    }

    @Override
    public String toString() {
        return id + " - " + name;
    }

    public static ObservableList<Ticket> loadList() {
        ObservableList<Ticket> list = FXCollections.observableArrayList();

        try {
            Connection connection = AccessDb.getConncection();
            Statement statement = null;

            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM tickets");

            while (result.next()) {
                Ticket p = new Ticket(result.getInt("ticket_id"), result.getString("name"), result.getString("desc"), result.getInt("priority_id"), result.getInt("Status_id"), result.getInt("order_id"));
                list.add(p);
            }
        } catch (SQLException throwables) {
        }

        return list;
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

                    b.id = Integer.parseInt(data[0]);
                    b.name = data[1];
                    b.description = data[2];
                    b.status.id = Integer.parseInt(data[3]);
                    b.status.name = Stati_Controller.getValueString(b.status.id);
                    b.priority.id = Integer.parseInt(data[4]);
                    b.priority.name = Priorities_Controller.getValueString(b.priority.id);
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
            text += dataObservableLo.get(i).id + ";" + dataObservableLo.get(i).name + ";" +
                    dataObservableLo.get(i).description + ";" + dataObservableLo.get(i).status.id + ";" + dataObservableLo.get(i).priority.id + "\n";
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
