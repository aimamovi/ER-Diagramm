package application.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Priority {

    public int valueINT;
    public String valueSTRING = "";


    @Override
    public String toString() {
        return valueINT + " - " + valueSTRING;
    }

}
