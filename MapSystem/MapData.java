package MapSystem;
//believe me I know it's bad to have to compile this junk every time, but i really REALLY don't want to, theres literally no time and we are done NOTHING

import java.util.ArrayList;
import java.util.Arrays;

import CharacterSystem.PlainsBoss;
import MapSystem.Interactables.Boss.MapBoss;
import MapSystem.Interactables.Door.Door;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MapData {
    private static Tile gras = new Tile(new Image("Resources/Sprites/Grass.png",45.0 , 45.0, true, false), false);
    private static Tile tree = new Tile(new Image("Resources/Sprites/Tree.png",45.0 , 45.0, true, false), true);

    private static Interactable[] temp = new Interactable[]{
        new Door("Door", new int[]{0,5}, "a", new ImageView(new Image("/Resources/Sprites/DoorSmall.png",40,40,true,false))),
        new MapBoss("Boss", new int[]{4,1}, new PlainsBoss(), new Label("boss")),
    };
    public static ArrayList<Interactable> grasInteractables = new ArrayList<>(Arrays.asList(temp));

    public static Tile[][] GRASSLANDS_GRID = new Tile[][]{
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
}
