import java.util.Scanner;
import java.util.Random;


/** Manages turn-based combat between a Player and a Boss. 
 * @param <Sword>
 * @param <MagicWand>
 * @param <PowerFist>
 * @param <GoodBread>
 * @param <MoldyBread>
 * @param <ActionMenu>*
 */
    public class BattleSystem {

abstract class Item {
    protected String name;
    protected String description;
    public int quantity;

    public Item(String name, String description, int quantity) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    public String getName() { 
        return name; 
    }
}

class Sword extends Item {
    private int damage;
    private double critChance;

    public Sword(String name, int damage, String description, double critChance) {
        super(name, description, 1);
        this.damage = damage;
        this.critChance = critChance;
    }

    public int getDamage() {
         return damage; 
        }
    public double getCritChance() {
         return critChance; 
        }
}

class MagicWand extends Item {
    private int damage, heal, mpCost;

    public MagicWand(String name, int damage, int heal, int mpCost, String description) {
        super(name, description, 1);
        this.damage = damage;
        this.heal = heal;
        this.mpCost = mpCost;
    }

    public int getDamage() {
         return damage; 
        }
    public int getHeal() {
         return heal; 
        }
    public int getMpCost() {
         return mpCost; 
        }
}

class PowerFist extends Item {
    private int damage;

    public PowerFist(String name, int damage, String description) {
        super(name, description, 1);
        this.damage = damage;
    }

    public int getDamage() {
         return damage; 
        }
}

abstract class Bread extends Item {
    protected int heal;

    public Bread(String name, String description, int quantity) {
        super(name, description, quantity);
    }

    public int getHeal() {
         return heal; 
        }
}

class GoodBread extends Bread {
    public GoodBread(int quantity) {
        super("Good Bread", "Restores 30 HP.", quantity);
        this.heal = 30;
    }
}

class MoldyBread extends Bread {
    public MoldyBread(int quantity) {
        super("Moldy Bread", "Restores 10 HP.", quantity);
        this.heal = 10;
    }
}


class Player {
    private String name;
    private int HP, maxHP, MP, maxMP;

    public Player(String name, int HP, int MP) {
        this.name = name;
        this.HP = HP;
        this.maxHP = HP;
        this.MP = MP;
        this.maxMP = MP;
    }

    public void takeDamage(int amount) {
         HP = Math.max(0, HP - amount); 
        }
    public void heal(int amount) {
         HP = Math.min(maxHP, HP + amount); 
        }
    public boolean isAlive(){
         return HP > 0; 
        }

    public String getName() {
         return name; 
        }

    public int getHP() {
         return HP; 
        }

    public int getMP() {
         return MP; 
        }

    public void setMP(int mp) {
         this.MP = Math.max(0, mp); 
        }

    public void printStatus() {
        System.out.println("  " + name + " | HP: " + HP + "/" + maxHP + " | MP: " + MP + "/" + maxMP);
    }
}

class Boss {
    private String name;
        private String bossType;    
        private String attack;      
        private String description; 
        private int HP, maxHP, attackPower;

   public Boss(String name, String bossType, String attack, String description, int HP, int attackPower) {
            this.name = name;
            this.bossType = bossType;
            this.attack = attack;
            this.description = description;
            this.HP = HP;
            this.maxHP = HP;
            this.attackPower = attackPower;
        }
    public void takeDamage(int amount) {
         HP = Math.max(0, HP - amount); 
        }

    public boolean isAlive() {
         return HP > 0; 
        }

    public String getName() {
         return name; 
        }
        public String getBossType() { 
            return bossType; 
        }
        public String getAttack() {
             return attack; 
            }
        public String getDescription() {
             return description; 
            }
        
        public int getAttackPower() {
             return attackPower; 
            }
        public int getHP() { 
            return HP; 
        }

    public void printStatus() {
        System.out.println("  " + name + " | HP: " + HP + "/" + maxHP);
    }
}

class ActionMenu {
    private Scanner scanner;

    public ActionMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public int chooseAction() {
        System.out.println("\n  Your turn:");
        System.out.println("  [1] Attack");
        System.out.println("  [2] Use Item");
        System.out.print("  > ");
        return scanner.nextInt();
    }

    public int chooseAttack(Player player) {
        System.out.println("\n  Choose weapon:");
        System.out.println("  [1] Iron Sword   (18 dmg, 10% crit)");
        System.out.println("  [2] Magic Wand   (22 dmg, heals 15 HP, costs 10 MP) [MP: " + player.getMP() + "]");
        System.out.println("  [3] Power Fist   (25 dmg)");
        System.out.print("  > ");
        int choice = scanner.nextInt();
        if (choice == 2 && player.getMP() < 10) {
            System.out.println("  Not enough MP!");
            return chooseAttack(player);
        }
        return choice;
    }

    public int chooseItemType() {
        System.out.println("\n  Choose item:");
        System.out.println("  [1] Good Bread  (heal 30 HP)");
        System.out.println("  [2] Moldy Bread (heal 10 HP)");
        System.out.print("  > ");
        return scanner.nextInt();
    }
}

}



