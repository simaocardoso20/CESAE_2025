package FichaPratica07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex06 {

    public static void imprimirFicheiro(String caminho) throws FileNotFoundException {

        int maiorIdade= -1;
        String nomeMaisVelho = "";

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] partes = linha.split(",");

            String nome = partes[0].trim();
            int idade = Integer.parseInt(partes[1].trim());

            if (idade > maiorIdade) {
                maiorIdade = idade;
                nomeMaisVelho = nome;
                }

            }

            sc.close();
            System.out.println("A pessoa mais velha é: " + nomeMaisVelho + " com " + maiorIdade);

        }

    public static void main(String[] args) throws FileNotFoundException {

        imprimirFicheiro("Ficheiros/exercicio_06.txt");
    }
}
