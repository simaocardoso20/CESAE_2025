package Repositories;

import Models.Custo;
import Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CustosRepo {


    private ArrayList<Custo> custoArray;

    public CustosRepo() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader();

        this.custoArray= csvFR.custosFileReader("Files/Cesaeland_custos.csv");
    }

    public ArrayList<Custo> getCustoArray() {
        return custoArray;
    }
}