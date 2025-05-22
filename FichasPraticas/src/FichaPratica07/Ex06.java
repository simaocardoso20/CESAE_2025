package FichaPratica07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex06 {

    public static void pessoaMaisVelha(String caminho) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        int maiorIdade= 0;
        String nomeMaisVelho = "";

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] linhaSeparada = linha.split(",");

            String nome = linhaSeparada[0];
            int idade = Integer.parseInt(linhaSeparada[1]);

            if (idade > maiorIdade) {
                maiorIdade = idade;
                nomeMaisVelho = nome;
                }

            }

            sc.close();
            System.out.println("A pessoa mais velha é: " + nomeMaisVelho + " com " + maiorIdade);

        }

    public static void main(String[] args) throws FileNotFoundException {

        pessoaMaisVelha("Ficheiros/exercicio_06.txt");
    }
}
