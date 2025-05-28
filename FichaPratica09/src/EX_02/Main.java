package EX_02;

public class Main {

    public static void main(String[] args) {

        ContaBancaria c1 = new ContaBancaria("PT50 123", "Vitor");
        ContaBancaria c2 = new ContaBancaria("PT50 123", "Vitor");
        ContaBancaria c3 = new ContaBancaria("PT50 123", "Vitor");

        c1.exibirDetalhes();
        c1.pedirEmprestimo(400);
        c1.exibirDetalhes();
        c1.amortizarEmprestimo();
        c1.exibirDetalhes();
    }
}
