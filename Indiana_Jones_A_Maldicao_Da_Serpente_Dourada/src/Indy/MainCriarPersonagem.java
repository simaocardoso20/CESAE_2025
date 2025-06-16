package Indy;

import java.util.Scanner;

public class MainCriarPersonagem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean jogarNovamente = true;
        Heroi heroi = null; // Declarar a variável heroi aqui

        while (jogarNovamente) {
            // Iniciar o jogo
            Jogo.iniciar();

            // Criar personagem
            heroi = Jogo.criarPersonagem();

            // Mostrar introdução da história
            Jogo.introducaoHistoria();

            // Mostrar roteiro do jogo personalizado: Missão 1
            Jogo.mostrarRoteiroPersonalizado(heroi);

            // Aceder à loja (vendedor e itens)
            Jogo.abrirLoja(heroi);

            // Iniciar uma luta
            heroi.atacar(Jogo.macacoLider);

            // Missão 2
            Jogo.missaoTemplo(heroi);

            // Missao 2 Alternativa
            Jogo.missaoAldeia(heroi);

            // Desafio chave cristal / Adivinha
            Jogo.desafioChaveCristal(heroi);

            // Após o switch (escolha) dentro de missaoTemplo
            Jogo.desafioChaveCristal(heroi);




            // Game Over ou Fim do Jogo
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
                // Jogo.labirintoMortal(heroi); // repete a aventura
                System.out.println("Repetindo aventura com " + heroi.getNome());
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