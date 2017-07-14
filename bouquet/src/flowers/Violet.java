package flowers;

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
