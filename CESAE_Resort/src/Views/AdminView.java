package Views;

import Controllers.AdminController;
import Controllers.ClienteController;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdminView {

    private AdminController adminController;

    public AdminView() throws FileNotFoundException {
        this.adminController = new AdminController();
    }

    public void adminMenu() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int opcaoAdmin;

        do {

            System.out.println("\n\n********** MENU ADMIN **********");
            System.out.println("1. Consultar Total de Reservas");
            System.out.println("2. Consultar Total de Receitas");
            System.out.println("3. Consultar Reservas/Receitas Mensais");
            System.out.println("4. Consultar Tipologia de Quarto Mais Reservada");
            System.out.println("5. Consultar Experiência Mais Procurada (Adultos)");
            System.out.println("6. Consultar Experiência Mais Procurada (Crianças)");
            System.out.println("7. Consultar Experiência Mais Lucrativa");
            System.out.println("8. Consultar Experiência Menos Lucrativa");
            System.out.println("9. Consultar Quarto com Melhor Preço/Semana");
            System.out.println("10.Adicionar Novo Login");
            System.out.println("0. Voltar\n");

            System.out.print("\nOpção: ");
            opcaoAdmin= input.nextInt();

            switch (opcaoAdmin){
                case 1:
                    System.out.println("\n***** Consultar Total de Reservas *****");
                    break;

                case 2:
                    System.out.println("\n***** Consultar Total de Receitas *****");
                    break;


                case 3:
                    System.out.println("\n***** Consultar Reservas/Receitas Mensais *****");
                    break;


                case 4:
                    System.out.println("\n***** Consultar Tipologia de Quarto Mais Reservada *****");
                    break;

                case 5:
                    System.out.println("\n***** Consultar Experiência Mais Procurada (Adultos) *****");

                    break;

                case 6:
                    System.out.println("\n***** Consultar Experiência Mais Procurada (Crianças) *****");

                    break;

                case 7:
                    System.out.println("\n***** Consultar Experiência Mais Lucrativa *****");

                    break;

                case 8:
                    System.out.println("\n***** Consultar Experiência Menos Lucrativa *****");

                    break;

                case 9:
                    System.out.println("\n***** Consultar Quarto com Melhor Preço/Semana *****");

                    break;

                case 10:
                    System.out.println("\n***** Adicionar Novo Login *****");

                    break;

                case 0:
                    break;

                default:
                    System.out.println("\nOpção Inválida!");
            }

        }while (opcaoAdmin!=0);
    }
}
