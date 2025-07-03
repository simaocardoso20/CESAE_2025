package FichaPratica02;

import java.util.Scanner;

public class Ex09 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        int num1, num2, num3;

        // Ler números
        System.out.print("Insira o número 1: ");
        num1 = input.nextInt();

        System.out.print("Insira o número 2: ");
        num2 = input.nextInt();

        System.out.print("Insira o número 3: ");
        num3 = input.nextInt();


        // Imprimir o número
        if (num1 < num2 && num1 < num3) {
            System.out.println("Menor: " +num1);
        }

        if (num2 < num1 && num2 < num3) {
            System.out.println("Menor: " +num2);

        }

        if (num3 < num1 && num3 < num2) {
            System.out.println("Menor: " +num3);

        }
    }
}