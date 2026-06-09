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
public class BattleSystem<ActionMenu, Sword, MagicWand, PowerFist, GoodBread, MoldyBread> {


abstract class Item {
    protected String name;
    protected String description;
    public int quantity;

    public Item(String name, String description, int quantity) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    public String getName() { return name; }
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
    private int HP, maxHP, attackPower;

    public Boss(String name, int HP, int attackPower) {
        this.name = name;
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

    public int getAttackPower() {
         return attackPower; 
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



/** Manages turn-based combat between a Player and a Boss. 
 * @param <fixed>*/

public class TurnSystem {

    private int currentTurn;
    private Random random;
    private ActionMenu actionMenu;

    private Sword ironSword;
    private MagicWand magicWand;
    private PowerFist powerFist;
    private GoodBread goodBread;
    private MoldyBread moldyBread;

    /** @param scanner used to read player input during combat */
    public TurnSystem(Scanner scanner) {
        this.currentTurn = 0;
        this.random = new Random();
        this.actionMenu = new ActionMenu(scanner);

        ironSword = new Sword("Iron Sword", 18, "A sturdy iron blade.", 0.10);
        magicWand = new MagicWand("Magic Wand", 22, 15, 10, "Channels arcane energy.");
        powerFist = new PowerFist("Power Fist", 25, "A gauntlet that hits hard.");
        goodBread = new GoodBread(2);
        moldyBread = new MoldyBread(3);
    }

    /** Increments the turn counter and prints both combatants' status. */
    public void turnOrder(Player player, Boss boss) {
        currentTurn++;
        System.out.println("\n══════════════ TURN " + currentTurn + " ══════════════");
        player.printStatus();
        boss.printStatus();
    }

    /**
     * Prompts the player to choose a weapon and returns the damage dealt.
     * @return damage dealt to the boss
     */
    public int chooseAttack(Player player) {
        int choice = actionMenu.chooseAttack(player);
        int damage = 0;

        switch (choice) {
            case 1:
                damage = ironSword.getDamage();
                boolean crit = random.nextDouble() < ironSword.getCritChance();
                if (crit) {
                    damage = (int)(damage * 1.8);
                    System.out.println("  Critical hit! " + ironSword.getName() + " deals " + damage + " damage!");
                } else {
                    System.out.println("  " + ironSword.getName() + " deals " + damage + " damage.");
                }
                break;

            case 2:
                damage = magicWand.getDamage();
                player.setMP(player.getMP() - magicWand.getMpCost());
                player.heal(magicWand.getHeal());
                System.out.println("  " + magicWand.getName() + " deals " + damage
                        + " damage and restores " + magicWand.getHeal() + " HP!");
                break;

            case 3:
                damage = powerFist.getDamage();
                System.out.println("  " + powerFist.getName() + " deals " + damage + " damage.");
                break;

            default:
                System.out.println("  Invalid choice. Wasted turn.");
        }
        return damage;
    }

    /** Boss attacks the player with randomized damage. */
    public void bossAttack(Player player, Boss boss) {
        int variance = random.nextInt(7) - 3;
        int damage   = Math.max(1, boss.getAttackPower() + variance);
        player.takeDamage(damage);
        System.out.println("  " + boss.getName() + " attacks for " + damage + " damage!");
    }

    /** Prompts the player to use a healing item and applies its effect. */
    public void useItem(Player player) {
        int choice = actionMenu.chooseItemType();
        Bread item = null;

        if (choice == 1)      item = goodBread;
        else if (choice == 2) item = moldyBread;

        if (item == null || item.quantity <= 0) {
            System.out.println("  None left!");
            return;
        }

        player.heal(item.getHeal());
        item.quantity--;
        System.out.println("  Used " + item.getName() + ". Restored " + item.getHeal()
                + " HP. (" + item.quantity + " left)");
    }

    /** @return number of turns elapsed in this battle */
    public int getCurrentTurn() {
         return currentTurn; 
        }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player("Hero", 100, 40);
        TurnSystem battle = new TurnSystem(scanner);

        Boss[] bosses = {
            new Boss("Plains Guardian",   80, 12),
            new Boss("Cavern Troll",     120, 18),
            new Boss("Shadow Sovereign", 160, 24)
        };

        for (Boss boss : bosses) {
            System.out.println("\n  A wild " + boss.getName() + " appears!");

            while (player.isAlive() && boss.isAlive()) {
                battle.turnOrder(player, boss);
                int action = battle.ActionMenu.chooseAction();

                if (action == 1) {
                    boss.takeDamage(battle.chooseAttack(player));
                } else if (action == 2) {
                    battle.useItem(player);
                }

                if (!boss.isAlive()) {
                    System.out.println("  *** " + boss.getName() + " defeated! ***");
                    break;
                }
                battle.bossAttack(player, boss);
            }

            if (!player.isAlive()) {
                System.out.println("\n  GAME OVER");
                scanner.close();
                return;
            }
        }

        System.out.println("\n  *** VICTORY ***");
        scanner.close();
    }
}
