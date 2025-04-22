package FichaPratica01;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        int valor1, valor2;

        // Ler números
        System.out.print("Introduzir o valor 1: ");
        valor1 = input.nextInt();

        System.out.print("Introduzir o valor 2: ");
        valor2 = input.nextInt();

        // Exibir valores originais
        System.out.println("Valor 1: " + valor1);
        System.out.println("Valor 2: " + valor2);

        // Trocar valores
        valor1 = valor1 + valor2;
        valor2 = valor1 - valor2;
        valor1 = valor1 - valor2;

        // Exibir valores após a troca
        System.out.println("Valor 1: " + valor1);
        System.out.println("Valor 2: " + valor2);


    }
}
