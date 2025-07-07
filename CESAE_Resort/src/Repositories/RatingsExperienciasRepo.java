package Repositories;

import Models.RatingExperiencia;
import Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Classe responsável por carregar e armazenar a lista de avaliações
 * de experiências a partir de um ficheiro CSV.
 */
public class RatingsExperienciasRepo {

    private ArrayList<RatingExperiencia> RatingExperienciaArrayList;

    public RatingsExperienciasRepo() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader();
        this.RatingExperienciaArrayList = csvFR.ratingsExperienciasFileReader("Files/ratings_experiencias.csv");

    }

    public ArrayList<RatingExperiencia> getRatingExperienciaArrayList() {
        return RatingExperienciaArrayList;
    }
}


