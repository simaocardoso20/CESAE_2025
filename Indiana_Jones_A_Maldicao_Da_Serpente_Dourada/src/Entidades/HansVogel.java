package Entidades;

import Items.ConsumivelCombate;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HansVogel extends Heroi {

    public HansVogel(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int ouro) {
        super(nome, vidaMax, vidaAtual, forca, nivel, ouro);
        this.ataqueEspecialUsado = false;
    }

    @Override
    public boolean atacar(NPC inimigo) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("⚔️ Enfrentas " + inimigo.getNome() + "! Prepara-te!");

        while (this.estaVivo() && inimigo.estaVivo()) {
            // Heroi ataca primeiro
            System.out.println("\n=== Escolhe o tipo de ataque ===");
            System.out.println("1 - Ataque Normal");
            System.out.println("2 - Ataque Especial" + (ataqueEspecialUsado ? " (já usado)" : ""));
            System.out.println("3 - Ataque com Consumível");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    inimigo.receberDano(getDanoNormal());
                    break;
                case 2:
                    if (!ataqueEspecialUsado) {
                        inimigo.receberDano(getDanoEspecial());
                        ataqueEspecialUsado = true;
                    } else {
                        System.out.println("⚠️ Já usaste o ataque especial.");
                    }
                    break;
                case 3:
                    usarConsumivelCombate(inimigo);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

            if (inimigo.estaVivo()) {

                this.receberDano(inimigo.getForca());
                System.out.println(inimigo.getNome() + " contra-atacou com " + inimigo.getForca() + " de dano!");
            }   if(this.getVidaAtual()<=0){
                return false;
            }
        }
        return finalizarLuta(inimigo);

    }

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

    private boolean finalizarLuta(NPC inimigo) {
        if (this.estaVivo()) {
            System.out.println("✅ Vitória!");
            adicionarOuro(inimigo.getOuro());
            subirNivel();
            return true;
        } else {
            System.out.println("💀 Foste derrotado...");
            return false;
        }
    }
}