package flowers;

public enum Accessories
{
    DECORATIVE_PAPER(10),
    RIBBONS(5),
    CRYSTALS(25),
    FEATHERS(15),
    ORGANZA(15),
    GREENERY(2),
    DECORATIVE_BUTTERFLY(25);

    private double cost;

    Accessories(double cost)
    {
        this.cost = cost;
    }

    public double getCost()
    {
        return cost;
    }
}
