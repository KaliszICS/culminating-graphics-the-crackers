import java.util.Random;
import BattleSystem.Combatant;
public class BattleStrategy2 {
    
    public class Monster extends Combatant {
        private Random random = new Random();

        public Monster(String name, int maxHp, int attackPower) {
            super(name, maxHp, attackPower);
        }
        
        
        @Override
        public void executeTurn(Combatant target) {
            System.out.println("\n--- Enemy Turn! ---");
            // Simple AI logic: executes random variations of basic damage output
            int variance = random.nextInt(5) - 2; // -2 to +2 damage variance
            int finalDamage = Math.max(1, getAttackPower() + variance);


            System.out.println(getName() + " bites " + target.getName() + " fiercely!");
            target.takeDamage(finalDamage);
        }
   }
