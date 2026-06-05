package ItemSystem;

public class Bread extends Item {
    
    public Bread(String name){
        super(name);
    }

    public Item(String name){
        this.name = name;
        System.out.println(name);
        //this.quantity = quantity;
    }

    public Heal(int HP){
        this.HP = HP;
        System.out.println(HP);
    }

    public Damage(int Damage){
        this.Damage = Damage;
        System.out.println(Damage);
    }

    public eatBread(int Heal, int Damage, String eat){
        if (Player == eat) {
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
            this.inv.remove(Bread);
        }
    }

    @Override
    public String toString(){
        return this.name;
        return this.HP;
    }
}