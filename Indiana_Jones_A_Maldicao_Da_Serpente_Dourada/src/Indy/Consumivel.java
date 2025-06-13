package Indy;

public abstract class Consumivel extends ItemHeroi{

    public Consumivel(String nome, int precoMoedasOuro) {
        super(nome, precoMoedasOuro);
    }

    @Override
    public boolean podeUsar(Heroi heroi) {
        return true;
    }

    @Override
    public void usar(Heroi heroi) {
    }
}
