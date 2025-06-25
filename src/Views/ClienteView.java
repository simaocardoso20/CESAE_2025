package Views;

import java.util.Scanner;

public class ClienteView {
    public void clientMenu() {
        Scanner input = new Scanner(System.in);
        int opcaoCliente;

        do {
            System.out.println("\n\n *********** MENU CLIENTE *********** ");
            System.out.println("1. Consultar Atrações Disponíveis");
            System.out.println("2. Consultar Atrações Favoritas");
            System.out.println("0.  Voltar");

            System.out.print("Opção: ");
            opcaoCliente = input.nextInt();

            switch (opcaoCliente) {
                case 1:
                    break;
                case 2:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nOpção Inválida!");
            }

        } while (opcaoCliente != 0);

    }
}