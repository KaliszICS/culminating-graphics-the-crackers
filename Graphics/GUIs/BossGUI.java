package Graphics.GUIs;

import MapSystem.GameMap;
import MapSystem.Interactables.Boss.Boss;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class BossGUI {
    private Parent root;
    //private BossController controller;

    public BossGUI(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Resources/GUI/DoorGUI/DoorUI1.fxml"));
            root = loader.load();
            //controller = loader.getController();
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public Parent getRoot(){
        return this.root;
    }

    public void open(Boss boss, GameMap map){

    }
}
