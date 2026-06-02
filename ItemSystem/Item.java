package ItemSystem;


//could be interface tbf
public class Item {
    private String name;
    //private int quantity;
    
    public Item(String name){
        this.name = name;
        //this.quantity = quantity;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
