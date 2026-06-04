package ItemSystem;

public class HealingItem extends Item {
    //private int quantity;
    
    public HealingItem(String name){
        super(name);
    }

    public Item(String name){
        this.name = name;
        System.out.println(name);
        //this.quantity = quantity;
    }

    public Heal(int HP){
        this.HP = HP;
        system.out.println(HP);
    }

    @Override
    public String toString(){
        return this.name;
        return this.HP;
    }
}