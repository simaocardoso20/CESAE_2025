package Views;

import Controllers.GuiaController;
import Controllers.LoginController;
import Cores.ConsoleColors;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Classe responsável por exibir o menu de opções disponíveis ao guia.
 * Permite ao guia consultar o seu histórico de experiências realizadas.
 */
public class GuiaView {

    private GuiaController guiaController;
    private String idGuia;

    /**
     * Construtor da classe GuiaView.
     * Inicializa o controlador de guia com o ID do guia autenticado.
     *
     * @param idGuia Identificador do guia atualmente autenticado.
     * @throws FileNotFoundException se os ficheiros de dados necessários não forem encontrados.
     */
    public GuiaView(String idGuia) throws FileNotFoundException {
        this.guiaController = new GuiaController();
        this.idGuia = idGuia;
    }

    /**
     * Exibe o menu do guia e processa a opção selecionada pelo utilizador.
     * Neste menu, o guia pode consultar o histórico das experiências realizadas.
     *
     * @throws FileNotFoundException se houver erro na leitura dos dados do histórico.
     */
    public void guiaMenu() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        int opcaoGuia;

        do {

            System.out.println(ConsoleColors.YELLOW_BOLD + "\n\uD83E\uDD20\uD83E\uDD20\uD83E\uDD20 MENU GUIA \uD83E\uDD20\uD83E\uDD20\uD83E\uDD20\n" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE + "1. Consultar Histórico de Experiências" + ConsoleColors.RESET);
            System.out.println("0. Voltar\n");

            System.out.print("Opção: ");
            opcaoGuia= input.nextInt();

            switch (opcaoGuia){
                case 1:
                    System.out.println(ConsoleColors.CYAN + "\n🧭 Consultar Histórico de Experiências \n" + ConsoleColors.RESET);
                    guiaController.imprimirHistoricoExperiencias(LoginController.utilizadorLogado);
                    break;

                case 0: // Voltar

                    break;

                default:
                    System.out.println("\nOpção Inválida!");
            }

        }while (opcaoGuia!=0);
    }
}
