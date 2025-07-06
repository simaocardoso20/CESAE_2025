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

            System.out.println("\n\n\uD83D\uDC68\u200D\uD83D\uDCBC\uD83D\uDC68\u200D\uD83D\uDCBC\uD83D\uDC68\u200D\uD83D\uDCBC MENU ADMIN \uD83D\uDC68\u200D\uD83D\uDCBC\uD83D\uDC68\u200D\uD83D\uDCBC\uD83D\uDC68\u200D\uD83D\uDCBC");
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

            System.out.print("Opção: ");
            opcaoAdmin= input.nextInt();

            switch (opcaoAdmin){
                case 1:
                    System.out.println("\n\uD83D\uDECE\uFE0F\uD83D\uDECE\uFE0F\uD83D\uDECE\uFE0F Consultar Total de Reservas \uD83D\uDECE\uFE0F\uD83D\uDECE\uFE0F\uD83D\uDECE\uFE0F");
                    break;

                case 2:
                    System.out.println("\n\uD83D\uDCB2\uD83D\uDCB2\uD83D\uDCB2 Consultar Total de Receitas \uD83D\uDCB2\uD83D\uDCB2\uD83D\uDCB2");
                    break;


                case 3:
                    System.out.println("\n\uD83D\uDCB2\uD83D\uDCB2\uD83D\uDCB2 Consultar Reservas/Receitas Mensais \uD83D\uDCB2\uD83D\uDCB2\uD83D\uDCB2");
                    break;


                case 4:
                    System.out.println("\n\uD83D\uDECC\uD83D\uDECC\uD83D\uDECC Consultar Tipologia de Quarto Mais Reservada \uD83D\uDECC\uD83D\uDECC\uD83D\uDECC");
                    break;

                case 5:
                    System.out.println("\n\uD83E\uDD3F\uD83E\uDD3F\uD83E\uDD3F Consultar Experiência Mais Procurada (Adultos) \uD83E\uDD3F\uD83E\uDD3F\uD83E\uDD3F");

                    break;

                case 6:
                    System.out.println("\n\uD83D\uDEF6\uD83D\uDEF6\uD83D\uDEF6 Consultar Experiência Mais Procurada (Crianças) \uD83D\uDEF6\uD83D\uDEF6\uD83D\uDEF6");

                    break;

                case 7:
                    System.out.println("\n\uD83D\uDCB2\uD83D\uDCB2\uD83D\uDCB2 Consultar Experiência Mais Lucrativa \uD83D\uDCB2\uD83D\uDCB2\uD83D\uDCB2");

                    break;

                case 8:
                    System.out.println("\n\uD83D\uDCB2\uD83D\uDCB2\uD83D\uDCB2 Consultar Experiência Menos Lucrativa \uD83D\uDCB2\uD83D\uDCB2\uD83D\uDCB2\uD83D\uDCB2");

                    break;

                case 9:
                    System.out.println("\n\uD83E\uDDF3\uD83E\uDDF3\uD83E\uDDF3 Consultar Quarto com Melhor Preço/Semana *****");

                    break;

                case 10:
                    System.out.println("\n\uD83C\uDD95\uD83C\uDD95\uD83C\uDD95 Adicionar Novo Login \uD83E\uDDF3\uD83E\uDDF3\uD83E\uDDF3");

                    break;

                case 0:
                    break;

                default:
                    System.out.println("\nOpção Inválida!");
            }

        }while (opcaoAdmin!=0);
    }
}
