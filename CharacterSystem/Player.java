package CharacterSystem;

public class Player extends Character {
    
    public Player(String name, int currentHP, int currentMP, int Heal, int attackDMG) {
        super(name, currentHP, currentMP, Heal, attackDMG);
    }
    public void attack(Boss boss) {
        boss.takeDamage(getAttackDMG());
        System.out.println(getName() + " attack for " + getAttackDMG() + "damage!");
    }
    @Override
    public void displayStats() {
        System.out.println("== PLAYER: " + getName() + " ==");
        System.out.println("HP: " + getCurrentHP());
        System.out.println("MP: " + getCurrentMP());
        System.out.println("Heal: " + getHeal());
        System.out.println("Attack: " + getAttackDMG());
    }

}


