package Indy;

public class ConsumivelCombate extends Consumivel{

    private int ataqueInstantaneo;

    public ConsumivelCombate(String nome, int precoMoedasOuro, int ataqueInstantaneo) {
        super(nome, precoMoedasOuro);
        this.ataqueInstantaneo = ataqueInstantaneo;
    }

        @Override
        public String getDescricao() {
            return "Consumível de Combate: " + nome + "\n" +
                    "Preço: " + precoMoedasOuro + " moedas de ouro\n" +
                    "Ataque Instantâneo: " + ataqueInstantaneo + " pontos de dano";
        }
    }

