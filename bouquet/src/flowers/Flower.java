package flowers;

public class Flower {
    protected Freshness[] listOfFreshness = Freshness.values();
    private Freshness freshness=calcFreshness((int) (Math.random() * listOfFreshness.length));
    public Color color;
    public int stemLength;
    protected double cost;


    public Flower() {
        this.color = FlowerSetting.calcAllowedColor(this);
        this.cost += calcCost();
    }

    public Flower(Color color) {
        if (FlowerSetting.checkInDictionary(this, color)) {
            this.color = color;
        }
        this.cost += calcCost();
    }

    public double getCost() {
        return cost;
    }

    public double calcCost() {
        if (stemLength >= 0 && stemLength <= 10) {
            this.cost += 2;
        } else if (stemLength >= 10 && stemLength <= 20) {
            this.cost += 5;
        }
        if (this.freshness == Freshness.VERY_FRESH)
            this.cost += 3;
        else if (this.freshness == Freshness.FRESH)
            this.cost += 1;
        else if (this.freshness == Freshness.ONE_DAY_FRESH)
            this.cost *= 0.5;
        return cost;
    }

    public Freshness getFreshness() {
        return freshness;
    }

    public Freshness calcFreshness(int tmp) {
        this.freshness = listOfFreshness[tmp];
        return freshness;
    }

    public Color getColor() {
        return color;
    }
}
