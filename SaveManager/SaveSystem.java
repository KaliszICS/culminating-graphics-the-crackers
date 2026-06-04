package SaveManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SaveSystem {
    public void saveGame(SaveData data, String filename) {
        try(FileWriter writer = new FileWriter(filename)) {
            writer.write(data.serialize());
            System.out.println("Progess successfully backed up!");
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
            System.out.println("Game saved successfully!");
        } catch (IOException e) {
            System.out.println("No save file detected or mismatch found. Starting fresh");
            return null;
        }
    }
}