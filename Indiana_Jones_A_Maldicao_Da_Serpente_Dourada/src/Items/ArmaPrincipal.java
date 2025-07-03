package Items;

import Entidades.Heroi;
import Entidades.ItemHeroi;

public class ArmaPrincipal extends ItemHeroi {

    private int ataque;
    private int ataqueEspecial;
    private int dano;
    private String tipoPermitido;

    public ArmaPrincipal(String nome, int preco, int ataque, int ataqueEspecial, int dano, String tipoPermitido) {
        super(nome, preco);
        this.ataque = ataque;
        this.ataqueEspecial = ataqueEspecial;
        this.dano = dano;
        this.tipoPermitido = tipoPermitido;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public int getDano() {
        return dano;
    }

    @Override
    public boolean podeUsar(Heroi heroi) {
        return tipoPermitido.equals("Todos") || heroi.getClass().getSimpleName().equals(tipoPermitido);
    }

    @Override
    public void usar(Heroi heroi) {
        heroi.equiparArma(this);
        System.out.println(heroi.getNome() + " equipou " + getNome() + "!");
    }

    @Override
    public String getDescricao() {
        String destinatarios = tipoPermitido.equals("Todos") ? "Para todos os heróis" : "Especial " + tipoPermitido;
        System.out.println("------------------------------------------------------------------");
        return getNome() + " - Ataque: " + ataque + ", Especial: " + ataqueEspecial + ", Dano: " + dano +
                "\n \uD83D\uDCB0 Preço: " + getPrecoMoedasOuro() + " | " + destinatarios;
    }
}



