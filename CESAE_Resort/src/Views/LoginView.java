package Views;

import Audio.Audio;
import Controllers.LoginController;
import Cores.ConsoleColors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Classe responsável por exibir o menu inicial do sistema,
 * permitindo ao utilizador aceder como cliente ou efetuar login como funcionário (admin, rececionista ou guia).
 * Reproduz música de fundo e exibe uma imagem ASCII ao iniciar.
 */
public class LoginView {

    private LoginController loginController;

    /**
     * Construtor da classe LoginView.
     * Inicializa o controlador de login.
     *
     * @throws FileNotFoundException se os ficheiros necessários não forem encontrados.
     */
    public LoginView() throws FileNotFoundException {
        this.loginController = new LoginController();
    }

    /**
     * Exibe o menu principal do programa.
     * As opções incluem o acesso como cliente, login de funcionário e saída do sistema.
     * Também reproduz música ambiente e exibe arte ASCII.
     *
     * @throws FileNotFoundException se houver erro ao carregar ficheiros externos.
     */
    public void mainMenu() throws FileNotFoundException {

        Audio.playMusic("src/Views/assets/Audio/yoga-meditation-relax-music-359352.wav");

        // Mostrar a imagem ASCII
        mostrarImagemAscii("Files/CESAE_Resort.txt");

        Scanner input = new Scanner(System.in);
        int opcaoLogin;

        do {
            System.out.println(ConsoleColors.YELLOW_BOLD + "\n⭐⭐⭐⭐⭐ CESAE RESORT ⭐⭐⭐⭐⭐\n" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN_BOLD + "1. CLIENTE" + ConsoleColors.RESET);
            System.out.println("   --------");
            System.out.println(ConsoleColors.YELLOW_BOLD + "2. LOGIN \uD83D\uDD12" + ConsoleColors.RESET);
            System.out.println("   --------");
            System.out.println(ConsoleColors.RED + "0. SAIR" + ConsoleColors.RESET);
            System.out.print("\nOPÇÃO: ");
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
                GuiaView gv = new GuiaView(usernameInput);  // Passa o id do guia aqui
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

