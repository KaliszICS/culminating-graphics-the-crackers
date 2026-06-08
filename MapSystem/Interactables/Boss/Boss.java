package MapSystem.Interactables.Boss;

import Graphics.ViewManager;
import MapSystem.GameMap;
import MapSystem.Interactable;
import javafx.scene.Node;

public class Boss extends Interactable{
    //Should have a sort of Character or any kind of fighter class, but there's no battle system lowk

    public Boss(String name, int[] pos, Node art){
        super(name, pos, art);
    }

    @Override
    public boolean interact(GameMap map){
        ViewManager.openBattle(null, map);
        return true;
    }
}
