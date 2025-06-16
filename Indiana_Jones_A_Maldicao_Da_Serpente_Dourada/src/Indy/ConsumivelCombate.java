package Indy;

public class ConsumivelCombate extends Consumivel {

    private int ataqueInstantaneo;

    public ConsumivelCombate(String nome, int precoMoedasOuro, int ataqueInstantaneo) {
        super(nome, precoMoedasOuro);
        this.ataqueInstantaneo = ataqueInstantaneo;
    }

    public int getAtaqueInstantaneo() {
        return ataqueInstantaneo;
    }

    @Override
    public String getDescricao() {
        return "Consumível de Combate: " + nome + "\n" +
                "Preço: " + precoMoedasOuro + " moedas de ouro\n" +
                "Ataque Instantâneo: " + ataqueInstantaneo + " pontos de dano";
    }

    @Override
    public void usar(Heroi heroi) {
        System.out.println(heroi.getNome() + " usou " + nome + " causando " + ataqueInstantaneo + " de dano instantâneo.");
    }
}