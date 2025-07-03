package EX_04;

public class Main {

    public static void main(String[] args) {

        Circulo circ1 = new Circulo("Roxo", 10);
        Circulo circ2 = new Circulo("Verde", 20);

        System.out.println("*********** Perimetro: " + circ2.calcularPerimetro() + " ***********");
        System.out.println("*********** Área: " + circ2.calcularArea() + " ***********");
    }
}
