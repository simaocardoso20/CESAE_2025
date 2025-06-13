package Indy;

public class ConsumivelCombate extends Consumivel{

    private int ataqueInstantaneo;

    public ConsumivelCombate(String nome, int precoMoedasOuro, int cura, int ataqueInstantaneo) {
        super(nome, precoMoedasOuro, cura);
        this.ataqueInstantaneo = ataqueInstantaneo;
    }

        @Override
        public String getDescricao() {
            return "Consumível de Combate: " + nome + "\n" +
                    "Preço: " + precoMoedasOuro + " moedas de ouro\n" +
                    "Cura: " + cura + " pontos de vida\n" +
                    "Ataque Instantâneo: " + ataqueInstantaneo + " pontos de dano";
        }
    }

