package Jogo;

import Audio.Audio;
import Cores.ConsoleColors;
import Entidades.HansVogel;
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
    public static NPC bossFinal;

    public static void inicializarNPCs() {
        devoradorAlmas = new NPC("Devorador de Almas", 110, 100, 250, 35);
        guerreiroTribal = new NPC("Guerreiro Tribal", 100, 100, 200, 35);
        protetorSagrado = new NPC("Protetor Sagrado", 120, 100, 300, 35);
        espectroGuardiao = new NPC("Espectro Guardião", 130, 100, 350, 35);
        sentinelaSombrasEternas = new NPC("Sentinela das Sombras Eternas", 100, 100, 1800, 30);
        bossFinal = new NPC("Rei da Câmara Esquecida", 150, 150, 40, 100);
    }

    // Metodo para gerar inimigo aleatório
    public static NPC gerarNPCaleatorio() {
        List<NPC> npcs = new ArrayList<>();
        npcs.add(devoradorAlmas);
        npcs.add(guerreiroTribal);
        npcs.add(protetorSagrado);
        npcs.add(espectroGuardiao);
        npcs.add(sentinelaSombrasEternas);

        Random random = new Random();
        return npcs.get(random.nextInt(npcs.size()));
    }

    public static int menuFimDeJogo(Scanner scanner, Heroi heroi) {
        System.out.println("\n=== JOGO TERMINADO ===");
        System.out.println("1 - Jogar novamente com a mesma personagem");
        System.out.println("2 - Criar nova personagem");
        System.out.println("3 - Voltar ao início do jogo");

        int escolha = 0;
        while (escolha < 1 || escolha > 3) {
            System.out.print("Escolha uma opção: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, insere um número válido: ");
                scanner.next();
            }
            escolha = scanner.nextInt();
        }

        switch (escolha) {
            case 1:
                System.out.println("Repetir a aventura com " + heroi.getNome());
                return 1;

            case 2:
                return 2;

            case 3:
                System.out.println("Obrigado por jogar. Até à próxima!");
                return 3;
        }

        // Este return nunca será alcançado, mas evita erro de compilação
        return -1;
    }

    /**
     * Inicializa os NPCs do jogo com atributos definidos.
     *
     * Requisitos:
     * As variáveis devoradorAlmas, guerreiroTribal, protetorSagrado,
     * espectroGuardiao, sentinelaSombrasEternas e bossFinal devem estar declaradas.
     */
    public static void iniciar() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Audio.playMusic("AudioFiles/IndianaJonesThemeSong.wav");

        System.out.println("       \n=================================== BEM-VINDO AO JOGO ===================================\n");

        System.out.println("INDIANA JONES: 🐍 A Maldição da Serpente Dourada 🐍\n");


        FileTools.printFile("AsciiFiles/IndianaJones.txt");


        System.out.print("Digite o teu nome de utilizador: ");
        String username = scanner.nextLine();
        System.out.println("Olá, " + username + "! Prepara-te para esta grande aventura...\n");
    }
    /**
     * Aguarda o utilizador pressionar Enter para continuar.
     *
     * Requisitos:
     * Recebe um objeto Scanner já inicializado para leitura da entrada.
     */
    private static void esperarEnter(Scanner scanner) {
        System.out.print(ConsoleColors.GREEN_BOLD + "\nEnter para continuar...)\n" + ConsoleColors.RESET);
        scanner.nextLine();
    }

    /**
     * Cria um herói com base na escolha do utilizador e distribui atributos.
     *
     * Requisitos:
     * Utiliza {@code Scanner} para leitura de input.
     * Requer classes IndianaJones, HansVogel e SophieValen implementadas.
     * O utilizador deve escolher personagem, dificuldade e distribuir pontos corretamente.
     *
     * @return Instância de uma subclasse de Heroi com os atributos escolhidos.
     */
    public static Heroi criarPersonagem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=================================== CRIAÇÃO DA PERSONAGEM ===================================\n");

        System.out.println("Escolhe o teu herói:");
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
                System.out.println("Escolheste o Indiana Jones, o lendário arqueólogo aventureiro e destemido.\n"
                        + "Com o seu inseparável chapéu, chicote e um vasto conhecimento sobre civilizações antigas,\n"
                        + "ele vai lutar para manter artefatos poderosos fora das mãos erradas.");
                break;
            case 2:
                nome = "Hans Vogel";
                System.out.println("Escolheste o General Hans Vogel, um oficial nazista implacável, um estratega frio e calculista.\n"
                        + "Vogel representa a face sombria da arqueologia – onde o conhecimento é usado como arma,\n"
                        + "e a história é moldada pela força. Obcecado pelo poder dos artefatos místicos,\n"
                        + "ele fará de tudo para obter o poder da Serpente Dourada.");
                break;
            case 3:
                nome = "Sophie Valen";
                System.out.println("Escolheste a Sophie Valen, sedutora e mortal, uma espiã misteriosa e letal.\n"
                        + "Mestre do disfarce, da manipulação e combate corpo a corpo, com um passado envolto em segredos\n"
                        + " e um olhar que esconde mais do que revela, Sophie é tão perigosa quanto fascinante.\n"
                        + "No final, ela terá de escolher: vingança, perdão... ou sacrifício.");
                break;
        }


        System.out.println("\nEscolhe a dificuldade do jogo:");
        System.out.println("1 - Fácil (300 pontos, 20 ouro)");
        System.out.println("2 - Difícil (220 pontos, 15 ouro)\n");

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
            System.out.println("\nDistribui os teus " + pontosTotais + " pontos:");

            // Vida
            System.out.print("- Quantos pontos de VIDA queres usar? (1 ponto = 1 vida): ");
            vida = scanner.nextInt();

            int pontosRestantes = pontosTotais - vida;

            if (pontosRestantes < 0) {
                System.out.println("Usaste mais do que tens! Só tens " + pontosTotais + " pontos. Tenta outra vez.");
                continue;
            }

            System.out.println("Restam-te " + pontosRestantes + " pontos para FORÇA.");
            System.out.println("Cada ponto de FORÇA custa 5 pontos.");
            System.out.println("Máximo possível de FORÇA: " + (pontosRestantes / 5) + "\n");

            System.out.print("- Quantos pontos de FORÇA queres usar? ");
            forca = scanner.nextInt();

            int custoTotal = vida + (forca * 5);

            if (custoTotal == pontosTotais) {
                distribuicaoValida = true;
            } else {
                System.out.println("\nDistribuição inválida! Usaste " + custoTotal + " pontos. Tenta novamente.\n");
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
     *
     * Requisitos:
     * Utiliza {@code Scanner} para esperar o utilizador pressionar Enter entre blocos de texto.
     */
    public static void introducaoHistoria() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== INTRODUÇÃO ===\n");
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
     *
     * Requisitos:
     * Recebe um objeto {@code Heroi} válido.
     * Utiliza {@code Scanner} para pausas entre os textos com o método auxiliar {@code esperarEnter}.
     */
    public static void mostrarRoteiroPersonalizado(Heroi heroi) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== MISSÃO 1 - BEM-VINDO À SELVA ===\n");
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
     *
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
     *
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


    public static void missaoSelva(Heroi heroi) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nCom os bolsos mais leves (ou não), entras na espessa e abafada selva.");
        System.out.println("O som distante de tambores tribais mistura-se com os gritos de animais selvagens.");
        esperarEnter(scanner);
        System.out.println("A missão é clara: encontrar o mapa perdido escondido dentro desta floresta traiçoeira.");
        System.out.println("Dois caminhos surgem à tua frente:\n");

        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.println("1. ⬅\uFE0F A Selva dos Sussurros: Não estás sozinho, os sons de algo (ou alguém) a mover-se entre os galhos são constantes.");
        System.out.println("2. ➡️ A Terra dos Mortos: Um atalho sinistro, com solo instável, lama densa e um perigo silencioso.");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------\n");

        System.out.print("Digita 1 ou 2: ");
        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                System.out.println("\nEscolheste a Selva dos Sussurros e avanças cautelosamente...");
                System.out.println("De repente surge " + gerarNPCaleatorio().getNome() + ", ele bloqueia o teu caminho. Vais ter que enfrentá-lo... isso se tiveres coragem suficiente!");
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
                    System.out.println("------------------------------------------------------------------------------------------------------------");
                    System.out.println("Foste derrotado! Não tiveste qualquer hipótese. É melhor não tentares novamente!");
                    System.out.println("Ainda te vais magoar!");
                    System.out.println("------------------------------------------------------------------------------------------------------------");

                    int escolhaFim = Jogo.menuFimDeJogo(scanner, heroi);

                    // Dependendo da escolha, devemos interromper aqui
                    if (escolhaFim == 1 || escolhaFim == 2 || escolhaFim == 3) {
                        return; // Sai da função/missão e volta ao controlo do método principal
                    }
                }
                break;

            case 2:
                System.out.println("\nAvanças pela passagem enlameada... acho que não foi boa ideia.");
                System.out.println("O solo cede de repente! Areia movediiiiiiiiiça!");
                esperarEnter(scanner);
                heroi.sofrerDanoAleatorio();
                System.out.println("Com muito esforço consegues escapar mas quase que morrias");
                System.out.println("No final do trilho, encontras pegadas e decides segui-las.\n");
                heroi.permitirMissaoAldeia();
                esperarEnter(scanner);
                break;

            default:
                System.out.println("Escolha inválida. A missão falhou por indecisão.");
        }
    }


    public static void missaoTemplo(Heroi heroi) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== MISSÃO 2 – O TEMPLO DOS ECOS PERDIDOS ===\n");
        System.out.println("Com o mapa nas mãos, atravessas a última barreira de vegetação densa...");
        System.out.println("Diante de ti ergue-se um templo milenar coberto por raízes e musgo.");
        esperarEnter(scanner);
        System.out.println("No seu interior, ecoam sons metálicos... algo se move.");
        System.out.println("Dois caminhos apresentam-se logo à entrada:\n");
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
                System.out.println("Avisei-te, esta aventura não é para amadores!\n");
                esperarEnter(scanner);
                break;

            case 2:
                System.out.println("\nAvanças pelo túnel subterrâneo com cuidado...");
                System.out.println("De repente – *click*! Cuidaaaaaaaaaado, uma lança surge do chão!");
                System.out.println("Tentas desviar-te mas foste ferido e quase que te afogas.");
                heroi.sofrerDanoAleatorio();
                esperarEnter(scanner);
                System.out.println("Esse corte está com muito mau aspeto.");
                System.out.println("Desculpa a sinceridade, mas essa perna não vai durar muito!\n");
                esperarEnter(scanner);
                break;

            default:
                System.out.println("Escolha inválida. Ficaste parado e foste apanhado pelo exército alemão. Missão falhada.");
                return;
        }
    }

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
            } else {
                tentativas++;
                heroi.perderVida(5);
                System.out.println("⚠️ Resposta errada! Perdes 5 pontos de vida. Tentativas restantes: " + (3 - tentativas));
            }
        }

        if (!acertou) {
            System.out.println("\n💥 Respondeste errado 3 vezes!");
            System.out.println("Consegues agarrar a chave, mas o templo começa a desmoronar-se!");
            System.out.println("🌪️ Corres por entre colunas a cair, pedras e poeira... e consegues escapar do templo com vida.");
            System.out.println("Mas sofres ferimentos graves.");
            heroi.sofrerDanoAleatorio();
            System.out.println("Com a chave nas mãos, respiras fundo. O verdadeiro desafio ainda está por vir...");
        }
    }

    public static void missaoAldeia(Heroi heroi) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== MISSÃO 2 - NA PISTA DO EXPLORADOR ===\n");

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
            System.out.println("\n🏆 Vitória! O " + gerarNPCaleatorio().getNome() + "cai de joelhos e os anciãos da aldeia aproximam-se.");
            System.out.println("🚪 És conduzido até uma cabana de madeira onde se esconde o explorador que procuras...");
            heroi.usarPocaoPosCombate();

            // Interação com o explorador
            System.out.println("\n🔍 O explorador observa-te com desconfiança, mas reconhece a marca da vitória.");
            System.out.println("🔓 Após algum tempo, ele entrega-te um mapa antigo, coberto de poeira e símbolos com marcas do Julgamento Antigo.");
            System.out.println("🐍 A Serpente Dourada repousa nas profundezas da Pirâmide de Zarthar, conhecida também pela Pirâmide do Último Sol.");


        } else {
            System.out.println("\n💀 O" + gerarNPCaleatorio().getNome() + "foi demasiado forte para ti. Eu disse-te para fugires! A tua aventura termina aqui.");


        }
    }

    public static void missaopiramide(Heroi heroi) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== MISSÃO 3 - O VALE DOS MORTOS ===\n");

        // O herói chega ao Vale dos Mortos após decifrar o mapa
        System.out.println("\n🌫️ Após decifrar o mapa, chegas finalmente ao misterioso Vale dos Mortos.");
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
                    System.out.println("------------------------------------------------------------------------------------------------------------");
                    System.out.println("Foste derrotado! Ainda por cima estavas tão perto do teu objetivo final!");
                    System.out.println("Tenta novamente, vou pedir aos teus inimigos para serem mais meigos contigo.\n");
                    System.out.println("------------------------------------------------------------------------------------------------------------");
                    break;
                }

            default:
                System.out.println("Escolha inválida. A missão falhou por indecisão.");

        }
    }
}





