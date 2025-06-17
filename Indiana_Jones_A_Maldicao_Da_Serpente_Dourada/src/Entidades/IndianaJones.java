package Entidades;

import Items.ConsumivelCombate;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IndianaJones extends Heroi {

    public IndianaJones(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int ouro) {
        super(nome, vidaMax, vidaAtual, forca, nivel, ouro);
        this.ataqueEspecialUsado = false;
    }

    @Override
    public boolean atacar(NPC inimigo) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("⚔️ Enfrentas " + inimigo.getNome() + "! Prepara-te!");

        while (this.estaVivo() && inimigo.estaVivo()) {
            // INIMIGO ataca primeiro (80% da força)
            int danoInimigo = (int) (inimigo.getForca() * 0.8);
            this.receberDano(danoInimigo);
            System.out.println(inimigo.getNome() + " atacou primeiro com dano reduzido (80%): " + danoInimigo);
            if (!this.estaVivo()) break;

            // Herói escolhe ataque
            System.out.println("\n=== Escolhe o tipo de ataque ===");
            System.out.println("1 - Ataque Normal");
            System.out.println("2 - Ataque Especial" + (ataqueEspecialUsado ? " (já usado)" : ""));
            System.out.println("3 - Ataque com Consumível");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    int dano = getDanoNormal();
                    inimigo.receberDano(dano);
                    System.out.println("Atacaste com ataque normal: " + dano);
                    break;
                case 2:
                    if (!ataqueEspecialUsado) {
                        int danoEsp = getDanoEspecial();
                        inimigo.receberDano(danoEsp);
                        ataqueEspecialUsado = true;
                        System.out.println("💥 Ataque especial usado: " + danoEsp);
                    } else {
                        System.out.println("⚠️ Já usaste o ataque especial nesta luta.");
                    }
                    break;
                case 3:
                    usarConsumivelCombate(inimigo);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        boolean venceu = this.estaVivo();

        if (venceu) {
            System.out.println("✅ Vitória sobre " + inimigo.getNome() + "!");
            System.out.println("Ganhaste " + inimigo.getOuro() + " moedas de ouro.");
            adicionarOuro(inimigo.getOuro());
            subirNivel();
        } else {
            System.out.println("💀 Foste derrotado por " + inimigo.getNome() + "...");
        }

        return venceu;
    }

    private void usarConsumivelCombate(NPC inimigo) {
        List<ConsumivelCombate> consumiveis = inventario.stream()
                .filter(item -> item instanceof ConsumivelCombate)
                .map(item -> (ConsumivelCombate) item)
                .collect(Collectors.toList());

        if (consumiveis.isEmpty()) {
            System.out.println("⚠️ Não tens consumíveis de combate.");
            return;
        }

        System.out.println("Consumíveis disponíveis:");
        for (int i = 0; i < consumiveis.size(); i++) {
            System.out.println((i + 1) + " - " + consumiveis.get(i).getDescricao());
        }
        System.out.println((consumiveis.size() + 1) + " - Cancelar");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Escolhe um: ");
        int escolha = scanner.nextInt();

        if (escolha >= 1 && escolha <= consumiveis.size()) {
            ConsumivelCombate c = consumiveis.get(escolha - 1);
            inimigo.receberDano(c.getAtaqueInstantaneo());
            inventario.remove(c);
            System.out.println("💣 Atacaste com " + c.getNome() + " causando " + c.getAtaqueInstantaneo() + " de dano.");
        } else {
            System.out.println("Ação cancelada.");
        }
    }
}