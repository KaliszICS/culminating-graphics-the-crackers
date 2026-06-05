package MapSystem;

import javafx.scene.input.KeyCode;

public class MapControls {
    private Map map;

    public MapControls(Map map){
        this.map = map;
    }

    //GettersSetters
    public Map getMap(){
        return this.map;
    }

    public void doKeyBehaviour(KeyCode k){
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
                System.out.println("D");
                break;
        }

    }
}
