public class TacoCarneFrango extends Taco {


    // Classe TacoCarneFramgo
    class TacoCarneFramgo extends Taco {
        public TacoCarneFramgo() {
            super("Carne de Frango");
        }

        @Override
        public void prepare() {
            System.out.println("A preparar taco de ");
        }

        @Override
        public void bake() {
            System.out.println("A cozinhar taco de ");
        }

        @Override
        public void box() {
            System.out.println("A embalar taco de ");
        }
    }
}
