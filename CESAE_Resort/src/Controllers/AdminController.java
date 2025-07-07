package Controllers;

import Cores.ConsoleColors;
import Models.*;
import Repositories.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Classe responsável pelas operações administrativas, como análise de receitas.
 *
 * Permite ao administrador consultar as receitas mensais provenientes de
 * reservas de quartos e vendas de experiências, com base nos dados obtidos
 * de vários repositórios.</p>
 */
public class AdminController {

    private ClientesRepo clientesRepo;
    private ExperienciasRepo experienciasRepo;
    private QuartosRepo quartosRepo;
    private ReservasQuartosRepo reservasQuartosRepo;
    private VendasExperienciasRepo vendasExperienciasRepo;
    private final TipologiasRepo tipologiasRepo;

    public AdminController() throws FileNotFoundException {
        this.clientesRepo = new ClientesRepo();
        this.experienciasRepo = new ExperienciasRepo();
        this.quartosRepo = new QuartosRepo();
        this.reservasQuartosRepo = new ReservasQuartosRepo();
        this.vendasExperienciasRepo = new VendasExperienciasRepo();
        this.tipologiasRepo = new TipologiasRepo();
    }

    /**
     * Metodo para consultar e imprimir a receita mensal total de quartos e experiências.
     *
     * Este metodo solicita ao utilizador o ano e o mês para o qual deseja obter as receitas,
     * depois calcula a receita dos quartos reservados e das experiências vendidas nesse período,
     * e finalmente imprime o total arrecadado separadamente e somado.
     *
     * O cálculo da receita dos quartos é feito somando o preço da tipologia associada
     * aos quartos reservados no ano e mês informados.
     *
     * O cálculo da receita das experiências é feito somando o preço pago por adultos e crianças
     * nas vendas de experiências efetuadas no mesmo período.
     *
     * Requisitos:
     * - Os repositórios de reservas, vendas, quartos, tipologias e experiências devem estar inicializados.
     *
     */
    public void consultarReceitasMensais() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o ano (ex: 2025): ");
        int ano = scanner.nextInt();

        System.out.print("Digite o mês (1-12): ");
        int mes = scanner.nextInt();

        // Buscar dados
        ArrayList<ReservaQuarto> reservas = reservasQuartosRepo.getReservaQuartoArrayList();
        ArrayList<VendaExperiencia> vendas = vendasExperienciasRepo.getVendaExperienciaArrayList();
        ArrayList<Quarto> quartos = quartosRepo.getQuartoArrayList();
        ArrayList<Tipologia> tipologias = tipologiasRepo.getTipologiaArrayList();
        ArrayList<Experiencia> experiencias = experienciasRepo.getExperienciaArray();

        double receitaQuartos = 0;
        double receitaExperiencias = 0;

        // Calcular receita dos quartos
        for (int i = 0; i < reservas.size(); i++) {
            ReservaQuarto reserva = reservas.get(i);

            if (reserva.getAnoReserva() == ano && reserva.getMesReserva() == mes) {
                // Buscar quarto
                for (int j = 0; j < quartos.size(); j++) {
                    Quarto quarto = quartos.get(j);

                    if (quarto.getNumQuarto() == reserva.getNumQuarto()) {
                        // Buscar tipologia
                        for (int k = 0; k < tipologias.size(); k++) {
                            Tipologia tipologia = tipologias.get(k);

                            if (tipologia.getIdTipologia() == quarto.getTipologia()) {
                                receitaQuartos += tipologia.getPrecoSemana();
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }

        // Calcular receita das experiências
        for (int i = 0; i < vendas.size(); i++) {
            VendaExperiencia venda = vendas.get(i);

            if (venda.getAnoVendaExperiencia() == ano && venda.getMesVendaExperiencia() == mes) {
                // Buscar experiência
                for (int j = 0; j < experiencias.size(); j++) {
                    Experiencia experiencia = experiencias.get(j);

                    if (experiencia.getIdExperiencia().equals(venda.getIdExperiencia())) {
                        if (venda.getTipoCliente().equalsIgnoreCase("adulto")) {
                            receitaExperiencias += experiencia.getPrecoAdulto();
                        } else if (venda.getTipoCliente().equalsIgnoreCase("crianca")) {
                            receitaExperiencias += experiencia.getPrecoCrianca();
                        }
                        break;
                    }
                }
            }
        }

        double receitaTotal = receitaQuartos + receitaExperiencias;

        System.out.printf(ConsoleColors.YELLOW_BOLD + "\n  Receita total em %02d/%d:%n\n" + ConsoleColors.RESET, mes, ano);
        System.out.printf(" - Quartos: %.2f€%n", receitaQuartos);
        System.out.println("  -------------------------");
        System.out.printf(" - Experiências: %.2f€%n", receitaExperiencias);
        System.out.println("  -------------------------");
        System.out.printf(ConsoleColors.GREEN_BOLD + " - Receita Total: %.2f€%n\n" + ConsoleColors.RESET, receitaTotal);
    }
}





