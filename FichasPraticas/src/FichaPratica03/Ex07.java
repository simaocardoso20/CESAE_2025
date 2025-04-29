package FichaPratica03;

import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {

        // Declarar as variáveis
        int inicio=1, salto = 1, soma=0;

        // Ler valores
        while (inicio <= 100) {
            System.out.println(inicio);
            soma = soma+inicio;
            inicio = inicio + salto;

        }
        System.out.println("Somatório: " + soma);
    }
}   // é uma variável de acumulação
