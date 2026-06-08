package ItemSystem;

public class HealingItem extends Item {
    //private int quantity;
    private int HP;

    public HealingItem(String name){
        super(name);
    }

    public String Item(String name){
        this.name = name;
        return this.name;
    }

    public int Heal(int HP){
        this.HP = HP;
        return this.HP;
    }

    @Override
    public String toString(){
        return this.name;
    }
    public int returnHP() {
        return this.HP;
    }
}