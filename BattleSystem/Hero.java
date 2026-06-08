import java.util.Scanner; 

public class Hero extends Combatant {
    private Scanner scanner = new Scanner(System.in);


    public Hero(String name, int maxHp, int attackPower) {
        super(name,maxHp, attackPower);
    }
    
    @Override
    public void executeTurn(Combatant target) {
        System.out.println("\n--- Your Turn! Choose an action: ---");
        System.out.println("1. Basic Attack");
        System.out.println("2. Defend (Not implemented yet)");


        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println(getName() + " slashes at " + target.getname() + "!");
            target.takeDamage(getAttackPower());
        } else {
            System.out.println("Invalid choice! You stumbled.");   
        }
    }
}        