package Ex_02.Veiculo;

import Ex_02.Enum.TipoCombustivel;

import java.util.ArrayList;

public class Carro extends Veiculo {
    private int QtPassageiros;

    public Carro(String marca, String modelo, int anoFabrico, int potencia, int cilindrada, double litro100Km, TipoCombustivel combustivel, int qtPassageiros) {
        super(marca, modelo, anoFabrico, potencia, cilindrada, litro100Km, combustivel);
        QtPassageiros = qtPassageiros;
    }
}





