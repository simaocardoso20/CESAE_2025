package FichaPratica02;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        double salario, taxa;

        // Ler valores
        System.out.print("Introduza um salário:" );
        salario = input.nextDouble();

        // Calcular e imprimir taxa
        if (salario <= 15000) {
            taxa = salario * 0.2;
            System.out.println("Paga taxa de 20%:" + taxa);
        }

        if (salario > 15000 && salario <= 20000) {
            taxa = salario * 0.3;
            System.out.println("Paga taxa de 30%: " + taxa);
        }

        if (salario > 20000 && salario <= 25000) {
            taxa = salario * 0.35;
            System.out.println("Paga taxa de 35%: " + taxa);
        }

        if (salario > 25000) {
            taxa = salario * 0.40;
            System.out.println("Paga taxa de 40%: " + taxa);
        }
    }
}
