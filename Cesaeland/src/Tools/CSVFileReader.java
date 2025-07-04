package Tools;

import Models.Atracao;
import Models.Custo;
import Models.User;
import Models.Venda;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVFileReader {

    public ArrayList<Atracao> atracaosFileReader(String filePath) throws FileNotFoundException {

        // Abrimos o ficheiro e criamos um Scanner associado
        File salesFile = new File(filePath);
        Scanner salesScanner = new Scanner(salesFile);

        // Criamos o ArrayList de Vendas, vazio
        ArrayList<Atracao> atracaoArray = new ArrayList<>();

        // Avançar o cabeçalho
        salesScanner.nextLine();

        // Ciclo que vai correr para cada linha do ficheiro
        while (salesScanner.hasNextLine()) {

            // Apanhamos a linha
            String linha = salesScanner.nextLine();

            // Separamos a linha, com base no seu separador ","
            String[] linhaSeparada = linha.split(";");

            // Reunir todas as informações da Venda
            int idAtracao =  Integer.parseInt(linhaSeparada[0]);
            String atracao = linhaSeparada[1];
            double precoAdulto = Double.parseDouble(linhaSeparada[2]);
            double precoCrianca = Double.parseDouble(linhaSeparada[3]);
            int duracaoSeg =  Integer.parseInt(linhaSeparada[4]);

            // Criar nova Venda
            Atracao newAtracao = new Atracao(idAtracao,atracao,precoAdulto,precoCrianca, duracaoSeg);

            // Adicionamos ao Array
            atracaoArray.add(newAtracao);

        }

        // Terminando o ciclo (não há mais linhas)
        return atracaoArray;
    }

    public ArrayList<Custo> custosFileReader(String filePath) throws FileNotFoundException {

        // Abrimos o ficheiro e criamos um Scanner associado
        File custosFile = new File(filePath);
        Scanner custosScanner = new Scanner(custosFile);

        // Criamos o ArrayList de Vendas, vazio
        ArrayList<Custo> custosArray = new ArrayList<>();

        // Avançar o cabeçalho
        custosScanner.nextLine();

        // Ciclo que vai correr para cada linha do ficheiro
        while (custosScanner.hasNextLine()) {

            // Apanhamos a linha
            String linha = custosScanner.nextLine();

            // Separamos a linha, com base no seu separador ","
            String[] linhaSeparada = linha.split(";");

            // Reunir todas as informações da Venda
            int idAtracao =  Integer.parseInt(linhaSeparada[0]);
            double custoManutencao = Double.parseDouble(linhaSeparada[1]);
            double custoFixo = Double.parseDouble(linhaSeparada[2]);

            // Criar nova Venda
            Custo newCusto = new Custo(idAtracao, custoManutencao, custoFixo);

            // Adicionamos ao Array
            custosArray.add(newCusto);

        }

        // Terminando o ciclo (não há mais linhas)
        return custosArray;
    }


    public ArrayList<User> usersFileReader(String filePath) throws FileNotFoundException {

        // Abrimos o ficheiro e criamos um Scanner associado
        File usersFile = new File(filePath);
        Scanner usersScanner = new Scanner(usersFile);

        // Criamos o ArrayList de Utilizadores, vazio
        ArrayList<User> usersArray = new ArrayList<>();


        // Ciclo que vai correr para cada linha do ficheiro
        while (usersScanner.hasNextLine()) {

            // Apanhamos a linha
            String linha = usersScanner.nextLine();

            // Separamos a linha, com base no seu separador ";"
            String[] linhaSeparada = linha.split(",");

            // Reunir todas as informações da Venda
            String tipoConta = linhaSeparada[0];
            String username= linhaSeparada[1];
            String password= linhaSeparada[2];

            // Criar novo Utilizador
            User newUser = new User(tipoConta,username,password);

            // Adicionamos ao Array
            usersArray.add(newUser);

        }

        // Terminando o ciclo (não há mais linhas)
        return usersArray;
    }


    public ArrayList<Venda> vendasFileReader(String filePath) throws FileNotFoundException {

        // Abrimos o ficheiro e criamos um Scanner associado
        File vendasFile = new File(filePath);
        Scanner vendasScanner = new Scanner(vendasFile);

        // Criamos o ArrayList de Vendas, vazio
        ArrayList<Venda> vendasArray = new ArrayList<>();

        // Avançar o cabeçalho
        vendasScanner.nextLine();

        // Ciclo que vai correr para cada linha do ficheiro
        while (vendasScanner.hasNextLine()) {

            // Apanhamos a linha
            String linha = vendasScanner.nextLine();

            // Separamos a linha, com base no seu separador ","
            String[] linhaSeparada = linha.split(";");

            // Reunir todas as informações da Venda
            int idAtracao =  Integer.parseInt(linhaSeparada[0]);

            String data = linhaSeparada[1];
            String[] dataSeparada = data.split("/");
            int mes = Integer.parseInt(dataSeparada[0]);
            int ano = Integer.parseInt(dataSeparada[1]);

            String tipoCliente = linhaSeparada[2];

            // Criar nova Venda
            Venda newVenda = new Venda(idAtracao, mes, ano, tipoCliente);

            // Adicionamos ao Array
            vendasArray.add(newVenda);

        }

        // Terminando o ciclo (não há mais linhas)
        return vendasArray;
    }
}