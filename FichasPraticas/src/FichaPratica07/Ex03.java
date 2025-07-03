package FichaPratica07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;



public class Ex03 {



    public static void copiarFicheiro(String caminhoOrigem, String caminhoDestino) throws FileNotFoundException {


        File ficheiroOrigem = new File(caminhoOrigem);
        Scanner sc = new Scanner(ficheiroOrigem);

        File ficheiroDestino = new File(caminhoDestino);
        PrintWriter pw = new PrintWriter(ficheiroDestino);

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            pw.println(linha);
        }

        pw.close();
        sc.close();

    }

        public static void main(String[] args) throws FileNotFoundException {

            copiarFicheiro("Ficheiros/exercicio_03.txt", "Ficheiros/exercicio_03_copia.txt" );


    }
}


