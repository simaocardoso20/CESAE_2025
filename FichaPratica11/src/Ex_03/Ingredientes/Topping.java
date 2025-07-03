package Ex_03.Ingredientes;

import Ex_03.Enums.OrigemIngrediente;
import Ex_03.Enums.UnidadeMedida;

public class Topping extends Ingrediente {
    private OrigemIngrediente origem;

    public Topping(int id, String nome, UnidadeMedida medida, double kcalPorMedida, OrigemIngrediente origem) {
        super(id, nome, medida, kcalPorMedida);
        this.origem = origem;
    }
}
