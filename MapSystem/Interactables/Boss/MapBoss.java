package MapSystem.Interactables.Boss;

import CharacterSystem.Boss;
import Graphics.ViewManager;
import MapSystem.GameMap;
import MapSystem.Interactable;
import javafx.scene.Node;

public class MapBoss extends Interactable{
    Boss boss;

    public MapBoss(String name, int[] pos, Boss boss, Node art){
        super(name, pos, art);
        this.boss = boss;
    }

    @Override
    public boolean interact(GameMap map){
        ViewManager.openBattle(this, map);
        return true;
    }

    public void setBoss(Boss boss){
        this.boss = boss;
    }

    public Boss getBoss(){
        return this.boss;
    }
}
