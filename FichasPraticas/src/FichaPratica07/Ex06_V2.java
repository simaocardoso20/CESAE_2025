package FichaPratica07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex06_V2 {

    public static void pessoaMaisVelha(String caminho) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        int idadeMaisVelha= 0;
        String nomeMaisVelho = "";


        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] linhaSeparada = linha.split(",");

            if(Integer.parseInt(linhaSeparada[1]) > idadeMaisVelha) {
            idadeMaisVelha = Integer.parseInt(linhaSeparada[1]);
            nomeMaisVelho = linhaSeparada[0];
            }
        }

        System.out.println("A pessoa mais velha é: " + nomeMaisVelho + " com " + idadeMaisVelha);

    }

    public static void main(String[] args) throws FileNotFoundException {

        pessoaMaisVelha("Ficheiros/exercicio_06.txt");
    }
}

