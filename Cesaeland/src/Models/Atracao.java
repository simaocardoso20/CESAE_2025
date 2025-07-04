package Models;

public class Atracao {

    private int idAtracao;
    private String atracao;
    private double precoAdulto;
    private double precoCrianca;
    private int duracaoSeg;

    public Atracao(int idAtracao, String atracao, double precoAdulto, double precoCrianca, int duracaoSeg) {
        this.idAtracao = idAtracao;
        this.atracao = atracao;
        this.precoAdulto = precoAdulto;
        this.precoCrianca = precoCrianca;
        this.duracaoSeg = duracaoSeg;
    }


    public int getIdAtracao() {
        return idAtracao;
    }

    public String getAtracao() {
        return atracao;
    }

    public double getPrecoAdulto() {
        return precoAdulto;
    }

    public double getPrecoCrianca() {
        return precoCrianca;
    }

    public int getDuracaoSeg() {
        return duracaoSeg;
    }
}
