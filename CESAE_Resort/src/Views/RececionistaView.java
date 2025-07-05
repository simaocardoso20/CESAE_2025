package Views;

import Controllers.AdminController;
import Controllers.GuiaController;
import Controllers.RececionistaController;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class RececionistaView {

    private RececionistaController rececionistaController;

    public RececionistaView() throws FileNotFoundException {
        this.rececionistaController = new RececionistaController();
    }
    public void rececionistaMenu() {

        Scanner input = new Scanner(System.in);
        int opcaoRececionista;

        do {

            System.out.println("\n\n********** MENU RECECIONISTA **********");
            System.out.println("1. Consultar Quartos Disponíveis");
            System.out.println("2. Consultar Quartos Reservados");
            System.out.println("3. Consultar Reservas Atuais");
            System.out.println("4. Efetuar uma Reserva");
            System.out.println("5. Reservar uma Experiência");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            opcaoRececionista = input.nextInt();

            switch (opcaoRececionista) {
                case 1:
                    System.out.println("\n******** Consultar Quartos Disponíveis ********\n");

                    break;

                case 2:
                    System.out.println("\n******** Consultar Quartos Reservados ********\n");

                    break;

                case 3:
                    System.out.println("\n******** Consultar Reservas Atuais ********\n");

                    break;

                case 4:
                    System.out.println("\n******** Efetuar uma Reserva ********\n");

                    break;

                case 5:
                    System.out.println("\n******** Reservar uma Experiência ********\n");

                    break;

                case 0:

                    break;

                default:
                    System.out.println("\nOpção Inválida!");
            }

        } while (opcaoRececionista != 0);
    }
}
