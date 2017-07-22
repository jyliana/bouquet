package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FlowerGirl flowerGirl = new FlowerGirl();
        Bouquet bouquet = null;
        int choice;
        boolean quit = false;
        printMenu();
        while (!quit) {
            choice = Integer.parseInt(reader.readLine());
            switch (choice) {
                case 0: {
                    System.out.println("Exiting");
                    quit = true;
                    break;
                }
                case 1: {
                    System.out.println("Please enter a number of flowers for a bouquet:");
                    int flowers_number = 0;
                    while (!(flowers_number > 0)) {
                        try {
                            flowers_number = Integer.parseInt(reader.readLine());
                        } catch (Exception e) {
                            System.out.println("Please enter correct number:");
                        }
                    }
                    bouquet = flowerGirl.makeRequiredBouquet(flowers_number);
                    break;
                }
                case 2: {
                    bouquet = flowerGirl.makeWildBouquet();
                    break;
                }
                case 3: {
                    bouquet = flowerGirl.makeDecorativeBouquet();
                    break;
                }
                case 4: {
                    flowerGirl.takeOrderDetails();
                    if (flowerGirl.addFlower(bouquet))
                        System.out.println("The flower was added to the bouquet");
                    else System.out.println("The flower was added to the bouquet, something was wrong.");
                    break;
                }

                case 5: {
                    if (bouquet == null)
                        System.out.println("Please order a bouquet first.");
                    else
                        System.out.println("The total bouquet's cost: " + new DecimalFormat("#,##0.00").format(bouquet.calcTotalCost()) + " hrn.");
                    break;
                }
                case 6: {
                    if (bouquet == null)
                        System.out.println("Please order a bouquet first.");
                    else
                        flowerGirl.sortFlowers(bouquet);
                    break;
                }
                case 7: {
                    if (bouquet == null)
                        System.out.println("Please order a bouquet first.");
                    else
                        flowerGirl.findFlowersWithStemLength(bouquet);
                    break;
                }
                case 8: {
                    if (bouquet == null)
                        System.out.println("Please order a bouquet first.");
                    else
                        bouquet.printBouquet();
                    break;
                }
                case 9: {
                    printMenu();
                    break;
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available options:");
        System.out.println("0: to quit\n" +
                "1: make random bouquet or bouquet with needed color from required flowers\n" +
                "2: make bouquet from wild flowers\n" +
                "3: make bouquet from decorative flowers\n" +
                "4: add a flower to the bouquet\n" +
                "5: get total cost of the bouquet\n" +
                "6: sort flowers by their freshness\n" +
                "7: find flowers with required stem length\n" +
                "8: print the order\n" +
                "9: print menu");
    }
}
