package application.model;

public class Priorities {

    public int valueINT;
    public String valueSTRING = "";


    @Override
    public String toString() {
        return valueINT + " - " + valueSTRING;
    }

}
