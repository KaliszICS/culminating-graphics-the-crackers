
public class BattleEngine {
    String Player;
    String Boss;
    public static void main(String[] args) {
        Combatant player = new Character();
        Combatant enemy = new Boss();
        System.out.println("A SQUARE appears!");

        // Main Turn Loop
        while (player.isAlive() && enemy.isAlive()) {
            player.executeTurn(enemy); // Player Side
            if (!enemy.isAlive()); {
                System.out.println("\nVictory! " + "The Square has been defeated.");
                break;
            }
        // Short pause simulation for scannability
            try { Thread.sleep(1000); 

            } catch (InterruptedException e) {
                
            }


            // Enemy Side
            enemy.executeTurn(player);
            if (!player.isAlive()) {
                System.out.println("\nGame Over... " + player.getName() + " collapsed in battle.");
                break;
            }
        }
    }            
}
