package SaveManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveSystem {
    public void saveGame(SaveData data, String filename) {
        try(FileWriter writer = new FileWriter(filename)) {
            writer.write(data.serialize());
            System.out.println("Progress successfully backed up!");
        } catch (IOException e) {
            System.out.println("Error saving game: " + e.getMessage());
        }
    }

public SaveData loadGame(String filename) {
        File file = new File(filename);

        if (!file.exists()) {
            System.out.println("No save file detected or mismatch found. Starting fresh.");
            return null;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String raw = reader.readLine();
            
            // Check for empty file
            if (raw == null || raw.trim().isEmpty()) {
                System.out.println("Save file is empty or corrupted");
                return null;
            }
            
            System.out.println("Game loaded successfully!");
            return SaveData.deserialize(raw);
            
        } catch (IOException e) {
            System.out.println("Error reading save file: " + e.getMessage());
            return null;
        }
    }

    // Check if save file exists
    public boolean saveExists(String filename) {
        File file = new File(filename);
        return file.exists();
    }

    // Delete save file
    public void deleteSave(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Save file deleted successfully");
            } else {
                System.out.println("Failed to delete save file");
            }
        } else {
            System.out.println("No save file to delete");
        }
    }

    public void displaySaveInfo(String filename) {
        SaveData data = loadGame(filename);
        if (data != null) {
            data.displayInfo();
        } else {
            System.out.println("No valid save data to display");
        }
    }

    //esting/debugging
    public static void main(String[] args) {
    SaveSystem ss = new SaveSystem();
    String file = "test.txt";
    
    // Create and save
    SaveData data = new SaveData(100, 50, 75, 120, 200, "caves");
    ss.saveGame(data, file);
    
    // Load and display
    SaveData loaded = ss.loadGame(file);
    loaded.displayInfo();
    
    // deletes save file
    ss.deleteSave(file);
}
}
