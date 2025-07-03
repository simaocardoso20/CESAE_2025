package FichaPratica01;

import java.util.Scanner;

public class EX09 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        double dias, codigo, vencimentobase, subalim, retencaoirs, segurancasocialpessoal, segurancasocialpatronal, vencimentoliquido;

        // Ler valores
        System.out.print("Introduza o seu código de utilizador: ");
        codigo = input.nextInt();

        System.out.print("Introduza o nº de dias de trabalho: ");
        dias = input.nextInt();

        // Calcular e apresentar o vencimento base mensal
        vencimentobase = dias * 40 ;
        System.out.println("Vencimento base:" + vencimentobase +"€");

        // Calcular e apresentar o subsidio alimentação
        subalim = dias * 5 ;
        System.out.println("Subsidio de Alimentação:" + subalim +"€");

        // Calcular e apresentar o valor de retenção de IRS
        retencaoirs = vencimentobase * 0.1 ;
        System.out.println("Retenção no IRS:" + subalim +"€");

        // Calcular e apresentar o valor de Segurança Social encargo do funcionário
        segurancasocialpessoal = vencimentobase * 0.11 ;
        System.out.println("Descontos para a Segurança Social:" + segurancasocialpessoal +"€");

        // Calcular e apresentar o valor de Segurança Social encargo da entidade patronal
        segurancasocialpatronal = vencimentobase * 0.2375 ;
        System.out.println("Descontos para a Segurança Social para a Entidade Patronal:" + segurancasocialpatronal +"€");

        // Calcular e apresentar o valor líquido
        vencimentoliquido = (vencimentobase + subalim) - retencaoirs - segurancasocialpessoal ;
        System.out.println("Vencimento líquido:" + vencimentoliquido +"€");

    }
}
