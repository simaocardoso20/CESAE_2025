package Indy;

public abstract class Entidade {

    protected String nome;
    protected int vidaMax;
    protected int vidaAtual;
    protected int forca;

    public Entidade(String nome, int vidaMax, int vidaAtual, int forca) {
        this.nome = nome;
        this.vidaMax = vidaMax;
        this.vidaAtual = vidaAtual;
        this.forca = forca;
    }

    public String getNome() {
        return nome;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public void setVidaAtual(int vidaAtual) {
        this.vidaAtual = vidaAtual;
    }

    public int getForca() {
        return forca;
    }

    public void receberDano(int dano) {
        vidaAtual -= dano;
        if (vidaAtual < 0) vidaAtual = 0;
        System.out.println(nome + " recebeu " + dano + " de dano. Vida atual: " + vidaAtual);
    }

    public boolean estaVivo() {
        return vidaAtual > 0;
    }

    //mostrarDetalhes()
}
