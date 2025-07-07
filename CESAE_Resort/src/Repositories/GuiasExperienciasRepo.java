package Repositories;


import Models.GuiaExperiencia;
import Tools.CSVFileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Classe responsável por carregar e armazenar as ligações entre Guias e Experiências,
 * obtidas a partir de um ficheiro CSV.
 */
public class GuiasExperienciasRepo {

    private ArrayList<GuiaExperiencia> guiaExperienciaArrayList;

    public GuiasExperienciasRepo() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader();
        this.guiaExperienciaArrayList = csvFR.guiasExperienciasFileReader("Files/guias_experiencias.csv");

    }

    public ArrayList<GuiaExperiencia> getGuiaExperienciaArrayList() {
        return guiaExperienciaArrayList;
    }
}

