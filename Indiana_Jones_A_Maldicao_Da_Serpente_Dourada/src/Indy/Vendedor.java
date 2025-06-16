package Indy;

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

    // Mostrar os 10 itens aleatórios da loja (mas contém 14 items)
    public void imprimirLoja(ArrayList<ItemHeroi> lista) {

        System.out.println("\n*-*-*-*-*-*-*-*-*-*-*-*-* ITEMS À VENDA *-*-*-*-*-*-*-*-*-*-*-*-* \n");
        int limite = Math.min(10, lista.size());
        for (int i = 0; i < limite; i++) {
            ItemHeroi item = lista.get(i);
            System.out.println((i + 1) + ". " + item.getDescricao());
        }
        System.out.println("------------------------------------------------------------------");
        System.out.println((limite + 1) + ". Sair da loja");
    }

    // Vender um item ao herói, se possível
    public void vender(Heroi heroi) {
        Scanner scanner = new Scanner(System.in);
        boolean comprar = true;

        ArrayList<ItemHeroi> copia = new ArrayList<>(loja); // Copia feita uma vez
        Collections.shuffle(copia); // Baralhar só uma vez

        while (comprar) {
            // mostrar a mesma lista sempre
            imprimirLoja(copia);

            System.out.print("\nEscolhe um item para comprar (ou sair): ");
            int escolha = scanner.nextInt();

            int limite = Math.min(10, copia.size());

            if (escolha == limite + 1) {
                System.out.println("\nSaíste da loja.");
                comprar = false;
            } else if (escolha >= 1 && escolha <= limite) {
                ItemHeroi item = copia.get(escolha - 1);

                if (!item.podeUsar(heroi)) {
                    System.out.println("\nO teu herói não pode usar este item.");
                } else if (heroi.getOuro() < item.getPrecoMoedasOuro()) {
                    System.out.println("\nOuro insuficiente!");
                } else {
                    heroi.retirarOuro(item.getPrecoMoedasOuro());
                    System.out.println("\nOuro restante: " + heroi.getOuro());

                    if (item instanceof ArmaPrincipal) {
                        heroi.equiparArma((ArmaPrincipal) item);
                        System.out.println("\nArma equipada: " + item.getNome());
                    } else {
                        heroi.adicionarItemAoInventario(item);
                        System.out.println("\nItem adicionado ao inventário: " + item.getNome());
                    }
                }
            } else {
                System.out.println("\nOpção inválida.");
            }
        }
    }
}





