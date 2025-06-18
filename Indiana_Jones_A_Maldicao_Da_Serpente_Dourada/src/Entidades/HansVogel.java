package Entidades;

import Items.ConsumivelCombate;
import Entidades.Heroi;
import Entidades.NPC;
import Jogo.Jogo;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;



public class HansVogel extends Heroi {

    public HansVogel(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int ouro) {
        super(nome, vidaMax, vidaAtual, forca, nivel, ouro);
        this.ataqueEspecialUsado = false;
    }


    /**
     * Método que realiza o ataque do herói contra um inimigo {@link NPC}.
     *
     * O combate é realizado por meio de um menu onde o jogador escolhe entre três opções de ataque:
     * 1. Ataque Normal
     * 2. Ataque Especial (apenas uma vez por combate)
     * 3. Ataque com Consumível
     *
     * O herói e o inimigo trocam ataques até que um dos dois morra.
     * Após cada ação, se o inimigo estiver vivo, ele contra-ataca com seu dano.
     *
     * @param inimigo O inimigo {@link NPC} contra o qual o herói vai lutar.
     * @return {@code true} se o herói venceu a luta, {@code false} se foi derrotado.
     */
    @Override
    public boolean atacar(NPC inimigo) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("⚔️ Enfrentas " + inimigo.getNome() + "! Prepara-te!");

        while (this.estaVivo() && inimigo.estaVivo()) {
            System.out.println("\n=== Escolhe o tipo de ataque ===");
            System.out.println("1 - Ataque Normal");
            System.out.println("2 - Ataque Especial" + (ataqueEspecialUsado ? " (já usado)" : ""));
            System.out.println("3 - Ataque com Consumível");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> inimigo.receberDano(getDanoNormal());
                case 2 -> {
                    if (!ataqueEspecialUsado) {
                        inimigo.receberDano(getDanoEspecial());
                        ataqueEspecialUsado = true;
                    } else {
                        System.out.println("⚠️ Já usaste o ataque especial.");
                    }
                }
                case 3 -> usarConsumivelCombate(inimigo);
                default -> System.out.println("Opção inválida.");
            }

            if (inimigo.estaVivo()) {
                this.receberDano(inimigo.getForca());
                System.out.println(inimigo.getNome() + " contra-atacou com " + inimigo.getForca() + " de dano!");
            }
        }

        return finalizarLuta(inimigo);
    }


    /**
     * Permite que o herói use um consumível de combate durante uma luta contra um inimigo {@link NPC}.
     *
     * O herói escolhe um consumível de combate do seu inventário. Cada consumível tem um efeito instantâneo
     * que causa dano ao inimigo. Após o uso, o consumível é removido do inventário.
     *
     * Caso o herói não tenha consumíveis ou se a escolha for inválida, o método exibe uma mensagem apropriada.
     *
     * @param inimigo O inimigo {@link NPC} que receberá o dano causado pelo consumível.
     */
    private void usarConsumivelCombate(NPC inimigo) {
        List<ConsumivelCombate> consumiveis = inventario.stream()
                .filter(i -> i instanceof ConsumivelCombate)
                .map(i -> (ConsumivelCombate) i)
                .collect(Collectors.toList());

        if (consumiveis.isEmpty()) {
            System.out.println("⚠️ Não tens consumíveis de combate.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolhe um consumível:");

        for (int i = 0; i < consumiveis.size(); i++) {
            System.out.println((i + 1) + " - " + consumiveis.get(i).getDescricao());
        }
        System.out.println((consumiveis.size() + 1) + " - Cancelar");

        int escolha = scanner.nextInt();
        if (escolha >= 1 && escolha <= consumiveis.size()) {
            ConsumivelCombate c = consumiveis.get(escolha - 1);
            inimigo.receberDano(c.getAtaqueInstantaneo());
            inventario.remove(c);
            System.out.println("💣 Usaste " + c.getNome() + " causando " + c.getAtaqueInstantaneo() + " de dano!");
        }
    }


    /**
     * Finaliza a luta contra o inimigo, verificando se o herói venceu ou perdeu.
     *
     * Se o herói estiver vivo ao final do combate, ele ganha ouro do inimigo e sobe de nível.
     * Se o herói morreu, a luta é considerada perdida.
     *
     * @param inimigo O inimigo {@link NPC} que o herói derrotou.
     * @return {@code true} se o herói venceu a luta, {@code false} caso contrário.
     */
    private boolean finalizarLuta(NPC inimigo) {
        if (this.estaVivo()) {
            adicionarOuro(inimigo.getOuro());
            subirNivel();
            return true;
        } else {
            return false;
        }
    }

}