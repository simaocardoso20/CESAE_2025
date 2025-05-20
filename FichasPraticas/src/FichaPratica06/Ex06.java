package FichaPratica06;

import java.util.Scanner;

import static FichaPratica06.Ex02.lerInteiroPositivo;
import static FichaPratica06.Ex03.par;
import static FichaPratica06.Ex03.primo;
import static FichaPratica06.Ex05.*;

public class Ex06 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int opcao;

        //tamanho

        System.out.println("_______Tamanho do Vetor_______");
        int tamanho = lerInteiroPositivo();

        //Preencher vetor
        int[] vetorUtilizador = lerInteiroPositivo(tamanho);


        do {
            System.out.println("\n\n***** Programa de Análise de um Vetor: " + numero + " *****");
            System.out.println("1. Maior Elemento");
            System.out.println("2. Menor Elemento");
            System.out.println("3. Crescente ou Não Crescente");
            System.out.println("0. Sair");

            System.out.print("Opção: ");
            opcao = input.nextInt();

            System.out.println();

            switch (opcao) {
                case 1: // Maior Elemento
                        System.out.println("Maior Elemento: " +maiorElemento(vetorUtilizador));
                    
                    break;

                case 2: // Menor Elemento
                        System.out.println("Menor Elemento: " + menorElemento(vetorUtilizador));
                    
                    break;

                case 3: //  Crescente
                        System.out.println("Crescente: " + crescente(vetorUtilizador));
                    
                    break;

                case 0: // Sair
                    System.out.println("A encerrar programa...");
                    break;

                default:
                    System.out.println("Opção Inválida!");
                    break;


            }

        } while (opcao != 0);

    }
}