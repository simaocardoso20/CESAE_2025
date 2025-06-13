package Indy;

import java.util.ArrayList;

public abstract class Heroi extends Entidade{

    protected int nivel;
    protected int ouro;
    protected ArmaPrincipal armaPrincipal;
    protected ArrayList<ItemHeroi> inventario;


    public Heroi(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int ouro) {
        super(nome, vidaMax, vidaAtual, forca);
        this.nivel = nivel;
        this.ouro = ouro;
        this.armaPrincipal = null;
        this.inventario = new ArrayList<ItemHeroi>();
    }

    public int getNivel() {
        return nivel;
    }

    public int getOuro() {
        return ouro;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    public void equiparArma(ArmaPrincipal arma) {
        this.armaPrincipal = arma;
        System.out.println(nome + " equipou a arma: " + arma.getNome());
    }

    public int getDanoTotal() {
        return armaPrincipal != null ? forca + armaPrincipal.getDano() : forca;
    }

    public void curar(int quantidade) {
        vidaAtual += quantidade;
        if (vidaAtual > vidaMax) {
            vidaAtual = vidaMax;
        }
        System.out.println(nome + " foi curado em " + quantidade + " pontos de vida.");
    }

    public void aumentarForca(int quantidade) {
        this.forca += quantidade;
    }

    public abstract void atacar(NPC inimigo);

    public void mostrarStatus() {
        System.out.println("=== STATUS DO HERÓI ===");
        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + vidaAtual + "/" + vidaMax);
        System.out.println("Força: " + forca);
        System.out.println("Nível: " + nivel);
        System.out.println("Ouro: " + ouro);
        System.out.println("Arma: " + (armaPrincipal != null ? armaPrincipal.getNome() + " (+" + armaPrincipal.getDano() + ")" : "Nenhuma"));
        System.out.println("========================");
    }

    public void adicionarItemAoInventario(ItemHeroi item) {
        inventario.add(item);
    }

    public void retirarOuro(int quantidade) {
        this.ouro -= quantidade;
    }

    }

    //metodo usarPocao


