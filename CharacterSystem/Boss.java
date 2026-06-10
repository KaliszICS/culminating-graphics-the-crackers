package CharacterSystem;

import Graphics.ViewManager;
import MapSystem.GameMap;
import MapSystem.MapData;

/**
 * Represent a boss enemy in rpg
 * extends character with specific boss attacks and defeat tracking
 * boss has no mp and cannot heal
 */
public class Boss extends Character {
    private String attack;  //Name of boss special attack
    private String finisher;    //name of finsiher move
    private String bossType; // type of boss "plains, cave, underworld"
    private boolean isDefeated; // when boss is defeated
/**
 * constructor for creating a new boss
 * bosses have no mp and no heal
 * @param name  display boss name
 * @param bossType  type of boss (plains, cave, underworld)
 * @param attack    name of attack
 * @param finisher  name of finisher move
 * @param currentHP starting hp
 * @param attackDMG  attack dmg
 */
    public Boss(String name, String bossType, String attack, String finisher, int currentHP, int attackDMG) {
        super(name, currentHP, 0, 0, attackDMG);
        this.attack = attack;
        this.attack = finisher;
        this.bossType = bossType;
        this.isDefeated = false;
    }
/**
 * performs a critcal damage on target
 * does double dmg compared to normal attack
 * @param target target the chraccter to attack
 */
    public void critHit(Character target) {
        int damage = getAttackDMG() * 2;
        target.takeDamage(damage);
         System.out.println(getName() + " uses " + attack + " for " + damage + " damage!");
    }

    //GETTERS
/**
 * @return name of boss attack
 */
     public String getAttack() { 
        return attack; 
     }
/**
 * @return  name of finishing move
 */
     public String getFinisher() {
        return finisher;
     }
/**
 * @return boss type: plains,cave, underworld
 */
    public String getBossType() { 
        return bossType; 
    }
/**
 * @return true if boss is defeated, false if not
 */
    public boolean isDefeated() { 
        return isDefeated; 
    }
    //SETTER
/**
 * sets the boss is defeated status
 * used when boss is defeated in battle or when loading/saving the game
 * @param defeated true to mark as defeated, false if not
 */
    public void setDefeated(boolean defeated) { 
        isDefeated = defeated; 
    }

 /**
     * Handles unlocks the next map region when this boss dies.
     *
     * @param map The current game map instance to update
     */
    public void defeat(GameMap map){
        switch(bossType){
            case "plains":
                map.setGrid(MapData.CAVES_GRID);
                map.setInteractables(MapData.caveInteractables);
                map.setPlayerPos((new int[]{4,7}));
                map.updateMap();

                ViewManager.openMap();
                break;
            case "cave":
                map.setGrid(MapData.UNDERWORLD_GRID);
                map.setInteractables(MapData.underworldInteractables);
                map.setPlayerPos((new int[]{0,4}));
                map.updateMap();

                ViewManager.openMap();
                break;
            case "underworld":
                ViewManager.openMap();
                break;
        }
    }
 /**
     * Prints the boss stats and attack details to the system.
     */
    @Override
    public void displayStats() {
        System.out.println("== BOSS: " + getName() + " ==");
        System.out.println("Attack: " + attack);
        System.out.println("HP: " + getCurrentHP());
        System.out.println("Attack DMG: " + getAttackDMG());
    }

    //Boss plainsBoss = new Boss("Green Square", "plains", "Square", "Watch Out For That Tree!", 1000, 50);

    //Boss caveBoss = new Boss("Blue Square", "cave", "Square", "Rocky Road", 2500, 100);

    //Boss underworldBoss = new Boss("Red Square", "underworld", "Square", "Satanic Star", 300, 666);
}

