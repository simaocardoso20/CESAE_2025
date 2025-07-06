package Views;

import Controllers.ClienteController;
import Controllers.GuiaController;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class GuiaView {

    private GuiaController guiaController;

    public GuiaView() throws FileNotFoundException {
        this.guiaController = new GuiaController();
    }

    public void guiaMenu() {

        Scanner input = new Scanner(System.in);
        int opcaoGuia;

        do {

            System.out.println("\n\nℹ\uFE0Fℹ\uFE0Fℹ\uFE0F MENU GUIA ℹ\uFE0Fℹ\uFE0Fℹ\uFE0F");
            System.out.println("1. Consultar Histórico de Experiências");
            System.out.println("0. Voltar\n");

            System.out.print("Opção: ");
            opcaoGuia= input.nextInt();

            switch (opcaoGuia){
                case 1:
                    System.out.println("\n\uD83E\uDDED\uD83E\uDDED\uD83E\uDDED Consultar Histórico de Experiências \uD83E\uDDED\uD83E\uDDED\uD83E\uDDED");

                    break;

                case 0: // Voltar

                    break;

                default:
                    System.out.println("\nOpção Inválida!");
            }

        }while (opcaoGuia!=0);
    }
}
