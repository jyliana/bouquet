package main;

import flowers.Accessories;
import flowers.Color;
import flowers.Flower;
import flowers.FlowerSetting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Pattern;

public class FlowerGirl {
    String[] listOfFlowers = {"Camomile", "Chrysanthemum", "Lavender", "Poppy", "Tulip", "Violet", "Lily", "Orchid", "Rose", "Lotus"};
    String[] listOfWildFlowers = {"Camomile", "Chrysanthemum", "Lavender", "Poppy", "Tulip", "Violet"};
    String[] listOfDecorativeFlowers = {"Lily", "Orchid", "Rose", "Lotus"};

    Pattern pattern = Pattern.compile(".*[^0-9+].*");

    public Bouquet makeRequiredBouquet() throws Exception {
        ArrayList<Accessories> accessories = new ArrayList<>(Arrays.asList(Accessories.ORGANZA, Accessories.DECORATIVE_BUTTERFLY, Accessories.CRYSTALS, Accessories.FEATHERS, Accessories.GREENERY));
        ArrayList<Flower> flowers = new ArrayList<>();
        Bouquet bouquet = null;
        Flower flower = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter a number of flowers for a bouquet:");
        int flowers_number = 0;
        while (!(flowers_number > 0)) {
            try {
                flowers_number = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                System.out.println("Please enter correct number:");
            }
        }

        System.out.println("Please enter needed flower or click any key for random choice:");
        String flower_tmp = reader.readLine();
        int in_flower = -1;
        System.out.println("Please enter needed color or click any key for random choice:");
        Color color;
        try {
            color = Color.valueOf(reader.readLine().toUpperCase());
        } catch (Exception e) {
            color = null;
        }

        if (!pattern.matcher(flower_tmp).matches() && !flower_tmp.isEmpty()) {
            in_flower = Integer.parseInt(flower_tmp);
            while (in_flower > 10 && in_flower < 0) {
                System.out.println("Please choose correct flower:");
                in_flower = Integer.parseInt(reader.readLine());
            }
            if (color != null) {
                while (!FlowerSetting.checkAllowedColor(listOfFlowers[in_flower], color)) {
                    System.out.println("Please enter correct color for this flower or \"Enter\" for random color:");
                    String line = reader.readLine();
                    if (line.isEmpty()) {
                        color = null;
                        break;
                    } else
                        color = Color.valueOf(line.toUpperCase());
                }
            }
        }

        while (flowers.size() < flowers_number) {
            if (pattern.matcher(flower_tmp).matches() || flower_tmp.isEmpty()) {
                in_flower = (int) (Math.random() * 10);
            }
            if (color != null) {
                if (FlowerSetting.checkAllowedColor(listOfFlowers[in_flower], color))
                    flower = createFlower(in_flower, color);
            } else flower = createFlower(in_flower, color);

            if (flower != null) {
                flowers.add(flower);
            }
        }

        if (bouquet == null) {
            bouquet = new Bouquet(flowers, accessories);
        } else {
            bouquet.getFlowers().addAll(flowers);
        }
        bouquet.printBouquet();
        return bouquet;
    }

    public Bouquet makeWildBouquet() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ArrayList<Flower> flowers = new ArrayList<>();
        ArrayList<Accessories> accessories = new ArrayList<>(Arrays.asList(Accessories.DECORATIVE_PAPER, Accessories.RIBBONS, Accessories.FEATHERS, Accessories.GREENERY));
        for (int i = 0; i < (int) (Math.random() * 11 + 3); i++) {
            int tmp = (int) (Math.random() * listOfWildFlowers.length);
            flowers.add(createFlowerByClassName(listOfWildFlowers[tmp], null));
        }
        Bouquet bouquet = new Bouquet(flowers, accessories);
        bouquet.printBouquet();
        return bouquet;
    }

    public Bouquet makeDecorativeBouquet() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ArrayList<Flower> flowers = new ArrayList<>();
        ArrayList<Accessories> accessories = new ArrayList<>(Arrays.asList(Accessories.ORGANZA, Accessories.CRYSTALS, Accessories.FEATHERS));

        for (int i = 0; i < (int) (Math.random() * 11 + 3); i++) {
            int tmp = (int) (Math.random() * listOfDecorativeFlowers.length);
            flowers.add(createFlowerByClassName(listOfDecorativeFlowers[tmp], null));
        }
        Bouquet bouquet = new Bouquet(flowers, accessories);
        bouquet.printBouquet();
        return bouquet;
    }

    public void sortFlowers(Bouquet bouquet) {
        Collections.sort(bouquet.getFlowers(), new Comparator<Flower>() {
            public int compare(Flower o1, Flower o2) {
                if ((o1.getFreshness().ordinal() + 1) - (o2.getFreshness().ordinal() + 1) > 0) return 1;
                else return -1;
            }
        });

        System.out.println("\n" + "To sort flowers by their freshness:");
        for (Flower element : bouquet.getFlowers()) {
            System.out.println(element.getClass().getSimpleName() + " is " + element.getColor().toString().toLowerCase() + ", its stem length is " + element.stemLength + "cm, " + element.getFreshness().toString().toLowerCase().replace("_", " ") + " and costs " + element.getCost() + " hrn.");
        }
    }

    public void findFlower(Bouquet bouquet) throws IOException {
        ArrayList<Flower> flowers = new ArrayList<>();
        Bouquet newBouquet = new Bouquet(flowers, null);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter lower value of the range");
        int start = Integer.parseInt(reader.readLine());
        System.out.println("Enter upper limit of the range");
        int end = Integer.parseInt(reader.readLine());

        for (Flower element : bouquet.getFlowers()) {
            if (element.stemLength >= start && element.stemLength <= end)
                flowers.add(element);
        }
        newBouquet.printBouquet();
    }

    Flower createFlowerByClassName(String strName, Color color) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String receivedName = Flower.class.getPackage().getName() + "." + strName;
        if (color == null) {
            return (Flower) Class.forName(receivedName).getConstructors()[0].newInstance();
        }
        return (Flower) Class.forName(receivedName).getConstructors()[1].newInstance(color);
    }

    public Flower createFlower(int flowerKey, Color color) throws Exception {
        Flower flower;
        flower = createFlowerByClassName(listOfFlowers[flowerKey], color);
        return flower;
    }
}