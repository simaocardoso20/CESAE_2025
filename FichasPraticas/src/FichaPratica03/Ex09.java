package FichaPratica03;

import java.util.Scanner;

public class Ex09 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        int numero = 0, soma = 1, contador = -1, media;

        // Ler números
        System.out.println("Introduza os números: ");

        // Ler valores
        while (numero != -1) {
            numero = input.nextInt();

            soma = soma + numero;
            contador++;
        }

        // Calcular e apresentar a media

        System.out.println("Soma: " + soma);
        System.out.println("Contador: " + contador);

        media = soma / contador;
        System.out.println("media= " + media);

    }
}

