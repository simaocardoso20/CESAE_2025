package FichaPratica05;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {

        // Import do Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        int[] vetor = new int[10];

        // Ler vetor
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Insira no vetor[" + i + "]: ");
            vetor[i] = input.nextInt();
        }

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] > vetor[i + 1]) {
                System.out.println("Os números não estão por ordem crescente.");


            }
        }
    }
}

