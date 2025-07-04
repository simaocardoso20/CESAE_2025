package Repositories;

import Models.Cliente;
import Models.GuiaExperiencia;
import Tools.CSVFileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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

