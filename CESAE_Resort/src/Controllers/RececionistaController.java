package Controllers;

import Models.Quarto;
import Models.ReservaQuarto;
import Models.Tipologia;
import Repositories.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;


/**
 * Controlador responsável pelas operações realizadas pela rececionista.
 * Inclui funcionalidades como consulta de quartos disponíveis na semana atual.
 */
public class RececionistaController {

    private ClientesRepo clientesRepo;
    private ExperienciasRepo experienciasRepo;
    private QuartosRepo quartosRepo;
    private ReservasQuartosRepo reservasQuartosRepo;
    private TipologiasRepo tipologiasRepo;

    public RececionistaController() throws FileNotFoundException {
        this.clientesRepo = new ClientesRepo();
        this.experienciasRepo = new ExperienciasRepo();
        this.quartosRepo = new QuartosRepo();
        this.reservasQuartosRepo = new ReservasQuartosRepo();
        this.tipologiasRepo = new TipologiasRepo();
    }

    /**
     * Consulta e imprime a lista de quartos disponíveis para a semana atual.
     * São considerados como disponíveis os quartos que não possuem reservas
     * para o ano, mês e semana especificados.
     * Os resultados são apresentados em formato de tabela com número do quarto,
     * descrição da tipologia e preço por semana.
     */
    public void consultarQuartosDisponiveisNaSemanaAtual() {
        int ano = 2025;
        int mes = 1; // Apesar de no enunciado estar o mês (7), optei pelo mês (1) porque em janeiro havia reservas e em Julho não havia. Somente para mostrar que a lista era menor com menos quartos disponíveis.
        int semana = 1;

        ArrayList<Quarto> quartos = quartosRepo.getQuartoArrayList();
        ArrayList<ReservaQuarto> reservas = reservasQuartosRepo.getReservaQuartoArrayList();
        ArrayList<Tipologia> tipologias = tipologiasRepo.getTipologiaArrayList();

        // "%-10s | %-18s | %-15s%n" para manter a tabela formatada
        System.out.printf("%-10s | %-18s | %-15s%n", "Num_Quarto", "Tipologia", "Preço por Semana");
        System.out.println("-----------------------------------------------");

        boolean encontrou = false;

        for (int i = 0; i < quartos.size(); i++) {
            Quarto quarto = quartos.get(i);
            boolean ocupado = false;

            // Verificar se o quarto está ocupado
            for (int j = 0; j < reservas.size(); j++) {
                ReservaQuarto reserva = reservas.get(j);
                if (reserva.getNumQuarto() == quarto.getNumQuarto() &&
                        reserva.getAnoReserva() == ano &&
                        reserva.getMesReserva() == mes &&
                        reserva.getSemanaReserva() == semana) {
                    ocupado = true;
                    break;
                }
            }

            // Se não está ocupado, mostrar
            if (!ocupado) {
                // Buscar tipologia
                Tipologia tipologia = null;
                for (int k = 0; k < tipologias.size(); k++) {
                    if (tipologias.get(k).getIdTipologia() == quarto.getTipologia()) {
                        tipologia = tipologias.get(k);
                        break;
                    }
                }

                // Mostrar quarto
                if (tipologia != null) {
                    System.out.printf("%-10d | %-18s | €%-14.2f%n", quarto.getNumQuarto(),tipologia.getDescricaoQuarto(), tipologia.getPrecoSemana());
                } else {
                    System.out.printf("%-10d | %-18s | %-15s%n", quarto.getNumQuarto(), "Desconhecida", "N/A");
                }
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("❌ Nenhum quarto disponível.");
        }
    }
}