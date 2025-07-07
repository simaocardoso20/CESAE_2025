package Repositories;


import Models.Quarto;
import Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Classe responsável por carregar e armazenar a lista de quartos
 * a partir de um ficheiro CSV.
 */
public class QuartosRepo {

    private ArrayList<Quarto> quartoArrayList;

    public QuartosRepo() {
        try {
        CSVFileReader csvFR = new CSVFileReader();
        this.quartoArrayList = csvFR.quartosFileReader("Files/quartos.csv");

     } catch (FileNotFoundException e) {
        System.out.println("Erro: Ficheiro quartos.csv não encontrado.");
    }
}

    public ArrayList<Quarto> getQuartoArrayList() {
        return quartoArrayList;
    }
}
