package flowers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FlowerSetting {
    static private Map<Class, FlowerTypeSetting> mapOfSettings = new HashMap<>();

    static {
        mapOfSettings.put(Lotus.class, new FlowerTypeSetting(new ArrayList<>(Arrays.asList(Color.BLUE, Color.WHITE, Color.ROSE)), 40, 10));
        mapOfSettings.put(Lavender.class, new FlowerTypeSetting(new ArrayList<>(Arrays.asList(Color.LAVENDER)), 10, 10));
        mapOfSettings.put(Violet.class, new FlowerTypeSetting(new ArrayList<>(Arrays.asList(Color.VIOLET)), 15, 10));
        mapOfSettings.put(Camomile.class, new FlowerTypeSetting(new ArrayList<>(Arrays.asList(Color.WHITE)), 10, 20));
        mapOfSettings.put(Poppy.class, new FlowerTypeSetting(new ArrayList<>(Arrays.asList(Color.RED)), 7, 20));
        mapOfSettings.put(Chrysanthemum.class, new FlowerTypeSetting(new ArrayList<>(Arrays.asList(Color.values())), 15, 15));
        mapOfSettings.put(Lily.class, new FlowerTypeSetting(new ArrayList<>(Arrays.asList(Color.BLACK, Color.WHITE, Color.CRIMSON, Color.ORANGE,
                Color.PURPLE, Color.VIOLET, Color.ROSE, Color.YELLOW, Color.GOLDEN, Color.RED)), 25, 15));
        mapOfSettings.put(Orchid.class, new FlowerTypeSetting(new ArrayList<>(Arrays.asList(Color.BLACK, Color.WHITE, Color.CRIMSON,
                Color.ROSE, Color.YELLOW, Color.RED)), 35, 20));
        mapOfSettings.put(Rose.class, new FlowerTypeSetting(new ArrayList<>(Arrays.asList(Color.WHITE, Color.CRIMSON,
                Color.ROSE, Color.YELLOW, Color.GOLDEN, Color.RED)), 30, 20));
        mapOfSettings.put(Tulip.class, new FlowerTypeSetting(new ArrayList<>(Arrays.asList(Color.BLACK, Color.WHITE, Color.ORANGE,
                Color.ROSE, Color.YELLOW, Color.RED)), 20, 15));
    }

    protected static boolean checkInDictionary(Flower flower, Color color) {
        if (mapOfSettings.containsKey(flower.getClass())) {
            if (mapOfSettings.get(flower.getClass()).getAllowedColors().contains(color))
                return true;
        }
        System.out.println("There is no " + flower.getClass().getSimpleName().toLowerCase() + " with such color, please choose other color");
        return false;
    }

    protected static Color calcAllowedColor(Flower flower) {
        if (mapOfSettings.containsKey(flower.getClass())) {
            int colorIndex = (int) (Math.random() * mapOfSettings.get(flower.getClass()).getAllowedColors().size());
            return mapOfSettings.get(flower.getClass()).getAllowedColors().get(colorIndex);
        }
        return null;
    }

    public static boolean checkAllowedColor(String nameOfFlower, Color color) {
        for (Map.Entry<Class, FlowerTypeSetting> item : mapOfSettings.entrySet()) {
            if (item.getKey().getName().contains(nameOfFlower) && item.getValue().getAllowedColors().contains(color)) {
                return true;
            }
        }
        return false;
    }

    public static Map<Class, FlowerTypeSetting> getMapOfSettings() {
        return mapOfSettings;
    }

    public static double calcCost(Flower flower) {
        if (mapOfSettings.containsKey(flower.getClass())) {
            return mapOfSettings.get(flower.getClass()).getPrice() * 0.9 + mapOfSettings.get(flower.getClass()).getStemLength() * 0.5 + (flower.freshness.ordinal() + 1) * (-1);
        }
        return 0.0;
    }

    public static Freshness calcFreshness(Flower flower) {
        Freshness[] listOfFreshness = Freshness.values();
        int tmp = (int) (Math.random() * listOfFreshness.length);
        return listOfFreshness[tmp];
    }
}
