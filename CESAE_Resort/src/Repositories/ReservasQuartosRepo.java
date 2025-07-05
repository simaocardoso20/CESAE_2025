package Repositories;

import Models.Quarto;
import Models.ReservaQuarto;
import Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ReservasQuartosRepo {

    private ArrayList<ReservaQuarto> reservaQuartoArrayList;

    public ReservasQuartosRepo() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader();
        this.reservaQuartoArrayList = csvFR.reservasQuartosFileReader("Files/reservas_quartos.csv");

    }

    public ArrayList<ReservaQuarto> getReservaQuartoArrayList() {
        return reservaQuartoArrayList;
    }
}
