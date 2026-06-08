package MapSystem.Interactables.Door;

import Graphics.ViewManager;
import MapSystem.GameMap;
import MapSystem.Interactable;
import javafx.scene.Node;

public class Door extends Interactable{
    private String code;

    public Door(String name, int[] pos, String code, Node art){
        super(name, pos, art);
        this.code = code;
    }

    public Door(String name, int[] pos, String code){
        super(name, pos);
        this.code = code;
    }

    //Getters
    public String getCode(){
        return this.code;
    }

    //Methods

    @Override
    public boolean interact(GameMap map){
        map.setCanMove(false);

        ViewManager.openDoorGUI(this, map);
        return false;
    }
}
