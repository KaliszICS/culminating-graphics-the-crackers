package ItemSystem;
import java.util.Scanner;
import java.util.ArrayList;

/**
     * Class for the inventory
     * @author Dorian Goobie
     * @param inv
     * @param i
     */

public class Inventory {
    private ArrayList<Item> inv;

    public Inventory(){
        this.inv = new ArrayList<>();
    }  

    //Getters
    public ArrayList<Item> getItems(){
        return this.inv;
    }
    
    public boolean hasItem(Item i){
        return this.inv.contains(i);
    }

    /**
     * Methods for if the player wants to use, remove, or add an item to the inventory
     */
    public void consume(Item item){
        this.inv.remove(item);
    }

    public void discard(Item item){
        this.inv.remove(item);
    }

    public void add(Item item){
        this.inv.add(item);
    }

    /**
     * Method that searches for an item in the player's inventory
     */
    
    public static void InventorySearch(String[] Inventory, String item){
        Scanner input = new Scanner(System.in);
        System.out.println("Which item would you like to use?");
        input.nextLine();
        if (input == contains(Inventory)) {
            for (int i = 0; i < Inventory.length; i++) {
                if (Inventory[i] == item) {
                    System.out.println("You have chosen " + item);
                }
            }
        }
        input.close();
    }

    private static Scanner contains(String[] inventory) {
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }
}