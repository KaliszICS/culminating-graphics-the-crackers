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
    }
}
