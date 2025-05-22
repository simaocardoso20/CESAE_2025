package FichaPratica01;

import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        double preco1, preco2, preco3, total, totalComDesconto;

        // Ler números/preços
        System.out.print("Introduza o preço 1: ");
        preco1 = input.nextDouble();

        System.out.print("Introduza o preço 2: ");
        preco2 = input.nextDouble();

        System.out.print("Introduza o preço 3: ");
        preco3 = input.nextDouble();

        // Calcular e apresentar o total
        total = preco1 + preco2 + preco3 ;
        System.out.println("Total:" + total);

        // Calcular e apresentar o total com desconto
        totalComDesconto = total * 0.9;
        System.out.println("Preço com 10% de desconto:" + totalComDesconto);


    }
}
