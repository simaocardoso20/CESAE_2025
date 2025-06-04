package Ex_02.Veiculo;

import Ex_02.Enum.TipoCombustivel;

import java.util.ArrayList;

public class Camiao extends Veiculo {

    private double capacidadeCarga;

    public Camiao(String marca, String modelo, int anoFabrico, int potencia, int cilindrada, double litro100Km, TipoCombustivel combustivel, double capacidadeCarga) {
        super(marca, modelo, anoFabrico, potencia, cilindrada, litro100Km, combustivel);
        this.capacidadeCarga = capacidadeCarga;
    }
}






