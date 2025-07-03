package FichaPratica01;

import java.util.Scanner;

public class Ex01 {

    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // declarar variáveis
        int numero1,numero2,soma;

        // Ler número1
        System.out.print("Introduz um número: ");
        numero1 = input.nextInt();

        // Ler número2
        System.out.print("Introduz um número: ");
        numero2 = input.nextInt();

        // Calcular a soma
        soma = numero1 + numero2;

        // Apresentar resultado
        System.out.println("Soma: " + soma);



    }

}
