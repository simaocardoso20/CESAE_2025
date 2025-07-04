package Repositories;

import Models.Quarto;
import Models.RatingExperiencia;
import Models.User;
import Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

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


