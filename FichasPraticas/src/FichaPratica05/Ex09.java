package FichaPratica05;

import java.util.Scanner;

public class Ex09 {
    public static void main(String[] args) {

        // Import do Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        int[][] matriz = new int[5][5];
        int soma = 0;


        // Ler vetor
        System.out.println("Digite 9 números inteiros para preencher a matriz: ");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = input.nextInt();
            }
        }

        // soma valor dentro da  matriz
        System.out.println("Soma valor matriz: " +soma);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                soma += matriz[i][j];


            }

        }

        System.out.println("Soma: "+soma);
    }
}



