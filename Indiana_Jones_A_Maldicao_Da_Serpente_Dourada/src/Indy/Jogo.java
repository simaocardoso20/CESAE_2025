package Indy;

public class Jogo {

    import java.util.Scanner;

        public class Jogo {

            public static void iniciar() {
                Scanner scanner = new Scanner(System.in);

                System.out.println("==== BEM-VINDO AO JOGO ====");
                System.out.println("INDIANA JONES: \uD83D\uDC0D A Maldição da Serpente Dourada \uD83D\uDC0D ==== /n");
                System.out.print("Digite o seu nome de utilizador: ");
                String username = scanner.nextLine();
                System.out.println("Olá, " + username + "! Prepara-te para esta grande aventura...\n");



                System.out.println("Escolhe o teu herói:");
                System.out.println("1 - Indiana Jones – Arqueólogo Aventureiro");
                System.out.println("2 - General Hans Vogel - Vilão Nazi");
                System.out.println("3 - Sophie Valen – Espiã Misteriosa");
        }

                public static Heroi criarPersonagem() {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("=== CRIAÇÃO DE PERSONAGEM ===");

                    System.out.println("Escolha o tipo de herói:");
                    System.out.println("1 - Indiana Jones – Arqueólogo Aventureiro");
                    System.out.println("2 - General Hans Vogel - Vilão Nazi");
                    System.out.println("3 - Sophie Valen – Espiã Misteriosa");

                    int escolhaTipo = 0;
                    while (escolhaTipo < 1 || escolhaTipo > 3) {
                        System.out.print("Digite 1, 2 ou 3: ");
                        escolhaTipo = scanner.nextInt();
                    }

                    System.out.println("Escolha a dificuldade:");
                    System.out.println("1 - Fácil (300 pontos, 20 ouro)");
                    System.out.println("2 - Difícil (220 pontos, 15 ouro)");

                    int dificuldade = 0;
                    while (dificuldade != 1 && dificuldade != 2) {
                        System.out.print("Digite 1 ou 2: ");
                        dificuldade = scanner.nextInt();
                    }

                    int pontosTotais;
                    int ouro;

                    if (dificuldade == 1) {
                        pontosTotais = 300;
                        ouro = 20;
                    } else {
                        pontosTotais = 220;
                        ouro = 15;
                    }

                    int vida = -1;
                    int forca = -1;
                    boolean distribuicaoValida = false;

                    // Distribuição de pontos
                    while (!distribuicaoValida) {
                        System.out.println("Distribua seus " + pontosTotais + " pontos:");
                        System.out.print("- Pontos para VIDA (1 ponto cada): ");
                        vida = scanner.nextInt();
                        System.out.print("- Pontos para FORÇA (1 ponto de força custa 5 pontos): ");
                        forca = scanner.nextInt();

                        int custoTotal = vida + (forca * 5);

                        if (custoTotal == pontosTotais) {
                            distribuicaoValida = true;
                        } else {
                            System.out.println("Distribuição inválida! Usou " + custoTotal + " pontos. Tente novamente.\n");
                        }
                    }




