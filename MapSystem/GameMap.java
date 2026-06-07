package MapSystem;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class GameMap {
    private Tile[][] grid;//replace with actual tiles because representing stuff with strings suk

    //Im not even sure if this is bad practice, but I'm too lazy to use anything new
    private int[] playerPos;
    private ArrayList<Interactable> interactables;
    private boolean canMove = true;

    //for graphics
    GridPane mapGrid = new GridPane();
    StackPane mapRoot = new StackPane(mapGrid);

    public GameMap(Tile[][] grid, int[] playerStartPos){
        this.grid = grid;
        this.playerPos = playerStartPos;
        interactables = new ArrayList<>();

        initMap(mapGrid);
    }

    public GameMap(Tile[][] grid, int[] playerStartPos, ArrayList<Interactable> interactables){
        this.grid = grid;
        this.playerPos = playerStartPos;
        this.interactables = interactables;

        initMap(mapGrid);
    }

    //Getters
    public Tile[][] getGrid(){
        return this.grid;
    }

    public int[] getPlayerPos(){
        return this.playerPos;
    }

    //Setters
    public void setGrid(Tile[][] grid){
        this.grid = grid;
    }

    public void setPlayerPos(int[] playerPos){
        this.playerPos = playerPos;
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
    public void move(int[] moveVector){
        if(!canMove){return;}
        int[] resultVector = new int[]{playerPos[0] + moveVector[0], playerPos[1] + moveVector[1]};

        Interactable found = findInteractable(resultVector);
        System.out.println("A");

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

    //MAP GRAPHICS
    Label player = new Label("Player");

    public void initMap(GridPane map){
        map.setAlignment(Pos.CENTER);
        mapRoot.setBackground(Background.fill(Color.GREEN));
    }

    public void updateMap(){
        //Yes, everytime the player moves the map will be redrawn completely, this kinda sux, but javaFX is not a game engine
        mapGrid.getChildren().clear();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                mapGrid.add(new ImageView(grid[i][j].getSprite()), i, j);
            }
        }

        mapGrid.add(player,playerPos[0],playerPos[1]);

        for(Interactable i : interactables){
            mapGrid.add(i.getArt(), i.getPos()[0], i.getPos()[1]);
        }
    }

    public GridPane getGP(){
        return this.mapGrid;
    }

    public StackPane getRoot(){
        return this.mapRoot;
    }
}
