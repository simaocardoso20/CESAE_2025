package Entidades;

import java.util.ArrayList;
import java.util.Scanner;

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

    public void curar(int quantidade) {
        vidaAtual += quantidade;
        if (vidaAtual > vidaMax) vidaAtual = vidaMax;
        System.out.println(nome + " foi curado em " + quantidade + " pontos de vida.");
    }

    public void recuperarVida(int vidaNova) {
        if (vidaNova > vidaMax) {
            this.vidaAtual = vidaMax;
        } else {
            this.vidaAtual = vidaNova;
        }
    }

    public void ganharForca(int quantidade) {
        if (quantidade > 0) {
            this.forca += quantidade;
        }
    }

    public void ganharOuro(int quantidade) {
        if (quantidade > 0) {
            this.ouro += quantidade;
        }
    }

    public void subirNivel() {
        this.nivel++;
        this.vidaMax += 10;
        this.vidaAtual += 10;
        this.forca += 1;
        System.out.println("🔺 Subiste de nível! Agora és nível " + nivel);
    }

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

    // Poção após cada combate
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

}

