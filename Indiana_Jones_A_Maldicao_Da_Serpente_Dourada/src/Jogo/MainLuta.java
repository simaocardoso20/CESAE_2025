package Jogo;

import Entidades.Heroi;
import Entidades.IndianaJones;
import Entidades.NPC;
import Items.ArmaPrincipal;
import Items.ConsumivelCombate;

public class MainLuta {
    public static void main(String[] args) {

        // Criar herói de teste (podes trocar para HansVogel ou SophieValen)
        Heroi heroi = new IndianaJones("Indiana Jones", 100, 100, 20, 1, 50);

        // Equipar arma
        ArmaPrincipal chicote = new ArmaPrincipal("Chicote de Couro", 10, 15, 25,30,"IndianaJones");
        heroi.equiparArma(chicote);

        // Adicionar consumível de combate ao inventário
        ConsumivelCombate granada = new ConsumivelCombate("Granada de Fumo", 10,  10);
        heroi.adicionarItemAoInventario(granada);

        // Criar inimigo (NPC)
        NPC macacoLider = new NPC("Macaco Líder", 80, 20, 30, 20);  // vida, força, ouro

        // Mostrar status inicial
        System.out.println(">>> Início da Luta <<<");
        heroi.mostrarStatus();
        System.out.println("Inimigo: " + macacoLider.getNome() + " - Vida: " + macacoLider.getVidaAtual() + "\n");

        // Iniciar luta
        boolean vitoria = heroi.atacar(macacoLider);

        // Resultado final
        if (vitoria) {
            System.out.println("\n🏆 O herói venceu a luta!");
        } else {
            System.out.println("\n💀 O herói foi derrotado...");
        }

        // Mostrar status final
        System.out.println("\n>>> Fim da Luta <<<");
        heroi.mostrarStatus();
    }
}
