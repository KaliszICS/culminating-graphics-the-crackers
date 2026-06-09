package CharacterSystem;

/**
* Represents a character in the RPG game.
 * All game entities (Player, Boss) extend this class.
 */
    public class Character {
    private String name;        //display character name
    private int currentHP;      // current hp
    private int currentMP;      // current mp
    private int Heal;           // amount of healed when using heal action
    private int attackDMG;      //damage dealt in attack
    private boolean isAlive;    //whether character is still alive

/**
 * Constructor for making a new character
 * @param name  character name
 * @param currentHP starting hp
 * @param currentMP starting mp
 * @param Heal  amount healed per healing action
 * @param attackDMG base attack dmg
 */
    public Character(String name, int currentHP, int currentMP,int Heal, int attackDMG) {
        this.name = name;
        this.currentHP = currentHP;
        this.currentMP = currentMP;
        this.Heal = Heal;
        this.attackDMG = attackDMG;
        this.isAlive = true;
        
    }
/**
 * reduce character hp at a speific amount
 * hp cannot go below 0 if hp reaches 0 character dies
 * @param amount the amount of dmg taken
 */

    public void takeDamage(int amount) {
        this.currentHP = Math.max(0, currentHP - amount);
        if (this.currentHP <= 0) {
            this.isAlive = false;
        }
        
    }
/**
 * heals the character by a set amount
 * no max hp limit (can overheal)
 */
     public void heal() {
        this.currentHP += Heal;
    }
/**
 * restores mp to the character
 * @param amount the amount of mp to restore
 */
    public void restoreMP(int amount) {
        this.currentMP += amount;
    }
/**
 * comsumes mp for healing
 * mp cannot be below 0
 * @param amount the amount of mp to use
 */
    public void useMP(int amount) {
        this.currentMP = Math.max(0, currentMP - amount);
    }
    // Getters
/**
 * @return the character name
 */
    public String getName() {
        return name;
    }
/**
 * @return current character hp
 */
    public int getCurrentHP() {
        return currentHP;
    }
/**
 * @return current character mp
 */
    public int getCurrentMP() {
        return currentMP;
    }
/**
 * @return heal amount
 */
    public int getHeal() {
        return Heal;
    }
/**
 * @return attack dmg
 */
    public int getAttackDMG() {
        return attackDMG;
    }
/**
 * @return true if character alive false if dead
 */
    public boolean isAlive() {
        return isAlive;
    }
    
    //setters for savesystem
/**
 * set current hp
 * @param hp new hp value
 */
    public void setCurrentHP(int hp) { 
        this.currentHP = hp; 
    }
/**
 * set current mp
 * @param mp new mp value
 */
    public void setCurrentMP(int mp) { 
        this.currentMP = mp; 
    }
/**
 * Displays all character stats
 * used for debugging
 */
    public void displayStats() {
        System.out.println("== " + name + " ==");
        System.out.println("HP: " + currentHP);
        System.out.println("MP: " + currentMP);
        System.out.println("Heal: " + Heal);
        System.out.println("Attack: " + attackDMG);
    }
}
