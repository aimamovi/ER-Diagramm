package application.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccessDb {

    Connection dbConnection;

    static {
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private static Connection conncection = null;

    public static Connection getConncection(){
        if(conncection == null){
            try {
                conncection = DriverManager.getConnection("jdbc:ucanaccess://db/ticketsystem.accdb");
            } catch (SQLException throwables) {
            }
        }
        return conncection;
    }


}
