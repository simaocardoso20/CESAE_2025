public class FactoryTaco {

    // Classe abstrata Taco
    class TacoFactory {
        public Taco createTaco(String tipo) {
            switch (tipo.toLowerCase()) {
                case "vaca":
                    return new TacoCarneVaca();
                case "frango":
                    return new TacoCarneFramgo();
                case "vegetariano":
                    return new TacoVegetariano();
                default:
                    throw new IllegalArgumentException("Tipo de taco não disponível: " + tipo);
            }
        }
    }
}

