package MapSystem.Interactables.Door;

import Graphics.ViewManager;
import MapSystem.GameMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DoorController {
    private GameMap map;
    private Door door;

    public void setEnd(GameMap map){
        this.map = map;
    }

    public void setDoor(Door door){
        this.door = door;
    }

    @FXML
    private TextField codeBox;

    @FXML
    public void exit(ActionEvent e){
        ViewManager.setRoot(map.getRoot());
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
