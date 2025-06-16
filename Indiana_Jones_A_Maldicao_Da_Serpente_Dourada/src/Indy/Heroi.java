package Indy;

import java.util.ArrayList;

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

    public abstract boolean atacar(NPC inimigo);


    // Criei para testar ataques instantâneos mas retirei o metodo da jogabilidade
    public void enfrentarNPC(NPC inimigo) {
        System.out.println("Combate iniciado contra " + inimigo.getNome() + "!");

        while (this.vidaAtual > 0 && inimigo.getVidaAtual() > 0) {
            inimigo.receberDano(this.forca);

            if (inimigo.getVidaAtual() > 0) {
                this.receberDano(inimigo.getForca());
            }
        }

        if (this.vidaAtual > 0) {
            System.out.println("Você venceu " + inimigo.getNome() + "!");
            recuperarVida(vidaMax);
            ganharForca(10);
        } else {
            System.out.println("Você foi derrotado por " + inimigo.getNome() + ".");
        }
    }
}
