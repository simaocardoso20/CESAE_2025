package Repositories;

import Models.Tipologia;
import Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Classe responsável por carregar e armazenar a lista de tipologias
 * a partir de um ficheiro CSV.
 */
public class TipologiasRepo {

    private ArrayList<Tipologia> tipologiaArrayList;

    public TipologiasRepo() {
        try{
        CSVFileReader csvFR = new CSVFileReader();
        this.tipologiaArrayList = csvFR.tipologiasFileReader("Files/tipologia.csv");

    }  catch (FileNotFoundException e) {
            System.out.println("Erro: Ficheiro tipologia.csv não encontrado.");
        }
    }

    public TipologiasRepo(ArrayList<Tipologia> tipologiaArrayList) {
        this.tipologiaArrayList = tipologiaArrayList;
    }

    public ArrayList<Tipologia> getTipologiaArrayList() {
        return tipologiaArrayList;
    }
}
