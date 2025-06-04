package Ex03;

import java.util.ArrayList;

public class BarcoPesca {

    private String nome;
    private String cor;
    private String anoFabrico;
    private int tripulacao;
    private double capacidadeCarga; // em kg
    private Marca marca;
    private ArrayList<Peixe> PeixesPescados;
    private ArrayList<Marisco> MariscoPescado;

    public BarcoPesca(String nome, String cor, String anoFabrico, int tripulacao, double capacidadeCarga, Marca marca) {
        this.nome = nome;
        this.cor = cor;
        this.anoFabrico = anoFabrico;
        this.tripulacao = tripulacao;
        this.capacidadeCarga = capacidadeCarga;
        this.marca = marca;
        this.PeixesPescados = new ArrayList<>();
        this.MariscoPescado = new ArrayList<>();
    }

    public void pescarPeixe(Peixe peixePescado) {
        double pesoTotal = calcularCargaAtual() + peixePescado.getPeso();
        if (pesoTotal <= capacidadeCarga) {
            PeixesPescados.add(peixePescado);
            System.out.println("Peixe pescado com sucesso!");
        } else {
            System.out.println("Carga excedida! NÃ£o Ã© possÃ­vel pescar mais.");
        }
    }

    public void pescarMarisco(Marisco mariscoPescado) {
        double pesoTotal = calcularCargaAtual() + mariscoPescado.getPeso();
        if (pesoTotal <= capacidadeCarga) {
            MariscoPescado.add(mariscoPescado);
            System.out.println("Marisco pescado com sucesso!");
        } else {
            System.out.println("Carga excedida! NÃ£o Ã© possÃ­vel pescar mais.");
        }
    }

    public double calcularCargaAtual() {
        double total = 0;   // Inicializa a variÃ¡vel total com zero. Ela vai guardar o peso total dos peixes e mariscos jÃ¡ pescados.

        for (Peixe p : PeixesPescados) {  //  Para cada peixe p que estÃ¡ na lista PeixesPescados...
            total = total + p.getPeso();  // ... soma o peso desse peixe ao total.
        }

        for (Marisco m : MariscoPescado) {  //  Para cada marisco m que estÃ¡ na lista MariscoPescado...
            total = total + m.getPeso();     // ... soma o peso desse marisco ao total.
        }

        return total;  // Retorna o total calculado, ou seja, a soma do peso de todos os peixes e mariscos pescados.
    }

    public void largarPeixe(int indice) {
        if (indice >= 0 && indice < PeixesPescados.size()) {
            PeixesPescados.remove(indice);
            System.out.println("Peixe largado com sucesso!");
        } else {
            System.out.println("Ãndice invÃ¡lido. Peixe nÃ£o largado.");
        }
    }

    public void largarMarisco(int indice) {
        if (indice >= 0 && indice < MariscoPescado.size()) {
            MariscoPescado.remove(indice);
            System.out.println("Marisco largado com sucesso!");
        } else {
            System.out.println("Ãndice invÃ¡lido. Marisco nÃ£o largado.");
        }
    }



    public double calcularTotal() {
        double total = 0;
        for (Peixe p : PeixesPescados) {
            total += p.getPeso() * p.getPreco();
        }
        for (Marisco m : MariscoPescado) {
            total += m.getPeso() * m.getPreco();
        }
        return total;
    }

    public double salarioTripulacao() {
        if (tripulacao <= 0) return 0;

        double total = calcularTotal();
        double restante = total * 0.6; // 60% vai para a tripulaÃ§Ã£o
        return restante / tripulacao;
    }

    public void exibirDetalhes() {
        System.out.println("Barco: " + nome + " | Cor: " + cor + " | Ano: " + anoFabrico +
                " | Marca: " + marca + " | TripulaÃ§Ã£o: " + tripulacao +
                " | Carga MÃ¡x: " + capacidadeCarga + "kg");
    }

    public void exibirPeixesPescados() {
        System.out.println("Peixes pescados:");
        for (Peixe p : PeixesPescados) {
            p.exibirDetalhes();
        }
    }

    public void exibirMariscosPescados() {
        System.out.println("Mariscos pescados:");
        for (Marisco m : MariscoPescado) {
            m.exibirDetalhes();
        }
    }
}
