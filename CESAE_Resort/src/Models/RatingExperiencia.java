package Models;

    /**
     * Representa um rating dado a uma experiência e ao guia responsável.
     * Cada rating está associado a uma experiência específica e inclui uma pontuação
     * para a experiência e outra para o guia.
     *
     * Este modelo é utilizado para encontrar experiências favoritas.
     *
     */
    public class RatingExperiencia {

    private String idRating;
    private String idExperiencia;
    private int ratingExperiencia;
    private int ratingGuia;

    /**
     *
     * @param idRating
     * @param idExperiencia
     * @param ratingExperiencia
     * @param ratingGuia
     */
    public RatingExperiencia(String idRating, String idExperiencia, int ratingExperiencia, int ratingGuia) {
        this.idRating = idRating;
        this.idExperiencia = idExperiencia;
        this.ratingExperiencia = ratingExperiencia;
        this.ratingGuia = ratingGuia;
    }

    public String getIdRating() {
        return idRating;
    }

    public String getIdExperiencia() {
        return idExperiencia;
    }

    public int getRatingExperiencia() {
        return ratingExperiencia;
    }

    public int getRatingGuia() {
        return ratingGuia;
    }
}

