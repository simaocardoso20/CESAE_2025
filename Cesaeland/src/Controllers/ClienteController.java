package Controllers;

import Models.Atracao;
import Repositories.AtracaosRepo;
import Repositories.VendasRepo;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ClienteController {
    private AtracaosRepo atracaosRepo;
    private VendasRepo vendasRepo;

    public ClienteController() throws FileNotFoundException {
        this.atracaosRepo = new AtracaosRepo();
        this.vendasRepo = new VendasRepo();
    }

    public boolean consultaAtracaoDisponivel(ArrayList<Atracao> atacaoArray) {
        for (Atracao atracao : atacaoArray) {
            System.out.println("Nome: " + atracao.getAtracao() + " | Preço Adulto: " + atracao.getPrecoAdulto() + " | Preço Criança: " + atracao.getPrecoCrianca());
        }
        return true;
    }
}