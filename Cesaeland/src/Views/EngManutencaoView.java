package Views;

import Controllers.EngManuController;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class EngManutencaoView {

    private EngManuController engManuController;

    public EngManutencaoView() throws FileNotFoundException {
        this.engManuController = new EngManuController();
    }

    public void EngManutencaoMenu() {
        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n\n********** MENU ENGENHEIRO DE MANUTENÇÃO **********\n");
            System.out.println("1. Consultar Próximas Revisões");
            System.out.println("2. Consultar Histórico de Revisões");
            System.out.println("0. Voltar");
            System.out.print("\nOpção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    ArrayList<String> proximas = engManuController.consultarProximasRevisoes();
                    System.out.println("\n--- Próximas Revisões ---");
                    if (proximas.size() == 0) {
                        System.out.println("Não há revisões agendadas.");
                    } else {
                        for (String s : proximas) {
                            System.out.println(s);
                        }
                    }
                    break;
                case 2:
                    ArrayList<String> historico = engManuController.consultarHistoricoRevisoes();
                    System.out.println("\n--- Histórico de Revisões ---");
                    if (historico.size() == 0) {
                        System.out.println("Ainda não foram efetuadas revisões.");
                    } else {
                        for (String s : historico) {
                            System.out.println(s);
                        }
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opcao != 0);
    }
}