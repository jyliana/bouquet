package flowers;

import java.util.*;

public class FlowerSetting {
    static private Map<Class, List<Color>> mapOfSettings = new HashMap<>();

    static {
        mapOfSettings.put(Lotus.class, new ArrayList<>(Arrays.asList(Color.BLUE, Color.WHITE, Color.ROSE)));
        mapOfSettings.put(Lavender.class, new ArrayList<>(Arrays.asList(Color.LAVENDER)));
        mapOfSettings.put(Violet.class, new ArrayList<>(Arrays.asList(Color.VIOLET)));
        mapOfSettings.put(Camomile.class, new ArrayList<>(Arrays.asList(Color.WHITE)));
        mapOfSettings.put(Poppy.class, new ArrayList<>(Arrays.asList(Color.RED)));
        mapOfSettings.put(Flower.class, new ArrayList<>(Arrays.asList(Color.BLACK, Color.BLUE, Color.WHITE, Color.CRIMSON, Color.ORANGE, Color.LAVENDER, Color.PURPLE,
                Color.VIOLET, Color.ROSE, Color.YELLOW, Color.GOLDEN, Color.RED)));
        mapOfSettings.put(Lily.class, new ArrayList<>(Arrays.asList(Color.BLACK, Color.WHITE, Color.CRIMSON, Color.ORANGE,
                Color.PURPLE, Color.VIOLET, Color.ROSE, Color.YELLOW, Color.GOLDEN, Color.RED)));
        mapOfSettings.put(Orchid.class, new ArrayList<>(Arrays.asList(Color.BLACK, Color.WHITE, Color.CRIMSON,
                Color.ROSE, Color.YELLOW, Color.RED)));
        mapOfSettings.put(Rose.class, new ArrayList<>(Arrays.asList(Color.WHITE, Color.CRIMSON,
                Color.ROSE, Color.YELLOW, Color.GOLDEN, Color.RED)));
        mapOfSettings.put(Tulip.class, new ArrayList<>(Arrays.asList(Color.BLACK, Color.WHITE, Color.ORANGE,
                Color.ROSE, Color.YELLOW, Color.RED)));
    }

    protected static boolean checkInDictionary(Flower flower, Color color) {
        if (mapOfSettings.containsKey(flower.getClass())) {
            if (mapOfSettings.get(flower.getClass()).contains(color))
                return true;
        } else if (flower instanceof Flower) {
            if (mapOfSettings.get(Flower.class).contains(color))
                return true;
        }
        System.out.println("There is no " + flower.getClass().getSimpleName().toLowerCase() + " with such color, please choose other color");
        return false;
    }

    public static Color calcAllowedColor(Flower flower) {
        if (mapOfSettings.containsKey(flower.getClass())) {
            int colorIndex = (int) (Math.random() * mapOfSettings.get(flower.getClass()).size());
            return mapOfSettings.get(flower.getClass()).get(colorIndex);
        } else if (flower instanceof Flower) {
            int colorIndex = (int) (Math.random() * mapOfSettings.get(Flower.class).size());
            return mapOfSettings.get(Flower.class).get(colorIndex);
        }
        return null;
    }

    public static boolean checkAllowedColor(String nameOfFlower, Color color) {
        for (Map.Entry<Class, List<Color>> item : mapOfSettings.entrySet()) {
            if (item.getKey().getName().contains(nameOfFlower) && item.getValue().contains(color)) {
                return true;
            }
        }
        return false;
    }

    public static Map<Class, List<Color>> getMapOfSettings() {
        return mapOfSettings;
    }
}
