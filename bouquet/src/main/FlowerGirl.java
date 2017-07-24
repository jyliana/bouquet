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
    private final String[] listOfFlowers = {"Camomile", "Chrysanthemum", "Lavender", "Lily", "Lotus", "Orchid", "Poppy", "Rose", "Tulip", "Violet"};
    private final String[] listOfWildFlowers = {"Camomile", "Chrysanthemum", "Lavender", "Poppy", "Tulip", "Violet"};
    private final String[] listOfDecorativeFlowers = {"Lily", "Orchid", "Rose", "Lotus"};
    private Pattern pattern = Pattern.compile(".*[^0-9+].*");
    private Color color;
    private int int_flower;
    private boolean isRandomFlower;
    private boolean isRandomColor;
    private ArrayList<Flower> flowers;

    protected void takeOrderDetails() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter needed flower or click any key for random choice:");
        printListOfAvailableFlowers();
        String flower_tmp = reader.readLine();

        if (!pattern.matcher(flower_tmp).matches() && !flower_tmp.isEmpty()) {
            int_flower = Integer.parseInt(flower_tmp);
            isRandomFlower = false;
            while (int_flower > listOfFlowers.length || int_flower < 0) {
                System.out.println("Please choose correct flower:");
                int_flower = Integer.parseInt(reader.readLine());
            }
            System.out.println("Please enter needed color or click any key for random choice:");
            try {
                color = Color.valueOf(reader.readLine().toUpperCase());
            } catch (Exception e) {
                color = null;
                isRandomColor = true;
            }
            if (color != null) {
                while (!FlowerSetting.checkAllowedColor(listOfFlowers[int_flower], color)) {
                    System.out.println("Please enter correct color for this flower or \"Enter\" for random color:");
                    String line = reader.readLine();
                    if (line.isEmpty()) {
                        color = null;
                        break;
                    } else
                        color = Color.valueOf(line.toUpperCase());
                }
            }
        } else isRandomFlower = true;
    }

    protected boolean addAccessories(Bouquet bouquet) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Accessories> listOfAccessories = new ArrayList<>(Arrays.asList(Accessories.values()));
        Accessories newAccessory;

        System.out.println("Please enter needed accessories:");
        for (int i = 0; i < listOfAccessories.size(); i++) {
            System.out.println(i + " - " + listOfAccessories.get(i).toString().toLowerCase());
        }
        String accessories_tmp = reader.readLine();
        int int_accessory;
        if (!pattern.matcher(accessories_tmp).matches() && !accessories_tmp.isEmpty()) {
            int_accessory = Integer.parseInt(accessories_tmp);
            while (int_accessory > listOfAccessories.size() || int_accessory < 0) {
                System.out.println("Please enter correct number for an accessory");
                int_accessory = Integer.parseInt(reader.readLine());
            }
            newAccessory = listOfAccessories.get(int_accessory);
            if (!bouquet.getAccessories().contains(newAccessory)) {
                bouquet.getAccessories().add(newAccessory);
                System.out.println("The accessory " + newAccessory.toString().toLowerCase() + " was added to the bouquet");
                return true;
            } else System.out.println("The bouquet has already contains " + newAccessory.toString().toLowerCase());
        }
        return false;
    }

    protected boolean addFlower(Bouquet bouquet) throws Exception {
        Flower flower = null;

        if (isRandomFlower) {
            int_flower = (int) (Math.random() * listOfFlowers.length);
        }

        boolean willCreate = (isRandomColor) ||
                ((!isRandomColor) && FlowerSetting.checkAllowedColor(listOfFlowers[int_flower], color));
        if (willCreate) {
            flower = createFlower(int_flower, color);
            flowers.add(flower);
            return true;
        }
        return false;
    }

    protected Bouquet makeRequiredBouquet(int flowers_number) throws Exception {
        ArrayList<Accessories> accessories = new ArrayList<>(Arrays.asList(Accessories.ORGANZA, Accessories.DECORATIVE_BUTTERFLY, Accessories.CRYSTALS, Accessories.FEATHERS, Accessories.GREENERY));
        flowers = new ArrayList<>();
        Bouquet bouquet = null;

        takeOrderDetails();
        while (flowers.size() < flowers_number) {
            addFlower(bouquet);
        }

        if (bouquet == null) {
            bouquet = new Bouquet(flowers, accessories);
        } else {
            bouquet.getFlowers().addAll(flowers);
        }
        bouquet.print();
        return bouquet;
    }

    protected Bouquet makeWildBouquet() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        flowers = new ArrayList<>();
        ArrayList<Accessories> accessories = new ArrayList<>(Arrays.asList(Accessories.DECORATIVE_PAPER, Accessories.RIBBONS, Accessories.FEATHERS, Accessories.GREENERY));
        for (int i = 0; i < (int) (Math.random() * 11 + 3); i++) {
            int tmp = (int) (Math.random() * listOfWildFlowers.length);
            flowers.add(createFlowerByClassName(listOfWildFlowers[tmp], null));
        }
        Bouquet bouquet = new Bouquet(flowers, accessories);
        bouquet.print();
        return bouquet;
    }

    protected Bouquet makeDecorativeBouquet() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        flowers = new ArrayList<>();
        ArrayList<Accessories> accessories = new ArrayList<>(Arrays.asList(Accessories.ORGANZA, Accessories.CRYSTALS, Accessories.FEATHERS));

        for (int i = 0; i < (int) (Math.random() * 11 + 3); i++) {
            int tmp = (int) (Math.random() * listOfDecorativeFlowers.length);
            flowers.add(createFlowerByClassName(listOfDecorativeFlowers[tmp], null));
        }
        Bouquet bouquet = new Bouquet(flowers, accessories);
        bouquet.print();
        return bouquet;
    }

    protected void sortFlowers(Bouquet bouquet) {
        Collections.sort(bouquet.getFlowers(), new Comparator<Flower>() {
            public int compare(Flower o1, Flower o2) {
                if ((o1.getFreshness().ordinal() + 1) - (o2.getFreshness().ordinal() + 1) > 0) return 1;
                else return -1;
            }
        });

        System.out.println("\n" + "To sort flowers by their freshness:");
        for (Flower element : bouquet.getFlowers()) {
            System.out.println(element.getClass().getSimpleName() + " is " + element.getColor().toString().toLowerCase() + ", its stem length is " + element.getStemLength() + "cm, " + element.getFreshness().toString().toLowerCase().replace("_", " ") + " and costs " + element.getCost() + " hrn.");
        }
    }

    protected void findFlowersWithStemLength(Bouquet bouquet) throws IOException {
        flowers = new ArrayList<>();
        Bouquet newBouquet = new Bouquet(flowers, null);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter lower value of the range");
        int start = Integer.parseInt(reader.readLine());
        System.out.println("Enter upper limit of the range");
        int end = Integer.parseInt(reader.readLine());

        for (Flower element : bouquet.getFlowers()) {
            if (element.getStemLength() >= start && element.getStemLength() <= end)
                flowers.add(element);
        }
        newBouquet.print();
    }

    protected Flower createFlowerByClassName(String strName, Color color) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String receivedName = Flower.class.getPackage().getName() + "." + strName;
        if (color == null) {
            return (Flower) Class.forName(receivedName).getConstructors()[0].newInstance();
        }
        return (Flower) Class.forName(receivedName).getConstructors()[1].newInstance(color);
    }

    protected Flower createFlower(int flowerKey, Color color) throws Exception {
        Flower flower;
        flower = createFlowerByClassName(listOfFlowers[flowerKey], color);
        return flower;
    }

    private void printListOfAvailableFlowers() {
        for (int i = 0; i < listOfFlowers.length; i++) {
            System.out.println(i + " - " + listOfFlowers[i]);
        }
    }
}