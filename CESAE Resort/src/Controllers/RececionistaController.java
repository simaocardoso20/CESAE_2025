package Controllers;

import Repositories.*;

import java.io.FileNotFoundException;

public class RececionistaController {

    private ClientesRepo clientesRepo;
    private ExperienciasRepo experienciasRepo;
    private QuartosRepo quartosRepo;
    private ReservasQuartosRepo reservasQuartosRepo;
    private TipologiasRepo tipologiasRepo;

    public RececionistaController() throws FileNotFoundException {
        this.clientesRepo = new ClientesRepo();
        this.experienciasRepo = new ExperienciasRepo();
        this.quartosRepo = new QuartosRepo();
        this.reservasQuartosRepo = new ReservasQuartosRepo();
        this.tipologiasRepo = new TipologiasRepo();
    }
}
