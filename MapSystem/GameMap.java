package MapSystem;
import java.util.ArrayList;
import java.util.Arrays;

import CharacterSystem.Player;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 * Games map object. Stores tile grid map, player position, and interactable position
 * handles movement on key press and handling interaction with interactables.
 * Yes this class does too much and yes it is coupling hell
 * 
 * @author Eric Chen
 * @version v0.067
 */
public class GameMap {
    private Tile[][] grid;
    private int[] playerPos;
    private ArrayList<Interactable> interactables;
    private boolean canMove = true;
    private Player player;
    GridPane mapGrid = new GridPane();
    StackPane mapRoot = new StackPane(mapGrid);

    public GameMap(Tile[][] grid, int[] playerStartPos, Player player){
        this.grid = grid;
        this.playerPos = playerStartPos;
        interactables = new ArrayList<>();

        initMap(mapGrid);
    }

    public GameMap(Tile[][] grid, int[] playerStartPos, Player player,ArrayList<Interactable> interactables){
        this.grid = grid;
        this.playerPos = playerStartPos;
        this.interactables = interactables;
        this.player = player;

        initMap(mapGrid);
    }

    //Getters
    public Tile[][] getGrid(){
        return this.grid;
    }

    public int[] getPlayerPos(){
        return this.playerPos;
    }

    public Player getPlayer(){
        return this.player;
    }

    //Setters
    public void setGrid(Tile[][] grid){
        this.grid = grid;
    }

    public void setPlayerPos(int[] playerPos){
        this.playerPos = playerPos;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public void setCanMove(boolean canMove){
        this.canMove = canMove;
    }

    public void setInteractables(ArrayList<Interactable> interactables){
        this.interactables = interactables;
    }

    public void addInteractable(Interactable i){
        interactables.add(i);
    }

    public Interactable removeInteractable(Interactable i){
        interactables.remove(i);

        return i;
    }

    //Methods

    /**
     * Moves the playerpos by a vector  
     * @param moveVector The vector to be added to playerpos
     */
    public void move(int[] moveVector){
        if(!canMove){return;}
        int[] resultVector = new int[]{playerPos[0] + moveVector[0], playerPos[1] + moveVector[1]};

        Interactable found = findInteractable(resultVector);

        if(found != null){
            found.interact(this);
        } else if(resultVector[0] < grid.length && resultVector[1] < grid[0].length && resultVector[0] >= 0 && resultVector[1] >= 0){

            if(grid[resultVector[0]][resultVector[1]].isCollidable()){return;}

            playerPos[0] += moveVector[0];
            playerPos[1] += moveVector[1];
        } 

        updateMap();
        //ADD ERROR LOGIC
    }

    /**
     * returns an interactable if interactable at position interactvector
     * @param interactVector position to be checked
     * @return interactable found, or null if not found
     */
    public Interactable findInteractable(int[] interactVector){
        Interactable found = null;

        for(Interactable i : interactables){
            if (Arrays.equals(interactVector, i.getPos())){
                found = i;
                break;
            }
        }

        return found;
    }

    /**
     * Run move() based on the key pressed
     * @param k Keycode of key pressed
     */
    public void doKeyBehaviour(KeyCode k){
        //this is going to be pretty yikes methinks

        switch(k.toString()){
            case "UP", "W":
                move(new int[]{0,-1});
                break;
            case "DOWN", "S":
                move(new int[]{0,1});
                break;
            case "LEFT", "A":
                move(new int[]{-1,0});
                break;
            case "RIGHT", "D":
                move(new int[]{1,0});
                break;
        }

    }

    //MAP GRAPHICS
    StackPane playerIcon = new StackPane(new ImageView(new Image("/Resources/Sprites/PlayerSmall.png",20,20,true,false))); //change this when we have like a player singleton or something

    public void initMap(GridPane map){
        map.setAlignment(Pos.CENTER);
        mapRoot.setBackground(Background.fill(Color.GREEN));
    }

    /**
     * redraws the entire map (because i suck at coding lol)
     */
    public void updateMap(){
        //Yes, everytime the player moves the map will be redrawn completely, this kinda sux, but javaFX is not a game engine
        mapGrid.getChildren().clear();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                mapGrid.add(new ImageView(grid[i][j].getSprite()), i, j);
            }
        } //crap bro, nodes longer than the tile sprites elongate the grid leaving gaps

        mapGrid.add(playerIcon,playerPos[0],playerPos[1]);

        for(Interactable i : interactables){
            mapGrid.add(i.getArt(), i.getPos()[0], i.getPos()[1]); //I really should separate updating entities and updating the map, but whatever
        }
    }

    public StackPane getRoot(){
        return this.mapRoot;
    }
}
