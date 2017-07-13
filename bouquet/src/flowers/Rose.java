package flowers;

public class Rose extends DecorativeFlower {
    public Rose() {
        super();
        this.cost += 27;
        stemLength += 20;
    }

    public Rose(Color color) {
        super(color);
        this.cost += 27;
        stemLength += 20;
    }
}
