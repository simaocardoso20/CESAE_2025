package FichaPratica01;

import java.util.Scanner;

public class Ex03 {

    public static void main(String[] args) {


        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        int comprimento, largura, perimetro, area;

        // Ler dimensões
        System.out.print("Comprimento: ");
        comprimento = input.nextInt();

        System.out.print("Largura: ");
        largura = input.nextInt();

        // Calcular a área
        area = comprimento * largura;

        // Apresentar o resultado
        System.out.println("Insira o comprimento: " + area);

        System.out.println("Insira a largura: " + area);

        // Calcular o perímetro
        perimetro = comprimento + comprimento + largura + largura;

        // Apresentar o perímetro
        System.out.println("Perímetro: " + perimetro);

    }
}
