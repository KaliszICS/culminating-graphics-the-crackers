package Graphics.GUIs;

import MapSystem.GameMap;
import MapSystem.Interactables.Boss.MapBoss;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class BossGUI {
    private Parent root;
    private BossController controller;

    public BossGUI(){

        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Resources/GUI/BossGUI/BossGUI.fxml"));
            root = loader.load();
            controller = loader.getController();
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public Parent getRoot(){
        return this.root;
    }

    public void open(MapBoss boss, GameMap map){
        map.setCanMove(false);

        controller.setMapBoss(boss);
        controller.setMap(map);
        
        controller.init();
    }
}
