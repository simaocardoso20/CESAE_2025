package Ex_03.Ingredientes;

import Ex_03.Enums.UnidadeMedida;

public class Ingrediente {
    private int id;
    private String nome;
    private UnidadeMedida medida;
    private double kcalPorMedida;

    public Ingrediente(int id, String nome, UnidadeMedida medida, double kcalPorMedida) {
        this.id = id;
        this.nome = nome;
        this.medida = medida;
        this.kcalPorMedida = kcalPorMedida;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public UnidadeMedida getMedida() {
        return medida;
    }

    public double getKcalPorMedida() {
        return kcalPorMedida;
    }

    public String getMedidaAbreviada() {

        switch (this.medida) {
            case GRAMAS:
                return "g.";

            case LITROS:
                return "L.";

            case UNIDADES:
                return "uni.";
        }

        return "";
    }


    public void exibirDetalhes() {
        System.out.print("[ " + this.id + " | " + this.nome + " | " + this.medida + " | " + this.kcalPorMedida + " Kcal ]");
    }
}
