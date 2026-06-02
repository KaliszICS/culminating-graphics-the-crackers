package ItemSystem;

import java.util.ArrayList;

public class Inventory {
    private int size;
    private ArrayList<Item> inv;

    public Inventory(int size){
        this.inv = new ArrayList<>();
        this.size = size;
    }  
    
    //GettersSetters
    public ArrayList<Item> getInv(){
        return this.inv;
    }

    public int size(){
        return this.size;
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
        if(this.inv.size() >= this.size){
            this.inv.add(item);
        }

        
    }
}
