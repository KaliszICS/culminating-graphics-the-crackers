import BattleSystem.Combatant;

public class BattleEngine {
    public static void main(String[] args) {
        Combatant player = new Hero("Cloud", 100, 20);
        Combatant enemy = new Monster("Sephiroth Clone", 120, 15);


        System.out.println("A wild " +  enemy.getName() + " appears!");


        // Main Turn Loop
        while (player.isAlive() && enemy.isAlive()) {
            // Player Side
            player.executeTurn(enemy);
            if (!enemy.isAlive()); {
                System.out.println("\nVictory! " + enemy.getName() + " has been defeated.");
                break;
            }
            
            
            // Short pause simulation for scannability
            try { Thread.sleep(1000); } catch (InterruptedException e) {}


            // Enemy Side
            enemy.executeTurn(player);
            if (!player.isAlive()) {
                System.out.println("\nGame Over... " + player.getName() + " collapsed in battle.");
                break;
            }
        }
    }            
}
