package FichaPratica06;

import java.util.Scanner;

public class Ex01 {

    public static void fazerBarulho(String animal){

        switch (animal){

            case "cão":
                System.out.println("Au au au");
                break;

            case "gato":
                System.out.println("Miau");
                break;

            case "peixe":
                System.out.println("Glub Glub");
                break;

            case "vaca":
                System.out.println("Muuuuu");
                break;

            case "porco":
                System.out.println("Oinc oinc");
                break;

            default:
                System.out.println("Barulho desconhecido...");
                break;
        }
        }
        public static void main(String[] args) {

            // Import do Scanner
            Scanner input = new Scanner(System.in);

            // Declarar variáveis
            String animalUtilizador;

            System.out.print("Insira uma animal: ");
            animalUtilizador=input.next();

            fazerBarulho("peixe");
            fazerBarulho(animalUtilizador);



    }
}
