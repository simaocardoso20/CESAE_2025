package Controllers;

import Cores.ConsoleColors;
import Models.Experiencia;
import Models.VendaExperiencia;
import Repositories.ClientesRepo;
import Repositories.ExperienciasRepo;
import Repositories.RatingsExperienciasRepo;
import Repositories.VendasExperienciasRepo;

import java.io.FileNotFoundException;
import java.util.ArrayList;


/**
 * Controlador responsável por operações relacionadas a guias turísticos.
 * Permite consultar o histórico de experiências guiadas por um guia específico,
 * incluindo a contagem de participantes e o total arrecadado.
 *
 * Utiliza os repositórios de clientes, experiências, avaliações e vendas
 * para recolher os dados necessários.
 */
public class GuiaController {

    private ClientesRepo clientesRepo;
    private ExperienciasRepo experienciasRepo;
    private RatingsExperienciasRepo ratingsExperienciasRepo;
    private VendasExperienciasRepo vendasExperienciasRepo;

    public GuiaController() throws FileNotFoundException {
        this.clientesRepo = new ClientesRepo();
        this.experienciasRepo = new ExperienciasRepo();
        this.ratingsExperienciasRepo = new RatingsExperienciasRepo();
        this.vendasExperienciasRepo = new VendasExperienciasRepo();
    }

    /**
     * Imprime o histórico de experiências realizadas por um guia específico.
     * Para cada experiência vinculada ao guia, conta o total de adultos e crianças inscritos,
     * calcula o valor total arrecadado com essa experiência e exibe esses dados formatados na consola.
     * Caso não encontre nenhuma experiência associada ao guia, informa que não há experiências.
     *
     * @param idGuia Identificador do guia cujas as experiências serão listadas.
     */
    public void imprimirHistoricoExperiencias(String idGuia) {
        ArrayList<Experiencia> experiencias = experienciasRepo.getExperienciaArray();
        ArrayList<VendaExperiencia> vendas = vendasExperienciasRepo.getVendaExperienciaArrayList();

        boolean encontrou = false;

        for (Experiencia exp : experiencias) {
            if (exp.getIdGuia().equals(idGuia)) {
                encontrou = true;

                int totalAdultos = 0;
                int totalCriancas = 0;
                double totalArrecadado = 0.0;

                for (VendaExperiencia venda : vendas) {
                    if (venda.getIdExperiencia().equals(exp.getIdExperiencia())) {
                        if (venda.getTipoCliente().equalsIgnoreCase("adulto")) {
                            totalAdultos++;
                            totalArrecadado += exp.getPrecoAdulto();
                        } else if (venda.getTipoCliente().equalsIgnoreCase("crianca") ||
                                venda.getTipoCliente().equalsIgnoreCase("criança")) {
                            totalCriancas++;
                            totalArrecadado += exp.getPrecoCrianca();
                        }
                    }
                }

                    System.out.println(ConsoleColors.YELLOW_BOLD + "    Experiência: " + exp.getNomeExperiencia() + ConsoleColors.RESET);
                    System.out.println("      ----------------------");
                    System.out.println("      Adultos inscritos: " + totalAdultos);
                    System.out.println("      ----------------------");
                    System.out.println("      Crianças inscritas: " + totalCriancas);
                    System.out.println("      ----------------------");
                    System.out.println(ConsoleColors.GREEN_BOLD + "  Valor total arrecadado: " + totalArrecadado + "€" + ConsoleColors.RESET);
                    System.out.println();
                }
            }

            if (!encontrou) {
                System.out.println("⚠️ Nenhuma experiência encontrada para este guia.");
            }
        }
    }
