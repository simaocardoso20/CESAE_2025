package FichaPratica02;

import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        double nota1, nota2, nota3, mediaponderada;

        // Ler números
        System.out.print("Insira a nota 1: ");
        nota1 = input.nextDouble();

        System.out.print("Insira a nota 2: ");
        nota2 = input.nextDouble();

        System.out.print("Insira a nota 3: ");
        nota3 = input.nextDouble();

        // Calcular média ponderada
        mediaponderada = (nota1 * 0.25) + (nota2 * 0.35)+ (nota3 * 0.4);

        System.out.println("Média: " +mediaponderada);

        // Imprimir o número
        if (mediaponderada > 9.5) {
            System.out.println("Aprovado ");
        } else {
            System.out.println("Não Aprovado ");
        }
    }
}
