package Ex_04;

public class BlackAndWhiteFilterStrategy implements ImageFilterStrategy{

    @Override
    public void apply(String image) {
        System.out.println("Aplicar filtro preto e branco na imagem " + image);
    }
}

