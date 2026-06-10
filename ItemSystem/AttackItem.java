package ItemSystem;

    /**
     * Class for attack items
     * @author Dorian Goobie
     * @param Damage
     * @param name
     */

public class AttackItem extends Item {

    protected int Damage;
    protected String name;

    public AttackItem(String name){
        super(name);
    }
    
    /**
     * Methods describing the name and damage of the item
     */
    
    public String Item(String name){
        super.name = name;
        return name;
        //this.quantity = quantity;
    }

    public int Damage(int Damage){
        this.Damage = Damage;
        return Damage;
    }

    @Override
    public String toString(){
        return this.name;
    }
    
    public int returnDamage() {
        return this.Damage;
    }
}