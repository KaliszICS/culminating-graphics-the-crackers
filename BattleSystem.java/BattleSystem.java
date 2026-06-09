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

    private int currentTurn;
    private Random random;
    private ActionMenu actionMenu;

    private Sword ironSword;
    private MagicWand magicWand;
    private PowerFist powerFist;
    private GoodBread goodBread;
    private MoldyBread moldyBread;

    /** @param scanner used to read player input during combat */
    public BattleSystem(Scanner scanner) {
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
    public int getCurrentTurn() { return currentTurn; }
}
