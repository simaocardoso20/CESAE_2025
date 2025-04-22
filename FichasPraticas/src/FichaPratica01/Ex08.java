package FichaPratica01;

import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        int min, seg, hora, total, totalSegundos, horas, minutosResultante, segundosResultante  ;

        // Ler minutos e segundos das músicas
        System.out.println("Introduza minutos da música 1: ");
        System.out.println("Introduza segundos da música 1: ");
        min = input.nextInt();
        seg = input.nextInt();

        System.out.println("Introduza minutos da música 2: ");
        System.out.println("Introduza segundos da música 2: ");
        min = input.nextInt();
        seg = input.nextInt();

        System.out.println("Introduza minutos da música 3: ");
        System.out.println("Introduza segundos da música 3: ");
        min = input.nextInt();
        seg = input.nextInt();

        System.out.println("Introduza minutos da música 4: ");
        System.out.println("Introduza segundos da música 4: ");
        min = input.nextInt();
        seg = input.nextInt();

        System.out.println("Introduza minutos da música 5: ");
        System.out.println("Introduza segundos da música 5: ");
        min = input.nextInt();
        seg = input.nextInt();

        // Converter minutos e segundos totais para segundos
        totalSegundos = min * 60 + seg;

        // Converter totalSegundos para horas, minutos e segundos
        horas = totalSegundos / 3600;
        minutosResultante = (totalSegundos % 3600) / 60;
        segundosResultante = totalSegundos % 60;

        // Exibir o resultado final
        System.out.println("Tempo total: " + horas + " horas, " + minutosResultante + " minutos e " + segundosResultante + " segundos.");
    }
}
