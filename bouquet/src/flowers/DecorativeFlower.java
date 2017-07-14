package flowers;

public abstract class DecorativeFlower extends Flower {

    public DecorativeFlower(Color color) {
        super(color);
        stemLength += 5;
    }

    public DecorativeFlower() {

    }
}
