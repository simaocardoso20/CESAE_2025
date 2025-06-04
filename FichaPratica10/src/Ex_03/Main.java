package Ex03;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        // Criar o barco de pesca
        BarcoPesca barco = new BarcoPesca("Maré Alta", "Azul", "2015", 5, 500.0, Marca.Quicksilver);

        // Exibir detalhes do barco
        barco.exibirDetalhes();

        // Criar alguns peixes e mariscos
        Peixe peixe1 = new Peixe("Sardinha", 10.0, 5.5);
        Peixe peixe2 = new Peixe("Atum", 50.0, 12.0);
        Marisco marisco1 = new Marisco("Camarão", 20.0, 18.0);
        Marisco marisco2 = new Marisco("Lagosta", 30.0, 25.0);

        // Pescar peixes e mariscos
        barco.pescarPeixe(peixe1);
        barco.pescarPeixe(peixe2);
        barco.pescarMarisco(marisco1);
        barco.pescarMarisco(marisco2);

        // Exibir tudo o que foi pescado
        barco.exibirPeixesPescados();
        barco.exibirMariscosPescados();

        // Mostrar carga atual e total de venda
        System.out.println("Carga atual: " + barco.calcularCargaAtual() + " kg");
        System.out.println("Total de venda do pescado: €" + barco.calcularTotal());

        // Mostrar salário por tripulante
        System.out.println("Salário por tripulante: €" + barco.salarioTripulacao());
    }
}
