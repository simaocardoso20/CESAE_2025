package Views;

import Controllers.LoginController;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginView {

    private LoginController loginController;

    public LoginView() throws FileNotFoundException {
        this.loginController = new LoginController();
    }

    public void mainMenu() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        int opcaoLogin;

        do {
            System.out.println("\n\n********** Bem-vindo/a ao Programa do CesaeLand **********\n");
            System.out.println("1. Administrador");
            System.out.println("2. Engenheiro de Manutenções");
            System.out.println("3. Cliente");
            System.out.println("0. Terminar Programa");

            System.out.print("\nOpção: ");
            opcaoLogin = input.nextInt();

            switch (opcaoLogin) {
                case 1:
                    // Admisnistrador

                    break;

                case 2:
                    // Engenheiro de Manutenções
                    this.loginMenu();
                    break;

                case 3:// Cliente

                case 0:
                    System.out.println("\nObrigado por utilizar o nosso programa... Até à próxima!");
                    break;

                default:
                    System.out.println("\nOpção Inválida");
            }
        } while (opcaoLogin != 0);
    }


    public void loginMenu() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        System.out.print("\nUsername: ");
        String usernameInput = input.next();

        System.out.print("Password: ");
        String passwordInput = input.next();

        //String accessType = this.loginController.validateLogin(usernameInput,passwordInput);

//        switch (accessType){
//            case "ADMIN":
//                AdminView av = new AdminView();
//                av.adminMenu();
//                break;
//
//            case "FUNC":
//                StaffView sv = new StaffView();
//                sv.staffMenu();
//                break;
//
//            case "ERROR":
//                System.out.println("Acessos inválidos");
//                break;
//        }

    }
}