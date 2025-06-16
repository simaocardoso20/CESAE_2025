package Indy;

public class NPC extends Entidade {

    private int ouro;

    public NPC(String nome, int vidaMax, int vidaAtual, int forca, int ouro) {
        super(nome, vidaMax, vidaAtual, forca);
        this.ouro = ouro;
    }

    public int getOuro() {
        return ouro;
    }

    public String getNome() {
        return nome;
    }

    public int getForca() {
        return forca;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public boolean estaVivo() {
        return vidaAtual > 0;
    }

    public void receberDano(int dano) {
        vidaAtual -= dano;
        if (vidaAtual < 0) vidaAtual = 0;

        System.out.println(nome + " recebeu " + dano + " de dano. Vida restante: " + vidaAtual);
    }
}