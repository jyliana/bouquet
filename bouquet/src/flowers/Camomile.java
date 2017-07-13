package flowers;

public class Camomile extends WildFlower {
    public Camomile() {
        super();
        stemLength = 20;
        this.cost += 2;
    }

    public Camomile(Color color) {
        super(color);
        stemLength = 20;
        this.cost += 2;
    }
}
