
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

    int pontosTotais = (dificuldade == 1) ? 300 : 220;
    int ouro = (dificuldade == 1) ? 20 : 15;

    int vida = -1;
    int forca = -1;
    boolean distribuicaoValida = false;

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

    scanner.nextLine(); // limpar o buffer
    System.out.print("Dá um nome à tua personagem: ");
    String nome = scanner.nextLine();

    // Mostrar descrição
    System.out.println("\n=== DESCRIÇÃO DA PERSONAGEM ===");
    switch (escolhaTipo) {
        case 1:
            System.out.println("Indiana Jones, o lendário arqueólogo aventureiro e destemido...");
            break;
        case 2:
            System.out.println("General Hans Vogel, o estratega nazi implacável...");
            break;
        case 3:
            System.out.println("Sophie Valen, a espiã misteriosa e letal...");
            break;
    }
    System.out.println(); // linha em branco

    // Instanciar personagem com os parâmetros corretos
    switch (escolhaTipo) {
        case 1:
            return new IndianaJones(nome, vida, vida, forca, 1, ouro);
        case 2:
            return new HansVogel(nome, vida, vida, forca, 1, ouro);
        case 3:
            return new SophieValen(nome, vida, vida, forca, 1, ouro);
        default:
            return null;
    }
}