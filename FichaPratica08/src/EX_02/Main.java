package EX_02;

import EX_01.Pessoa;

public class Main {

    public static void main(String[] args) {

        // Novas instancias

        Edificio edif = new Edificio("Clérigos", "Rua dos Clérigos", "Porto", "Cinza", 4, true);

        System.out.println("*************** Especificações do Edifício: " + edif.getNome()+ " ***************");

        System.out.println("Localização: " + edif.getRua());

        System.out.println("Cidade: " + edif.getCidade());

        System.out.println("Cor da Fachada: " + edif.getCorFachada());

        System.out.println("Nº de andares: " + edif.getAndares());

        System.out.println("Garagem: " + edif.getGaragem());


        // Trocar cor de edifícios
        edif.setCorFachada("Branca");

        System.out.println("\nNova cor da fachada: " + edif.getCorFachada());


        // Imprimir novamente as especificações do edifício

        System.out.println("\nNome do Edifício: " + edif.getNome());

        System.out.println("Localização: " + edif.getRua());

        System.out.println("Cidade: " + edif.getCidade());

        System.out.println("Cor da Fachada: " + edif.getCorFachada());

        System.out.println("Nº de andares: " + edif.getAndares());

        System.out.println("Garagem: " + edif.getGaragem());


// Trocar cidade

//        edif.setCidade("Lisboa");
//
//        System.out.println("Nova cidade: " + edif.getCidade());

    }
}


