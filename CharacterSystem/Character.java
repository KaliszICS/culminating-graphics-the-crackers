package CharacterSystem;

public class Character {
    private String name;
    private int currentHP;
    private int currentMP;
    private int Heal;
    private int attackDMG;
    private boolean isAlive;


    public Character(String name, int currentHP, int currentMP,int Heal, int attackDMG) {
        this.name = name;
        this.currentHP = currentHP;
        this.currentMP = currentMP;
        this.Heal = Heal;
        this.attackDMG = attackDMG;
        this.isAlive = true;
        
    }

    public void takeDamage(int amount) {
        this.currentHP = Math.max(0, currentHP - amount);
        if (this.currentHP <= 0) {
            this.isAlive = false;
        }
        
    }

     public void heal() {
        this.currentHP += Heal;
    }
    
    public void restoreMP(int amount) {
        this.currentMP += amount;
    }
    
    public void useMP(int amount) {
        this.currentMP = Math.max(0, currentMP - amount);
    }
    //getters
    public String getName() {
        return name;
    }
    public int getCurrentHP() {
        return currentHP;
    }
    public int getCurrentMP() {
        return currentMP;
    }
    public int getHeal() {
        return Heal;
    }
    public int getAttackDMG() {
        return attackDMG;
    }
    public boolean isAlive() {
        return isAlive;
    }
    
    //setters for savesystem
    public void setCurrentHP(int hp) { 
        this.currentHP = hp; 
    }
    public void setCurrentMP(int mp) { 
        this.currentMP = mp; 
    }
        public void displayStats() {
        System.out.println("== " + name + " ==");
        System.out.println("HP: " + currentHP);
        System.out.println("MP: " + currentMP);
        System.out.println("Heal: " + Heal);
        System.out.println("Attack: " + attackDMG);
    }
}
