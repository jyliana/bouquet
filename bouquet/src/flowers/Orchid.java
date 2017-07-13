package flowers;


public class Orchid extends DecorativeFlower {
    public Orchid() {
        super();
        stemLength += 20;
        this.cost += 27;
    }

    public Orchid(Color color) {
        super(color);
        stemLength += 20;
        this.cost += 27;
    }

}
