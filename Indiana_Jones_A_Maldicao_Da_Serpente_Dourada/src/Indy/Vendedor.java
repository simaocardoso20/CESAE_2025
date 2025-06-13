package Indy;

import java.util.ArrayList;

public class Vendedor {

        protected ArrayList<ItemHeroi> loja;

        public Vendedor() {
            loja = new ArrayList<>();
        }

        public void adicionarItem(ItemHeroi item) {
            loja.add(item);
        }

        // Mostrar os 10 itens aleatórios da loja
        public void imprimirLoja() {
            System.out.println("\n=== Itens à venda ===");
            ArrayList<ItemHeroi> copia = new ArrayList<>(loja);
            Collections.shuffle(copia);

            int limite = Math.min(10, copia.size());
            for (int i = 0; i < limite; i++) {
                ItemHeroi item = copia.get(i);
                System.out.println((i + 1) + ". " + item.getDescricao());
            }
            System.out.println((limite + 1) + ". Sair da loja");
        }

        // Vender um item ao herói, se possível
        public void vender(Heroi heroi) {
            Scanner scanner = new Scanner(System.in);
            boolean comprar = true;

            while (comprar) {
                imprimirLoja();
                System.out.print("Escolha um item para comprar (ou sair): ");
                int escolha = scanner.nextInt();

                ArrayList<ItemHeroi> copia = new ArrayList<>(loja);
                Collections.shuffle(copia); // Baralha para manter o comportamento do imprimirLoja()
                int limite = Math.min(10, copia.size());

                if (escolha == limite + 1) {
                    System.out.println("Saiu da loja.");
                    comprando = false;
                } else if (escolha >= 1 && escolha <= limite) {
                    ItemHeroi item = copia.get(escolha - 1);

                    if (!item.podeUsar(heroi)) {
                        System.out.println("O seu herói não pode usar este item.");
                    } else if (heroi.getOuro() < item.getPrecoMoedasOuro()) {
                        System.out.println("Ouro insuficiente!");
                    } else {
                        heroi.retirarOuro(item.getPrecoMoedasOuro());

                        if (item instanceof ArmaPrincipal) {
                            heroi.equiparArma((ArmaPrincipal) item);
                            System.out.println("Arma equipada: " + item.getNome());
                        } else {
                            heroi.adicionarItemAoInventario(item);
                            System.out.println("Item adicionado ao inventário: " + item.getNome());
                        }
                    }
                } else {
                    System.out.println("Opção inválida.");
                }
            }
        }
    }




