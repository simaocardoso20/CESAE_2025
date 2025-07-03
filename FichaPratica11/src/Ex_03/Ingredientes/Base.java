package Ex_03.Ingredientes;

import Ex_03.Enums.TipoBase;
import Ex_03.Enums.UnidadeMedida;

public class Base extends Ingrediente {

    private TipoBase tipo;
    private String descricao;

    public Base(int id, String nome, double kcalPorMedida, TipoBase tipo, String descricao) {
        super(id, nome, UnidadeMedida.GRAMAS, kcalPorMedida);
        this.tipo = tipo;
        this.descricao = descricao;
    }
}
