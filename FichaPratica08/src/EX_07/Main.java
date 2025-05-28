package EX_07;

public class Main {

    public static void main(String[] args) {

        Aluno aluno1 = new Aluno("Rodrigo Cardoso", 13, "rodri.test@gmail.com", "Engenheiro Informático", 15);
        Aluno aluno2 = new Aluno("Gabriela Cardoso", 9, "gabi.test@gmail.com", "Veterinária", 10);

        if (aluno1.situacaoAprovacao() && aluno2.situacaoAprovacao()) {
            System.out.println("Ambos aprovados");
        }
    }
}

