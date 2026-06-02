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

}