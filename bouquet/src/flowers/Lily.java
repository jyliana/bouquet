package flowers;

public class Lily extends DecorativeFlower {

    public Lily() {
        super();
        stemLength += 15;
        this.cost += 15;
    }

    public Lily(Color color) {
        super(color);
        stemLength += 15;
        this.cost += 15;
    }
}
