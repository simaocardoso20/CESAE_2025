package Controllers;

import Repositories.*;

import java.io.FileNotFoundException;

public class AdminController {

    private ClientesRepo clientesRepo;
    private ExperienciasRepo experienciasRepo;
    private ReservasQuartosRepo reservasQuartosRepo;
    private VendasExperienciasRepo vendasExperienciasRepo;
    private final TipologiasRepo tipologiasRepo;

    public AdminController() throws FileNotFoundException {
        this.clientesRepo = new ClientesRepo();
        this.experienciasRepo = new ExperienciasRepo();
        this.reservasQuartosRepo = new ReservasQuartosRepo();
        this.vendasExperienciasRepo = new VendasExperienciasRepo();
        this.tipologiasRepo = new TipologiasRepo();
    }
}



