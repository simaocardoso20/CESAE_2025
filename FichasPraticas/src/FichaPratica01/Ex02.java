package FichaPratica01;

import java.util.Scanner;

public class Ex02 {

    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // declarar variáveis
        int numero1,numero2,soma, subtracao, multi, divisao;

        // Ler número1
        System.out.print("Introduz um número: ");
        numero1 = input.nextInt();

        // Ler número2
        System.out.print("Introduz um número: ");
        numero2 = input.nextInt();

        // Calcular a soma
        soma = numero1 + numero2;

        // Apresentar a soma
        System.out.println("Soma: " + soma);

        // Calcular a subtracao
        subtracao = numero1 - numero2;

        // Apresentar a subtracao
        System.out.println("Subtração: " + subtracao);

        // Calcular a multiplicacao
        multi = numero1 * numero2;

        // Apresentar a multiplicacao
        System.out.println("Multiplicação: " + multi);

        // Calcular a divisao
        divisao = numero1 / numero2;

        // Apresentar a divisao
        System.out.println("Divisão: " + divisao);


    }
}

