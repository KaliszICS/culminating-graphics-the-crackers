package SaveManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * handles file i/o operations for saving and loading game data
 * manages savefile, serialize and deserialize
 * @author Jason Wu
 */
public class SaveSystem {
    /**
     * Saves game data to a file.
     * Converts SaveData to string format.
     * 
     * @param data     The SaveData object to save
     * @param filename The file path to save
     */

    public void saveGame(SaveData data, String filename) {
        try(FileWriter writer = new FileWriter(filename)) {
            writer.write(data.serialize());
            System.out.println("Progress successfully backed up!");
        } catch (IOException e) {
            System.out.println("Error saving game: " + e.getMessage());
        }
    }
 /**
     * Loads game data from a save file.
     * Reads the file, parses the string, and reconstructs SaveData.
     * 
     * @param filename The file path to load from
     * @return SaveData object if successful, null if file doesn't exist or is corrupted
     */

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
  /**
     * Checks if a save file exists at the specified path.
     * 
     * @param filename The file path to check
     * @return true if file exists, false if not
     */

    // Check if save file exists
    public boolean saveExists(String filename) {
        File file = new File(filename);
        return file.exists();
    }
 /**
     * Deletes the save file at the specified path.
     * 
     * @param filename The file path to delete
     */

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
 /**
     * Displays save file information without loading the game.
     * Useful for save.
     * 
     * @param filename The file path to display info for
     */

    public void displaySaveInfo(String filename) {
        SaveData data = loadGame(filename);
        if (data != null) {
            data.displayInfo();
        } else {
            System.out.println("No valid save data to display");
        }
    }
    
    //testing/debugging
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
