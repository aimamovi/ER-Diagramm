package application.model;

public class User {
    public int valueINT;
    public String titel = "";
    public String name = "";
    public String strase = "";
    public int plz;
    public String ort = "";
    public int abteilung;


    @Override
    public String toString() {
        return valueINT + " - " + name;
    }

}
