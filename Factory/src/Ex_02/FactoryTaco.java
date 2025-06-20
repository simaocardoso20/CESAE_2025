package Ex_02;

public class FactoryTaco {

        public static Taco createTaco(String tipo) {
            switch (tipo) {
                case "CARNE VACA":
                    return new TacoCarneVaca();

                case "CARNE FRANGO":
                    return new TacoCarneFrango();

                case "VEGETARIANO":
                    return new TacoVegetariano();

                default:
                    throw new IllegalArgumentException("Não temos tacos desse tipo: " + tipo);

            }
        }
    }


