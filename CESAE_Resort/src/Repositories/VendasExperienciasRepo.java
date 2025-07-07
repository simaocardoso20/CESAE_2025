package Repositories;

import Models.VendaExperiencia;
import Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Classe responsável por carregar e armazenar a lista de vendas de experiências
 * a partir do ficheiro CSV "vendas_experiencias.csv".
 */
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
