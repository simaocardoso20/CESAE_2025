package Views;

import Controllers.AdminController;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdminView {

    private AdminController adminController;

    public AdminView() throws FileNotFoundException {
        this.adminController= new AdminController();
    }

    public void adminMenu(){
        Scanner input = new Scanner(System.in);
        int opcaoAdmin;

        do {

            System.out.println("\n\n********** MENU ADMIN **********\n");
            System.out.println("1. Consultar o total de todas as vendas.");
            System.out.println("2. Consultar o total de lucro");
            System.out.println("3. Consultar o total de vendas e lucro por mês");
            System.out.println("4. Consultar a atração mais procurada por adultos");
            System.out.println("5. Consultar a atração mais procurada por crianças");
            System.out.println("6. Consultar a atração mais procurada");
            System.out.println("7. Consultar a atração mais lucrativa");
            System.out.println("8. Consultar a atração menos lucrativa");
            System.out.println("9. Adicionar novo login");
            System.out.println("0. Voltar");

            System.out.print("\nOpção: ");
            opcaoAdmin= input.nextInt();

            switch (opcaoAdmin){
                case 1: // Consultar o total de todas as vendas
                    int totalVendas = adminController.consultarTotalVendas();
                    System.out.println("Total de todas as vendas: " + totalVendas);
                    break;

                case 2: //Analisar qual o produto que gerou mais valor de vendas.
                    System.out.println("\n***** Produto que gerou mais valor de vendas *****");

                    break;


                case 3: //Consultar qual a venda que vendeu mais unidades.
                    System.out.println("\n***** Venda que vendeu mais unidades *****");

                    break;


                case 4: //Consultar qual a venda que vendeu mais valor
                    System.out.println("\n***** Venda que vendeu mais valor *****");

                    break;

                case 5: // Total Vendas

                    break;

                case 6: // Media todas vendas

                    break;

                case 7: // Media todas vendas

                    break;

                case 8: // Media todas vendas

                    break;

                case 9: // Media todas vendas

                    break;


                case 0:
                    break;

                default:
                    System.out.println("\nOpção Inválida!");
            }

        }while (opcaoAdmin!=0);
    }
}