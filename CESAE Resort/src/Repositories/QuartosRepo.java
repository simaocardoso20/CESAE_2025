package Repositories;

import Models.GuiaExperiencia;
import Models.Quarto;
import Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class QuartosRepo {

    private ArrayList<Quarto> quartoArrayList;

    public QuartosRepo() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader();
        this.quartoArrayList = csvFR.quartosFileReader("Files/quartos.csv");

    }

    public ArrayList<Quarto> getQuartoArrayList() {
        return quartoArrayList;
    }
}
