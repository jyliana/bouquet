package flowers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FlowerSetting {
    static private Map<Class, FlowerTypeSetting> mapOfSettings = new HashMap<>();

    static {
        mapOfSettings.put(Lotus.class, new FlowerTypeSetting(new ArrayList<>(Arrays.asList(Color.BLUE, Color.WHITE, Color.ROSE)), 40));
        mapOfSettings.put(Lavender.class, new FlowerTypeSetting(new ArrayList<>(Arrays.asList(Color.LAVENDER)), 10));
        mapOfSettings.put(Violet.class, new FlowerTypeSetting(new ArrayList<>(Arrays.asList(Color.VIOLET)), 15));
        mapOfSettings.put(Camomile.class, new FlowerTypeSetting(new ArrayList<>(Arrays.asList(Color.WHITE)), 10));
        mapOfSettings.put(Poppy.class, new FlowerTypeSetting(new ArrayList<>(Arrays.asList(Color.RED)), 7));
        mapOfSettings.put(Flower.class, new FlowerTypeSetting(new ArrayList<>(Arrays.asList(Color.BLACK, Color.BLUE, Color.WHITE, Color.CRIMSON, Color.ORANGE, Color.LAVENDER, Color.PURPLE,
                Color.VIOLET, Color.ROSE, Color.YELLOW, Color.GOLDEN, Color.RED)), 15));
        mapOfSettings.put(Lily.class, new FlowerTypeSetting(new ArrayList<>(Arrays.asList(Color.BLACK, Color.WHITE, Color.CRIMSON, Color.ORANGE,
                Color.PURPLE, Color.VIOLET, Color.ROSE, Color.YELLOW, Color.GOLDEN, Color.RED)), 25));
        mapOfSettings.put(Orchid.class, new FlowerTypeSetting(new ArrayList<>(Arrays.asList(Color.BLACK, Color.WHITE, Color.CRIMSON,
                Color.ROSE, Color.YELLOW, Color.RED)), 35));
        mapOfSettings.put(Rose.class, new FlowerTypeSetting(new ArrayList<>(Arrays.asList(Color.WHITE, Color.CRIMSON,
                Color.ROSE, Color.YELLOW, Color.GOLDEN, Color.RED)), 30));
        mapOfSettings.put(Tulip.class, new FlowerTypeSetting(new ArrayList<>(Arrays.asList(Color.BLACK, Color.WHITE, Color.ORANGE,
                Color.ROSE, Color.YELLOW, Color.RED)), 20));
    }

    protected static boolean checkInDictionary(Flower flower, Color color) {
        if (mapOfSettings.containsKey(flower.getClass())) {
            if (mapOfSettings.get(flower.getClass()).allowedColors.contains(color))
                return true;
        } else if (flower instanceof Flower) {
            if (mapOfSettings.get(Flower.class).allowedColors.contains(color))
                return true;
        }
        System.out.println("There is no " + flower.getClass().getSimpleName().toLowerCase() + " with such color, please choose other color");
        return false;
    }

    protected static Color calcAllowedColor(Flower flower) {
        if (mapOfSettings.containsKey(flower.getClass())) {
            int colorIndex = (int) (Math.random() * mapOfSettings.get(flower.getClass()).allowedColors.size());
            return mapOfSettings.get(flower.getClass()).allowedColors.get(colorIndex);
        } else if (flower instanceof Flower) {
            int colorIndex = (int) (Math.random() * mapOfSettings.get(Flower.class).allowedColors.size());
            return mapOfSettings.get(Flower.class).allowedColors.get(colorIndex);
        }
        return null;
    }

    public static boolean checkAllowedColor(String nameOfFlower, Color color) {
        for (Map.Entry<Class, FlowerTypeSetting> item : mapOfSettings.entrySet()) {
            if (item.getKey().getName().contains(nameOfFlower) && item.getValue().allowedColors.contains(color)) {
                return true;
            }
        }
        return false;
    }

    public static Map<Class, FlowerTypeSetting> getMapOfSettings() {
        return mapOfSettings;
    }

    static class FlowerTypeSetting {
        ArrayList<Color> allowedColors;
        int price;

        public FlowerTypeSetting(ArrayList<Color> allowedColors, int price) {
            this.allowedColors = allowedColors;
            this.price = price;
        }
    }

}
