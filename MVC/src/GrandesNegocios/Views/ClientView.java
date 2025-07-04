package GrandesNegocios.Views;

import GrandesNegocios.Controllers.ClientController;

import java.util.Scanner;

public class ClientView {

    private ClientController clientController;

    public ClientView() {
        this.clientController = new ClientController();
    }

    public void clientMenu(){

        Scanner input = new Scanner(System.in);
        int opcaoCliente;

        do {

            System.out.println("\n\n********** MENU CLIENTE **********");
            System.out.println("1. Consultar Produtos Disponíveis");
            System.out.println("2. Consultar Produtos p/ Categoria");
            System.out.println("3. Consultar Produto Mais Barato / Mais Caro");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            opcaoCliente= input.nextInt();

            switch (opcaoCliente){
                case 1: // Consultar Produtos Disponíveis
                    System.out.println("\n******** Produtos Disponíveis ********\n");
                    this.clientController.produtosDisponiveis();

                    break;

                case 2 : // Consultar Produtos p/ Categoria
                    System.out.println("\n******** Produtos por Categoria ********\n");
                    this.clientController.produtosCategoria();

                    break;

                case 3: // Consultar Produto Mais Barato / Mais Caro
                    System.out.println("\n******** Produto Mais Barato e Mais Caro ********\n");
                    this.clientController.produtoBaratoCaro();

                    break;

                case 0: // Voltar
                    break;

                default:
                    System.out.println("\nOpção Inválida!");
            }

        }while (opcaoCliente!=0);
    }
}
