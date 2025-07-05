package Models;

    /**
     * Representa um cliente do Hotel CESAE.
     * Contém informações pessoais e consentimento para marketing.
     *
     */
public class Cliente {

    private String idCliente;
    private String nomeCliente;
    private String nacionalidade;
    private String email;
    private int telemovel;
    private int anoNascimento;
    private int mesNascimento;
    private int diaNascimento;
    private boolean consentimentoMarketing;

    /**
     *
     * @param idCliente
     * @param nomeCliente
     * @param nacionalidade
     * @param email
     * @param telemovel
     * @param anoNascimento
     * @param mesNascimento
     * @param diaNascimento
     * @param consentimentoMarketing
     */
    public Cliente(String idCliente, String nomeCliente, String nacionalidade, String email, int telemovel, int anoNascimento, int mesNascimento, int diaNascimento, boolean consentimentoMarketing) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.nacionalidade = nacionalidade;
        this.email = email;
        this.telemovel = telemovel;
        this.anoNascimento = anoNascimento;
        this.mesNascimento = mesNascimento;
        this.diaNascimento = diaNascimento;
        this.consentimentoMarketing = consentimentoMarketing;
    }


    public String getIdCliente() {
        return idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getEmail() {
        return email;
    }

    public int getTelemovel() {
        return telemovel;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public int getMesNascimento() {
        return mesNascimento;
    }

    public int getDiaNascimento() {
        return diaNascimento;
    }

    public boolean isConsentimentoMarketing() {
        return consentimentoMarketing;
    }
}

