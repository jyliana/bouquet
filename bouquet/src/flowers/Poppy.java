package flowers;

/**
 * Created by Inna on 8/13/16.
 */
public class Poppy extends WildFlower {
    public Poppy() {
        super();
        stemLength = 20;
        this.cost += 2;
    }

    public Poppy(Color color) {
        super(color);
        stemLength = 20;
        this.cost += 2;
    }
}
