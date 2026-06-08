package ItemSystem;
import java.util.Random;

public class Bread extends Item {
    
    protected int HP;
    protected int Damage;
    protected String name;
    
    public Bread(String name){
        super(name);
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

    public void eatBread(int Heal, int Damage){
            int z = rnd.nextInt(100);
            int odds = 0;

            odds += 75;
            if (z < odds){
                System.out.println("This bread is GOOD BREAD!");
                System.out.println("You have gained" + HP + "HP");
            }
            odds += 25;
            if (z < odds) {
                System.out.println("This bread is MOLDY BREAD...");
                System.out.println("You have gained" + Damage + "HP");
            }
        }
        
    public void attackBread(int Heal, int Damage){
            int z = rnd.nextInt(100);
            int odds = 0;

            odds += 75;
            if (z < odds){
                System.out.println("This bread is GOOD BREAD! The boss gains HP.");
                System.out.println("The boss gained" + HP + "HP");
            }
            odds += 25;
            if (z < odds) {
                System.out.println("This bread is MOLDY BREAD...");
                System.out.println("You have dealt" + Damage + "HP");            
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