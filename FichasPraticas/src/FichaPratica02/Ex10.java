package FichaPratica02;

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        int num1, num2, resultado;
        String operacao;

        // Ler números
        System.out.print("Insira o número 1: ");
        num1 = input.nextInt();

        System.out.print("Insira o número 2: ");
        num2 = input.nextInt();


        // Ler operação
        System.out.print("Operação pretendida (+ - * /): ");
        operacao = input.next();

        switch (operacao) {
            case "+":
                resultado = num1 + num2;
                System.out.println("Soma: " + resultado);
                break;

            case "-":
                resultado = num1 - num2;
                System.out.println("Subtração: " + resultado);
                break;

            case "*":
                resultado = num1 * num2;
                System.out.println("Multiplicação: " + resultado);
                break;

            case "/":
                resultado = num1 / num2;
                System.out.println("Divisão: " + resultado);
                break;

            default:
                System.out.println("Operação não reconhecida");
                break;


        }

    }
}
