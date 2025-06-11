package Indy;

public class ArmaPrincipal extends ItemHeroi{

    private int ataque;
    private int AtaqueEspecial;
    private String tipoPermitido;

    public ArmaPrincipal(String nome, int precoMoedasOuro, int ataque, int ataqueEspecial, String tipoPermitido) {
        super(nome, precoMoedasOuro);
        this.ataque = ataque;
        AtaqueEspecial = ataqueEspecial;
        this.tipoPermitido = tipoPermitido;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public boolean podeUsar(Heroi heroi) {
        return tipoPermitido.equals("Todos") || heroi.getClass().getSimpleName().equals(tipoPermitido);
    }

    public void usar(Heroi heroi) {
        heroi.equiparArma(this);
        System.out.println(heroi.getNome() + " equipou " + getNome() + "!");
    }
}

