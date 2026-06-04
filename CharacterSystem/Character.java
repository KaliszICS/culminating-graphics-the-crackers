package CharacterSystem;

public class Character {
    private String name;
    private int maxHP;
    private int maxMP;
    private int currentHP;
    private int currentMP;
    private int attackDMG;
    private int speed;


    public Character(String name, int maxHP, int maxMP, int currentHP, int currentMP, int attackDMG, int speed) {
        this.name = name;
        this.maxHP = maxHP;
        this.maxMP = maxMP;
        this.currentHP = currentHP;
        this.currentMP = currentMP;
        this.attackDMG = attackDMG;
        this.speed = speed;
        
    }

    public void takeDamage(int amount) {
        this.currentHP = Math.max(0, currentHP - amount);
    }
    
}
