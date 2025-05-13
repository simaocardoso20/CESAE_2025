package FichaPratica05;

import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args) {

        // Import do Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        int[][] matriz = new int[3][3];

        // Ler vetor
            System.out.println("Digite 9 números inteiros para preencher a matriz: ");

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print("Elemento [" + i + "][" + j + "]: ");
                    matriz[i][j] = input.nextInt();
                }
            }

            // imprimir matriz
            System.out.println("Matriz 3x3:");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(matriz[i][j]+" ");
                }
                System.out.println();

            }
        }
    }



