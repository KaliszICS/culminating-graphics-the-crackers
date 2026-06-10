package Graphics.GUIs;

import Graphics.ViewManager;
import MapSystem.GameMap;
import MapSystem.Interactables.Door.Door;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * FXML controller for door gui
 * @author Eric Chen
 * @version 0.0.7.7.7 (CASH MONEY :moneyeyes:)
 */
public class DoorController {
    private GameMap map;
    private Door door;

    public void setMap(GameMap map){
        this.map = map;
    }

    public void setDoor(Door door){
        this.door = door;
    }

    @FXML
    private TextField codeBox;

    @FXML
    public void exit(ActionEvent e){

        ViewManager.openMap();
        map.setCanMove(true);
    }

    @FXML
    public void submit(ActionEvent e){
        if(codeBox.getText().equals(this.door.getCode())){
            map.removeInteractable(door);
            ViewManager.setRoot(map.getRoot());
            map.setCanMove(true);
            map.updateMap();
        }
    }
}
