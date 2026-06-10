package BattleSystem;
import java.util.Scanner;

/**
 * Manages turn-based combat between a Player and a Boss.
 * Contains all inner classes for items, characters, and the action menu.
 *
 * @author Adhiraj Singh
 */
public class BattleSystem {

    /**
     *  Abstract base class for all items. 
    */
    abstract class Item {
        protected String name;
        protected String description;
        public int quantity;

        /**
         * @param name        display name of the item
         * @param description short description of the item
         * @param quantity    starting quantity
         */
        public Item(String name, String description, int quantity) {
            this.name = name;
            this.description = description;
            this.quantity = quantity;
        }

        /** 
         * @return the item's name 
        */
        public String getName() { return name; }
    }

    /** 
     * A melee weapon with a critical hit chance. 
    */
    class Sword extends Item {
        private int damage;
        private double critChance;

        /**
         * @param name        sword name
         * @param damage      base damage per swing
         * @param description short description
         * @param critChance  crit chance (e.g. 0.10 = 10%)
         */
        public Sword(String name, int damage, String description, double critChance) {
            super(name, description, 1);
            this.damage = damage;
            this.critChance = critChance;
        }

        /** 
         * @return base damage 
        */
        public int getDamage() { return damage; }

        /**
         *  @return crit chance
        */
        public double getCritChance() { return critChance; }
    }

    /** 
     * A magic weapon that deals damage, heals the player, and costs MP. 
    */
    class MagicWand extends Item {
        private int damage, heal, mpCost;

        /**
         * @param name        wand name
         * @param damage      damage dealt per cast
         * @param heal        HP restored to the player per cast
         * @param mpCost      MP consumed per cast
         * @param description short description
         */
        public MagicWand(String name, int damage, int heal, int mpCost, String description) {
            super(name, description, 1);
            this.damage = damage;
            this.heal = heal;
            this.mpCost = mpCost;
        }

        /** 
         * @return damage per cast
        */
        public int getDamage() { 
            return damage; 
        }

        /** 
         * @return HP restored per cast 
        */
        public int getHeal() { 
        return heal; 
    }

        /** 
         * @return MP cost per cast 
        */
        public int getMpCost() { 
            return mpCost; 

        }
    }

    /** 
     * A weapon that deals high damage with no effects. 
    */
    class PowerFist extends Item {
        private int damage;

        /**
         * @param name        weapon name
         * @param damage      base damage per punch
         * @param description short description
         */
        public PowerFist(String name, int damage, String description) {
            super(name, description, 1);
            this.damage = damage;
        }

        /** @return base damage */
        public int getDamage() { return damage; }
    }

    /** 
     * Abstract class for bread consumables that restore HP.
    */
    abstract class Bread extends Item {
        protected int heal;

        /**
         * @param name        bread name
         * @param description short description
         * @param quantity    starting quantity
         */
        public Bread(String name, String description, int quantity) {
            super(name, description, quantity);
        }

        /** @return HP restored on use */
        public int getHeal() { return heal; }
    }

    /** 
     * bread that restores 30 HP. 
    */
    class GoodBread extends Bread {
        /** @param quantity starting quantity */
        public GoodBread(int quantity) {
            super("Good Bread", "Restores 30 HP.", quantity);
            this.heal = 30;
        }
    }

    /** moldy bread that restores 10 HP. 
     * 
    */
    class MoldyBread extends Bread {
        /** 
         * @param quantity starting quantity 
         * */
        public MoldyBread(int quantity) {
            super("Moldy Bread", "Restores 10 HP.", quantity);
            this.heal = 10;
        }
    }

    /** 
     * Represents the player character, tracking HP, MP, and combat actions. 
    */
    class Player {
        private String name;
        private int HP, maxHP, MP, maxMP;

        /**
         * @param name player's display name
         * @param HP   starting (and maximum) HP
         * @param MP   starting (and maximum) MP
         */
        public Player(String name, int HP, int MP) {
            this.name = name;
            this.HP = HP;
            this.maxHP = HP;
            this.MP = MP;
            this.maxMP = MP;
        }

        /**
         *  @param amount damage taken; HP is floored at 0 
         * 
        */
        public void takeDamage(int amount) { 
            HP = Math.max(0, HP - amount); 
        }

        /** @param amount HP restored; capped at maxHP 
         * 
        */
        public void heal(int amount) { 
            HP = Math.min(maxHP, HP + amount); 
        }

        /** @return {@code true} if HP > 0 
         * 
        */
        public boolean isAlive() { 
            return HP > 0; 
        }

        /** @return player's name 
         * 
        */
        public String getName() { 
            return name; 
        }

        /** @return current HP 
         * 
        */
        public int getHP() { 
            return HP; 
        }

        /** @return current MP 
         * 
        */
        public int getMP() { 
            return MP; 

        }

        /** @param mp new MP value; below at 0 
         * 
        */
        public void setMP(int mp) { 
            this.MP = Math.max(0, mp); 
        }

        /** Prints | HP: current/max | MP: current/max} to the system. 
         * 
        */
        public void printStatus() {
            System.out.println("  " + name + " | HP: " + HP + "/" + maxHP + " | MP: " + MP + "/" + maxMP);
        }
    }

    /** 
     * Represents the enemy boss with a type, signature attack, and combat stats. 
    */
    class Boss {
        private String name;
        private String bossType;
        private String attack;
        private String description;
        private int HP, maxHP, attackPower;

        /**
         * @param name        boss display name
         * @param bossType    like plains,cave,underworld archtypes
         * @param attack      name of the boss's signature attack
         * @param description long/short text of item
         * @param HP          starting (and maximum) HP
         * @param attackPower damage dealt per attack
         */
        public Boss(String name, String bossType, String attack, String description, int HP, int attackPower) {
            this.name = name;
            this.bossType = bossType;
            this.attack = attack;
            this.description = description;
            this.HP = HP;
            this.maxHP = HP;
            this.attackPower = attackPower;
        }

        /** @param amount damage taken; HP is floored at 0 
         * 
        */
        public void takeDamage(int amount) { 
            HP = Math.max(0, HP - amount); 
        }

        /** @return {@code true} if HP > 0 
         * 
        */
        public boolean isAlive() { 
            return HP > 0; 

        }

        /** @return boss's name 
         * 
        */
        public String getName() { 
            return name; 
        }

        /** @return boss archetype 
         * 
        */
        public String getBossType() { 
            return bossType; 
        }

        /** @return signature attack name 
         * 
        */
        public String getAttack() { 
            return attack; 

        }

        /** @return flavour text description 
         * 
        */
        public String getDescription() {
             return description; 
            }

        /** @return damage dealt per attack 
         * 
        */
        public int getAttackPower() { 
            return attackPower; 
        }

        /** @return current HP 
         * 
        */
        public int getHP() { 
            return HP; 
        }

        /** Prints| HP: current/max} to the console. 
         * 
        */
        public void printStatus() {
            System.out.println("  " + name + " | HP: " + HP + "/" + maxHP);
        }
    }

    /** Handles player input during combat, presenting menus and validating choices. 
     * 
    */
    class ActionMenu {
        private Scanner scanner;

        /** @param scanner Scanner to read player input from 
         * 
        */
        public ActionMenu(Scanner scanner) {
            this.scanner = scanner;
        }

        /**
         * Displays the main action menu.
         * @return 1 for Attack, 2 for Use Item
         */
        public int chooseAction() {
            System.out.println("\n  Your turn:");
            System.out.println("  [1] Attack");
            System.out.println("  [2] Use Item");
            System.out.print("  > ");
            return scanner.nextInt();
        }

        /**
         * Displays the weapon menu. Re-prompts if Magic Wand is chosen without enough MP.
         * @param player the current player, used to check available MP
         * @return 1 = Sword, 2 = Magic Wand, 3 = Power Fist
         */
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

        /**
         * Displays the item menu.
         * @return 1 = Good Bread, 2 = Moldy Bread
         */
        public int chooseItemType() {
            System.out.println("\n  Choose item:");
            System.out.println("  [1] Good Bread  (heal 30 HP)");
            System.out.println("  [2] Moldy Bread (heal 10 HP)");
            System.out.print("  > ");
            return scanner.nextInt();
        }
    }
}
