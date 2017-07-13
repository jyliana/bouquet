package flowers;

public class Tulip extends DecorativeFlower {
    public Tulip() {
        super();
        stemLength += 15;
        this.cost += 5;
    }

    public Tulip(Color color) {
        super(color);
        stemLength += 15;
        this.cost += 5;
    }
}
