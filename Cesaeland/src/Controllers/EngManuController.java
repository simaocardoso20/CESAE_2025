package Controllers;

import Models.Atracao;
import Models.Venda;
import Repositories.AtracaosRepo;
import Repositories.VendasRepo;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class EngManuController {

    private AtracaosRepo atracaosRepo;
    private VendasRepo vendasRepo;

    public EngManuController() throws FileNotFoundException {
        this.atracaosRepo = new AtracaosRepo();
        this.vendasRepo = new VendasRepo();
    }

    // Consulta as 3 próximas revisões a serem efetuadas
    // Retorna uma lista de String para cada linha a apresentar (ID, Nome, Bilhetes que faltam)
    public ArrayList<String> consultarProximasRevisoes() {
        ArrayList<String> resultado = new ArrayList<>();

        // Para cada atração, conta quantos bilhetes foram vendidos desde a última revisão (ou sempre)
        for (int i = 0; i < atracaosRepo.getAtacaoArray().size(); i++) {
            Atracao atracao = atracaosRepo.getAtacaoArray().get(i);
            int idAtracao = atracao.getIdAtracao();

            int totalBilhetes = 0;
            for (int j = 0; j < vendasRepo.getVendasArray().size(); j++) {
                Venda venda = vendasRepo.getVendasArray().get(j);
                if (venda.getIdAtracao() == idAtracao) {
                    totalBilhetes++;
                }
            }

            // Calcular quantos bilhetes faltam para a próxima revisão (de 50 em 50)
            int bilhetesAteRevisao = 50 - (totalBilhetes % 50);
            if (bilhetesAteRevisao == 50) bilhetesAteRevisao = 0; // Se acabou de fazer revisão

            String linha = "ID: " + idAtracao
                    + " | Nome: " + atracao.getAtracao()
                    + " | Bilhetes para próxima revisão: " + bilhetesAteRevisao;
            resultado.add(linha);
        }

        // Ordenar para mostrar só as 3 mais próximas revisões (menor bilhetesAteRevisao)
        // Como não podes usar Map, ordena manualmente (BubbleSort ou SelectionSort)
        for (int i = 0; i < resultado.size() - 1; i++) {
            for (int j = i + 1; j < resultado.size(); j++) {
                int bi1 = extrairBilhetesFaltam(resultado.get(i));
                int bi2 = extrairBilhetesFaltam(resultado.get(j));
                if (bi1 > bi2) {
                    String tmp = resultado.get(i);
                    resultado.set(i, resultado.get(j));
                    resultado.set(j, tmp);
                }
            }
        }

        // Devolver só as 3 primeiras
        ArrayList<String> top3 = new ArrayList<>();
        for (int i = 0; i < 3 && i < resultado.size(); i++) {
            top3.add(resultado.get(i));
        }
        return top3;
    }

    // Função auxiliar para extrair o número de bilhetes que faltam a partir da String
    private int extrairBilhetesFaltam(String linha) {
        String[] partes = linha.split(": ");
        String ultimo = partes[partes.length - 1];
        return Integer.parseInt(ultimo.trim());
    }

    // Consulta as 3 últimas revisões efetuadas
    // (Ou seja, as 3 últimas vezes que se atingiu múltiplos de 50 bilhetes vendidos por atração)
    public ArrayList<String> consultarHistoricoRevisoes() {
        ArrayList<String> resultado = new ArrayList<>();

        for (int i = 0; i < atracaosRepo.getAtacaoArray().size(); i++) {
            Atracao atracao = atracaosRepo.getAtacaoArray().get(i);
            int idAtracao = atracao.getIdAtracao();

            int totalBilhetes = 0;
            for (int j = 0; j < vendasRepo.getVendasArray().size(); j++) {
                Venda venda = vendasRepo.getVendasArray().get(j);
                if (venda.getIdAtracao() == idAtracao) {
                    totalBilhetes++;
                }
            }

            // Quantas revisões já foram feitas?
            int numRevisoes = totalBilhetes / 50;

            // Para histórico, mostra as últimas 3 revisões (se existirem)
            for (int rev = numRevisoes; rev > numRevisoes - 3 && rev > 0; rev--) {
                String linha = "ID: " + idAtracao
                        + " | Nome: " + atracao.getAtracao()
                        + " | Revisão nº: " + rev
                        + " | Bilhetes após revisão: " + (totalBilhetes - (rev * 50));
                resultado.add(linha);
            }
        }

        // Se quiseres, mostra só as 3 mais recentes no geral:
        ArrayList<String> top3 = new ArrayList<>();
        for (int i = 0; i < 3 && i < resultado.size(); i++) {
            top3.add(resultado.get(i));
        }
        return top3;
    }
}