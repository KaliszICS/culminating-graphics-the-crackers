package MapSystem.Interactables.Chest;

import java.util.Arrays;

import ItemSystem.Item;
import MapSystem.GameMap;
import MapSystem.Interactable;
import javafx.scene.Node;

public class Chest extends Interactable{
    private Item[] items;

    public Chest(String name, int[] position, Item[] items, Node art){
        super(name, position, art);

        this.items = items;
    }

    @Override
    public boolean interact(GameMap map){
        map.getPlayer().getInventory().getItems().addAll(Arrays.asList(items));
        map.removeInteractable(this);
        return true;
    }
}
