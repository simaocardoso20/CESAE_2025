package Jogo;

import Entidades.Heroi;
import Entidades.IndianaJones;
import Entidades.Vendedor;
import Items.ArmaPrincipal;
import Items.Pocao;

public class MainVendedor {

    public static void main(String[] args) {

        // Criar herói
        Heroi heroi = new IndianaJones("Indy", 100, 100, 20, 100, 100);

        // Criar vendedor
        Vendedor vendedor = new Vendedor();

        // Carregar os itens na loja
            carregarItensLoja(vendedor);

        // Começar a vender
            vendedor.vender(heroi);
    }

    public static void carregarItensLoja (Vendedor vendedor){
        // Poções (usáveis por todos os heróis)
        vendedor.adicionarItem(new Pocao("Poção de vida normal", 20, 25, 5));
        vendedor.adicionarItem(new Pocao("Poção de vida extra", 40, 50, 10));
        vendedor.adicionarItem(new Pocao("Poção de força", 15, 0, 30));

        // Armas para IndianaJones
        vendedor.adicionarItem(new ArmaPrincipal("Machado pesado", 35, 20, 30, 25, "IndianaJones"));
        vendedor.adicionarItem(new ArmaPrincipal("Espada de bronze", 25, 15, 25, 20, "IndianaJones"));
        vendedor.adicionarItem(new ArmaPrincipal("Chicote de couro", 20, 10, 20, 15, "IndianaJones"));

        // Armas para HansVogel
        vendedor.adicionarItem(new ArmaPrincipal("Pistola semiautomática", 35, 20, 30, 25, "HansVogel"));
        vendedor.adicionarItem(new ArmaPrincipal("Granada de Gás", 25, 15, 25, 20, "HansVogel"));
        vendedor.adicionarItem(new ArmaPrincipal("Bastão com lâmina escondida", 20, 10, 20, 15, "HansVogel"));

        // Armas para SophieValen
        vendedor.adicionarItem(new ArmaPrincipal("Pistola de bolso", 35, 20, 30, 25, "SophieValen"));
        vendedor.adicionarItem(new ArmaPrincipal("Faca afiada", 25, 15, 25, 20, "SophieValen"));
        vendedor.adicionarItem(new ArmaPrincipal("Alfinete com veneno", 20, 10, 20, 15, "SophieValen"));

        // Itens variados
        vendedor.adicionarItem(new ArmaPrincipal("Tocha", 15, 10, 15, 10, "Todos"));
        vendedor.adicionarItem(new ArmaPrincipal("Corda com Gancho", 15, 10, 15, 10, "Todos"));


    }
}
