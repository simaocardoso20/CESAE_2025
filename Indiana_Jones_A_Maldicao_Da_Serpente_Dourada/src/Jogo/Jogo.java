package Jogo;

import Entidades.HansVogel;
import Audio.Audio;
import Cores.ConsoleColors;
import Entidades.Heroi;
import Entidades.IndianaJones;
import Entidades.NPC;
import Entidades.SophieValen;
import Entidades.Vendedor;
import Items.ArmaPrincipal;
import Items.Pocao;
import Tools.FileTools;


import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;


public class Jogo {

    // NPCs principais da história
    public static NPC devoradorAlmas;
    public static NPC guerreiroTribal;
    public static NPC protetorSagrado;
    public static NPC espectroGuardiao;
    public static NPC sentinelaSombrasEternas;
    public static NPC reiDasTrevas;

    public static void inicializarNPCs() {
        devoradorAlmas = new NPC("Devorador de Almas", 110, 1, 10, 35);
        guerreiroTribal = new NPC("Guerreiro Tribal", 100, 1, 20, 35);
        protetorSagrado = new NPC("Protetor Sagrado", 120, 1, 30, 35);
        espectroGuardiao = new NPC("Espectro Guardião", 130, 1, 35, 35);
        sentinelaSombrasEternas = new NPC("Sentinela das Sombras Eternas", 100, 1, 18, 30);
        reiDasTrevas = new NPC("Rei das Trevas", 150, 1, 40, 100);
    }

    /**
     * Gera um NPC aleatório a partir de uma lista predefinida de inimigos.
     * A lista contém diferentes tipos de NPCs com atributos variados.
     *
     * @return Um NPC aleatório escolhido da lista.
     */
    public static NPC gerarNPCaleatorio() {
        List<NPC> npcs = new ArrayList<>();
        npcs.add(devoradorAlmas);
        npcs.add(guerreiroTribal);
        npcs.add(protetorSagrado);
        npcs.add(espectroGuardiao);
        npcs.add(sentinelaSombrasEternas);
        npcs.add(reiDasTrevas);

        Random random = new Random();
        return npcs.get(random.nextInt(npcs.size()));
    }

    /**
     * Inicializa os NPCs do jogo com atributos definidos.
     * <p>
     * Requisitos:
     * As variáveis devoradorAlmas, guerreiroTribal, protetorSagrado,
     * espectroGuardiao, sentinelaSombrasEternas e bossFinal devem estar declaradas.
     */
    public static void iniciar() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Audio.playMusic("AudioFiles/IndianaJonesThemeSong.wav");

        System.out.println("       \n ======== BEM-VINDO AO JOGO ========\n");

        System.out.println(ConsoleColors.YELLOW + "           INDIANA JONES:" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.YELLOW + "\uD83D\uDC0D A Maldição da Serpente Dourada \uD83D\uDC0D\n" + ConsoleColors.RESET);

        FileTools.printFile("AsciiFiles/IndianaJones.txt");


        System.out.print("\nDigite o teu nome de utilizador: ");
        String username = scanner.nextLine();
        System.out.println("Olá, " + username + "! Prepara-te para esta grande aventura...\n");
    }

    /**
     * Aguarda o utilizador pressionar Enter para continuar.
     * <p>
     * Requisitos:
     * Recebe um objeto Scanner já inicializado para leitura da entrada.
     */
    private static void esperarEnter(Scanner scanner) {
        System.out.print(ConsoleColors.GREEN_BOLD + "\nEnter para continuar...)\n" + ConsoleColors.RESET);
        scanner.nextLine();
    }

    /**
     * Cria um herói com base na escolha do utilizador e distribui atributos.
     * <p>
     * Requisitos:
     * Utiliza {@code Scanner} para leitura de input.
     * Requer classes IndianaJones, HansVogel e SophieValen implementadas.
     * O utilizador deve escolher personagem, dificuldade e distribuir pontos corretamente.
     *
     * @return Instância de uma subclasse de Heroi com os atributos escolhidos.
     */
    public static Heroi criarPersonagem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("========  CRIAÇÃO DA PERSONAGEM ======== \n");

        System.out.println("Escolhe o teu herói:\n");
        System.out.println(ConsoleColors.YELLOW + "1 - Indiana Jones - Arqueólogo Aventureiro" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "2 - General Hans Vogel - Vilão Nazi" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "3 - Sophie Valen – Espiã Misteriosa\n" + ConsoleColors.RESET);

        int escolhaTipo = 0;
        while (escolhaTipo < 1 || escolhaTipo > 3) {
            System.out.print("Escreve 1, 2 ou 3: ");
            escolhaTipo = scanner.nextInt();
        }

        //  Mostrar descrição da personagem escolhida
        String nome = "";

        switch (escolhaTipo) {
            case 1:
                nome = "Indiana Jones";
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("Escolheste o Indiana Jones, o lendário arqueólogo aventureiro e destemido.\n"
                        + "Com o seu inseparável chapéu, chicote e um vasto conhecimento sobre civilizações antigas,\n"
                        + "ele vai lutar para manter artefatos poderosos fora das mãos erradas.");
                System.out.println("-----------------------------------------------------------------------------------");
                break;
            case 2:
                nome = "Hans Vogel";
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("Escolheste o General Hans Vogel, um oficial nazista implacável, um estratega frio e calculista.\n"
                        + "Vogel representa a face sombria da arqueologia – onde o conhecimento é usado como arma,\n"
                        + "e a história é moldada pela força. Obcecado pelo poder dos artefatos místicos,\n"
                        + "ele fará de tudo para obter o poder da Serpente Dourada.");
                System.out.println("-----------------------------------------------------------------------------------");
                break;
            case 3:
                nome = "Sophie Valen";
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("Escolheste a Sophie Valen, sedutora e mortal, uma espiã misteriosa e letal.\n"
                        + "Mestre do disfarce, da manipulação e combate corpo a corpo, com um passado envolto em segredos\n"
                        + " e um olhar que esconde mais do que revela, Sophie é tão perigosa quanto fascinante.\n"
                        + "No final, ela terá de escolher: vingança, perdão... ou sacrifício.");
                System.out.println("-----------------------------------------------------------------------------------");
                break;
        }


        System.out.println("\nEscolhe a dificuldade do jogo:");
        System.out.println(ConsoleColors.GREEN + "1 - Fácil (300 pontos, 20 ouro)" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED + "2 - Difícil (220 pontos, 15 ouro)\n" + ConsoleColors.RESET);

        int dificuldade = 0;
        while (dificuldade != 1 && dificuldade != 2) {
            System.out.print("Escreve 1 ou 2: ");
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
        int vidaMax;
        int vidaAtual;
        int nivel = 1;
        boolean distribuicaoValida = false;

        // Distribuição de pontos
        while (!distribuicaoValida) {
            System.out.println(ConsoleColors.YELLOW + "\nDistribui os teus " + pontosTotais + " pontos:" + ConsoleColors.RESET);

            // Vida
            System.out.print("- Quantos pontos de VIDA queres usar? (1 ponto = 1 vida): ");
            vida = scanner.nextInt();

            int pontosRestantes = pontosTotais - vida;

            if (pontosRestantes < 0) {
                System.out.println("❌ Usaste mais do que tens! Só tens " + pontosTotais + " pontos. Tenta outra vez.");
                continue;
            }

            System.out.println(ConsoleColors.GREEN + "Restam-te " + pontosRestantes + " pontos para FORÇA." + ConsoleColors.RESET);
            System.out.println("Cada ponto de FORÇA custa 5 pontos.");
            System.out.println("⚠\uFE0F Máximo possível de FORÇA: " + (pontosRestantes / 5) + "\n");

            System.out.print("- Quantos pontos de FORÇA queres usar? ");
            forca = scanner.nextInt();

            int custoTotal = vida + (forca * 5);

            if (custoTotal == pontosTotais) {
                distribuicaoValida = true;
            } else {
                System.out.println("\n❌ Distribuição inválida! Usaste " + custoTotal + " pontos. Tenta novamente.\n");
            }
        }

        System.out.println();

        vidaMax = vida;
        vidaAtual = vida;

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

    /**
     * Exibe a introdução narrativa do jogo ao utilizador.
     * <p>
     * Requisitos:
     * Utiliza {@code Scanner} para esperar o utilizador pressionar Enter entre blocos de texto.
     */
    public static void introducaoHistoria() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n======== INTRODUÇÃO ========\n");
        System.out.println("Ano de 1938. A Europa estremece às portas de uma guerra iminente, mas longe das grandes potências,");
        System.out.println("nos confins do Sudeste Asiático, uma ameaça mais antiga desperta.");
        System.out.println("O mundo mergulha nas sombras à medida que forças obscuras procuram artefactos lendários.");
        esperarEnter(scanner);
        System.out.println("A Serpente Dourada, uma relíquia amaldiçoada com poderes místicos, reapareceu nos confins de um templo esquecido.");
        System.out.println("Dizem as lendas locais que a estátua, feita de ouro puro, representa uma deusa-serpente capaz de libertar tempestades tropicais");
        System.out.println("e despertar um exército adormecido de guerreiros espectrais.");
        esperarEnter(scanner);
        System.out.println("Diz-se que quem a possuir poderá dominar os reinos da vida e da morte...");
        System.out.println("Cabe-te a ti, corajoso aventureiro, enfrentar este labirinto de perigos e escolher o teu destino.");
        System.out.println("Boa sorte — o teu caminho começa agora!");
        esperarEnter(scanner);
    }

    /**
     * Apresenta a introdução personalizada da Missão 1 com base no herói escolhido.
     * <p>
     * Requisitos:
     * Recebe um objeto {@code Heroi} válido.
     * Utiliza {@code Scanner} para pausas entre os textos com o método auxiliar {@code esperarEnter}.
     */
    public static void mostrarRoteiroPersonalizado(Heroi heroi) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(ConsoleColors.YELLOW + "======== MISSÃO 1 - BEM-VINDO À SELVA ========\n" + ConsoleColors.RESET);
        System.out.println("No coração da selva peruana, um antigo artefacto – A Serpente Dourada de Uxmal –");
        System.out.println("foi descoberto por exploradores ilegais.");
        System.out.println("Diz a lenda que quem a possui controla as forças da natureza.");
        esperarEnter(scanner);

        // Personalizar o texto consoante a escolha do herói
        String classeHeroi = heroi.getClass().getSimpleName();
        String partePersonalizada = "";

        switch (classeHeroi) {
            case "IndianaJones":
                // Texto personalizado consoante o heroi escolhido
                partePersonalizada = "Indiana Jones fará tudo para recuperá-la antes que caia nas mãos erradas, impedindo assim uma catástrofe!!!";
                System.out.println(partePersonalizada);
                System.out.println("Depois de saber dos perigos que o aguardavam, Indy foi ao mercado procurar o seu amigo de longa data, Tupaq Callani.");
                System.out.println("Um velho guia nativo da selva peruana, astuto, leal e com um conhecimento lendário sobre ruínas esquecidas.");
                esperarEnter(scanner);
                System.out.println("O velho amigo de Indiana Jones, já lhe salvou a vida mais vezes do que ele gosta de admitir.");
                System.out.println("Vê o que Tupaq Callani tem para te oferecer, sê sábio na tua escolha!");
                esperarEnter(scanner);
                break;
            case "HansVogel":
                partePersonalizada = "Hans Vogel pretende usá-la como arma de dominação mundial,";
                System.out.println(partePersonalizada);
                System.out.println("moldando o destino da humanidade com punho de ferro!!!");
                System.out.println("Calculista, Hans sabia que tinha que estar preparado para enfrentar os perigos que o aguardavam.");
                System.out.println("Um velho guia nativo da selva peruana, com um conhecimento lendário sobre ruínas esquecidas,");
                esperarEnter(scanner);
                System.out.println("encontra-se no mercado e tem tudo o que Hans precisa para atingir os seus objetivos.");
                System.out.println("Vê o que o velho peruano tem para te oferecer, sê sábio na tua escolha!");
                esperarEnter(scanner);
                break;
            case "SophieValen":
                partePersonalizada = "Sophie Valen vê neste artefacto uma peça vital do seu passado sombrio,";
                System.out.println(partePersonalizada);
                System.out.println("mas também uma ameaça que poderá destruir tudo!!!");
                System.out.println("Sedutora e esperta, Sophie conseguiu convencer o proprietário do hotel onde estava hospedada,");
                System.out.println("a fornecer-lhe um conjunto de items raros e proibidos.");
                esperarEnter(scanner);
                System.out.println("Entre olhares furtivos e palavras sussurradas ao pé do ouvido,");
                System.out.println("ela obteve acesso ao velho arsenal escondido no porão do edifício.");
                System.out.println("Vê o que o dono do hotel tem para te oferecer, sê sábia na tua escolha!");
                esperarEnter(scanner);
                break;
            default:
                partePersonalizada = "Este aventureiro desconhecido enfrenta a selva sem saber que o seu destino será alterado para sempre.";
        }
    }

    /**
     * Abre a loja do jogo, permitindo ao herói comprar itens.
     * <p>
     * Requisitos:
     * Recebe um objeto {@code Heroi} válido.
     * Requer as classes {@code Vendedor} e o metodo {@code carregarItensLoja(Vendedor)} implementados.
     */
    public static void abrirLoja(Heroi heroi) {
        Vendedor vendedor = new Vendedor();
        carregarItensLoja(vendedor);
        vendedor.vender(heroi);
    }

    /**
     * Carrega os itens disponíveis na loja para o vendedor.
     * <p>
     * Requisitos:
     * Recebe um objeto {@code Vendedor} válido.
     * Adiciona poções, armas específicas para cada herói e itens gerais.
     */
    public static void carregarItensLoja(Vendedor vendedor) {
        // Poções (usáveis por todos os heróis)
        vendedor.adicionarItem(new Pocao("Poção de vida normal", 10, 25, 5));
        vendedor.adicionarItem(new Pocao("Poção de vida extra", 15, 50, 10));
        vendedor.adicionarItem(new Pocao("Poção de força", 5, 0, 30));

        // Armas para IndianaJones
        vendedor.adicionarItem(new ArmaPrincipal("Machado pesado", 20, 20, 30, 25, "IndianaJones"));
        vendedor.adicionarItem(new ArmaPrincipal("Espada de bronze", 10, 15, 25, 20, "IndianaJones"));
        vendedor.adicionarItem(new ArmaPrincipal("Chicote de couro", 5, 10, 20, 15, "IndianaJones"));

        // Armas para HansVogel
        vendedor.adicionarItem(new ArmaPrincipal("Pistola semiautomática", 20, 20, 30, 25, "HansVogel"));
        vendedor.adicionarItem(new ArmaPrincipal("Granada de Gás", 10, 15, 25, 20, "HansVogel"));
        vendedor.adicionarItem(new ArmaPrincipal("Bastão com lâmina escondida", 5, 10, 20, 15, "HansVogel"));

        // Armas para SophieValen
        vendedor.adicionarItem(new ArmaPrincipal("Pistola de bolso", 20, 20, 30, 25, "SophieValen"));
        vendedor.adicionarItem(new ArmaPrincipal("Faca afiada", 10, 15, 25, 20, "SophieValen"));
        vendedor.adicionarItem(new ArmaPrincipal("Alfinete com veneno", 5, 10, 20, 15, "SophieValen"));

        // Itens variados
        vendedor.adicionarItem(new ArmaPrincipal("Tocha", 10, 10, 15, 10, "Todos"));
        vendedor.adicionarItem(new ArmaPrincipal("Corda com Gancho", 10, 10, 15, 10, "Todos"));
    }


    /**
     * Executa a primeira missão do jogo na selva, com escolhas que afetam o progresso do herói.
     * <p>
     * Requisitos:
     * Recebe um objeto {@code Heroi} válido.
     * Utiliza {@code Scanner} para ler decisões do utilizador.
     * Depende de métodos como {@code gerarNPCaleatorio()}, {@code heroi.atacar()},
     * {@code heroi.usarPocaoPosCombate()}, {@code heroi.sofrerDanoAleatorio()},
     * e {@code heroi.permitirMissaoAldeia()}.
     */
    public static void missaoSelva(Heroi heroi) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nCom os bolsos mais leves (ou não), entras na espessa e abafada selva.");
        System.out.println("O som distante de tambores tribais mistura-se com os gritos de animais selvagens.");
        esperarEnter(scanner);
        System.out.println("A missão é clara: encontrar o mapa perdido escondido dentro desta floresta traiçoeira.");
        System.out.println(ConsoleColors.GREEN + "Dois caminhos surgem à tua frente:\n" + ConsoleColors.RESET);

        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.println("1. ⬅\uFE0F A Selva dos Sussurros: Não estás sozinho, os sons de algo (ou alguém) a mover-se entre os galhos são constantes.");
        System.out.println("2. ➡️ A Terra dos Mortos: Um atalho sinistro, com solo instável, lama densa e um perigo silencioso.");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------\n");

        System.out.print("Digita 1 ou 2: ");
        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                System.out.println("\nEscolheste a Selva dos Sussurros e avanças cautelosamente...");
                System.out.println("De repente surge o maior dos teus pesadelos. Ele bloqueia o teu caminho. Vais ter que enfrentá-lo... isto se tiveres coragem suficiente!");
                System.out.println("Boa sorte, estás por tua conta!\n");

                // Lutar com NPC aleatório
                NPC inimigo = gerarNPCaleatorio();
                boolean venceu = heroi.atacar(inimigo);

                if (venceu) {
                    System.out.println("------------------------------------------------------------------------------------------------------------");
                    System.out.println("Parabéns!!! Conseguiste algo que mais ninguém tinha conseguido antes.");
                    System.out.println("Mas não te entusiasmes, agarra-te ao medo para estares desperto.");
                    System.out.println("Como recompensa e demonstração de respeito, o teu inimigo deu-te o mapa que procuravas!");
                    System.out.println("------------------------------------------------------------------------------------------------------------\n");
                    heroi.usarPocaoPosCombate();

                } else {
                    Audio.playMusic("AudioFiles/wah-wah-sad-trombone-6347.wav");

                    try {
                        Thread.sleep(6000); // pausa

                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }

                    // Mostrar o conteúdo do ficheiro ASCII
                    FileTools.printFile("AsciiFiles/gameover.txt");


                    System.out.println("------------------------------------------------------------------------------------------------------------");
                    System.out.println(ConsoleColors.RED + "Foste derrotado! Não tiveste qualquer hipótese. É melhor não tentares novamente!" + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.RED + "Ainda te vais magoar!" + ConsoleColors.RESET);
                    System.out.println("------------------------------------------------------------------------------------------------------------");

                    // Termina o jogo
                    System.exit(0);
                }

                break;

            case 2:
                System.out.println("\nAvanças pela passagem enlameada... acho que não foi boa ideia.");
                System.out.println("O solo cede de repente! Areia movediiiiiiiiiça!");
                esperarEnter(scanner);
                heroi.sofrerDanoAleatorio();
                System.out.println("Com muito esforço consegues escapar mas quase que morrias.");
                System.out.println("No final do trilho, encontras pegadas e decides segui-las.");
                heroi.permitirMissaoAldeia();
                esperarEnter(scanner);
                break;

            default:
                System.out.println("Escolha inválida. A missão falhou por indecisão.");
        }
    }


    /**
     * Executa a missão no templo antigo, onde o herói enfrenta armadilhas e toma decisões.
     * <p>
     * Requisitos:
     * Recebe um objeto {@code Heroi} válido.
     * Utiliza {@code Scanner} para decisões do utilizador.
     * Depende do metodo {@code heroi.sofrerDanoAleatorio()} e do auxiliar {@code esperarEnter(Scanner)}.
     */
    public static void missaoTemplo(Heroi heroi) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(ConsoleColors.YELLOW + "======== MISSÃO 2 – O TEMPLO DOS ECOS PERDIDOS ========\n" + ConsoleColors.RESET);
        System.out.println("Com o mapa nas mãos, atravessas a última barreira de vegetação densa...");
        System.out.println("Diante de ti ergue-se um templo milenar coberto por raízes e musgo.");
        esperarEnter(scanner);
        System.out.println("No seu interior, ecoam sons metálicos... algo se move.");
        System.out.println(ConsoleColors.GREEN + "Dois caminhos apresentam-se logo à entrada:" + ConsoleColors.RESET);
        esperarEnter(scanner);

        System.out.println("1. ⬅\uFE0F A Entrada dos Deuses – Uma entrada imponente com inscrições antigas. Um cheiro a óleo queimado no ar.");
        System.out.println("2. ➡️ Um Túnel Subterrâneo – Escuro, húmido, onde só os morcegos ousam entrar.\n");

        System.out.print("Qual caminho escolhes? Digita 1 ou 2: ");
        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                System.out.println("\nAvanças pela Entrada dos Deuses...cuidado onde pões os pés!");
                System.out.println("Pisos móveis, sensores escondidos e uma armadilha disparaaaAAAAAA!");
                esperarEnter(scanner);
                System.out.println("➡️ Lançamento automático de flechas!");
                heroi.sofrerDanoAleatorio();
                System.out.println(ConsoleColors.RED + "Avisei-te, esta aventura não é para amadores!" + ConsoleColors.RESET);
                esperarEnter(scanner);
                break;

            case 2:
                System.out.println("Avanças pelo túnel subterrâneo com cuidado...");
                System.out.println("De repente – *click*! Cuidaaaaaaaaaado, uma lança surge do chão!");
                System.out.println("Tentas desviar-te mas foste ferido e quase que te afogas.");
                heroi.sofrerDanoAleatorio();
                esperarEnter(scanner);
                System.out.println("Esse corte está com muito mau aspeto.");
                System.out.println(ConsoleColors.RED + "Desculpa a sinceridade, mas essa perna não vai durar muito!" + ConsoleColors.RESET);
                esperarEnter(scanner);
                break;

            default:
                System.out.println("Escolha inválida. Ficaste parado e foste apanhado pelo exército alemão. Missão falhada.");
                return;
        }
    }

    /**
     * Executa o enigma da Chave de Cristal, testando o raciocínio do herói com consequências baseadas na resposta.
     * <p>
     * Requisitos:
     * Recebe um objeto {@code Heroi} válido.
     * Utiliza {@code Scanner} para leitura da resposta do utilizador.
     * Requer métodos como {@code heroi.recuperarVida()}, {@code heroi.ganharForca()},
     * {@code heroi.ganharOuro()}, {@code heroi.perderVida()} e {@code heroi.sofrerDanoAleatorio()}.
     */
    public static void desafioChaveCristal(Heroi heroi) {
        Scanner scanner = new Scanner(System.in);

        String respostaCorreta = "livro";
        int tentativas = 0;
        boolean acertou = false;

        System.out.println("\nApesar dos ferimentos, avanças para o centro do templo.");
        System.out.println("Sobre um pedestal de pedra, envolta em luz azulada, repousa uma pequena — mas poderosa — **Chave de Cristal**!");
        esperarEnter(scanner);
        System.out.println("Ao esticares a mão para a agarrar, ouves uma voz antiga ecoar pelas paredes de pedra:");
        System.out.println("Responde se fores digno. Uma única palavra é a chave. Se falhares... o templo decidirá teu destino.\n");
        esperarEnter(scanner);

        System.out.println("🔐 Adivinha: ");
        System.out.println("Vivo entre páginas, mas não sou animal.");
        System.out.println("Revelo o antigo, o sagrado e o mortal.");
        System.out.println("Quem me decifra, ganha poder imortal.");
        System.out.println("O que é?\n");

        while (tentativas < 3 && !acertou) {
            System.out.print("A tua resposta: ");
            String resposta = scanner.nextLine().trim().toLowerCase();

            if (resposta.equals(respostaCorreta)) {
                acertou = true;
                System.out.println("\n✨ A luz azulada envolve-te — acertaste!");
                System.out.println("O templo reconhece a tua sabedoria... e concede-te acesso ao seu maior segredo.");
                System.out.println("A Chave de Cristal flutua até à tua mão. Foste digno!");
                esperarEnter(scanner);
                System.out.println("A tua vida é restaurada: ganhas 20 pontos de força e 20 moedas de ouro como recompensa pela tua inteligência.");
                heroi.recuperarVida(heroi.getVidaMax()); // restaura a vida
                heroi.ganharForca(20);
                heroi.ganharOuro(20);
                heroi.permitirMissaoPiramide();
                esperarEnter(scanner);

            } else {
                tentativas++;
                heroi.perderVida(5);
                System.out.println("⚠️ Resposta errada! Perdes 5 pontos de vida. Tentativas restantes: " + (3 - tentativas));
                // Termina o jogo
                System.exit(0);
            }
        }

        if (!acertou) {
            System.out.println("\n💥 Respondeste errado 3 vezes!");
            System.out.println("Consegues agarrar a chave, mas o templo começa a desmoronar-se!");
            System.out.println("🌪️ Corres por entre colunas a cair, pedras e poeira... e consegues escapar do templo com vida.");
            System.out.println("Mas sofres ferimentos graves.");
            heroi.sofrerDanoAleatorio();
            System.out.println("Com a chave nas mãos, sentes que o verdadeiro desafio ainda está por vir...");

        }
    }

    public static void missaoAldeia(Heroi heroi) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ConsoleColors.YELLOW + "======== MISSÃO 2 - NA PISTA DO EXPLORADOR ========\n" + ConsoleColors.RESET);

        System.out.println("Seguindo as pegadas deixadas na lama, atravessas a vegetação densa até chegares a uma clareira secreta.");
        System.out.println("Diante de ti ergue-se uma pequena aldeia tribal, oculta do mundo exterior.");
        System.out.println("Habitantes observam-te com desconfiança, mas algo nos teus olhos os faz hesitar...");
        esperarEnter(scanner);
        System.out.println("\nSegundo os rumores, o explorador que encontrou a Serpente Dourada refugiou-se aqui, escondido do mundo...");
        System.out.println("Mas antes que possas falar com alguém, algo imponente surge no centro da aldeia.");
        esperarEnter(scanner);
        System.out.println("Para falares com o explorador, primeiro deves enfrentar o guardião do espírito da selva!");
        System.out.println("Que os Deuses estejam do teu lado porque eu já fugi à sete pés!\n");


        // Lutar com NPC aleatório
        NPC inimigo = gerarNPCaleatorio();
        boolean venceu = heroi.atacar(inimigo);

        if (venceu) {
            System.out.println("\n🏆 Vitória! O teu adversário cai de joelhos e os anciãos da aldeia aproximam-se.");
            System.out.println("🚪 És conduzido até uma cabana de madeira onde se esconde o explorador que procuras...");
            heroi.usarPocaoPosCombate();

            // Interação com o explorador
            System.out.println("\n🔍 O explorador observa-te com desconfiança, mas reconhece a marca da vitória.");
            System.out.println("🔓 Após algum tempo, ele entrega-te um mapa antigo, coberto de poeira e símbolos com marcas do Julgamento Antigo.");
            System.out.println("🐍 A Serpente Dourada repousa nas profundezas da Pirâmide de Zarthar, conhecida também pela Pirâmide do Último Sol.");


        } else {

            Audio.playMusic("AudioFiles/wah-wah-sad-trombone-6347.wav");

            try {
                Thread.sleep(6000); // pausa

            } catch (InterruptedException e) {

                e.printStackTrace();
            }

            // Mostrar o conteúdo do ficheiro ASCII
            FileTools.printFile("AsciiFiles/gameover.txt");

            System.out.println(ConsoleColors.RED + "\n💀 Ele foi demasiado forte para ti. Eu disse-te para fugires! A tua aventura termina aqui." + ConsoleColors.RESET);

            // Termina o jogo
            System.exit(0);

        }
    }

    /**
     * Método que executa a missão 3 do jogo - O Vale dos Mortos.
     * O herói chega ao Vale dos Mortos e precisa tomar decisões em um caminho dividido.
     * Dependendo da escolha do jogador, o herói poderá enfrentar desafios, incluindo um combate com um NPC aleatório.
     * Caso o herói vença, ele avança para a próxima etapa. Caso contrário, o jogo termina.
     *
     * @param heroi O herói controlado pelo jogador que participa na missão.
     * @throws FileNotFoundException Caso o arquivo de game over não seja encontrado.
     */
    public static void missaopiramide(Heroi heroi) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ConsoleColors.YELLOW + "\n======== MISSÃO 3 - O VALE DOS MORTOS ========\n" + ConsoleColors.RESET);

        // O herói chega ao Vale dos Mortos após decifrar o mapa
        System.out.println("🌫️ Após decifrar o mapa, chegas finalmente ao misterioso Vale dos Mortos.");
        System.out.println("Ossadas espalham-se pelo solo seco e estalado, e o ar cheira a pedra antiga e sacrifício.");
        System.out.println("À tua frente, o caminho divide-se em dois:");

        System.out.println("\n1. ⬅\uFE0F À esquerda, uma ponte suspensa feita de cordas podres e tábuas partidas balança sobre um abismo sem fundo.");
        System.out.println(" ⚠️ O vento assobia, e cada passo ali parece ser um pacto com a morte.");
        System.out.println("2. ➡️ À direita, uma corda antiga desce pela face de um penhasco íngreme.");
        System.out.println(" As pedras estão húmidas e cobertas de musgo. A profundidade é impossível de calcular.");

        System.out.println("\nQual o caminho que queres seguir? Digita 1 ou 2: ");

        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                System.out.println("\nDás os primeiros passos na ponte suspensa mas o vento não dá tréguas.");
                System.out.println("⚠️ A ponte abana por todo o lado, uma tábua estala. Outra parte-se. As cordas começam a romper-se!");
                System.out.println("💥 Ruuuunnnnnnnnn! Começas a correr mas a ponte cede por completo e desfaz-se no vazio.");
                System.out.println("💀 O corpo desaparece na escuridão do abismo.");
                System.out.println("❌ A tua aventura termina aqui. Só um louco teria escolhido ir por essa ponte!");

                Audio.playMusic("AudioFiles/wah-wah-sad-trombone-6347.wav");

                try {
                    Thread.sleep(6000); // pausa

                } catch (InterruptedException e) {

                    e.printStackTrace();
                }

                // Mostrar o conteúdo do ficheiro ASCII
                FileTools.printFile("AsciiFiles/gameover.txt");

                // Termina o jogo
                System.exit(0);

                break;

            case 2:
                System.out.println("\n🪢 Agarras a corda antiga e começas a descer com cuidado.");
                System.out.println("🧗 Fragmentos de pedra soltam-se, mas a corda resiste. Os músculos ardem com o esforço.");
                System.out.println("🌑 Chegas a uma plataforma subterrânea escondida na lateral do penhasco.");
                System.out.println("🕷️ De entre as sombras surge algo que não estava nos teus planos! Não queres voltar a subir???");

                // Lutar com NPC aleatório
                NPC inimigo = gerarNPCaleatorio();
                boolean venceu = heroi.atacar(inimigo);

                if (venceu) {
                    System.out.println("------------------------------------------------------------------------------------------------------------");
                    System.out.println("Parabéns!!! Por acaso duvidei que fosses conseguir.");
                    System.out.println("Devo dizer que me estás a surpreender. Já devias ter morrido faz tempo!");
                    System.out.println("O caminho ficou livre, estás cada vez mais perto do teu objetivo");
                    System.out.println("------------------------------------------------------------------------------------------------------------\n");
                    heroi.usarPocaoPosCombate();
                } else {

                    Audio.playMusic("AudioFiles/wah-wah-sad-trombone-6347.wav");

                    try {
                        Thread.sleep(6000); // pausa

                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }

                    // Mostrar o conteúdo do ficheiro ASCII
                    FileTools.printFile("AsciiFiles/gameover.txt");

                    System.out.println("------------------------------------------------------------------------------------------------------------");
                    System.out.println("Foste derrotado! Ainda por cima estavas tão perto do teu objetivo final!");
                    System.out.println("Tenta novamente, vou pedir aos teus inimigos para serem mais meigos contigo.\n");
                    System.out.println("------------------------------------------------------------------------------------------------------------");

                    // Termina o jogo
                    System.exit(0);

                    break;
                }

            default:
                System.out.println("Escolha inválida. A missão falhou por indecisão.");

        }

        System.out.println("Após uma longa jornada pelas dunas escaldantes do deserto de Atacama,");
        System.out.println("avistas a imponente silhueta da Pirâmide do Último Sol.");
        System.out.println("Mas, antes de entrar na pirâmide, deparas-te com uma tenda misteriosa.");
        System.out.println("Dentro, um vendedor encapuzado parece estar a tua espera...");
        esperarEnter(scanner);
        System.out.println("De forma enigmática, ele aponta para os itens espalhados em cima da mesa.");
        System.out.println("A pirâmide do Último Sol não é para os fracos.");
        System.out.println("Escolhe de forma sensata:");

        abrirLojaPiramide(heroi);

    }

    /**
     * Abre a loja dentro da Pirâmide do Último Sol e permite que o herói compre itens.
     * O vendedor oferece uma variedade de itens, incluindo poções e armas específicas para cada tipo de herói.
     *
     * @param heroi O herói que irá comprar itens na loja. Dependendo do tipo de herói, ele poderá comprar armas específicas.
     */
    public static void abrirLojaPiramide(Heroi heroi) {
        Vendedor vendedor = new Vendedor();
        carregarItensLojaPiramide(vendedor);
        vendedor.vender(heroi);
    }

    /**
     * Carrega os itens disponíveis na loja para o vendedor.
     * <p>
     * Requisitos:
     * Recebe um objeto {@code Vendedor} válido.
     * Adiciona poções, armas específicas para cada herói e itens gerais.
     */
    public static void carregarItensLojaPiramide(Vendedor vendedor) {
        // Poções (usáveis por todos os heróis)
        vendedor.adicionarItem(new Pocao("Poção de vida normal", 10, 25, 5));
        vendedor.adicionarItem(new Pocao("Poção de vida extra", 15, 50, 10));
        vendedor.adicionarItem(new Pocao("Poção de força", 5, 0, 30));

        // Armas para IndianaJones
        vendedor.adicionarItem(new ArmaPrincipal("Machado pesado", 20, 20, 30, 25, "IndianaJones"));
        vendedor.adicionarItem(new ArmaPrincipal("Espada de bronze", 10, 15, 25, 20, "IndianaJones"));
        vendedor.adicionarItem(new ArmaPrincipal("Chicote de couro", 5, 10, 20, 15, "IndianaJones"));

        // Armas para HansVogel
        vendedor.adicionarItem(new ArmaPrincipal("Pistola semiautomática", 20, 20, 30, 25, "HansVogel"));
        vendedor.adicionarItem(new ArmaPrincipal("Granada de Gás", 10, 15, 25, 20, "HansVogel"));
        vendedor.adicionarItem(new ArmaPrincipal("Bastão com lâmina escondida", 5, 10, 20, 15, "HansVogel"));

        // Armas para SophieValen
        vendedor.adicionarItem(new ArmaPrincipal("Pistola de bolso", 20, 20, 30, 25, "SophieValen"));
        vendedor.adicionarItem(new ArmaPrincipal("Faca afiada", 10, 15, 25, 20, "SophieValen"));
        vendedor.adicionarItem(new ArmaPrincipal("Alfinete com veneno", 5, 10, 20, 15, "SophieValen"));

        // Itens variados
        vendedor.adicionarItem(new ArmaPrincipal("Tocha", 10, 10, 15, 10, "Todos"));
        vendedor.adicionarItem(new ArmaPrincipal("Corda com Gancho", 10, 10, 15, 10, "Todos"));
    }
}

/**
 * Representa a última missão no jogo, onde o herói enfrenta o Rei da Câmara Esquecida na Pirâmide do Último Sol.
 * O herói deve derrotar o Rei em uma batalha épica, e depois decidir seu destino.
 * Se o herói vence, ele avança para a próxima etapa. Caso contrário, a aventura termina.
 *
 * @param heroi O herói que enfrenta o Rei da Câmara Esquecida.
 * @throws FileNotFoundException Se houver problemas ao acessar arquivos necessários para a missão, como os arquivos ASCII ou música.
 */
public static void missaoBossFinal(Heroi heroi) throws FileNotFoundException {


    System.out.println(ConsoleColors.YELLOW + "======== ÚLTIMA MISSAO - A PIRÂMIDE DO ÚLTIMO SOL ========\n" + ConsoleColors.RESET);

    System.out.println("\nAo entrar já sentes o peso do ar denso e a presença de algo maligno.");
    System.out.println("Diante de ti, um imponente monstro se ergue, o guardião da serpente dourada, o Rei da Câmara Esquecida.");
    System.out.println("Com olhos brilhando como ouro, ele prepara-se para enfrentar-te com uma fúria incontrolável.");

    NPC inimigo = gerarNPCaleatorio();
    boolean venceu = heroi.atacar(inimigo);

    if (venceu) {
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("Após uma batalha feroz, tu finalmente derrotas o Rei da Câmara Esquecida!");
        System.out.println("Com um rugido final, o Rei cai de joelhos e se desfaz em ouro e pó, a serpente dourada está a poucos metros de ti.");
        System.out.println("Mas a câmara começa a desmoronar-se e tu tens que decidir se arriscas a tua vida.");
        System.out.println("Desiste... foge enquanto podes ou vais ser mais um a morrer esquecido.");
        System.out.println("Boa decisão... não te vão faltar outros tesouros para descobrir.");

        heroi.usarPocaoPosCombate();

    } else {

        Audio.playMusic("AudioFiles/wah-wah-sad-trombone-6347.wav");

        try {
            Thread.sleep(6000); // pausa

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        // Mostrar o conteúdo do ficheiro ASCII
        FileTools.printFile("AsciiFiles/gameover.txt");

        System.out.println("O Rei da Câmara Esquecida provou ser demasiado poderoso...");
        System.out.println("A tua aventura termina aqui, nas profundezas da pirâmide.");

        // Termina o jogo
        System.exit(0);

    }
}

