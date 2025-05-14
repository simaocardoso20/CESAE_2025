package FichaPratica05;

import java.util.Scanner;

public class Ex09 {
    public static void main(String[] args) {

        // Import do Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        int[][] matriz = new int[5][5];
        int soma = 0;


        // Ler matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print("Insira na matriz [" + i + "][" + j + "]: ");
                matriz[i][j] = input.nextInt();
            }
        }


        // soma valor dentro da  matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                soma += matriz[i][j];


            }

        }

        System.out.println("Soma: "+soma);
    }
}



