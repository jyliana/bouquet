package flowers;

public class Flower {
    public Freshness freshness;
    public Color color;
    public int stemLength;
    protected double cost;

    public Flower() {
        this.color = FlowerSetting.calcAllowedColor(this);
        this.freshness = calcFreshness((int) (Math.random() * 3));
        this.cost += setCost();
    }

    public Flower(Color color) {
        if (FlowerSetting.checkInDictionary(this, color)) {
            this.color = color;
        }
        this.freshness = calcFreshness((int) (Math.random() * 3));
        this.cost += setCost();
    }

    public double getCost() {
        return cost;
    }

    public double setCost() {
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
        switch (tmp) {
            case 0: {
                this.freshness = Freshness.FRESH;
                break;
            }
            case 1: {
                this.freshness = Freshness.ONE_DAY_FRESH;
                break;
            }
            case 2: {
                this.freshness = Freshness.VERY_FRESH;
                break;
            }
        }
        return freshness;
    }

    public Color getColor() {
        return color;
    }
}
