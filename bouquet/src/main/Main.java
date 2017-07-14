package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FlowerGirl flowerGirl = new FlowerGirl();
        Bouquet bouquet = null;
        String choice = "";


        while (!choice.equals("e")) {
            System.out.println("Choose one of the next options:");
            System.out.println("0: make random bouquet or bouquet with needed color from required flowers");
            System.out.println("1: make bouquet from wild flowers");
            System.out.println("2: make bouquet from decorative flowers");
            System.out.println("3: get total cost of the bouquet");
            System.out.println("4: sort flowers by their freshness");
            System.out.println("5: find flowers with required stem length");
            System.out.println("6: print order");

            System.out.println("e: exit");
            System.out.println("Enter your choice: ");
            choice = reader.readLine();
            switch (choice) {
                case "0": {
                    bouquet = flowerGirl.makeRequiredBouquet();
                    break;
                }
                case "1": {
                    bouquet = flowerGirl.makeWildBouquet();
                    break;
                }
                case "2": {
                    bouquet = flowerGirl.makeDecorativeBouquet();
                    break;
                }
                case "3": {
                    if (bouquet == null)
                        System.out.println("Please order a bouquet first.");
                    else
                        System.out.println("The total bouquet's cost: " + new DecimalFormat("#,##0.00").format(bouquet.getTotalCost()) + " hrn.");
                    break;
                }
                case "4": {
                    if (bouquet == null)
                        System.out.println("Please order a bouquet first.");
                    else
                        flowerGirl.sortFlowers(bouquet);
                    break;
                }
                case "5": {
                    if (bouquet == null)
                        System.out.println("Please order a bouquet first.");
                    else
                        flowerGirl.findFlower(bouquet);
                    break;
                }
                case "6": {
                    if (bouquet == null)
                        System.out.println("Please order a bouquet first.");
                    else
                        bouquet.printBouquet();
                    break;
                }
            }
        }
    }
}
