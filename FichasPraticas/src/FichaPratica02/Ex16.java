package FichaPratica02;

import java.util.Scanner;

public class Ex16 {

    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        int montante, notas;

        // Ler montante
        System.out.print("Valor a levantar: ");
        montante = input.nextInt(); // 525€ (exemplo do montante a querer levantar)

        if (montante % 5 == 0) { // É múltiplo de 5 pq a nota mais baixa é 5€

            // Notas 200
            notas = montante / 200;
            System.out.println("Notas de 200:" + notas);
            montante = montante % 200;

            // Notas 100
            notas = montante / 100;
            System.out.println("Notas de 100:" + notas);
            montante = montante % 100;

            // Notas 50
            notas = montante / 50;
            System.out.println("Notas de 50:" + notas);
            montante = montante % 50;

            // Notas 20
            notas = montante / 20;
            System.out.println("Notas de 20:" + notas);
            montante = montante % 20;

            // Notas 10
            notas = montante / 10;
            System.out.println("Notas de 10:" + notas);
            montante = montante % 10;

            // Notas 5
            notas = montante / 5;
            System.out.println("Notas de 5:" + notas);
            montante = montante % 5;

        } else {
            System.out.println("Não damos trocos");
        }
    }
}
