package flowers;

/**
 * Created by Inna on 8/13/16.
 */
public abstract class DecorativeFlower extends Flower {

    public DecorativeFlower(Color color) {
        super(color);
        stemLength += 5;
    }

    public DecorativeFlower() {

    }
}
