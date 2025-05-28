package EX_02;

public class ContaBancaria {
    private String titular;
    private String iban;
    private double saldo;
    private int anoAbertura = 2025;
    private double margemEmprestimo = 0.5;
    private double valorDivida = 0.0;

    public ContaBancaria(String titular, String iban, double saldo) {
        this.titular = titular;
        this.iban = iban;
    }

    public void pedirEmprestimo(double valorPedido) {
        if (valorDivida > 0) {
            System.out.println("Empréstimo recusado: já existe uma dívida ativa de €" + valorDivida);
            return;
        }

        double limiteEmprestimo = saldo * margemEmprestimo;

        if (valorPedido <= limiteEmprestimo) {
            saldo += valorPedido;
            valorDivida = valorPedido;
            System.out.println("Empréstimo aprovado de €" + valorPedido + ". Novo saldo: €" + saldo);
        } else {
            System.out.println("Empréstimo recusado: valor solicitado (€" + valorPedido +
                    ") excede o limite de €" + limiteEmprestimo);
        }
    }

    public void amortizarEmprestimo() {
        if (valorDivida == 0) {
            System.out.println("Não há dívida ativa a ser paga.");
        } else if (saldo >= valorDivida) {
            saldo -= valorDivida;
            System.out.println("Dívida de €" + valorDivida + " amortizada com sucesso.");
            valorDivida = 0;
        } else {
            System.out.println("Saldo insuficiente para amortizar a dívida de €" + valorDivida);
        }
    }

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println(valor + " € depositados na conta " + this.iban);
    }


    public void exibirDetalhes() {
        System.out.println(this.iban + " " + this.titular + " | Saldo: €" + this.saldo + " | Ano Abertura: " + this.anoAbertura + " | Dívida: €" + this.valorDivida);
    }
}