package SaveManager;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import java.io.IOException;

public class SaveSystem {
    private String saveDirectory;
    private String saveFilePath;

    public SaveSystem() {
        this.saveDirectory = System.getProperty(saveDirectory);
        this.saveFilePath = 
        createSaveDirectory();
    }
    public SaveSystem(String customPath) {
        this.saveFilePath = customPath;
        File file = new File(saveFilePath);
        this.saveDirectory = file.getParent();
        createSaveDirectory();
    }

    private void createSaveDirectory() {
        File directory = new File(saveDirectory);
        if (!directory.exists()) {
            directory.mdirs();
        }
    }
    //saveFile()
    public SaveData saveFile() {
        File file = new File(saveFilePath);
        if (!file.exists()) {
            System.out.println();
            return null;
        }
    }
}