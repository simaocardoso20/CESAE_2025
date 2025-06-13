package Indy;

public class IndianaJones extends Heroi{

    public IndianaJones(String nome, int vidaMax, int vidaAtual, int forca, int nivel, int ouro) {
        super(nome, vidaMax, vidaAtual, forca, nivel, ouro);
    }

    @Override
    public void atacar(NPC inimigo) {
        int dano = getDanoTotal();
        System.out.println(nome + " ataca " + inimigo.getNome() + " com força total " + dano + "!");
        inimigo.receberDano(dano);

        if (inimigo.estaVivo()) {
            System.out.println(inimigo.getNome() + " revida!");
            this.receberDano(inimigo.getForca());
        }
    }
}

