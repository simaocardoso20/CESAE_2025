package Repositories;

import Models.Venda;
import Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class VendasRepo {

    private ArrayList<Venda> vendasArray;

    public VendasRepo() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader();

        this.vendasArray = csvFR.vendasFileReader("Files/Cesaeland_vendas.csv");
    }

    public ArrayList<Venda> getVendasArray() {
        return vendasArray;
    }




}

