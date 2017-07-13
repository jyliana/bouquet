package flowers;

/**
 * Created by Inna on 8/13/16.
 */
public class Chrysanthemum extends WildFlower {
    public Chrysanthemum() {
        super();
        stemLength += 10;
        this.cost += 3;
    }

    public Chrysanthemum(Color color) {
        super(color);
        stemLength += 10;
        this.cost += 3;
    }
}
