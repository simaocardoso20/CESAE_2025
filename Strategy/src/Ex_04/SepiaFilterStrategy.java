package Ex_04;

public class SepiaFilterStrategy implements ImageFilterStrategy{
    @Override
    public void apply(String image) {
        System.out.println("Aplicar filtro sépia na imagem " + image);
    }
}
