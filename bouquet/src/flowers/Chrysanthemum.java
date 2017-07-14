package flowers;

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
