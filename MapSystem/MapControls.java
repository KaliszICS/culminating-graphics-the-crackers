package MapSystem;

import javafx.scene.input.KeyCode;

public class MapControls {
    private GameMap map;

    public MapControls(GameMap map){
        this.map = map;
    }

    //GettersSetters
    public GameMap getMap(){
        return this.map;
    }

    public void setMap(GameMap map){
        this.map = map;
    }

    public void doKeyBehaviour(KeyCode k){
        //this is going to be pretty yikes methinks

        switch(k.toString()){
            case "UP", "W":
                map.move(new int[]{0,-1});
                break;
            case "DOWN", "S":
                map.move(new int[]{0,1});
                break;
            case "LEFT", "A":
                map.move(new int[]{-1,0});
                break;
            case "RIGHT", "D":
                map.move(new int[]{1,0});
                break;
        }

    }
}
