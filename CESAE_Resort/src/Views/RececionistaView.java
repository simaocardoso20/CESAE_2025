package Views;

import Controllers.RececionistaController;
import Cores.ConsoleColors;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Classe responsável pela interface de interação do rececionista.
 * Permite aceder a funcionalidades como consulta de quartos, reservas e experiências.
 */
public class RececionistaView {

    private RececionistaController rececionistaController;

    /**
     * Construtor da classe RececionistaView.
     * Inicializa o controlador do rececionista.
     *
     * @throws FileNotFoundException se o controlador não conseguir aceder aos ficheiros necessários.
     */
    public RececionistaView() throws FileNotFoundException {
        this.rececionistaController = new RececionistaController();
    }

    /**
     * Exibe o menu principal do rececionista, permitindo a navegação pelas diferentes opções disponíveis.
     */
    public void rececionistaMenu() {

        Scanner input = new Scanner(System.in);
        int opcaoRececionista;

        do {

            System.out.println(ConsoleColors.YELLOW_BOLD + "\n\uD83D\uDECE\uFE0F\uD83D\uDECE\uFE0F\uD83D\uDECE\uFE0F MENU RECECIONISTA \uD83D\uDECE\uFE0F\uD83D\uDECE\uFE0F\uD83D\uDECE\uFE0F\n"+ ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN + "1. Consultar Quartos Disponíveis" + ConsoleColors.RESET);
            System.out.println("   -----------------------------");
            System.out.println("2. Consultar Quartos Reservados");
            System.out.println("   -----------------------------");
            System.out.println("3. Consultar Reservas Atuais");
            System.out.println("   -----------------------------");
            System.out.println("4. Efetuar uma Reserva");
            System.out.println("   -----------------------------");
            System.out.println("5. Reservar uma Experiência");
            System.out.println("   -----------------------------");
            System.out.println("0. Voltar\n");

            System.out.print("Opção: ");
            opcaoRececionista = input.nextInt();

            switch (opcaoRececionista) {
                case 1:
                    System.out.println(ConsoleColors.YELLOW_BOLD + "\uD83D\uDECC\uD83D\uDECC\uD83D\uDECC Consultar Quartos Disponíveis \uD83D\uDECC\uD83D\uDECC\uD83D\uDECC\n" + ConsoleColors.RESET);
                    rececionistaController.consultarQuartosDisponiveisNaSemanaAtual();
                    break;

                case 2:
                    System.out.println("\n\uD83D\uDECC\uD83D\uDECC\uD83D\uDECC Consultar Quartos Reservados \uD83D\uDECC\uD83D\uDECC\uD83D\uDECC");

                    break;

                case 3:
                    System.out.println("\n\uD83D\uDCD2\uD83D\uDCD2\uD83D\uDCD2 Consultar Reservas Atuais \uD83D\uDCD2\uD83D\uDCD2\uD83D\uDCD2");

                    break;

                case 4:
                    System.out.println("\n\uD83D\uDC4D\uD83D\uDC4D\uD83D\uDC4D Efetuar uma Reserva \uD83D\uDC4D\uD83D\uDC4D\uD83D\uDC4D");

                    break;

                case 5:
                    System.out.println("\n\uD83C\uDFC4\u200D♂\uFE0F\uD83C\uDFC4\u200D♂\uFE0F\uD83C\uDFC4\u200D♂\uFE0F Reservar uma Experiência \uD83C\uDFC4\u200D♂\uFE0F\uD83C\uDFC4\u200D♂\uFE0F\uD83C\uDFC4\u200D♂\uFE0F");

                    break;

                case 0:

                    break;

                default:
                    System.out.println("\nOpção Inválida!");
            }

        } while (opcaoRececionista != 0);
    }
}
