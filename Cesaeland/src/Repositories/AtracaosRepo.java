package Repositories;

import Models.Atracao;
import Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AtracaosRepo {


    private ArrayList<Atracao> atacaoArray;

    public AtracaosRepo() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader();

        this.atacaoArray= csvFR.atracaosFileReader("Files/Cesaeland_atracoes.csv");
    }

    public ArrayList<Atracao> getAtacaoArray() {
        return atacaoArray;
    }
}