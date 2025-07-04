package Controllers;

import Repositories.ClientesRepo;
import Repositories.ExperienciasRepo;
import Repositories.RatingsExperienciasRepo;
import Repositories.VendasExperienciasRepo;

import java.io.FileNotFoundException;

public class GuiaController {

    private ClientesRepo clientesRepo;
    private ExperienciasRepo experienciasRepo;
    private RatingsExperienciasRepo ratingsExperienciasRepo;
    private VendasExperienciasRepo vendasExperienciasRepo;

    public GuiaController() throws FileNotFoundException {
        this.clientesRepo = new ClientesRepo();
        this.experienciasRepo = new ExperienciasRepo();
        this.ratingsExperienciasRepo = new RatingsExperienciasRepo();
        this.vendasExperienciasRepo = new VendasExperienciasRepo();
    }
}
