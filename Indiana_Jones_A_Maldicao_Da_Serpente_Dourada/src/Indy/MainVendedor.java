package Indy;

public class MainVendedor {

    public static void carregarItensLoja(Vendedor vendedor) {
        // Poções (usáveis por todos os heróis)
        vendedor.adicionarItem(new Pocao("Poção de Vida 25", 10, 25, 0));
        vendedor.adicionarItem(new Pocao("Poção de Vida 50", 20, 50, 0));
        vendedor.adicionarItem(new Pocao("Poção de Força 25", 15, 0, 25));

        // Armas para IndianaJones
        vendedor.adicionarItem(new ArmaPrincipal("Machado pesado", 35, 20, 30,25,"IndianaJones"));
        vendedor.adicionarItem(new ArmaPrincipal("Espada de bronze", 25, 15,  25, 20,"IndianaJones"));
        vendedor.adicionarItem(new ArmaPrincipal("Chicote de couro", 20, 10, 20,15,"IndianaJones"));

        // Armas para HansVogel
        vendedor.adicionarItem(new ArmaPrincipal("Pistola semiautomática", 35, 20, 30,25,"HansVogel"));
        vendedor.adicionarItem(new ArmaPrincipal("Granada de Gás Oculto", 25, 15, 25,20,"HansVogel"));
        vendedor.adicionarItem(new ArmaPrincipal("Bastão com lâmina escondida", 20, 10, 20,15,"HansVogel"));

        // Armas para SophieValen
        vendedor.adicionarItem(new ArmaPrincipal("Pistola de bolso", 35, 20, 30,25,"SophieValen"));
        vendedor.adicionarItem(new ArmaPrincipal("Faca afiada", 25, 15, 25,20,"SophieValen"));
        vendedor.adicionarItem(new ArmaPrincipal("Alfinete com veneno", 20, 10, 20,15,"SophieValen"));

        // Itens variados
        vendedor.adicionarItem(new ArmaPrincipal("Tocha", 15, 10, 15, 10,"Todos"));
        vendedor.adicionarItem(new ArmaPrincipal("Corda com Gancho", 15, 10, 15, 10,"Todos"));
    }
}
