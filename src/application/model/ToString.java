package application.model;

public class ToString{

    public int valueINT;
    public String valueSTRING = "";


    @Override
    public String toString() {
        return valueINT + " - " + valueSTRING;
    }

}
