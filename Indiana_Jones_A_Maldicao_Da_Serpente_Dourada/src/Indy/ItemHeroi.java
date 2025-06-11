package Indy;

public abstract class ItemHeroi {

    protected String nome;
    protected int precoMoedasOuro;
    protected ArrayList<String>heroisPermitidos;

    public ItemHeroi(String nome, int precoMoedasOuro) {
        this.nome = nome;
        this.precoMoedasOuro = precoMoedasOuro;
    }

    public String getNome() {
            return nome;
        }

        public int getPrecoMoedasOuro() {
            return precoMoedasOuro;
        }

        public abstract boolean podeUsar(Heroi heroi);
        public abstract void usar(Heroi heroi);

        public abstract String getDescricao();
    }


