package Controllers;

import Repositories.*;

import java.io.FileNotFoundException;

public class ClienteController {

    private ExperienciasRepo experienciasRepo;
    private GuiasExperienciasRepo guiasExperienciasRepo;
    private QuartosRepo quartosRepo;
    private RatingsExperienciasRepo ratingsExperienciasRepo;
    private final TipologiasRepo tipologiasRepo;

    public ClienteController() throws FileNotFoundException {
        this.experienciasRepo = new ExperienciasRepo();
        this.guiasExperienciasRepo = new GuiasExperienciasRepo();
        this.quartosRepo = new QuartosRepo();
        this.ratingsExperienciasRepo = new RatingsExperienciasRepo();
        this.tipologiasRepo = new TipologiasRepo();
    }
}
