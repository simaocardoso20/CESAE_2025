package Ex_03.Ingredientes;

import Ex_03.Enums.OrigemIngrediente;
import Ex_03.Enums.TipoVegetal;
import Ex_03.Enums.UnidadeMedida;

public class Vegetal extends Topping{
    private TipoVegetal tipo;

    public Vegetal(int id, String nome, UnidadeMedida medida, double kcalPorMedida, OrigemIngrediente origem, TipoVegetal tipo) {
        super(id, nome, medida, kcalPorMedida, origem);
        this.tipo = tipo;
    }
}
