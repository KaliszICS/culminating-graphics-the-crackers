package ItemSystem;
import java.util.Random;

public class Bread extends Item {
    
    private int HP;
    
    public Bread(String name){
        super(name);
    }

    public String Item(String name){
        this.name = name;
        return name;
        //this.quantity = quantity;
    }

    public void Heal(int HP){
        this.HP = HP;
        System.out.println(HP);
    }

    public void Damage(int Damage){
        System.out.println(Damage);
    }

    public int eatBread(int Heal, int Damage){
            Random r = newRandom();
            int z = rnd.nextInt(100);
            int odds = 0;

            odds += 75;
            if (z < odds){
                eventA();
                return Heal;
            }
            odds += 25;
            if (z < odds) {
                eventB();
                return Damage;
            }
        }
        
        public int attackBread(int Heal, int Damage){
            int z = rnd.nextInt(100);
            int odds = 0;

            odds += 75;
            if (z < odds){
                
                return Heal;
            }
            odds += 25;
            if (z < odds) {
                return Damage;
            }
        }
        

    @Override
    public String toString(){
        return this.name;
        return this.HP;
    }
}