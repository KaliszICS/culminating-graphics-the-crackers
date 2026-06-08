package Graphics;

import Graphics.GUIs.DoorGUI;
import MapSystem.GameMap;
import MapSystem.Interactables.Door.Door;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

/**
 * Static manager that stores the scene and changes it between the map and different GUIs
 * im about to stackOverthrow
 * 
 * @author Eric Chen and the thousands of reddit/stackoverflow threads
 * @version ALPHA.6.7
 */
public class ViewManager {
    private static Scene scene;

    private static Parent mapRoot;
    private static DoorGUI doorGUI;

    //Setters
    public static void setScene(Scene newScene){
        scene = newScene;
    }

    public static void setRoot(StackPane root){
        scene.setRoot(root);
    }

    public static void setMapRoot(Parent root){
        mapRoot = root;
    }

    //getters
    public static Scene getScene(){
        return scene;
    }

    public static void init(){
        doorGUI = new DoorGUI();
    }

    //Open each gui
    public static void openDoorGUI(Door door, GameMap map){
        scene.setRoot(doorGUI.getRoot());
        doorGUI.open(door, map);
    }

    public static void openMap(){
        scene.setRoot(mapRoot);
    }
}
