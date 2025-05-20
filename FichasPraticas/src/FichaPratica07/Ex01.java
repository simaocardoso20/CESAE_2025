
package FichaPratica07;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Ex01 {

    /**
     * Função que imprime o conteúdo de um ficheiro na consola
     * @param caminhoFicheiro Caminho do ficheiro a ser lido
     * @throws FileNotFoundException Se o ficheiro não for encontrado
     */

    public static void imprimirFicheiro(String caminhoFicheiro) throws FileNotFoundException {
        
        file ficheiro = new File(caminhoFicheiro);
        scanner sc = new Scanner(ficheiro);

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            System.out.println(linha);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
    imprimirFicheiro("Ficheiros/exercicio_01_Alternativa01.txt");
    imprimirFicheiro("Ficheiros/exercicio_01_Alternativa02.txt");
    }
}

      
