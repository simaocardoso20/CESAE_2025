package FichaPratica02;

import java.util.Scanner;

public class Ex11 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        int saldomedio, saldoatual, movimento;

        // Ler números
        System.out.print("Introduza saldo médio: ");
        saldomedio = input.nextInt();

        System.out.print("Introduza o valor a movimentar: ");
        movimento = input.nextInt();

        // Operações
        saldoatual = saldomedio + movimento;

        // Ler operação
        if (saldoatual > 0) {
            System.out.println("Saldo atual= " + saldoatual);

    } else {
        System.out.println("Operação Inválida. Saldo Insuficiente.");
            System.out.println("saldo Atual: " + saldomedio);

        }
    }
}




