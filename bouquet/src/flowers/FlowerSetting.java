package flowers;

import java.util.*;

public class FlowerSetting {
    static private Map<Class, List<Color>> map = new HashMap<>();

    static {
        map.put(Lotus.class, new ArrayList<>(Arrays.asList(Color.BLUE, Color.WHITE, Color.ROSE)));
        map.put(Lavender.class, new ArrayList<>(Arrays.asList(Color.LAVENDER)));
        map.put(Violet.class, new ArrayList<>(Arrays.asList(Color.VIOLET)));
        map.put(Camomile.class, new ArrayList<>(Arrays.asList(Color.WHITE)));
        map.put(Poppy.class, new ArrayList<>(Arrays.asList(Color.RED)));
        map.put(Flower.class, new ArrayList<>(Arrays.asList(Color.BLACK, Color.BLUE, Color.WHITE, Color.CRIMSON, Color.ORANGE, Color.LAVENDER, Color.PURPLE,
                Color.VIOLET, Color.ROSE, Color.YELLOW, Color.GOLDEN, Color.RED)));
        map.put(Lily.class, new ArrayList<>(Arrays.asList(Color.BLACK, Color.WHITE, Color.CRIMSON, Color.ORANGE,
                Color.PURPLE, Color.VIOLET, Color.ROSE, Color.YELLOW, Color.GOLDEN, Color.RED)));
        map.put(Orchid.class, new ArrayList<>(Arrays.asList(Color.BLACK, Color.WHITE, Color.CRIMSON,
                Color.ROSE, Color.YELLOW, Color.RED)));
        map.put(Rose.class, new ArrayList<>(Arrays.asList(Color.WHITE, Color.CRIMSON,
                Color.ROSE, Color.YELLOW, Color.GOLDEN, Color.RED)));
        map.put(Tulip.class, new ArrayList<>(Arrays.asList(Color.BLACK, Color.WHITE, Color.ORANGE,
                Color.ROSE, Color.YELLOW, Color.RED)));
    }

    protected static boolean checkInDictionary(Flower flower, Color color) {
        if (map.containsKey(flower.getClass())) {
            if (map.get(flower.getClass()).contains(color))
                return true;
        } else if (flower instanceof Flower) {
            if (map.get(Flower.class).contains(color))
                return true;
        }
        System.out.println("There is no " + flower.getClass().getSimpleName().toLowerCase() + " with such color, please choose other color");
        return false;
    }

    public static Color calcAllowedColor(Flower flower) {
        if (map.containsKey(flower.getClass())) {
            int colorIndex = (int) (Math.random() * map.get(flower.getClass()).size());
            return map.get(flower.getClass()).get(colorIndex);
        } else if (flower instanceof Flower) {
            int colorIndex = (int) (Math.random() * map.get(Flower.class).size());
            return map.get(Flower.class).get(colorIndex);
        }
        return null;
    }

    public static Map<Class, List<Color>> getMap() {
        return map;
    }
}
