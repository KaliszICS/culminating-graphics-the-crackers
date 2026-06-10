package ItemSystem.Items;
import java.util.Random;

import CharacterSystem.Player;
import ItemSystem.Item;

/**
     * Class for bread
     * @author Dorian Goobie
     * @param HP
     * @param Damage
     * @param name
     */
public class Bread extends Item {
    
    protected int HP;
    protected int Damage;
    
    public Bread(String name, int HP, int damage){
        super(name);
        this.HP = HP;
        this.Damage = damage;
    }

    public String Item(String name){
        this.name = name;
        return name;
    }

    public int Heal(int HP){
        this.HP = HP;
        return HP;
    }

    public int Damage(int Damage){
        this.Damage = Damage;
        return Damage;
    }

    @Override
    public void use(Player p){
            Random random = new Random();
            double moldy = 0.25;

            //hilariously uncharacteristic of bread, i will call this suspicious bread
            if (random.nextDouble() > moldy){
                System.out.println("This bread is GOOD BREAD!");
                System.out.println("You have gained" + HP + "HP");
                p.heal(HP); 
            }
            if (random.nextDouble() < moldy) {
                System.out.println("This bread is MOLDY BREAD...");
                System.out.println("You have lost" + Damage + "HP");
                p.takeDamage(Damage);
            }

            p.getInventory().getItems().remove(this);
        }
        
    /**
     * Use the bread to attack the boss, but the boss can lose or gain health
     * @param random
     * @param moldy
     */
    public void attackBread(int Heal, int Damage){
            Random random = new Random();
            double moldy = 0.25;

            if (random.nextDouble() > moldy){
                System.out.println("This bread is GOOD BREAD!");
                System.out.println("The boss has gained" + HP + "HP");
            }
            if (random.nextDouble() < moldy) {
                System.out.println("This bread is MOLDY BREAD...");
                System.out.println("The boss has lost" + Damage + "HP");
            }
        }
        
    @Override
    public String toString(){
        return this.name;
    }
    public int returnHP() {
        return this.HP;
    }
    public int returnDamage() {
        return this.Damage;
    }
}