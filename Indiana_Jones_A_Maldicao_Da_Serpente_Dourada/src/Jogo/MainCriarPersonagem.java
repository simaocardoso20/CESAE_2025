package Jogo;

import Entidades.Heroi;
import Audio.Audio;
import Jogo.Jogo;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainCriarPersonagem {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        boolean jogarNovamente = true;
        Heroi heroi = null; // Declarar a variável heroi aqui
        Jogo.inicializarNPCs();

        while (jogarNovamente) {
            // Iniciar o jogo
            Jogo.iniciar();

            // Criar personagem
            heroi = Jogo.criarPersonagem();

            boolean continuar = true;
            while (continuar) {
                Jogo.introducaoHistoria();
                Jogo.mostrarRoteiroPersonalizado(heroi);
                Jogo.abrirLoja(heroi);
                Jogo.missaoSelva(heroi);
                Jogo.missaoTemplo(heroi);
                Jogo.missaoAldeia(heroi);
                Jogo.desafioChaveCristal(heroi);
                Jogo.missaopiramide(heroi);

                // 👉 Se morreu, mostrar menu
                if (!heroi.estaVivo()) {
                    System.out.println("😵 Morreste!");
                    int escolha = Jogo.menuFimDeJogo(scanner, heroi);

                    switch (escolha) {
                        case 1:
                            // Jogar novamente com o mesmo personagem
                            continuar = true;
                            break;
                        case 2:
                            // Criar novo personagem
                            continuar = false; // sair do loop interno
                            break;
                        case 3:
                            // Voltar ao início (recomeça tudo)
                            continuar = false;
                            System.out.println("🔁 A voltar ao menu principal...");
                            break;
                    }

                    break; // sair do ciclo interno após morte
                } else {
                    // 👉 Se o herói ainda está vivo, jogo acabou com sucesso
                    System.out.println("🎉 Completaste o jogo com sucesso!");
                    jogarNovamente = false;
                    continuar = false;
                }
            }
        }

        System.out.println("👋 Obrigado por jogar. Até à próxima!");
        scanner.close();
    }
}
