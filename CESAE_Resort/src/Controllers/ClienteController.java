package Controllers;

import Cores.ConsoleColors;
import Models.Quarto;
import Models.Tipologia;
import Repositories.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Controlador responsável por gerir ações do cliente, como consultar quartos disponíveis
 * e (futuramente) experiências disponíveis, favoritas e avaliações.
 */
public class ClienteController {

    private QuartosRepo quartosRepo;
    private TipologiasRepo tipologiasRepo;
    private ExperienciasRepo experienciasRepo;
    private GuiasExperienciasRepo guiasExperienciasRepo;
    private RatingsExperienciasRepo ratingsExperienciasRepo;

    public ClienteController() throws FileNotFoundException {
        this.quartosRepo = new QuartosRepo();
        this.tipologiasRepo = new TipologiasRepo();
        this.experienciasRepo = new ExperienciasRepo();
        this.guiasExperienciasRepo = new GuiasExperienciasRepo();
        this.ratingsExperienciasRepo = new RatingsExperienciasRepo();

}

    /**
     * Exibe uma lista formatada dos quartos disponíveis, mostrando o número do quarto,
     * a tipologia e o preço por semana.
     * Obtém os quartos e tipologias dos repositórios e para cada quarto procura a sua tipologia correspondente.
     * Imprime as informações de cada quarto encontrado.
     */
    public void consultarQuartosDisponiveis() {
        ArrayList<Quarto> quartos = quartosRepo.getQuartoArrayList();
        ArrayList<Tipologia> tipologias = tipologiasRepo.getTipologiaArrayList();

        System.out.printf(ConsoleColors.CYAN_BOLD + "%-12s | %-20s | %-16s%n", "Num_Quarto", "Tipologia", "Preço por Semana" + ConsoleColors.RESET);
        System.out.println("------------------------------------------------------");

        for (int i = 0; i < quartos.size(); i++) {
            Quarto quarto = quartos.get(i);
            Tipologia tipologiaEncontrada = procurarTipologia(tipologias, quarto.getTipologia());

            if (tipologiaEncontrada != null) {
                mostrarQuarto(quarto, tipologiaEncontrada);
            }
        }
    }

    /**
     * Procura uma tipologia na lista pelo seu ID.
     *
     * @param tipologias Lista de tipologias disponíveis.
     * @param idTipologia ID da tipologia a ser procurada.
     * @return A tipologia correspondente ao ID fornecido, ou null se não encontrada.
     */
    private Tipologia procurarTipologia(ArrayList<Tipologia> tipologias, int idTipologia) {
        for (Tipologia tipologia : tipologias) {
            if (tipologia.getIdTipologia() == idTipologia) {
                return tipologia;
            }
        }
        return null;
    }

    /**
     * Imprime os detalhes do quarto e sua tipologia em formato tabelar.
     *
     * @param quarto Quarto a ser exibido.
     * @param tipologia Tipologia associada ao quarto, contendo descrição e preço.
     */
    private void mostrarQuarto(Quarto quarto, Tipologia tipologia) {
        System.out.printf("%-12d | %-20s | %10.2f €%n",
                quarto.getNumQuarto(),
                tipologia.getDescricaoQuarto(),
                tipologia.getPrecoSemana());
    }
}