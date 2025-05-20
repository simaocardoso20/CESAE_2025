package FichaPratica07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex07 {

    public static void imprimirFicheiro(String caminho) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        int numLinhas = 0;
        int numPalavras = 0;

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            numLinhas += sc.nextInt();

            String[] palavras = linha.trim().split("\\s+");

        }
    }
}

    System.out.println("Número de linhas:" + numLinhas);
    System.out.println("Número de palavras:" + numPalavras);


    public static void main(String[] args) throws FileNotFoundException {

        imprimirFicheiro("Ficheiros/exercicio_07.txt");
}

}
