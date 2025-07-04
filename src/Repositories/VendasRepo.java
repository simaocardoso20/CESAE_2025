package Repositories;

import Models.Venda;
import Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class VendasRepo {

    private ArrayList<Venda> vendasArray;

    public VendasRepo() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader();

        this.vendasArray = csvFR.vendasFileReader("CesaeLand/Files/Cesaeland_vendas.csv");
    }


}

