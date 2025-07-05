package Models;

/**
 * Representa a tipologia de um quarto no Hotel CESAE Resort.
 * Cada tipologia tem um ID único, uma descrição e um preço por semana.
 *
 * Os quartos pertencem a uma destas tipologias através do seu ID.
 *
 * Este modelo é usado para determinar o preço de uma reserva e descrever os quartos.
 *
 */
public class Tipologia {

    private int idTipologia;
    private String descricaoQuarto;
    private double precoSemana;

    /**
     *
     * @param idTipologia
     * @param descricaoQuarto
     * @param precoSemana
     */
    public Tipologia(int idTipologia, String descricaoQuarto, double precoSemana) {
        this.idTipologia = idTipologia;
        this.descricaoQuarto = descricaoQuarto;
        this.precoSemana = precoSemana;
    }

    public int getIdTipologia() {
        return idTipologia;
    }

    public String getDescricaoQuarto() {
        return descricaoQuarto;
    }

    public double getPrecoSemana() {
        return precoSemana;
    }
}
