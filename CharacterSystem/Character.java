package CharacterSystem;

public class Character {
    private String name;
    private int currentHP;
    private int currentMP;
    private int Heal;
    private int attackDMG;


    public Character(String name, int currentHP, int currentMP,int Heal, int attackDMG) {
        this.name = name;
        this.currentHP = currentHP;
        this.currentMP = currentMP;
        this.Heal = Heal;
        this.attackDMG = attackDMG;
        
    }

    public void takeDamage(int amount) {
        this.currentHP = Math.max(0, currentHP - amount);
    }
    public void healtakenDMG(int amount) {
        
    }

}
