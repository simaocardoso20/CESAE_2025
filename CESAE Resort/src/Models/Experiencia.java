package Models;

    /**
     * Representa uma experiência de programação oferecida pelo Hotel CESAE Resort.
     * Cada experiência é conduzida por um guia e tem preços diferentes para adultos e crianças.
     */
public class Experiencia {

    private String idExperiencia;
    private String nomeExperiencia;
    private String idGuia;
    private double precoAdulto;
    private double precoCrianca;

    /**
     *
     * @param idExperiencia
     * @param nomeExperiencia
     * @param idGuia
     * @param precoAdulto
     * @param precoCrianca
     */
    public Experiencia(String idExperiencia, String nomeExperiencia, String idGuia, double precoAdulto, double precoCrianca) {
        this.idExperiencia = idExperiencia;
        this.nomeExperiencia = nomeExperiencia;
        this.idGuia = idGuia;
        this.precoAdulto = precoAdulto;
        this.precoCrianca = precoCrianca;
    }


    public String getIdExperiencia() {
        return idExperiencia;
    }

    public String getNomeExperiencia() {
        return nomeExperiencia;
    }

    public String getIdGuia() {
        return idGuia;
    }

    public double getPrecoAdulto() {
        return precoAdulto;
    }

    public double getPrecoCrianca() {
        return precoCrianca;
    }
}
