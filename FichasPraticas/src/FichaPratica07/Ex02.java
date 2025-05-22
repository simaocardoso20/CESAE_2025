package FichaPratica07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Ex02 {

    public static void escreverFicheiro(String caminho, String mensagem) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        PrintWriter pw = new PrintWriter(ficheiro);

        pw.println(mensagem);

        pw.close();

    }

    public static void main(String[] args) throws FileNotFoundException {

        escreverFicheiro("Ficheiros/exercicio_02.txt","Olá mundo :D");
    }
}