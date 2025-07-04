package GrandesNegocios.Controllers;

import GrandesNegocios.Models.Sale;
import GrandesNegocios.Repositories.SalesRepository;
import GrandesNegocios.Repositories.UsersRepository;
import GrandesNegocios.Tools.CSVFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ClientController {

    private ArrayList<Sale> sales;

    public ClientController() {
        try {
            SalesRepository repo = new SalesRepository();
            this.sales = repo.getSalesArray();
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Ficheiro de vendas não encontrado.");
            this.sales = new ArrayList<>();
        }
    }

    // Ponto 1: Mostrar todos os produtos disponíveis
    public void produtosDisponiveis() {
        if (sales.isEmpty()) {
            System.out.println("Não existem produtos disponíveis.");
        } else {
            for (Sale s : sales) {
                System.out.println(s.getNomeProduto() + " | Preço: " + s.getPrecoUnitario() + "€");
            }
        }
    }

    public void produtosCategoria() {

        // Lista para guardar as categorias únicas
        ArrayList<String> categorias = new ArrayList<>();

        for (Sale s : sales) {
            String tipoCat = s.getTipoProduto();

            // Verificar se a categoria já está na lista
            boolean existe = false;
            for (String c : categorias) {
                if (c.equalsIgnoreCase(tipoCat)) {
                    existe = true;
                    break;
                }
            }

            // Se não existe, adiciona
            if (!existe) {
                categorias.add(tipoCat);
            }
        }

        for (String categoria : categorias) {
            System.out.println("\n   ******** " + categoria + " ********\n");
            for (Sale s : sales) {
                if (s.getTipoProduto().trim().equalsIgnoreCase(categoria)) {
                    System.out.println(" - " + s.getNomeProduto() + " | Preço: " + s.getPrecoUnitario() + "€");
                }
            }
        }

    }

    public void produtoBaratoCaro() {
        if (sales.isEmpty()) {
            System.out.println("Não existem produtos disponíveis.");
            return;
        }

        Sale maisBarato = sales.get(0);
        Sale maisCaro = sales.get(0);

        for (Sale s : sales) {
            if (s.getPrecoUnitario() < maisBarato.getPrecoUnitario()) {
                maisBarato = s;
            }
            if (s.getPrecoUnitario() > maisCaro.getPrecoUnitario()) {
                maisCaro = s;
            }
        }

        System.out.println("Produto mais barato:");
        System.out.println(maisBarato.getNomeProduto() + " | Preço: " + maisBarato.getPrecoUnitario() + "€");

        System.out.println("\nProduto mais caro:");
        System.out.println(maisCaro.getNomeProduto() + " | Preço: " + maisCaro.getPrecoUnitario() + "€");
    }
}









