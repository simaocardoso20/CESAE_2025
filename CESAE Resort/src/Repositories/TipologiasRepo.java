package Repositories;

import Models.Quarto;
import Models.Tipologia;
import Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TipologiasRepo {

    private ArrayList<Tipologia> tipologiaArrayList;

    public TipologiasRepo() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader();
        this.tipologiaArrayList = csvFR.tipologiasFileReader("Files/tipologia.csv");

    }

    public ArrayList<Tipologia> getTipologiaArrayList() {
        return tipologiaArrayList;
    }
}
