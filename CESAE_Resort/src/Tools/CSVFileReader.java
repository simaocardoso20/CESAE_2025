package Tools;

import Models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVFileReader {

    public ArrayList<User> usersFileReader(String filePath) throws FileNotFoundException {

        // Abrimos o ficheiro e criamos um Scanner associado
        File usersFile = new File(filePath);
        Scanner usersScanner = new Scanner(usersFile);

        // Criamos o ArrayList de Utilizadores, vazio
        ArrayList<User> usersArray = new ArrayList<>();

        // Ignoramos a primeira linha (cabeçalho)
        if (usersScanner.hasNextLine()) {
            usersScanner.nextLine();
        }

        // Ciclo que vai correr para cada linha do ficheiro
        while (usersScanner.hasNextLine()) {

            // Apanhamos a linha
            String linha = usersScanner.nextLine();

            // Separamos a linha, com base no seu separador ";"
            String[] linhaSeparada = linha.split(",");

            // Reunir todas as informações da Venda
            String username = linhaSeparada[0];
            String password = linhaSeparada[1];
            String tipoAcesso = linhaSeparada[2];

            // Criar novo Utilizador
            User newUser = new User(username,password,tipoAcesso);

            // Adicionamos ao Array
            usersArray.add(newUser);

        }

        // Terminando o ciclo (não há mais linhas)
        return usersArray;
    }


    public ArrayList<Cliente> clientesFileReader(String filePath) throws FileNotFoundException {

        // Abrimos o ficheiro e criamos um Scanner associado
        File clientesFile = new File(filePath);
        Scanner clientesScanner = new Scanner(clientesFile);

        // Criamos o ArrayList de Vendas, vazio
        ArrayList<Cliente> clienteArray = new ArrayList<>();

        // Ignoramos a primeira linha (cabeçalho)
        if (clientesScanner.hasNextLine()) {
            clientesScanner.nextLine();
        }

        // Ciclo que vai correr para cada linha do ficheiro
        while (clientesScanner.hasNextLine()) {

            // Apanhamos a linha
            String linha = clientesScanner.nextLine();

            // Separamos a linha, com base no seu separador ","
            String[] linhaSeparada = linha.split(",");

            // Reunir todas as informações da Venda
            String idCliente =  linhaSeparada[0];
            String nomeCliente = linhaSeparada[1];
            String nacionalidade = linhaSeparada[2];
            String email = linhaSeparada[3];
            int telemovel =  Integer.parseInt(linhaSeparada[4]);
            String[] dataNascimento = linhaSeparada[5].split("-");
            int anoNascimento = Integer.parseInt(dataNascimento[0]);
            int mesNascimento = Integer.parseInt(dataNascimento[1]);
            int diaNascimento = Integer.parseInt(dataNascimento[2]);
            boolean consentimentoMarketing = Boolean.parseBoolean(linhaSeparada[6]);



            // Criar nova Venda
            Cliente newCliente = new Cliente(idCliente,nomeCliente,nacionalidade,email,telemovel,anoNascimento,mesNascimento,diaNascimento,consentimentoMarketing);

            // Adicionamos ao Array
            clienteArray.add(newCliente);

        }

        // Terminando o ciclo (não há mais linhas)
        return clienteArray;
    }


    public ArrayList<Experiencia> experienciasFileReader(String filePath) throws FileNotFoundException {

        // Abrimos o ficheiro e criamos um Scanner associado
        File experienciasFile = new File(filePath);
        Scanner experienciasScanner = new Scanner(experienciasFile);

        // Criamos o ArrayList de Vendas, vazio
        ArrayList<Experiencia> experienciaArray = new ArrayList<>();

        // Ignoramos a primeira linha (cabeçalho)
        if (experienciasScanner.hasNextLine()) {
            experienciasScanner.nextLine();
        }

        // Ciclo que vai correr para cada linha do ficheiro
        while (experienciasScanner.hasNextLine()) {

            // Apanhamos a linha
            String linha = experienciasScanner.nextLine();

            // Separamos a linha, com base no seu separador ","
            String[] linhaSeparada = linha.split(",");

            // Reunir todas as informações da Venda
            String idExperiencia =  linhaSeparada[0];
            String nomeExperiencia = linhaSeparada[1];
            String idGuia = linhaSeparada[2];
            double precoAdulto = Double.parseDouble(linhaSeparada[3]);
            double precoCrianca =  Double.parseDouble(linhaSeparada[4]);


            // Criar nova Venda
            Experiencia newExperiencia = new Experiencia(idExperiencia,nomeExperiencia,idGuia,precoAdulto,precoCrianca);

            // Adicionamos ao Array
            experienciaArray.add(newExperiencia);

        }

        // Terminando o ciclo (não há mais linhas)
        return experienciaArray;
    }


    public ArrayList<GuiaExperiencia> guiasExperienciasFileReader(String filePath) throws FileNotFoundException {

        // Abrimos o ficheiro e criamos um Scanner associado
        File guiasexperienciasFile = new File(filePath);
        Scanner guiasexperienciasScanner = new Scanner(guiasexperienciasFile);

        // Criamos o ArrayList de Vendas, vazio
        ArrayList<GuiaExperiencia> guiaExperienciaArray = new ArrayList<>();

        // Ignoramos a primeira linha (cabeçalho)
        if (guiasexperienciasScanner.hasNextLine()) {
            guiasexperienciasScanner.nextLine();
        }

        // Ciclo que vai correr para cada linha do ficheiro
        while (guiasexperienciasScanner.hasNextLine()) {

            // Apanhamos a linha
            String linha = guiasexperienciasScanner.nextLine();

            // Separamos a linha, com base no seu separador ","
            String[] linhaSeparada = linha.split(",");

            // Reunir todas as informações da Venda
            String idGuia =  linhaSeparada[0];
            String nomeGuia = linhaSeparada[1];
            String nacionalidade = linhaSeparada[2];
            String email = linhaSeparada[3];
            int telemovel =  Integer.parseInt(linhaSeparada[4]);

            // Criar nova Venda
            GuiaExperiencia newGuiaExperiencia = new GuiaExperiencia(idGuia,nomeGuia,nacionalidade,email,telemovel);

            // Adicionamos ao Array
            guiaExperienciaArray.add(newGuiaExperiencia);

        }

        // Terminando o ciclo (não há mais linhas)
        return guiaExperienciaArray;
    }


    public ArrayList<Quarto> quartosFileReader(String filePath) throws FileNotFoundException {

        // Abrimos o ficheiro e criamos um Scanner associado
        File quartosFile = new File(filePath);
        Scanner quartosScanner = new Scanner(quartosFile);

        // Criamos o ArrayList de Utilizadores, vazio
        ArrayList<Quarto> quartosArray = new ArrayList<>();

        // Ignoramos a primeira linha (cabeçalho)
        if (quartosScanner.hasNextLine()) {
            quartosScanner.nextLine();
        }

        // Ciclo que vai correr para cada linha do ficheiro
        while (quartosScanner.hasNextLine()) {

            // Apanhamos a linha
            String linha = quartosScanner.nextLine();

            // Separamos a linha, com base no seu separador ";"
            String[] linhaSeparada = linha.split(",");

            // Reunir todas as informações da Venda
            int numQuarto = Integer.parseInt(linhaSeparada[0]);
            int idTipologia = Integer.parseInt(linhaSeparada[1]);

            // Criar novo Utilizador
            Quarto newQuarto = new Quarto(numQuarto,idTipologia);

            // Adicionamos ao Array
            quartosArray.add(newQuarto);

        }

        // Terminando o ciclo (não há mais linhas)
        return quartosArray;
    }

    public ArrayList<RatingExperiencia> ratingsExperienciasFileReader(String filePath) throws FileNotFoundException {

        // Abrimos o ficheiro e criamos um Scanner associado
        File ratingsExperienciasFile = new File(filePath);
        Scanner ratingsExperienciasScanner = new Scanner(ratingsExperienciasFile);

        // Criamos o ArrayList de Utilizadores, vazio
        ArrayList<RatingExperiencia> ratingsExperienciasArray = new ArrayList<>();

        // Ignoramos a primeira linha (cabeçalho)
        if (ratingsExperienciasScanner.hasNextLine()) {
            ratingsExperienciasScanner.nextLine();
        }

        // Ciclo que vai correr para cada linha do ficheiro
        while (ratingsExperienciasScanner.hasNextLine()) {

            // Apanhamos a linha
            String linha = ratingsExperienciasScanner.nextLine();

            // Separamos a linha, com base no seu separador ";"
            String[] linhaSeparada = linha.split(",");

            // Reunir todas as informações da Venda
            String idRating = linhaSeparada[0];
            String idExperiencia = linhaSeparada[1];
            int ratingExperiencia = Integer.parseInt(linhaSeparada[2]);
            int ratingGuia = Integer.parseInt(linhaSeparada[3]);


            // Criar novo Utilizador
            RatingExperiencia newRatingExperiencia = new RatingExperiencia(idRating,idExperiencia,ratingExperiencia,ratingGuia);

            // Adicionamos ao Array
            ratingsExperienciasArray.add(newRatingExperiencia);

        }

        // Terminando o ciclo (não há mais linhas)
        return ratingsExperienciasArray;
    }


    public ArrayList<ReservaQuarto> reservasQuartosFileReader(String filePath) throws FileNotFoundException {

        // Abrimos o ficheiro e criamos um Scanner associado
        File reservasQuartosFile = new File(filePath);
        Scanner reservasQuartosScanner = new Scanner(reservasQuartosFile);

        // Criamos o ArrayList de Utilizadores, vazio
        ArrayList<ReservaQuarto> reservasQuartosArray = new ArrayList<>();

        // Ignoramos a primeira linha (cabeçalho)
        if (reservasQuartosScanner.hasNextLine()) {
            reservasQuartosScanner.nextLine();
        }

        // Ciclo que vai correr para cada linha do ficheiro
        while (reservasQuartosScanner.hasNextLine()) {

            // Apanhamos a linha
            String linha = reservasQuartosScanner.nextLine();

            // Separamos a linha, com base no seu separador ";"
            String[] linhaSeparada = linha.split(",");

            // Reunir todas as informações da Venda
            String idReserva = linhaSeparada[0];
            int numQuarto = Integer.parseInt(linhaSeparada[1]);
            String idCliente = linhaSeparada[2];
            int anoReserva = Integer.parseInt(linhaSeparada[3]);
            int mesReserva = Integer.parseInt(linhaSeparada[4]);
            int semanaReserva = Integer.parseInt(linhaSeparada[5]);

            // Criar novo Utilizador
            ReservaQuarto newReservaQuarto = new ReservaQuarto(idReserva,numQuarto,idCliente,anoReserva,mesReserva,semanaReserva);

            // Adicionamos ao Array
            reservasQuartosArray.add(newReservaQuarto);

        }

        // Terminando o ciclo (não há mais linhas)
        return reservasQuartosArray;
    }

    public ArrayList<Tipologia> tipologiasFileReader(String filePath) throws FileNotFoundException {

        // Abrimos o ficheiro e criamos um Scanner associado
        File tipologiasFile = new File(filePath);
        Scanner tipologiasScanner = new Scanner(tipologiasFile);

        // Criamos o ArrayList de Utilizadores, vazio
        ArrayList<Tipologia> tipologiasArray = new ArrayList<>();

        // Ignoramos a primeira linha (cabeçalho)
        if (tipologiasScanner.hasNextLine()) {
            tipologiasScanner.nextLine();
        }

        // Ciclo que vai correr para cada linha do ficheiro
        while (tipologiasScanner.hasNextLine()) {

            // Apanhamos a linha
            String linha = tipologiasScanner.nextLine();

            // Separamos a linha, com base no seu separador ";"
            String[] linhaSeparada = linha.split(",");

            // Reunir todas as informações da Venda
            int idTipologia = Integer.parseInt(linhaSeparada[0]);
            String descricaoQuarto = linhaSeparada[1];
            double precoSemana = Double.parseDouble(linhaSeparada[2]);

            // Criar novo Utilizador
            Tipologia newTipologia = new Tipologia(idTipologia,descricaoQuarto,precoSemana);

            // Adicionamos ao Array
            tipologiasArray.add(newTipologia);

        }

        // Terminando o ciclo (não há mais linhas)
        return tipologiasArray;
    }


    public ArrayList<VendaExperiencia> VendasExperienciasFileReader(String filePath) throws FileNotFoundException {

        // Abrimos o ficheiro e criamos um Scanner associado
        File VendasExperienciasFile = new File(filePath);
        Scanner VendasExperienciasScanner = new Scanner(VendasExperienciasFile);

        // Criamos o ArrayList de Utilizadores, vazio
        ArrayList<VendaExperiencia> VendasExperienciasArray = new ArrayList<>();


        // Ignoramos a primeira linha (cabeçalho)
        if (VendasExperienciasScanner.hasNextLine()) {
            VendasExperienciasScanner.nextLine();
        }

        // Ciclo que vai correr para cada linha do ficheiro
        while (VendasExperienciasScanner.hasNextLine()) {

            // Apanhamos a linha
            String linha = VendasExperienciasScanner.nextLine();

            // Separamos a linha, com base no seu separador ";"
            String[] linhaSeparada = linha.split(",");

            // Reunir todas as informações da Venda
            String idVendaExperiencia = linhaSeparada[0];
            String idExperiencia = linhaSeparada[1];
            String tipoCliente = linhaSeparada[2];
            int anoVendaExperiencia = Integer.parseInt(linhaSeparada[3]);
            int mesVendaExperiencia = Integer.parseInt(linhaSeparada[4]);

            // Criar novo Utilizador
            VendaExperiencia newVendaExperiencia = new VendaExperiencia(idVendaExperiencia, idExperiencia,tipoCliente,anoVendaExperiencia,mesVendaExperiencia);

            // Adicionamos ao Array
            VendasExperienciasArray.add(newVendaExperiencia);

        }

        // Terminando o ciclo (não há mais linhas)
        return VendasExperienciasArray;
    }


}
