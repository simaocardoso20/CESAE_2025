package Ex_03.Ingredientes;

import Ex_03.Enums.OrigemIngrediente;
import Ex_03.Enums.TipoFrutoMar;
import Ex_03.Enums.UnidadeMedida;

public class FrutoMar extends Topping{
    private TipoFrutoMar tipo;

    public FrutoMar(int id, String nome, UnidadeMedida medida, double kcalPorMedida, OrigemIngrediente origem, TipoFrutoMar tipo) {
        super(id, nome, medida, kcalPorMedida, origem);
        this.tipo = tipo;
    }
}
