package Models;

    /**
     * Representa um guia responsável por conduzir experiências no Hotel CESAE Resort.
     * Contém informações pessoais e de contacto do guia.
     * Um guia pode estar associado a várias experiências.
     */
    public class GuiaExperiencia {
        private String idGuia;
        private String nomeGuia;
        private String nacionalidade;
        private String email;
        private int telemovel;

        /**
         *
         * @param idGuia
         * @param nomeGuia
         * @param nacionalidade
         * @param email
         * @param telemovel
         */
        public GuiaExperiencia(String idGuia, String nomeGuia, String nacionalidade, String email, int telemovel) {
            this.idGuia = idGuia;
            this.nomeGuia = nomeGuia;
            this.nacionalidade = nacionalidade;
            this.email = email;
            this.telemovel = telemovel;
        }

        public String getIdGuia() {
            return idGuia;
        }

        public String getNomeGuia() {
            return nomeGuia;
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
    }

