package ItemSystem;

import CharacterSystem.Player;

//could be interface tbf
public class Item {
    protected String name;
    protected String description;
    //private int quantity;
    
    public Item(String name){
        this.name = name;
        //this.quantity = quantity;
    }

    @Override
    public String toString(){
        return this.name;
    }

    public String returnName() {
        throw new UnsupportedOperationException("Unimplemented method 'returnName'");
    }
    

    public void use(Player p){
        //generic item use
        p.getInventory().getItems().remove(this);
    }
}
