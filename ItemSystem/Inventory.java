package ItemSystem;

import java.util.ArrayList;

public class Inventory {
    private int size;
    private ArrayList<Item> inv;

    public Inventory(int size){
        this.inv = new ArrayList<>();
        this.size = size;
    }  

    //Getters
    public ArrayList<Item> getInv(){
        return this.inv;
    }

    public int size(){
        return this.size;
    }

    public boolean hasItem(Item i){
        return this.inv.contains(i);
    }

    //Setters
    public void setSize(int size){
        //probably will go unused
        this.size = size;
    }


    //Methods
    public void consume(Item item){
        //Add some logic here


        this.inv.remove(item);
    }

    public void discard(Item item){
        this.inv.remove(item);
    }

    public void add(Item item){
        if(this.inv.size() < this.size){
            this.inv.add(item);
        }
    }

    //DEBUGGING
    public static void main(String[] args){
        Inventory i = new Inventory(4);
        Item it = new Item("Bread");
        i.add(it);
        i.add(it);
        i.add(it);
        i.add(it);
        i.add(it);

        System.out.println(i.getInv().toString());

        i.discard(it);
        i.consume(it);
        System.out.println(i.getInv().toString());

    }
}
