package Ex_03.Ingredientes;

import Ex_03.Enums.OrigemIngrediente;
import Ex_03.Enums.TipoQueijo;
import Ex_03.Enums.UnidadeMedida;

public class Queijo extends Topping{
    private TipoQueijo tipo;

    public Queijo(int id, String nome, UnidadeMedida medida, double kcalPorMedida, OrigemIngrediente origem, TipoQueijo tipo) {
        super(id, nome, medida, kcalPorMedida, origem);
        this.tipo = tipo;
    }
}