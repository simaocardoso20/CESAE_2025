package Models;

public class Venda {

    private int idAtracao;
    private int ano;
    private int mes;
    private String tipoCliente;

    public Venda(int idAtracao, int ano, int mes, String tipoCliente) {
        this.idAtracao = idAtracao;
        this.ano = ano;
        this.mes = mes;
        this.tipoCliente = tipoCliente;
    }

    public int getIdAtracao() {
        return idAtracao;
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }
}
