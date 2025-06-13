package Indy;

public abstract class Consumivel extends ItemHeroi{

    protected int cura;

    public Consumivel(String nome, int precoMoedasOuro, int cura) {
        super(nome, precoMoedasOuro);
        this.cura = cura;
    }

    public int getCura() {
        return cura;
    }

    @Override
    public boolean podeUsar(Heroi heroi) {
        return true;
    }

    @Override
    public void usar(Heroi heroi) {
        heroi.curar(cura);
        System.out.println(heroi.getNome() + " usou " + nome + " e recuperou " + cura + " de vida.");
    }
}
