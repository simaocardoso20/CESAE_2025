package Entidades;

import java.util.ArrayList;
import java.util.Scanner;
import Jogo.Jogo;

import Items.ArmaPrincipal;
import Items.Pocao;

public abstract class Heroi extends Entidade {

    protected int nivel;
    protected int ouro;
    protected boolean ataqueEspecialUsado;
    protected ArmaPrincipal armaPrincipal;
    protected ArrayList<ItemHeroi> inventario;

    public Heroi(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int ouro) {
        super(nome, vidaMax, vidaAtual, forca);
        this.nivel = nivel;
        this.ouro = ouro;
        this.armaPrincipal = null;
        this.inventario = new ArrayList<>();
        this.ataqueEspecialUsado = false;
    }

    public int getNivel() {
        return nivel;
    }

    public int getOuro() {
        return ouro;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    public void retirarOuro(int quantidade) {
        this.ouro -= quantidade;
    }

    public void adicionarOuro(int quantidade) {
        this.ouro += quantidade;
    }

    public void equiparArma(ArmaPrincipal arma) {
        this.armaPrincipal = arma;
        System.out.println(nome + " equipou a arma: " + arma.getNome());
    }

    public int getDanoTotal() {
        return armaPrincipal != null ? forca + armaPrincipal.getDano() : forca;
    }

    public int getDanoNormal() {
        return forca + (armaPrincipal != null ? armaPrincipal.getAtaque() : 0);
    }

    public int getDanoEspecial() {
        return forca + (armaPrincipal != null ? armaPrincipal.getAtaqueEspecial() : 0);
    }

    public void perderVida(int quantidade) {
        this.vidaAtual -= quantidade;
        if (this.vidaAtual < 0) {
            this.vidaAtual = 0;
        }
    }

    /**
     * Cura o herói, aumentando sua vida atual.
     *
     * Se a cura exceder a vida máxima do herói, a vida será ajustada para o valor máximo permitido.
     *
     * @param quantidade A quantidade de pontos de vida que o herói será curado.
     */
    public void curar(int quantidade) {
        vidaAtual += quantidade;
        if (vidaAtual > vidaMax) vidaAtual = vidaMax;
        System.out.println(nome + " foi curado em " + quantidade + " pontos de vida.");
    }


    /**
     * Recupera a vida do herói, ajustando para o valor especificado.
     *
     * Se o valor de vida nova for maior que a vida máxima, a vida será ajustada para o valor máximo.
     * Caso contrário, a vida será ajustada para o valor de vida nova.
     *
     * @param vidaNova O novo valor de vida que o herói terá.
     */
    public void recuperarVida(int vidaNova) {
        if (vidaNova > vidaMax) {
            this.vidaAtual = vidaMax;
        } else {
            this.vidaAtual = vidaNova;
        }
    }


    /**
     * Aumenta a força do herói em uma quantidade especificada.
     *
     * O aumento de força só ocorre se a quantidade for positiva.
     * Caso contrário, a força não será alterada.
     *
     * @param quantidade A quantidade de força a ser adicionada ao herói. Deve ser maior que zero.
     */

    public void ganharForca(int quantidade) {
        if (quantidade > 0) {
            this.forca += quantidade;
        }
    }

    /**
     * Aumenta a quantidade de ouro do herói em uma quantidade especificada.
     *
     * O aumento de ouro só ocorre se a quantidade for positiva.
     * Caso contrário, a quantidade de ouro não será alterada.
     *
     * @param quantidade A quantidade de ouro a ser adicionada ao herói. Deve ser maior que zero.
     */
    public void ganharOuro(int quantidade) {
        if (quantidade > 0) {
            this.ouro += quantidade;
        }
    }


    /**
     * Faz o herói subir de nível, aumentando sua vida máxima, vida atual e força.
     * Cada vez que o herói sobe de nível:
     * - O nível é incrementado em 1.
     * - A vida máxima e a vida atual aumentam em 10 pontos.
     * - A força aumenta em 1 ponto.
     *
     * Esta melhoria reflete o crescimento do herói após completar desafios ou batalhas.
     */
    public void subirNivel() {
        this.nivel++;
        this.vidaMax += 10;
        this.vidaAtual += 10;
        this.forca += 1;
        System.out.println("🔺 Subiste de nível! Agora és nível " + nivel);
    }


    /**
     * Exibe o status atual do herói, incluindo informações sobre vida, força, nível,
     * ouro e arma equipada.
     *
     * O status é exibido em um formato amigável para o jogador, facilitando o acompanhamento
     * do progresso do herói no jogo.
     */
    public void mostrarStatus() {
        System.out.println("=== STATUS DO HERÓI ===");
        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + vidaAtual + "/" + vidaMax);
        System.out.println("Força: " + forca);
        System.out.println("Nível: " + nivel);
        System.out.println("Ouro: " + ouro);
        System.out.println("Arma: " + (armaPrincipal != null ? armaPrincipal.getNome() + " (+" + armaPrincipal.getDano() + ")" : "Nenhuma"));
        System.out.println("========================");
    }

    public void adicionarItemAoInventario(ItemHeroi item) {
        inventario.add(item);
    }

    // O ataque do heroi
    public abstract boolean atacar(NPC inimigo);


    /**
     * Permite ao herói usar uma poção após um combate para recuperar vida.
     * O método verifica se o herói tem poções disponíveis e permite ao jogador escolher qual poção usar.
     * Se a poção curar mais do que a vida máxima, o jogador é alertado e deve confirmar se deseja continuar.
     *
     * O método também garante que a poção é removida do inventário após o uso.
     */
    public void usarPocaoPosCombate() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Pocao> pocoesDisponiveis = new ArrayList<>();
        for (ItemHeroi item : inventario) {
            if (item instanceof Pocao) {
                pocoesDisponiveis.add((Pocao) item);
            }
        }

        if (pocoesDisponiveis.isEmpty()) {
            System.out.println("⚠️ Não tens nenhuma poção no inventário.");
            return;
        }

        System.out.println("🎒 Poções disponíveis:");
        for (int i = 0; i < pocoesDisponiveis.size(); i++) {
            Pocao p = pocoesDisponiveis.get(i);
            System.out.println(i + 1 + " - " + p.getNome() + " (cura " + p.getVidaCurar() + " HP)");
        }

        System.out.print("Queres usar alguma poção? (s/n): ");
        String resposta = scanner.nextLine().trim().toLowerCase();
        if (!resposta.equals("s")) return;

        System.out.print("Escolhe o número da poção que queres usar: ");
        int escolha;
        try {
            escolha = Integer.parseInt(scanner.nextLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("❌ Escolha inválida.");
            return;
        }

        if (escolha < 0 || escolha >= pocoesDisponiveis.size()) {
            System.out.println("❌ Escolha inválida.");
            return;
        }

        Pocao escolhida = pocoesDisponiveis.get(escolha);
        int vidaAntes = vidaAtual;
        int excesso = (vidaAtual + escolhida.getVidaCurar()) - vidaMax;

        if (excesso > 0) {
            System.out.println("⚠️ A poção vai curar mais do que a tua vida máxima.");
            System.out.println("Perderás " + excesso + " pontos de cura. Desejas continuar? (s/n): ");
            String confirmacao = scanner.nextLine().trim().toLowerCase();
            if (!confirmacao.equals("s")) {
                System.out.println("❌ Poção não utilizada.");
                return;
            }
        }

        curar(escolhida.getVidaCurar());
        inventario.remove(escolhida);
        System.out.println("✅ Usaste " + escolhida.getNome() + " e recuperaste " + (vidaAtual - vidaAntes) + " de vida.");
    }

    public void sofrerDanoAleatorio() {
        int dano = (int) (Math.random() * 30) + 1;  // Gera número entre 1 e 30
        perderVida(dano);
        System.out.println("⚠️ Estás ferido e perdeste " + dano + " pontos de vida!");
    }

    public boolean estaVivo() {
        return this.vidaAtual > 0;
    }

    private boolean podeFazerMissaoAldeia = false;

    public void permitirMissaoAldeia() {
        this.podeFazerMissaoAldeia = true;
    }

    public boolean temPermissaoMissaoAldeia() {
        return this.podeFazerMissaoAldeia;
    }

    public void recuperarVida() {
        this.vidaAtual = this.vidaMax;
        System.out.println("❤️ Vida totalmente restaurada!");
    }
}


