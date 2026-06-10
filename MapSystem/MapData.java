package MapSystem;
//believe me I know it's bad to have to compile this junk every time, but i really REALLY don't want to, theres literally no time and we are done NOTHING

import java.util.ArrayList;
import java.util.Arrays;

import CharacterSystem.CaveBoss;
import CharacterSystem.PlainsBoss;
import CharacterSystem.UnderworldBoss;
import ItemSystem.Item;
import ItemSystem.Items.Bread;
import ItemSystem.Items.GoodBread;
import MapSystem.Interactables.Boss.MapBoss;
import MapSystem.Interactables.Door.Door;
import MapSystem.Interactables.MagicWand.MapMagicWand;
import MapSystem.Interactables.Chest.Chest;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MapData {
    private static Tile gras = new Tile(new Image("Resources/Sprites/Grass.png",45.0 , 45.0, true, false), false);
    private static Tile tree = new Tile(new Image("Resources/Sprites/Tree.png",45.0 , 45.0, true, false), true);

    private static Interactable[] temp = new Interactable[]{
        new Door("Door", new int[]{0,5}, "a", new ImageView(new Image("/Resources/Sprites/DoorSmall.png",40,40,true,false))),
        new MapBoss("Boss", new int[]{4,1}, new PlainsBoss(), new ImageView(new Image("/Resources/Sprites/greenBoss.png",40,40,true,false))),
        new MapMagicWand("Wand", new int[]{0,0}, new ImageView(new Image("/Resources/Sprites/MagicWand.png",40,40,true,false))),
        new Chest("Chest", new int[]{9,0}, new Item[]{
            new Bread("Bread", 20, 10),
            new GoodBread("Good Bread"),
        }, new ImageView(new Image("/Resources/Sprites/Chest.png",40,40,true,false)))
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

    private static Tile ston = new Tile(new Image("Resources/Sprites/Stone.png",45.0 , 45.0, true, false), false);
    private static Tile rock = new Tile(new Image("Resources/Sprites/Rock.png",45.0 , 45.0, true, false), true);
    private static Tile crys = new Tile(new Image("Resources/Sprites/Crystal.png",45.0 , 45.0, true, false), true);

    private static Interactable[] temp2 = new Interactable[]{
        new MapBoss("Boss", new int[]{4,3}, new CaveBoss(), new ImageView(new Image("/Resources/Sprites/BlueBoss.png",40,40,true,false)))
    };

    public static ArrayList<Interactable> caveInteractables = new ArrayList<>(Arrays.asList(temp2));
    public static Tile[][] CAVES_GRID = new Tile[][]{
        {rock,rock,ston,ston,ston,ston,ston,rock,rock},
        {rock,ston,ston,ston,ston,ston,ston,ston,rock},
        {ston,ston,rock,rock,rock,ston,ston,ston,ston},
        {ston,rock,crys,ston,crys,rock,ston,ston,ston},
        {ston,ston,ston,ston,ston,rock,ston,ston,ston},
        {ston,rock,crys,ston,crys,rock,ston,ston,ston},
        {ston,ston,rock,rock,rock,ston,ston,ston,ston},
        {rock,ston,ston,ston,ston,ston,ston,ston,rock},
        {rock,rock,ston,ston,ston,ston,ston,rock,rock},
    };

    private static Tile hrak = new Tile(new Image("Resources/Sprites/HellFloor.png",45.0 , 45.0, true, false), false);
    private static Tile lava = new Tile(new Image("Resources/Sprites/Lava.png",45.0 , 45.0, true, false), true);
    private static Tile hbug = new Tile(new Image("Resources/Sprites/Hbug.png",45.0 , 45.0, true, false), true);
    private static Tile tort = new Tile(new Image("Resources/Sprites/Torch.png",45.0 , 45.0, true, false), true);

    private static Interactable[] temp3 = new Interactable[]{
        new MapBoss("Boss", new int[]{12,4}, new UnderworldBoss(), new ImageView(new Image("/Resources/Sprites/RedBoss.png",40,40,true,false)))
    };

    public static ArrayList<Interactable> underworldInteractables = new ArrayList<>(Arrays.asList(temp3));

    public static Tile[][] UNDERWORLD_GRID = new Tile[][]{
        {lava,lava,lava,tort,hrak,tort,lava,lava,lava,},
        {lava,lava,lava,hrak,hrak,hrak,lava,lava,lava,},
        {lava,lava,lava,tort,hrak,tort,lava,lava,lava,},
        {lava,lava,lava,hrak,hrak,hrak,lava,lava,lava,},
        {lava,lava,lava,tort,hrak,tort,lava,lava,lava,},
        {lava,lava,lava,hrak,hrak,hrak,lava,lava,lava,},
        {lava,lava,hrak,hrak,hrak,hrak,hrak,lava,lava,},
        {lava,hbug,hrak,hbug,hrak,hbug,hrak,hbug,lava,},
        {lava,hrak,hrak,hrak,hrak,hrak,hrak,hrak,lava,},
        {lava,hbug,hrak,hbug,hrak,hbug,hrak,hbug,lava,},
        {lava,hrak,hrak,hrak,hrak,hrak,hrak,hrak,lava,},
        {lava,hbug,hrak,hrak,hrak,hrak,hrak,hbug,lava,},
        {lava,lava,hrak,tort,hrak,tort,hrak,lava,lava,},
    };

}
