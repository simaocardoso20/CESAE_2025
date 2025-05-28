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
        return 2 * Math.PI * this.raio;
    }

    public double calcularPerimetro() {
        return Math.PI * this.raio * this.raio;
    }

}


