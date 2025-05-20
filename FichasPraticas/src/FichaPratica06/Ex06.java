package FichaPratica06;

import java.util.Scanner;

import static FichaPratica06.Ex02.lerInteiroPositivo;
import static FichaPratica06.Ex05.*;

public class Ex06 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int opcao;

        // Tamanho
        System.out.println("_____ Tamanho do Vetor _____");
        int tamanho = lerInteiroPositivo();

        // Preencher o vetor
        int[] vetorUtilizador = lerVetorInteiros(tamanho);


        do {
            System.out.println("\n\n***** Programa de Análise de um Vetor *****");
            System.out.println("1. Maior Elemento");
            System.out.println("2. Menor Elemento");
            System.out.println("3. Crescente");
            System.out.println("0. Sair");

            System.out.print("Opção: ");
            opcao = input.nextInt();

            System.out.println();

            switch (opcao){
                case 1: // Maior Elemento
                    System.out.println("Maior Elemento: "+ maiorElemento(vetorUtilizador));
                    break;

                case 2: // Menor Elemento
                    System.out.println("Menor Elemento: "+ menorElemento(vetorUtilizador));
                    break;

                case 3: // Crescente

                    if(vetorCrescente(vetorUtilizador)){
                        System.out.println("Crescente");
                    }else{
                        System.out.println("Não crescente");
                    }
                    break;

                case 0:
                    System.out.println("Encerrar o programa...");
                    break;

                default:
                    System.out.println("Opção Inválida!");
                    break;
            }

        } while (opcao != 0);

    }
}