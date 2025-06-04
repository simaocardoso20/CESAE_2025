package Ex_02.Veiculo;

import Ex_02.Enum.TipoCombustivel;

public class Veiculo {

    private String marca;
    private String modelo;
    private int anoFabrico;
    private int potencia;
    private int cilindrada;
    private double litro100Km;
    private boolean ligado;
    private TipoCombustivel combustivel;

    public Veiculo(String marca, String modelo, int anoFabrico, int potencia, int cilindrada, double litro100Km, TipoCombustivel combustivel) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabrico = anoFabrico;
        this.potencia = potencia;
        this.cilindrada = cilindrada;
        this.litro100Km = litro100Km;
        this.combustivel = combustivel;
        this.ligado = false; // inicia desligado
    }

    public boolean isLigado() {
        return ligado;
    }

    public void ligar() {
        if (!this.ligado) {
            this.ligado = true;
            System.out.println("O carro está ligado");
        } else {
            System.out.println("O carro já está ligado");
        }
    }

    public Veiculo corrida(Veiculo adversario) {
        if (this.potencia > adversario.potencia) {
            return this;
        } else if (this.potencia < adversario.potencia) {
            return adversario;
        } else {
            if (this.cilindrada > adversario.cilindrada) {
                return this;
            } else if (this.cilindrada < adversario.cilindrada) {
                return adversario;
            } else {
                System.out.println("Empate entre os veículos!");
                return null;
            }
        }
    }
}




