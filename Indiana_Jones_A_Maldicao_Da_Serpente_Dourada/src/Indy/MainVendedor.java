package Indy;

public class MainVendedor {

    public static void carregarItensLoja(Vendedor vendedor) {
        // Poções (usáveis por todos os heróis)
        vendedor.adicionarItem(new Pocao("Poção de Vida 25", 10, 25, 0));
        vendedor.adicionarItem(new Pocao("Poção de Vida 50", 20, 50, 0));
        vendedor.adicionarItem(new Pocao("Poção de Força 25", 15, 0, 25));

        // Armas para IndianaJones
        vendedor.adicionarItem(new ArmaPrincipal("Espada de Bronze", 25, 8, "Cavaleiro"));
        vendedor.adicionarItem(new ArmaPrincipal("Chicote de Couro", 20, 6, "Cavaleiro"));
        vendedor.adicionarItem(new ArmaPrincipal("Machado Pesado", 35, 12, "Cavaleiro"));

        // Armas para HansVogel
        vendedor.adicionarItem(new ArmaPrincipal("Cajado do Vento", 22, 7, "Feiticeiro"));
        vendedor.adicionarItem(new ArmaPrincipal("Orbe Arcano", 30, 10, "Feiticeiro"));
        vendedor.adicionarItem(new ArmaPrincipal("Tomo da Destruição", 40, 14, "Feiticeiro"));

        // Armas para SophieValen
        vendedor.adicionarItem(new ArmaPrincipal("Arco Curto", 18, 5, "Arqueiro"));
        vendedor.adicionarItem(new ArmaPrincipal("Arco Longo", 25, 9, "Arqueiro"));
        vendedor.adicionarItem(new ArmaPrincipal("Bestinha Rápida", 32, 11, "Arqueiro"));

        // Itens variados
        //vendedor.adicionarItem(new Pocao("Poção de Vida Menor", 5, 10)); // universal
        //vendedor.adicionarItem(new Pocao("Elixir de Força", 18, 5));
    }
}
