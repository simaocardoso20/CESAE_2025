package Views;

import Controllers.ClienteController;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClienteView {

    private ClienteController clienteController;

    public ClienteView() throws FileNotFoundException {
        this.clienteController = new ClienteController();
    }

    public void clienteMenu() {

        Scanner input = new Scanner(System.in);
        int opcaoCliente;

        do {

            System.out.println("\n\n********** MENU CLIENTE **********");
            System.out.println("1. Consultar Quartos Disponíveis");
            System.out.println("2. Consultar Experiências Disponíveis");
            System.out.println("3. Consultar Experiência Favorita");
            System.out.println("4. Consultar Experiência Top-Seller");
            System.out.println("5. Avaliar uma Experiência");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            opcaoCliente= input.nextInt();

            switch (opcaoCliente){
                case 1:
                    System.out.println("\n******** Consultar Quartos Disponíveis ********\n");

                    break;

                case 2 :
                    System.out.println("\n******** Consultar Experiências Disponíveis ********\n");

                    break;

                case 3:
                    System.out.println("\n******** Consultar Experiência Favorita ********\n");

                    break;

                case 4:
                    System.out.println("\n******** Consultar Experiência Top-Seller ********\n");

                    break;

                case 5:
                    System.out.println("\n******** Avaliar uma Experiência ********\n");

                    break;

                case 0: // Voltar
                    break;

                default:
                    System.out.println("\nOpção Inválida!");
            }

        }while (opcaoCliente!=0);
    }
}
