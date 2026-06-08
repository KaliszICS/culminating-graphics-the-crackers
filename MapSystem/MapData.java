package MapSystem;
//believe me I know it's bad to have to compile this junk every time, but i really REALLY don't want to, theres literally no time and we are done NOTHING

import java.util.ArrayList;
import java.util.Arrays;
import MapSystem.Interactables.Door.Door;
import javafx.scene.image.Image;

public class MapData {
    private static Tile gras = new Tile(new Image("Resources/Sprites/Grass.png",45.0 , 45.0, true, false), false);
    private static Tile tree = new Tile(new Image("Resources/Sprites/Tree.png",45.0 , 45.0, true, false), true);

    private static Interactable[] temp = new Interactable[]{
        new Door("Door", new int[]{0,5}, "a")
    };
    private static ArrayList<Interactable> grasInteractables = new ArrayList<>(Arrays.asList(temp));

    private static Tile[][] GRASSLANDS_GRID = new Tile[][]{
        {gras,gras,gras,gras,gras,gras,gras,gras,gras,gras,},
        {gras,gras,tree,tree,gras,tree,gras,gras,gras,gras,},
        {gras,tree,gras,gras,tree,tree,gras,gras,gras,gras,},
        {tree,gras,gras,gras,gras,tree,gras,gras,gras,gras,},
        {tree,gras,gras,gras,gras,gras,gras,gras,gras,gras,},
        {tree,gras,gras,gras,gras,tree,gras,gras,gras,gras,},
        {gras,tree,gras,gras,tree,tree,gras,gras,gras,gras,},
        {gras,gras,tree,tree,gras,tree,gras,gras,gras,gras,},
        {gras,gras,gras,gras,gras,gras,gras,gras,gras,gras,},
        {gras,gras,gras,gras,gras,gras,gras,gras,gras,gras,},
    }; //THE MAP IS COMPLETELY FLIPPED DIAGONALLY FRICK ME BRRR

    public static GameMap GRASSLANDS = new GameMap(GRASSLANDS_GRID, new int[]{5,8}, grasInteractables);

}
