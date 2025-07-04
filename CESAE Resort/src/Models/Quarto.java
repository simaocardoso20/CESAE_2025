package Models;

        /**
         * Representa um quarto disponível no Hotel CESAE Resort.
         * Cada quarto tem um número único e está associado a uma tipologia.
         * A tipologia define o tipo de quarto e respetivo preço.
         */
        public class Quarto {
                private int numQuarto;
                private int tipologia;

                /**
                 *
                 * @param numQuarto
                 * @param tipologia
                 */
                public Quarto(int numQuarto, int tipologia) {
                        this.numQuarto = numQuarto;
                        this.tipologia = tipologia;
                }

                public int getNumQuarto() {
                        return numQuarto;
                }

                public int getTipologia() {
                        return tipologia;
                }
        }



