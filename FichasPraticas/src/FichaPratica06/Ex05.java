package FichaPratica06;

import java.util.Scanner;

public class Ex05 {


    public static int[] lerVetorInteiros(int tamanho) {
        int[] vetorPreencher = new int[tamanho];

        // Import do Scanner
        Scanner input = new Scanner(System.in);

        // Ler vetor
        for (int i = 0; i < vetorPreencher.length; i++) {
            System.out.print("Insira no vetor[" + i + "]: ");
            vetorPreencher[i] = input.nextInt();
        }

        return vetorPreencher;
    }

    public static void imprimirVetorInteiros(int[] vetor){

        // Imprimir vetor
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("vetor[" + i + "]: " + vetor[i]);
        }

    }

    public static int maiorElemento(int[] vetor){
        int maiorElemento = vetor[0];

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] > maiorElemento) {
                maiorElemento = vetor[i];
            }
        }

        return maiorElemento;
    }

    public static int menorElemento(int[] vetor){
        int menorElemento = vetor[0];

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] < menorElemento) {
                menorElemento = vetor[i];
            }
        }

        return menorElemento;
    }

    public static boolean vetorCrescente(int[] vetor){

        for (int i = 1; i < vetor.length; i++) {

            if (vetor[i] <= vetor[i - 1]) {
                return false;
            }
        }

        return true;
    }
}