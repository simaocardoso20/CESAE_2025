package Models;

/**
 * Representa uma reserva semanal de um quarto no Hotel CESAE Resort.
 * A reserva inclui o número do quarto, o cliente associado e a data (ano, mês e semana).
 *
 * Cada quarto pode ser reservado apenas uma vez por semana.
 * As reservas são feitas com base na semana do ano, não por datas exatas.
 *
 */
public class ReservaQuarto {

    private String idReserva;
    private int numQuarto;
    private String idCliente;
    private int anoReserva;
    private int mesReserva;
    private int semanaReserva;

    /**
     *
     * @param idReserva
     * @param numQuarto
     * @param idCliente
     * @param anoReserva
     * @param mesReserva
     * @param semanaReserva
     */
    public ReservaQuarto(String idReserva, int numQuarto, String idCliente, int anoReserva, int mesReserva, int semanaReserva) {
        this.idReserva = idReserva;
        this.numQuarto = numQuarto;
        this.idCliente = idCliente;
        this.anoReserva = anoReserva;
        this.mesReserva = mesReserva;
        this.semanaReserva = semanaReserva;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public int getNumQuarto() {
        return numQuarto;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public int getAnoReserva() {
        return anoReserva;
    }

    public int getMesReserva() {
        return mesReserva;
    }

    public int getSemanaReserva() {
        return semanaReserva;
    }
}
