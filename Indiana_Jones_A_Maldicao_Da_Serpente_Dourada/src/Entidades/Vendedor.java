package Entidades;

import Cores.ConsoleColors;
import Entidades.Heroi;
import Entidades.ItemHeroi;
import Items.ArmaPrincipal;
import Items.Pocao;

import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Vendedor {

    protected ArrayList<ItemHeroi> loja;

    public Vendedor() {
        loja = new ArrayList<>();
    }

    public void adicionarItem(ItemHeroi item) {
        loja.add(item);
    }

    // Mostrar os itens disponíveis (até 10)
    public void imprimirLoja(ArrayList<ItemHeroi> lista) {
        System.out.println(ConsoleColors.YELLOW + "\n*-*-*-*-*-*-*-*-*-*-*-*-* ITEMS À VENDA *-*-*-*-*-*-*-*-*-*-*-*-*\n" + ConsoleColors.RESET);

        int limite = Math.min(10, lista.size());
        for (int i = 0; i < limite; i++) {
            ItemHeroi item = lista.get(i);
            System.out.println((i + 1) + ". " + item.getDescricao());
        }

        System.out.println("------------------------------------------------------------------");
        System.out.println((limite + 1) + ". ❌ Sair da loja");
    }

    // Vender um item ao herói, se possível
    public void vender(Heroi heroi) {
        Scanner scanner = new Scanner(System.in);
        boolean comprar = true;

        ArrayList<ItemHeroi> copia = new ArrayList<>(loja);
        Collections.shuffle(copia);

        Set<ItemHeroi> itensComprados = new HashSet<>();

        imprimirLoja(copia);  // Mostrar a lista só uma vez

        while (comprar) {
            int limite = Math.min(10, copia.size());

            // Verifica se ainda há itens compráveis
            boolean algumItemDisponivel = false;
            for (int i = 0; i < limite; i++) {
                ItemHeroi item = copia.get(i);
                if (!itensComprados.contains(item) && item.getPrecoMoedasOuro() <= heroi.getOuro()) {
                    algumItemDisponivel = true;
                    break;
                }
            }

            if (!algumItemDisponivel) {
                System.out.println("\n⚠️ Já não tens ouro suficiente ou já compraste todos os itens disponíveis.");
                System.out.println("A sair da loja...\n");
                return;
            }

            System.out.print("\nEscolhe um item para comprar (ou " + (limite + 1) + " para sair): ");
            int escolha = scanner.nextInt();

            if (escolha == limite + 1) {
                System.out.println(ConsoleColors.RED + "\nSaíste da loja." + ConsoleColors.RESET);
                comprar = false;
            } else if (escolha >= 1 && escolha <= limite) {
                ItemHeroi item = copia.get(escolha - 1);

                if (itensComprados.contains(item)) {
                    System.out.println("\n❌ Já compraste este item, não podes comprá-lo novamente.");
                } else if (!item.podeUsar(heroi)) {
                    System.out.println("\nO teu herói não pode usar este item.");
                } else if (heroi.getOuro() < item.getPrecoMoedasOuro()) {
                    System.out.println("\n❌ Ouro insuficiente!");
                } else {
                    heroi.retirarOuro(item.getPrecoMoedasOuro());
                    System.out.println("\n\uD83D\uDCB0 Ouro restante: " + heroi.getOuro());

                    if (item instanceof ArmaPrincipal) {
                        heroi.equiparArma((ArmaPrincipal) item);
                        System.out.println("Arma equipada: " + item.getNome());
                    } else {
                        heroi.adicionarItemAoInventario(item);
                        System.out.println("Item adicionado ao inventário: " + item.getNome());
                    }

                    itensComprados.add(item); // Marca como comprado
                }
            } else {
                System.out.println("\n❌ Opção inválida.");
            }
        }
    }

    public static void abrirLojaPiramide(Heroi heroi) {
        Vendedor vendedor = new Vendedor();
        carregarItensLojaPiramide(vendedor);
        vendedor.vender(heroi);
    }

    /**
     * Carrega os itens disponíveis na loja para o vendedor.
     *
     * Requisitos:
     * Recebe um objeto {@code Vendedor} válido.
     * Adiciona poções, armas específicas para cada herói e itens gerais.
     */
    public static void carregarItensLojaPiramide(Vendedor vendedor) {
        // Poções (usáveis por todos os heróis)
        vendedor.adicionarItem(new Pocao("Poção de vida normal", 10, 25, 5));
        vendedor.adicionarItem(new Pocao("Poção de vida extra", 15, 50, 10));
        vendedor.adicionarItem(new Pocao("Poção de força", 5, 0, 30));

        // Armas para IndianaJones
        vendedor.adicionarItem(new ArmaPrincipal("Machado pesado", 20, 20, 30, 25, "IndianaJones"));
        vendedor.adicionarItem(new ArmaPrincipal("Espada de bronze", 10, 15, 25, 20, "IndianaJones"));
        vendedor.adicionarItem(new ArmaPrincipal("Chicote de couro", 5, 10, 20, 15, "IndianaJones"));

        // Armas para HansVogel
        vendedor.adicionarItem(new ArmaPrincipal("Pistola semiautomática", 20, 20, 30, 25, "HansVogel"));
        vendedor.adicionarItem(new ArmaPrincipal("Granada de Gás", 10, 15, 25, 20, "HansVogel"));
        vendedor.adicionarItem(new ArmaPrincipal("Bastão com lâmina escondida", 5, 10, 20, 15, "HansVogel"));

        // Armas para SophieValen
        vendedor.adicionarItem(new ArmaPrincipal("Pistola de bolso", 20, 20, 30, 25, "SophieValen"));
        vendedor.adicionarItem(new ArmaPrincipal("Faca afiada", 10, 15, 25, 20, "SophieValen"));
        vendedor.adicionarItem(new ArmaPrincipal("Alfinete com veneno", 5, 10, 20, 15, "SophieValen"));

        // Itens variados
        vendedor.adicionarItem(new ArmaPrincipal("Tocha", 10, 10, 15, 10, "Todos"));
        vendedor.adicionarItem(new ArmaPrincipal("Corda com Gancho", 10, 10, 15, 10, "Todos"));
    }
}