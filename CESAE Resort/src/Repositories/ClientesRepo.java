package Repositories;

import Models.Cliente;
import Models.User;
import Tools.CSVFileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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

