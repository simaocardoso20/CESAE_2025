package Controllers;

import Repositories.AtracaosRepo;
import Repositories.CustosRepo;
import Repositories.VendasRepo;

import java.io.FileNotFoundException;

public class AdminController {

    private AtracaosRepo atracaosRepo;
    private CustosRepo custosRepo;
    private final VendasRepo vendasRepo;

    public AdminController() throws FileNotFoundException {
        this.atracaosRepo = new AtracaosRepo();
        this.custosRepo = new CustosRepo();
        this.vendasRepo = new VendasRepo();
    }

    //Consultar o total de todas as vendas
    public int consultarTotalVendas() {
        return vendasRepo.getVendasArray().size();
    }

    //Consultar o total de lucro



}
