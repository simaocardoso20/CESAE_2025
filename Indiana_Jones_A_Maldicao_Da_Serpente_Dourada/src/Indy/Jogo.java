package Indy;

import java.util.Scanner;

public class Jogo {

    public static void iniciar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==== BEM-VINDO AO JOGO ====");
        System.out.println("INDIANA JONES: 🐍 A Maldição da Serpente Dourada 🐍\n");
        System.out.print("Digite o teu nome de utilizador: ");
        String username = scanner.nextLine();
        System.out.println("Olá, " + username + "! Prepara-te para esta grande aventura...\n");
    }

    public static Heroi criarPersonagem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== CRIAÇÃO DA PERSONAGEM ===");

        System.out.println("Escolha o teu herói:");
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

        // Mostrar descrição da personagem escolhida
        System.out.println("\n=== DESCRIÇÃO DA PERSONAGEM ===");

        String nome = "";
        int vidaMax = vida;
        int vidaAtual = vida;
        int nivel = 1;

        switch (escolhaTipo) {
            case 1:
                nome = "Indiana Jones";
                System.out.println("Indiana Jones, o lendário arqueólogo aventureiro e destemido. Com o seu inseparável chapéu, chicote e um vasto conhecimento sobre civilizações antigas,");
                System.out.println("ele vai lutar para manter artefatos poderosos fora das mãos erradas.");
                break;
            case 2:
                nome = "Hans Vogel";
                System.out.println("General Hans Vogel, um oficial nazista implacável, um estratega frio e calculista. Vogel representa a face sombria da arqueologia – onde o conhecimento é usado como arma, e a história é moldada pela força.");
                System.out.println("Obcecado pelo poder dos artefatos místicos, ele fará de tudo para obter o poder da Serpente Dourada.");
                break;
            case 3:
                nome = "Sophie Valen";
                System.out.println("Sophie Valen, sedutora e mortal, uma espiã misteriosa e letal. Mestre do disfarce, da manipulação e combate corpo a corpo,");
                System.out.println("com um passado envolto em segredos e um olhar que esconde mais do que revela, Sophie é tão perigosa quanto fascinante. No final, ela terá de escolher: vingança, perdão... ou sacrifício.");
                break;
        }
        System.out.println();

        // Instanciar personagem
        switch (escolhaTipo) {
            case 1:
                return new IndianaJones(nome, vidaMax, vidaAtual, forca, nivel, ouro);
            case 2:
                return new HansVogel(nome, vidaMax, vidaAtual, forca, nivel, ouro);
            case 3:
                return new SophieValen(nome, vidaMax, vidaAtual, forca, nivel, ouro);
            default:
                return null;
        }
    }

    public static void introducaoHistoria() {
        System.out.println("\n=== INTRODUÇÃO ===");
        System.out.println("Ano de 1938. A Europa estremece às portas de uma guerra iminente, mas longe das grandes potências, nos confins do Sudeste Asiático, uma ameaça mais antiga desperta.");
        System.out.println("O mundo mergulha nas sombras à medida que forças obscuras procuram artefactos lendários.");
        System.out.println("A Serpente Dourada, uma relíquia amaldiçoada com poderes místicos, reapareceu nos confins de um templo esquecido.");
        System.out.println("Dizem as lendas locais que a estátua, feita de ouro puro, representa uma deusa-serpente capaz de libertar tempestades tropicais e despertar um exército adormecido de guerreiros espectrais.\n");
        System.out.println("Diz-se que quem a possuir poderá dominar os reinos da vida e da morte...");
        System.out.println("Cabe-te a ti, corajoso aventureiro, enfrentar este labirinto de perigos e escolher o teu destino.\n");
        System.out.println("Boa sorte — o teu caminho começa agora!\n");
    }
}