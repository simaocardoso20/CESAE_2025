package EX_02;

public class Edificio {

    // Atributos
    private String nome;
    private String rua;
    private String cidade;
    private String corFachada;
    private int andares;
    private boolean garagem;

    // Construtor (teclas alt+insert preenche automatico)
    public Edificio(String nome, String rua, String cidade, String corFachada, int andares, boolean garagem) {
        this.nome = nome;
        this.rua = rua;
        this.cidade = cidade;
        this.corFachada = corFachada;
        this.andares = andares;
        this.garagem = garagem;
    }

    public String getNome() {
        return this.nome;
    }
    public String getRua() {
        return this.rua;
    }
    public String getCidade() {
        return this.cidade;
    }

    public String getCorFachada() {
        return this.corFachada;
    }
    public int getAndares() {
        return this.andares;
    }
    public boolean getGaragem() {
        return this.garagem;
    }

// Alterar a cor da fachada
    public void setCorFachada(String novaCor) {
        this.corFachada = novaCor;
    }

    }



