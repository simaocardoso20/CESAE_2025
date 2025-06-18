public class TacoVegetariano extends Taco {


    class TacoVegetariano extends Taco {
        public TacoVegetariano() {
            super("Vegetariano");
        }

        @Override
        public void prepare() {
            System.out.println("A preparar taco ");
        }

        @Override
        public void bake() {
            System.out.println("A cozinhar taco ");
        }

        @Override
        public void box() {
            System.out.println("A embalar taco " + nome);
        }
    }

}





