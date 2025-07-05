package Views;

import Controllers.LoginController;
import Controllers.ClienteController;
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
            System.out.println("\n\n********** Bem-vindo/a ao CESAE RESORT **********\n");
            System.out.println("1. Cliente");
            System.out.println("2. Login");
            System.out.println("0. Sair");
            System.out.print("\nOpção: ");
            opcaoLogin = input.nextInt();

            switch (opcaoLogin) {
                case 1:
                    ClienteView cv = new ClienteView();
                    cv.clienteMenu();
                    break;

                case 2:
                    loginMenu("ADMIN");
                    break;

                case 3:
                    loginMenu("GESTAO");
                    break;

                case 4:
                    loginMenu("GUIA");
                    break;

                case 0:
                    System.out.println("\nObrigado por utilizar o nosso programa... Até à próxima!");
                    break;
                default:
                    System.out.println("\nOpção Inválida");
            }
        } while (opcaoLogin != 0);
    }

    public void loginMenu(String tipoAcesso) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        System.out.print("\nUsername: ");
        String usernameInput = input.next();

        System.out.print("Password: ");
        String passwordInput = input.next();

        String accessType = this.loginController.validateLogin(usernameInput, passwordInput);

        if (accessType.equals(tipoAcesso)) {
            if (accessType.equals("ADMIN")) {
                AdminView av = new AdminView();
                av.adminMenu();
            } else if (accessType.equals("GESTAO")) {
                RececionistaView rv = new RececionistaView();
                rv.rececionistaMenu();
            } else if (accessType.equals("GUIA")) {
                GuiaView gv = new GuiaView();
                gv.guiaMenu();
            }
        } else {
            System.out.println("Acesso inválido ou sem permissões para este menu!");
        }
    }
}