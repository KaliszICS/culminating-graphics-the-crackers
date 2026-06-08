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
            Random random = new Random();
            double moldy = 0.25;

            if (random.nextDouble() > moldy){
                System.out.println("This bread is GOOD BREAD!");
                System.out.println("You have gained" + HP + "HP");
            }
            if (random.nextDouble() < moldy) {
                System.out.println("This bread is MOLDY BREAD...");
                System.out.println("You have lost" + Damage + "HP");
            }
        }
        
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