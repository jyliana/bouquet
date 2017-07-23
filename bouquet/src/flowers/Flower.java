package flowers;

public class Flower {
    private Color color;
    private int stemLength;
    private double cost;
    private Freshness freshness;

    public Flower() {
        this.color = FlowerSetting.calcAllowedColor(this);
        this.freshness = FlowerSetting.calcFreshness(this);
        this.cost = FlowerSetting.calcCost(this);
        this.stemLength = FlowerSetting.getMapOfSettings().get(this.getClass()).getStemLength();
    }

    public Flower(Color color) {
        this.color = color;
        this.freshness = FlowerSetting.calcFreshness(this);
        this.cost = FlowerSetting.calcCost(this);
        this.stemLength = FlowerSetting.getMapOfSettings().get(this.getClass()).getStemLength();
    }

    public double getCost() {
        return this.cost;
    }

    public Freshness getFreshness() {
        return freshness;
    }

    public Color getColor() {
        return color;
    }

    public int getStemLength() {
        return stemLength;
    }
}
