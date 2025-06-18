package Jogo;

import Entidades.Heroi;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainJogo {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        boolean jogarNovamente = true;
        Heroi heroi = null; // Declarar a variável heroi aqui
        Jogo.inicializarNPCs();


        while (jogarNovamente) {
            // Iniciar o jogo
            Jogo.iniciar();


            // Criar personagem
            heroi = Jogo.criarPersonagem();

            boolean continuar = true;
            while (continuar) {
                Jogo.introducaoHistoria();
                Jogo.mostrarRoteiroPersonalizado(heroi);
                Jogo.abrirLoja(heroi);
                Jogo.missaoSelva(heroi);
                Jogo.missaoTemplo(heroi);
                Jogo.missaoAldeia(heroi);
                Jogo.desafioChaveCristal(heroi);
                Jogo.missaopiramide(heroi);
                Jogo.missaoBossFinal(heroi);

                }
            }

        scanner.close();
    }
}
