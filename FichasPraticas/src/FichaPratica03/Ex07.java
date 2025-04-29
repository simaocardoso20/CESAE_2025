package FichaPratica03;

import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {

        // Declarar as variáveis
        int inicio=0, salto = 1;

        // Ler valores
        while (inicio <= 100) {
            System.out.println(inicio);
            inicio = inicio + salto;
            inicio++;
        }
    }
}
