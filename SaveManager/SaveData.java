package SaveManager;
public class SaveData {

    // Player stats
    public int playerHP;
    public int playerMP;

    // Boss stats at time of save (if not defeated)
    public int plainsBossHP;
    public int caveBossHP;
    public int underworldBossHP;

    // Map explore
    public String currentMapArea; // "plains", "caves", "underworld"

    //Constructor
    public SaveData(int playerHP, int playerMP, int plainsBossHP, int caveBossHP, int underworldBossHP, String currentMapArea) {
        this.playerHP = playerHP;
        this.playerMP = playerMP;
        this.plainsBossHP = plainsBossHP;
        this.caveBossHP = caveBossHP;
        this.underworldBossHP = underworldBossHP;
        this.currentMapArea = currentMapArea;
    }

    //Converts saveData
    public String serialize() {
        return playerHP + ","
             + playerMP + ","
             + plainsBossHP + ","
             + caveBossHP + ","
             + underworldBossHP + ","
             + currentMapArea;
    }

    public static SaveData deserialize(String saveString) {
        String[] parts = saveString.split(",");
        
        if (parts.length != 6) {
            System.out.println("Invalid save data");
            return null;
        } try {
            int playerHP = Integer.parseInt(parts[0]);
            int playerMP = Integer.parseInt(parts[1]);
            int plainsBossHP = Integer.parseInt(parts[2]);
            int caveBossHP = Integer.parseInt(parts[3]);
            int underworldBossHP = Integer.parseInt(parts[4]);
            String currentMapArea = parts[5];
            
            return new SaveData(playerHP, playerMP, plainsBossHP, caveBossHP, underworldBossHP, currentMapArea);
        } catch (NumberFormatException e) {
            System.out.println("Error parsing save data: " + e.getMessage());
            return null;
        }
    }
    
        // Display save info
    public void displayInfo() {
        System.out.println("=== SAVE DATA ===");
        System.out.println("Player HP: " + playerHP);
        System.out.println("Player MP: " + playerMP);
        System.out.println("Plains Boss HP: " + plainsBossHP);
        System.out.println("Cave Boss HP: " + caveBossHP);
        System.out.println("Underworld Boss HP: " + underworldBossHP);
        System.out.println("Current Area: " + currentMapArea);
    }


    //test/debugging
 public static void main(String[] args) {
        System.out.println("Testing SaveData...\n");

        //create save data
         SaveData original = new SaveData(100, 50, 250, 350, 500, "caves");
         System.out.println("Displaying Saved Data:");
        original.displayInfo();

        // convert to string
        String saved = original.serialize();
        System.out.println("\nSaved as string: " + saved);
        
        // convert back from string
        SaveData loaded = SaveData.deserialize(saved);
        System.out.println("\nDisplaying Loaded data:");
        loaded.displayInfo();

        // check if they match
        System.out.println("\nDoes it work? " + 
            (original.playerHP == loaded.playerHP &&
             original.playerMP == loaded.playerMP &&
             original.plainsBossHP == loaded.plainsBossHP &&
             original.caveBossHP == loaded.caveBossHP &&
             original.underworldBossHP == loaded.underworldBossHP &&
             original.currentMapArea.equals(loaded.currentMapArea) 
             ? "YES! SaveData is working correctly!" : "NO! Something is wrong"));
    }
}

