package flowers;

import java.util.ArrayList;


public class FlowerTypeSetting {
    private ArrayList<Color> allowedColors;
    private int price;
    private int stemLength;

    public FlowerTypeSetting(ArrayList<Color> allowedColors, int price, int stemLength) {
        this.allowedColors = allowedColors;
        this.price = price;
        this.stemLength = stemLength;
    }

    public int getStemLength() {
        return stemLength;
    }

    public ArrayList<Color> getAllowedColors() {
        return allowedColors;
    }

    public int getPrice() {
        return price;
    }
}