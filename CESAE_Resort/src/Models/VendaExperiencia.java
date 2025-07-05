package Models;

/**
 * Representa uma venda de bilhete para uma experiência no CESAE Resort.
 *
 * Cada venda regista a experiência associada, o tipo de cliente (adulto ou criança),
 * e a data (ano e mês) em que a venda ocorreu.
 *
 * Este modelo é utilizado para análise de vendas, relatórios e cálculo de receitas.
 *
 */
public class VendaExperiencia {

    private String idVendaExperiencia;
    private String idExperiencia;
    private String tipoCliente;
    private int anoVendaExperiencia;
    private int mesVendaExperiencia;

    /**
     *
     * @param idVendaExperiencia
     * @param idExperiencia
     * @param tipoCliente
     * @param anoVendaExperiencia
     * @param mesVendaExperiencia
     */
    public VendaExperiencia(String idVendaExperiencia, String idExperiencia, String tipoCliente, int anoVendaExperiencia, int mesVendaExperiencia) {
        this.idVendaExperiencia = idVendaExperiencia;
        this.idExperiencia = idExperiencia;
        this.tipoCliente = tipoCliente;
        this.anoVendaExperiencia = anoVendaExperiencia;
        this.mesVendaExperiencia = mesVendaExperiencia;
    }

    public String getIdVendaExperiencia() {
        return idVendaExperiencia;
    }

    public String getIdExperiencia() {
        return idExperiencia;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public int getAnoVendaExperiencia() {
        return anoVendaExperiencia;
    }

    public int getMesVendaExperiencia() {
        return mesVendaExperiencia;
    }
}
