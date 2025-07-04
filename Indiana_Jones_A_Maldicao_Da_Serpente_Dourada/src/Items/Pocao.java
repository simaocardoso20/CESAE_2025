package Items;

import Entidades.Heroi;

public class Pocao extends Consumivel {

    private int vidaCurar;
    private int aumentoForca;

    public Pocao(String nome, int precoMoedasOuro, int vidaCurar, int aumentoForca) {
        super(nome, precoMoedasOuro);
        this.vidaCurar = vidaCurar;
        this.aumentoForca = aumentoForca;
    }

    public int getVidaCurar() {
        return vidaCurar;
    }

    @Override
    public void usar(Heroi heroi) {
        if (vidaCurar > 0) {
            heroi.curar(vidaCurar);
            System.out.println(heroi.getNome() + " recuperou " + vidaCurar + " de vida.");
        }
        if (aumentoForca > 0) {
            heroi.ganharForca(aumentoForca);
            System.out.println(heroi.getNome() + " aumentou a força em +" + aumentoForca + ".");
        }
    }

    @Override
    public boolean podeUsar(Heroi heroi) {
        return true;  // poções são para todos
    }

    @Override
    public String getDescricao() {
        System.out.println("------------------------------------------------------------------");
        return getNome() + " - Vida +" + vidaCurar + ", Força +" + aumentoForca
                + "\n \uD83D\uDCB0 Preço: " + getPrecoMoedasOuro() + " Moedas de ouro | Para todos os heróis";
    }
}