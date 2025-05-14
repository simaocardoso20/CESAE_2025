package FichaPratica05;

import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args) {

        // Import do Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        int[][] matriz = new int[3][3];

        // Ler matriz
        for (int i = 0; i < matriz.length; i++) {  // i=linha
                for (int j = 0; j < matriz[0].length; j++) { //  j=coluna matriz[0] para diferenciar as matrizes
                    System.out.print("Insira na matriz [" + i + "][" + j + "]: ");
                    matriz[i][j] = input.nextInt();
                }
            }

            // imprimir matriz
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    System.out.print(matriz[i][j]+"\t");
                }
                System.out.println();

            }
        }
    }



