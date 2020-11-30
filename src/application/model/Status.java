package application.model;

public class Status {

    public int valueINT;
    public String valueSTRING = "";


    @Override
    public String toString() {
        return valueINT + " - " + valueSTRING;
    }

}
