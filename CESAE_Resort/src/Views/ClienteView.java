package Views;

import Controllers.ClienteController;
import Cores.ConsoleColors;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe responsável por exibir o menu de opções disponíveis ao cliente.
 * Permite ao cliente consultar quartos e experiências, bem como avaliar uma experiência.
 */
public class ClienteView {

    private ClienteController clienteController;

    public ClienteView() throws FileNotFoundException {
        this.clienteController = new ClienteController();
    }

    /**
     * Exibe o menu de cliente e processa as opções selecionadas pelo utilizador.
     * As opções incluem consultar quartos, experiências, experiências favoritas e avaliação.
     */
    public void clienteMenu() {

        Scanner input = new Scanner(System.in);
        int opcaoCliente;

        do {

            System.out.println(ConsoleColors.YELLOW_BOLD + "\n⭐⭐⭐⭐⭐ MENU CLIENTE ⭐⭐⭐⭐⭐\n" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN + "1. Consultar Quartos Disponíveis" + ConsoleColors.RESET);
            System.out.println("   ----------------------------------");
            System.out.println("2. Consultar Experiências Disponíveis");
            System.out.println("   ----------------------------------");
            System.out.println("3. Consultar Experiência Favorita");
            System.out.println("   ----------------------------------");
            System.out.println("4. Consultar Experiência Top-Seller");
            System.out.println("   ----------------------------------");
            System.out.println("5. Avaliar uma Experiência");
            System.out.println("   ----------------------------------");
            System.out.println("0. Voltar\n");

            System.out.print("Opção: ");
            opcaoCliente= input.nextInt();

            switch (opcaoCliente){
                case 1:
                    System.out.println(ConsoleColors.YELLOW_BOLD + "\n\uD83D\uDECC\uD83D\uDECC\uD83D\uDECC Consultar Quartos Disponíveis \uD83D\uDECC\uD83D\uDECC\uD83D\uDECC\n" + ConsoleColors.RESET);
                    clienteController.consultarQuartosDisponiveis();
                    break;

                case 2 :
                    System.out.println("\n\uD83E\uDD3F\uD83E\uDD3F\uD83E\uDD3F Consultar Experiências Disponíveis \uD83E\uDD3F\uD83E\uDD3F\uD83E\uDD3F");

                    break;

                case 3:
                    System.out.println("\n\uD83D\uDC47\uD83D\uDC47\uD83D\uDC47 Consultar Experiência Favorita \uD83D\uDC47\uD83D\uDC47\uD83D\uDC47");
                    break;

                case 4:
                    System.out.println("\n\uD83D\uDD1D\uD83D\uDD1D\uD83D\uDD1D Consultar Experiência Top-Seller \uD83D\uDD1D\uD83D\uDD1D\uD83D\uDD1D");

                    break;

                case 5:
                    System.out.println("\n\uD83D\uDCDD\uD83D\uDCDD\uD83D\uDCDD Avaliar uma Experiência \uD83D\uDCDD\uD83D\uDCDD\uD83D\uDCDD");

                    break;

                case 0: // Voltar
                    break;

                default:
                    System.out.println("\nOpção Inválida!");
            }

        }while (opcaoCliente!=0);
    }
}
