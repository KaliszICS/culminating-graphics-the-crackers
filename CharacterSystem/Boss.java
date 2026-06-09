package CharacterSystem;

public class Boss extends Character {
    private String attack;
    private String bossType;
    private boolean isDefeated;

    public Boss(String name, String bossType, String attack, String finisher, int currentHP, int attackDMG) {
        super(name, currentHP, 0, 0, attackDMG);
        this.attack = attack;
        this.finisher = finisher;
        this.bossType = bossType;
        this.isDefeated = false;
    }
    public void critHit(Character target) {
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

Boss plainsBoss = new Boss("Green Square", "plains", "Watch Out For That Tree!", 1000, 50);

Boss caveBoss = new Boss("Blue Square", "cave", "Rocky Road", 2500, 100);

Boss underworldBoss = new Boss("Red Square", "underworld", "Satanic Star", 5000, 300, 666);
}

