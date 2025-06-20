package Ex_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Scanner
        Scanner input = new Scanner(System.in);

        // Declarar Variáveis
        String escolha;

        System.out.println("Qual o tipo de taco (Carne Vaca, Carne Frango, Vegetariano): ");
        escolha= input.nextLine();

        Taco tacoUser = FactoryTaco.createTaco(escolha.toUpperCase());

        tacoUser.prepare();
        tacoUser.bake();
        tacoUser.box();
    }
}