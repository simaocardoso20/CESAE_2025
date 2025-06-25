package Views;

import java.util.Scanner;

public class EngManutencaoView {
    public void EngManutencaoMenu(){
        Scanner input = new Scanner(System.in);
        int opcaoEngManutencao;

        do {
            System.out.println("\n\n *********** MENU ENGENHEIRO DE MANUTENCAO *********** ");
            System.out.println("1. Consultar Próximas Revisões");
            System.out.println("2. Consultar Histórico de Revisões");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            opcaoEngManutencao = input.nextInt();

            switch (opcaoEngManutencao) {
                case 1:
                    break;
                case 2:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nOpção Inválida!");
            }

        } while (opcaoEngManutencao != 0);

    }
}