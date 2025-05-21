package FichaPratica07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex07 {

    public static int contarLinhas(String caminho) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        int contagemLinhas = 0;

        while (sc.hasNextLine()) {
            sc.nextLine();
            contagemLinhas++;
        }

        return contagemLinhas;

    }

    public static int contarPalavras(String caminho) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        int contagemPalavras = 0;

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] linhaSeparada = linha.split(" ");

            contagemPalavras += linhaSeparada.length;
        }

        return contagemPalavras;

    }

}