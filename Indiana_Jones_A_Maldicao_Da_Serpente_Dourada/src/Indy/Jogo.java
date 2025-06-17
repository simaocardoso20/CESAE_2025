package Indy;

import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;


public class Jogo {

    // NPCs principais da história
    public static NPC macacoLider;
    public static NPC guerreiroTribal;
    public static NPC serpenteUxmal;
    public static NPC espectroGuardiao;
    public static NPC generalNazi;
    public static NPC bossFinal;

    public static void inicializarNPCs () {
        macacoLider = new NPC("Macaco Líder", 100, 100, 25, 30);
        guerreiroTribal = new NPC("Guerreiro Tribal", 100, 100, 25, 30);
        serpenteUxmal = new NPC("Serpente Gigante de Uxmal", 100, 120, 30, 30);
        espectroGuardiao = new NPC("Espectro Guardião", 100, 90, 22, 30);
        generalNazi = new NPC("General Nazi", 100, 100, 18, 30);
        bossFinal = new NPC("Múmia Azrak", 150, 150, 40, 100);
    }

    // Metodo para gerar inimigo aleatório
    public static NPC gerarNPCaleatorio() {
        List<NPC> npcs = new ArrayList<>();
        npcs.add(macacoLider);
        npcs.add(guerreiroTribal);
        npcs.add(serpenteUxmal);
        npcs.add(espectroGuardiao);
        npcs.add(generalNazi);

        Random random = new Random();
        return npcs.get(random.nextInt(npcs.size()));
    }

    public static void iniciar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("       \n======== BEM-VINDO AO JOGO ========\n");
        System.out.println("INDIANA JONES: 🐍 A Maldição da Serpente Dourada 🐍\n");
        System.out.print("Digite o teu nome de utilizador: ");
        String username = scanner.nextLine();
        System.out.println("Olá, " + username + "! Prepara-te para esta grande aventura...\n");
    }

    private static void esperarEnter (Scanner scanner) {
        System.out.print("\n(Enter para continuar...)\n");
        scanner.nextLine();
    }

    public static Heroi criarPersonagem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== CRIAÇÃO DA PERSONAGEM ===\n");

        System.out.println("Escolhe o teu herói:");
        System.out.println("1 - Indiana Jones - Arqueólogo Aventureiro");
        System.out.println("2 - General Hans Vogel - Vilão Nazi");
        System.out.println("3 - Sophie Valen – Espiã Misteriosa\n");

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


        public static void introducaoHistoria () {
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


        public static void mostrarRoteiroPersonalizado (Heroi heroi){
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

        public static void abrirLoja (Heroi heroi){
            Vendedor vendedor = new Vendedor();
            carregarItensLoja(vendedor);
            vendedor.vender(heroi);
        }

        public static void carregarItensLoja (Vendedor vendedor){
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


        public static void missaoSelva (Heroi heroi){
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
                        System.out.println("\nParabéns! Derrotaste o " + gerarNPCaleatorio().getNome() + ", um feito que mais ninguém tinha conseguido.");
                        System.out.println("Como recompensa e demonstração de respeito, o " + gerarNPCaleatorio().getNome() + " deu-te o mapa que procuravas!");
                        System.out.println("------------------------------------------------------------------------------------------------------------\n");
                        heroi.usarPocaoPosCombate();
                    } else {
                        System.out.println("------------------------------------------------------------------------------------------------------------");
                        System.out.println("Foste derrotado! Não tiveste qualquer hipótese. É melhor não tentares novamente!");
                        System.out.println("Ainda te vais magoar!\n");
                        System.out.println("------------------------------------------------------------------------------------------------------------");
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

        public static void missaoTemplo (Heroi heroi){
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

        public static void desafioChaveCristal (Heroi heroi){
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

        public static void missaoAldeia (Heroi heroi){
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n=== MISSÃO 2 - NA PISTA DO EXPLORADOR ===\n");

            System.out.println("Seguindo as pegadas deixadas na lama, atravessas a vegetação densa até chegares a uma clareira secreta.");
            System.out.println("Diante de ti ergue-se uma pequena aldeia tribal, oculta do mundo exterior.");
            System.out.println("Habitantes observam-te com desconfiança, mas algo nos teus olhos os faz hesitar...");
            esperarEnter(scanner);
            System.out.println("\nSegundo os rumores, o explorador que encontrou a Serpente Dourada refugiou-se aqui, escondido do mundo...");
            System.out.println("Mas antes que possas falar com alguém, algo imponente surge no centro da aldeia.");
            esperarEnter(scanner);
            System.out.println("Para falares com o explorador, primeiro deves enfrentar " + gerarNPCaleatorio().getNome() + "o protetor do espírito da selva!”");
            System.out.println("Que os Deuses estejam do teu lado porque eu já fugi à sete pés!\n");


            // Lutar com NPC aleatório
            NPC inimigo = gerarNPCaleatorio();
            boolean venceu = heroi.atacar(inimigo);

            if (venceu) {
                System.out.println("\n🏆 Vitória! O " + gerarNPCaleatorio().getNome() + "cai de joelhos e os anciãos da aldeia aproximam-se.");
                System.out.println("🚪 És conduzido até uma cabana de madeira onde se esconde o explorador que procuras...");
                heroi.usarPocaoPosCombate();

            } else {
                System.out.println("\n💀 O" + gerarNPCaleatorio().getNome() + "foi demasiado forte para ti. Eu disse-te para fugires! A tua aventura termina aqui.");

            }
        }
    }
