package CharacterSystem;
import ItemSystem.Inventory;
/**
 * represent player character in rpg
 * extends from character functionality like attacking bosses
 * @author Jason Wu
 */

public class Player extends Character {
    Inventory inventory;

    /**
     * Constructor a player
     * @param name  players name
     * @param currentHP     starting hp
     * @param currentMP     startting mp
     * @param Heal      amount healed per healing action
     * @param attackDMG     base attack dmg
     */
    public Player(String name, int currentHP, int currentMP, int Heal, int attackDMG) {
        super(name, currentHP, currentMP, Heal, attackDMG);
        inventory = new Inventory();
    }

    /**
     * players attacks boss
     * deals dmg equal to attackDMG to the boss
     * @param boss attacks dealt to the boss
     */
    public void attack(Boss boss) {
        boss.takeDamage(getAttackDMG());
        System.out.println(getName() + " attack for " + getAttackDMG() + "damage!");
    }

    /**
     * displays players stats
     * overrides parent method to "PLAYER:"
     */
    @Override
    public void displayStats() {
        System.out.println("== PLAYER: " + getName() + " ==");
        System.out.println("HP: " + getCurrentHP());
        System.out.println("MP: " + getCurrentMP());
        System.out.println("Heal: " + getHeal());
        System.out.println("Attack: " + getAttackDMG());
    }

    /**
     * returns inventory
     * @return this player's inventory
     */
    public Inventory getInventory(){
        return this.inventory;
    }

}


