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
                    loginMenu("ADMIN");
                    break;
                case 2:
                    loginMenu("ENG");
                    break;
                case 3:
                    ClienteView cv = new ClienteView();
                    cv.clientMenu();
                    break;
                case 0:
                    System.out.println("\nObrigado por utilizar o nosso programa... Até à próxima!");
                    break;
                default:
                    System.out.println("\nOpção Inválida");
            }
        } while (opcaoLogin != 0);
    }

    // Agora o loginMenu pede o tipo de conta a validar
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
            } else if (accessType.equals("ENG")) {
                EngManutencaoView ev = new EngManutencaoView();
                ev.EngManutencaoMenu();
            }
        } else {
            System.out.println("Acesso inválido ou sem permissões para este menu!");
        }
    }
}