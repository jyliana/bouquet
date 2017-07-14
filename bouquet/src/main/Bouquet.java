package main;

import flowers.Accessories;
import flowers.Flower;

import java.util.ArrayList;

public class Bouquet {
    private ArrayList<Flower> flowers;
    private ArrayList<Accessories> accessories;

    public Bouquet(ArrayList<Flower> flowers, ArrayList<Accessories> accessories) {
        this.flowers = flowers;
        this.accessories = accessories;
    }

    public ArrayList<Flower> getFlowers() {
        return flowers;
    }

    public ArrayList<Accessories> getAccessories() {
        return accessories;
    }

    public double getTotalCost() {
        double total = 0;
        for (Flower element : getFlowers()) {
            total += element.getCost();
        }
        for (Accessories element : getAccessories()) {
            total += element.getCost();
        }
        return total;
    }

    public void printBouquet() {
        System.out.println("\nPlease, take a bouquet from " + flowers.size() + " flowers:");
        for (Flower element : getFlowers()) {
            System.out.println(element.getClass().getSimpleName() + " is " + element.getColor().toString().toLowerCase() + ", its stem length is " + element.stemLength + " cm, " + element.getFreshness().toString().toLowerCase().replace("_", " ") + " and costs " + element.getCost() + " hrn.");
        }
        if (getAccessories() != null) {
            System.out.println("\nThe bouquet has the next accessories:");
            for (Accessories element : getAccessories()) {
                System.out.println(element.toString().toLowerCase().replaceAll("_", " "));
            }
        }
    }
}
