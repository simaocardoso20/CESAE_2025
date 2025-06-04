package Ex_03_Alex;

public class Peixe {

    private String especie;
    private double peso;
    private double preco; // por kg

    public Peixe(String especie, double peso, double preco) {
        this.especie = especie;
        this.peso = peso;
        this.preco = preco;
    }

    public double getPeso() {
        return peso;
    }

    public double getPreco() {
        return preco;
    }

    public void exibirDetalhes() {
        System.out.println(especie + " - " + peso + "kg - €" + preco + "/kg");
    }
}
