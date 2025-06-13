package Indy;

import java.util.Scanner;

public class MainCriarPersonagem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean jogarNovamente = true;

        System.out.println("==== BEM-VINDO AO JOGO ====");
        System.out.println("INDIANA JONES: 🐍 A Maldição da Serpente Dourada 🐍\n");

        while (jogarNovamente) {
            Heroi heroi = Jogo.criarPersonagem(); // método que já tens
            Jogo.introducaoHistoria();            // método que imprime a história geral

            Jogo.labirintoMortal(heroi);          // aqui começa a aventura

            // Perguntar ao jogador o que quer fazer após o fim
            System.out.println("\n=== JOGO TERMINADO ===");
            System.out.println("1 - Jogar novamente com a mesma personagem");
            System.out.println("2 - Criar nova personagem");
            System.out.println("3 - Sair");

            int escolha = 0;
            while (escolha < 1 || escolha > 3) {
                System.out.print("Escolha uma opção: ");
                escolha = scanner.nextInt();
            }

            if (escolha == 1) {
                Jogo.labirintoMortal(heroi); // repete a aventura
            } else if (escolha == 2) {
                continue; // volta ao topo do ciclo
            } else {
                jogarNovamente = false;
                System.out.println("Obrigado por jogar. Até à próxima!");
            }
        }

        scanner.close();
    }
}