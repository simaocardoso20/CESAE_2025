package Repositories;

import Models.Experiencia;
import Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Classe responsável por carregar e disponibilizar as experiências turísticas
 * a partir de um ficheiro CSV.
 */
public class ExperienciasRepo {

    private ArrayList<Experiencia> experienciaArray;

    public ExperienciasRepo() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader();
        this.experienciaArray = csvFR.experienciasFileReader("Files/experiencias.csv");

    }

    public ArrayList<Experiencia> getExperienciaArray() {
        return experienciaArray;
    }
}

