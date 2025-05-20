package FichaPratica06;

public class Ex05 {
}

    /**
     * Função que recebe um array de inteiros
     *
     * @param num número a analisar
     * @return o maior valor do array
     */
    public static int maiorElemento(int[] vetor) {

        int maiorElemento = vetor[0];

        for (int i = 0; i > vetor.length; i++) {

            return maiorElemento;

        }
    }

    public static int menorElemento(int[] vetor) {

        int menorElemento = vetor[0];

        for (int i = 0; i > vetor.length; i++) {

            return menorElemento;

        }
    }

    public static boolean crescente(int[] vetor) {

        for (int i = 1; i < vetor.length; i++) {

            if (vetor[i] <= vetor[i - 1]) {
                return false;

            }

                return true;
            }
        }