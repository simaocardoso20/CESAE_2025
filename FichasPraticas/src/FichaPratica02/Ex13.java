package FichaPratica02;

import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        int hora, minuto;

        // Ler horas
        System.out.println("Introduza horas: ");
        System.out.println("Introduza minutos: ");

        // Verificar se é AM ou PM
        if (hora == 0) {
            periodo = "AM";
        } else if (hora < 12) {
            periodo = "AM";
        } else if (hora == 12) {
            periodo = "PM";
        } else {
            hora -= 12;
            periodo = "PM";
        }

        // Imprimir no formato 12h
        System.out.println("Resultado: " + hora + " " + minuto + " " + periodo);
        }
    }

