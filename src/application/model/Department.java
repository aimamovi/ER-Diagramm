package application.model;

public class Department {
    public int valueINT;
    public String valueSTRING = "";


    @Override
    public String toString() {
        return valueINT + " - " + valueSTRING;
    }
}
