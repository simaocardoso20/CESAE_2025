package Repositories;

import Models.Cliente;
import Tools.CSVFileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Classe responsável por armazenar e disponibilizar os dados dos clientes
 * lidos a partir de um ficheiro CSV.
 */
public class ClientesRepo {

    private ArrayList<Cliente> clienteArray;

    public ClientesRepo() throws FileNotFoundException {
        CSVFileReader csvFR = new CSVFileReader();
        this.clienteArray = csvFR.clientesFileReader("Files/clientes.csv");

    }

    public ArrayList<Cliente> getClienteArray() {
        return clienteArray;
    }
}

