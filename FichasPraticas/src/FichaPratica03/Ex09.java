package FichaPratica03;

import java.util.Scanner;

public class Ex09 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        int numero, contagem=0, soma=0;

        // Ler números
        System.out.println("Introduza os números (digite -1 para terminar) ");
        numero = input.nextInt();

        // Ler valores
        while (numero != -1) {
            soma = soma + numero; // acumula a soma
            contagem = contagem + 1;
            numero = input.nextInt();

            if (contagem > 0) {
                double media = (double) soma / contagem;
                System.out.println("Média dos números: " + media);

            }

        }
    }
}
