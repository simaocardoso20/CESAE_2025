package Ex_03.Ingredientes;

import Ex_03.Enums.OrigemIngrediente;
import Ex_03.Enums.TipoCarne;
import Ex_03.Enums.UnidadeMedida;

public class Carne extends Topping{
    private TipoCarne tipo;

    public Carne(int id, String nome, UnidadeMedida medida, double kcalPorMedida, OrigemIngrediente origem, TipoCarne tipo) {
        super(id, nome, medida, kcalPorMedida, origem);
        this.tipo = tipo;
    }
}
