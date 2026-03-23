package org;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {

    public static int costOfItem(int quantity, int price){
        return quantity * price;
    }

    public static int totalCost(ArrayList<Integer> list){
        int sum = 0;
        for (int cost: list){
            sum+=cost;
        }
        return sum;
    }

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose your preferred language (en,fi,ja,se): ");
        String input = scanner.nextLine();
        Locale locale;
        switch (input) {
            case "fi":
                locale = new Locale("fi", "FI");
                break;
            case "sv":
                locale = new Locale("sv", "SE");
                break;
            case "ja":
                locale = new Locale("ja", "JP");
                break;
            default:
                locale = new Locale("en", "US");
        }
        ResourceBundle bundle = ResourceBundle.getBundle("MessagesBundle", locale);
        System.out.print(bundle.getString("numberOfItems"));
        int numberOfItems = scanner.nextInt();
        ArrayList<Integer> costs = new ArrayList<>();
        for (int i=0; i<numberOfItems; i++){
            System.out.print(bundle.getString("itemPrice"));
            int price = scanner.nextInt();
            System.out.print(bundle.getString("itemQuantity"));
            int quantity = scanner.nextInt();
            costs.add(costOfItem(price, quantity));
        }

        int totalCost = totalCost(costs);
        System.out.println(bundle.getString("totalCost")+totalCost);

    }
}
