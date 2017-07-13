package flowers;

public class Lotus extends DecorativeFlower {
    public Lotus() {
        super();
        stemLength += 10;
        this.cost += 37;
    }

    public Lotus(Color color) {
        super(color);
        stemLength += 10;
        this.cost += 37;
    }
}
