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
}
