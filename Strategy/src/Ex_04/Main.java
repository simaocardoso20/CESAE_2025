package Ex_04;

public class Main {
        public static void main(String[] args) {
            String image = "foto.jpg";

            ImageProcessor processor1 = new ImageProcessor(new BlackAndWhiteFilterStrategy());
            processor1.applyFilter(image);

            ImageProcessor processor2 = new ImageProcessor(new SepiaFilterStrategy());
            processor2.applyFilter(image);

            ImageProcessor processor3 = new ImageProcessor(new VintageFilterStrategy());
            processor3.applyFilter(image);
        }
    }
