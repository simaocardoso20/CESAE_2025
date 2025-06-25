package Models;

public class Custo {

    private int idAtracao;
    private double custoManutencao;
    private double custoFixo;

    public Custo(int idAtracao, double custoManutencao, double custoFixo) {
        this.idAtracao = idAtracao;
        this.custoManutencao = custoManutencao;
        this.custoFixo = custoFixo;
    }

    public int getIdAtracao() {
        return idAtracao;
    }

    public double getCustoManutencao() {
        return custoManutencao;
    }

    public double getCustoFixo() {
        return custoFixo;
    }
}
