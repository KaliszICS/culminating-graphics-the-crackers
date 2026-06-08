package Graphics.GUIs;

import MapSystem.GameMap;
import MapSystem.Interactables.Door.Door;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class DoorGUI {
    private Parent root;
    private DoorController controller;

    public DoorGUI(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Resources/GUI/DoorGUI/DoorUI1.fxml"));
            root = loader.load();
            controller = loader.getController();
            
        } catch(Exception e){
            System.out.println("bad");
            e.printStackTrace();
        }
    }

    public Parent getRoot(){
        return this.root;
    }

    public void open(Door door, GameMap map){
        controller.setDoor(door);
        controller.setMap(map);
    }
}
