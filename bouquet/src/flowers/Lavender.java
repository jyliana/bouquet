package flowers;

public class Lavender extends WildFlower {
    public Lavender() {
        super();
        stemLength = 10;
        this.cost += 2;
    }

    public Lavender(Color color) {
        super(color);
        stemLength = 10;
        this.cost += 2;
    }
}
