package FichaPratica01;

import java.util.Scanner;

public class Ex05 {

    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        double mediaAritmetica, mediaPonderada, num1, num2, num3;

        // Ler os valores
        System.out.print("Insira o valor 1: ");
        num1 = input.nextDouble();

        System.out.print("Insira o valor 1: ");
        num2 = input.nextDouble();

        System.out.print("Insira o valor 1: ");
        num3 = input.nextDouble();

        // Calcular e apresentar a média aritmética
        mediaAritmetica = (num1 + num2 + num3) / 3;
        System.out.println("Média Aritmética: " + mediaAritmetica);

        // Calcular e apresentar a média ponderada (20%, 30%, 50%)
        mediaPonderada = (num1 * 0.2) + (num2 * 0.3) + (num3 * 0.5);
        System.out.println("Média Ponderada: " + mediaPonderada);

    }
}
