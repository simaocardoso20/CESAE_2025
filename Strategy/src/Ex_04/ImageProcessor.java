package Ex_04;

public class ImageProcessor {
    private ImageFilterStrategy filterStrategy;

    public ImageProcessor(ImageFilterStrategy filterStrategy) {
        this.filterStrategy = filterStrategy;
    }

    public void applyFilter(String image) {
        filterStrategy.apply(image);
    }

    public void setFilterStrategy(ImageFilterStrategy filterStrategy) {
        this.filterStrategy = filterStrategy;
    }
}
