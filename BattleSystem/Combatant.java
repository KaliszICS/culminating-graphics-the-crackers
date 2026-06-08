public abstract Combatant {

protected String name;
protected int hp;
protected int maxHp;
protected int attackPower;


public Combatant(String name, int maxHp, int attackPower) {
    this.name = name;
    this.maxHp = maxHp;
    this.hp = maxHp;
    this.attackPower = attackPower;
}

public boolean isAlive() {
    return this.hp > 0;
}


public void takeDamage(int damage) {
    this.hp = Math.max(0, this.hp - damage);
    System.out.println(name + " takes " + damage + " damage! HP: " + hp + "/" + maxHp);
}


// Abstract method forcing unique action selection strategies
public abstract void executeTurn(Combatant target);


// Getters and Setters
public String getName() { return name; }
public int getAttackPower() { return attackPower; }
}