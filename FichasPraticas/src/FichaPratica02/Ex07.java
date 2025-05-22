package FichaPratica02;

import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        int num1, par, impar;

        // Ler números
        System.out.print("Insira um número: ");
        num1 = input.nextInt();

        // Apresentar se é par ou ímpar
        if (num1 % 2 == 0) {
            System.out.println("O número é par");
        } else {
            System.out.println("O número é ímpar");
        }
    }
}
