package flowers;

/**
 * Created by Inna on 8/13/16.
 */
public class Violet extends WildFlower {
    public Violet() {
        super();
        this.cost += 2;
        stemLength = 10;
    }

    public Violet(Color color) {
        super(color);
        this.cost += 2;
        stemLength = 10;
    }
}
