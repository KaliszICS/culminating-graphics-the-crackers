package MapSystem.Interactables.MagicWand;

import ItemSystem.Items.MagicWand;
import MapSystem.GameMap;
import MapSystem.Interactable;
import javafx.scene.Node;

public class MapMagicWand extends Interactable{

    public MapMagicWand(String name, int[] pos, Node art) {
        super(name, pos, art);
    }

    @Override
    public boolean interact(GameMap map){
        map.getPlayer().getInventory().getItems().add(new MagicWand("Healing Wand"));
        map.removeInteractable(this);
        return true;
    }
    
}
