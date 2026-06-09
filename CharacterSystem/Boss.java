package CharacterSystem;

public class Boss extends Character {
    private String attack;
    private String bossType;
    private boolean isDefeated;

    public Boss(String name, String bossType, String attack, int currentHP, int attackDMG) {
        super(name, currentHP, 0, 0, attackDMG);
        this.attack = attack;
        this.bossType = bossType;
        this.isDefeated = false;
    }
    public void ulimateMove(Character target) {
        int damage = getAttackDMG() * 2;
        target.takeDamage(damage);
         System.out.println(getName() + " uses " + attack + " for " + damage + " damage!");
    }
     public String getAttack() { 
        return attack; 
     }
    public String getBossType() { 
        return bossType; 
    }
    public boolean isDefeated() { 
        return isDefeated; 
    }
    public void setDefeated(boolean defeated) { 
        isDefeated = defeated; 
    }

    @Override
    public void displayStats() {
        System.out.println("== BOSS: " + getName() + " ==");
        System.out.println("Attack: " + attack);
        System.out.println("HP: " + getCurrentHP());
        System.out.println("Attack DMG: " + getAttackDMG());
    }

Boss plainsBoss = new Boss("Plains Guardian", "plains", "Earth Slam", 250, 25);

Boss caveBoss = new Boss("Cave Titan", "cave", "Rock Crush", 350, 35);

Boss underworldBoss = new Boss("Unknown Being", "underworld", "Darkness Beam", 500, 50);
}

