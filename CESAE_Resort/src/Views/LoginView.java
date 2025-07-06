package Views;

import Controllers.LoginController;
import Controllers.ClienteController;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginView {

    private LoginController loginController;

    public LoginView() throws FileNotFoundException {
        this.loginController = new LoginController();
    }

    public void mainMenu() throws FileNotFoundException {

        // Mostrar a imagem ASCII
        mostrarImagemAscii("Files/CESAE_Resort.txt");

        Scanner input = new Scanner(System.in);
        int opcaoLogin;

        do {
            System.out.println("\n⭐⭐⭐⭐⭐ CESAE RESORT ⭐⭐⭐⭐⭐\n");
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
                    loginMenu();
                    break;


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

        String accessType = this.loginController.validateLogin(usernameInput, passwordInput);

        switch (accessType) {
            case "ADMIN":
                AdminView av = new AdminView();
                av.adminMenu();
                break;
            case "GESTAO":
                RececionistaView rv = new RececionistaView();
                rv.rececionistaMenu();
                break;
            case "GUIA":
                GuiaView gv = new GuiaView();
                gv.guiaMenu();
                break;
            default:
                System.out.println("Acesso inválido ou sem permissões para este menu!");
        }
    }

    private void mostrarImagemAscii(String caminhoFicheiro) throws FileNotFoundException {
        File file = new File(caminhoFicheiro);
        Scanner leitor = new Scanner(file);
        while (leitor.hasNextLine()) {
            System.out.println(leitor.nextLine());
        }
        leitor.close();
    }
}

