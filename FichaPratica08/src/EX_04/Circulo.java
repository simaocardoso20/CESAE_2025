package EX_04;

public class Circulo {

    private String cor;
    private double raio;

    public Circulo(String cor, double raio) {
        this.cor = cor;
        this.raio = raio;
    }

    public double getRaio(){
        return raio;
    }

    public double calcularArea() {
        return this.raio * this.raio * 3.14;
    }

    public double calcularPerimetro() {
        return this.raio * 2 * 3.14;
    }

}


