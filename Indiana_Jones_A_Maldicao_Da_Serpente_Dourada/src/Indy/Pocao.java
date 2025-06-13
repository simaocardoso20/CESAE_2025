package Indy;

public class Pocao extends Consumivel{

    private int vidaCurar;
    private int aumentoForca;

    public Pocao(String nome, int precoMoedasOuro, int vidaCurar, int aumentoForca) {
        super(nome, precoMoedasOuro);
        this.vidaCurar = vidaCurar;
        this.aumentoForca = aumentoForca;
    }

    @Override
    public void usar(Heroi heroi) {
        if (vidaCurar > 0) {
            heroi.curar(vidaCurar);
            System.out.println(heroi.getNome() + " recuperou " + vidaCurar + " de vida.");
        }
        if (aumentoForca > 0) {
            heroi.aumentarForca(aumentoForca);
            System.out.println(heroi.getNome() + " aumentou a força em +" + aumentoForca + ".");
        }
    }

    @Override
    public boolean podeUsar(Heroi heroi) {
        return true; // todas as poções podem ser usadas por qualquer herói
    }

    @Override
    public String getDescricao() {
        return getNome() + " (Vida +" + vidaCurar + ", Força +" + aumentoForca + ")";
    }
}
