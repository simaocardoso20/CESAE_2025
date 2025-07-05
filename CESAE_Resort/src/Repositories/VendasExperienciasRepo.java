package Repositories;

import Models.Quarto;
import Models.VendaExperiencia;
import Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class VendasExperienciasRepo {

    private ArrayList<VendaExperiencia> vendaExperienciaArrayList;

    public VendasExperienciasRepo() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader();
        this.vendaExperienciaArrayList = csvFR.VendasExperienciasFileReader("Files/vendas_experiencias.csv");

    }

    public ArrayList<VendaExperiencia> getVendaExperienciaArrayList() {
        return vendaExperienciaArrayList;
    }
}
