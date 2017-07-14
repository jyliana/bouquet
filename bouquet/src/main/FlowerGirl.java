package main;

import flowers.Accessories;
import flowers.Color;
import flowers.Flower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.regex.Pattern;

public class FlowerGirl {
    static HashMap<Integer, String> listOfFlowers = new HashMap<>();

    static {
        listOfFlowers.put(0, "Camomile");
        listOfFlowers.put(1, "Chrysanthemum");
        listOfFlowers.put(2, "Lavender");
        listOfFlowers.put(3, "Lily");
        listOfFlowers.put(4, "Lotus");
        listOfFlowers.put(5, "Orchid");
        listOfFlowers.put(6, "Poppy");
        listOfFlowers.put(7, "Rose");
        listOfFlowers.put(8, "Tulip");
        listOfFlowers.put(9, "Violet");
    }

    Pattern pattern = Pattern.compile(".*[^0-9+].*");

    public Bouquet makeRequiredBouquet() throws Exception {
        ArrayList<Accessories> accessories = new ArrayList<>();
        accessories.add(Accessories.ORGANZA);
        accessories.add(Accessories.DECORATIVE_BUTTERFLY);
        accessories.add(Accessories.CRYSTALS);
        accessories.add(Accessories.FEATHERS);
        accessories.add(Accessories.GREENERY);

        ArrayList<Flower> flowers = new ArrayList<>();
        Bouquet bouquet = null;
        Flower flower;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter a number for multiple bouquets or \"Enter\" for default one bouquet:");
        int number = 0;
        while (number <= 0) {
            try {
                String number_tmp = reader.readLine();
                if (number_tmp.isEmpty())
                    number = 1;
                else number = Integer.parseInt(number_tmp);
            } catch (Exception e) {
                System.out.println("Please enter correct number:");
            }
        }
        System.out.println("Please enter a number of flowers for a bouquet:");
        int flowers_number = 0;
        while (!(flowers_number > 0)) {
            try {
                flowers_number = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                System.out.println("Please enter correct number:");
            }
        }

        for (int i = 0; i < number; i++) {
            System.out.println("Please enter needed flower or click \"Enter\" for random choice:");
            String flower_tmp = reader.readLine();
            int in_flower = 0;
            if (!pattern.matcher(flower_tmp).matches() && !flower_tmp.isEmpty()) {
                in_flower = Integer.parseInt(flower_tmp);
                while (in_flower > 10 && in_flower < 0) {
                    System.out.println("Please choose correct flower:");
                    in_flower = Integer.parseInt(reader.readLine());
                }
            }
            System.out.println("Please enter needed color or click \"Enter\" for random choice:");
            Color color;
            try {
                color = Color.valueOf(reader.readLine().toUpperCase());
            } catch (Exception e) {
                color = null;
            }

            if (flower_tmp.isEmpty()) {
                while (flowers.size() < flowers_number) {
                    int tmp = (int) (Math.random() * 10);
                    flower = createFlowerByClassName(listOfFlowers.get(tmp), color);
                    if (!(flower == null))
                        flowers.add(flower);
                }
            } else {
                while (flowers.size() < flowers_number) {
                    flower = createFlower(in_flower, color);
                    while (flower == null) {
                        System.out.println("Please enter correct color for this flower:");
                        color = Color.valueOf(reader.readLine().toUpperCase());
                        flower = createFlower(in_flower, color);
                    }
                    flowers.add(flower);
                }
            }
            if (bouquet == null) {
                bouquet = new Bouquet(flowers, accessories);
                flowers = new ArrayList<>();
            } else {
                bouquet.getFlowers().addAll(flowers);
                flowers = new ArrayList<>();
            }
        }
        System.out.println("\nPlease, take a bouquet from " + bouquet.getFlowers().size() + " flowers:");
        bouquet.printBouquet();
        return bouquet;
    }

    public Bouquet makeWildBouquet() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ArrayList<Flower> flowers = new ArrayList<>();
        ArrayList<Accessories> accessories = new ArrayList<>();
        accessories.add(Accessories.DECORATIVE_PAPER);
        accessories.add(Accessories.RIBBONS);
        accessories.add(Accessories.FEATHERS);
        accessories.add(Accessories.GREENERY);

        listOfFlowers.clear();
        listOfFlowers.put(0, "Camomile");
        listOfFlowers.put(1, "Chrysanthemum");
        listOfFlowers.put(2, "Lavender");
        listOfFlowers.put(3, "Poppy");
        listOfFlowers.put(4, "Tulip");
        listOfFlowers.put(5, "Violet");
        for (int i = 0; i < (int) (Math.random() * 11 + 3); i++) {
            int tmp = (int) (Math.random() * listOfFlowers.size());
            flowers.add(createFlowerByClassName(listOfFlowers.get(tmp), null));
        }
        Bouquet bouquet = new Bouquet(flowers, accessories);
        System.out.println("\nPlease, take a bouquet from " + flowers.size() + " wild flowers:");
        bouquet.printBouquet();
        return bouquet;
    }

    public Bouquet makeDecorativeBouquet() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ArrayList<Flower> flowers = new ArrayList<>();
        ArrayList<Accessories> accessories = new ArrayList<>();
        accessories.add(Accessories.ORGANZA);
        accessories.add(Accessories.CRYSTALS);
        accessories.add(Accessories.FEATHERS);
        listOfFlowers.clear();
        listOfFlowers.put(0, "Lily");
        listOfFlowers.put(1, "Orchid");
        listOfFlowers.put(2, "Rose");
        listOfFlowers.put(3, "Lotus");

        for (int i = 0; i < (int) (Math.random() * 11 + 3); i++) {
            int tmp = (int) (Math.random() * listOfFlowers.size());
            flowers.add(createFlowerByClassName(listOfFlowers.get(tmp), null));
        }
        Bouquet bouquet = new Bouquet(flowers, accessories);
        System.out.println("\nPlease, take a bouquet from " + flowers.size() + " decorative flowers:");
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
        /*String receivedName = Flower.class.getPackage().getName() + "." + listOfFlowers.get(flowerKey);*/
        flower = createFlowerByClassName(listOfFlowers.get(flowerKey), color);
        return flower;
    }
}