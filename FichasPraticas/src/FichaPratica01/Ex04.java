package FichaPratica01;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        double raio, circunferencia, area;

        // Ler o raio
        System.out.print("Introduzir o valor do raio: " );
        raio = input.nextDouble();

        // Definir o valor de PI
        final double PI = 3.1415926;

        // Ler o valor de PI
        System.out.println("O valor de PI é: " + PI);

        // Calcular e apresentar a área da circunferência
        area = PI * raio * raio;
        System.out.println("Área: " + area);

    }
}
