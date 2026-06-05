package MapSystem;

import java.awt.Button;
import java.util.Arrays;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Map {
    private String[][] grid;
    private int[] playerPos;

    public Map(String[][] grid, int[] playerStartPos){
        this.grid = grid;
        this.playerPos = playerStartPos;
    }

    //Getters
    public String[][] getGrid(){
        return this.grid;
    }

    public int[] getPlayerPos(){
        return this.playerPos;
    }

    //setters
    public void setGrid(String[][] grid){
        this.grid = grid;
    }

    public void setPlayerPos(int[] playerPos){
        this.playerPos = playerPos;
    }

    //methods
    public void move(int[] moveVector){
        if(playerPos[0] + moveVector[0] < grid.length && playerPos[1] + moveVector[1] < grid[0].length && playerPos[0] + moveVector[0] >= 0 && playerPos[1] + moveVector[1] >= 0){
            playerPos[0] += moveVector[0];
            playerPos[1] += moveVector[1];
        }

        updateMap();

        //ADD ERROR LOGIC
    }

    //MAP GRAPHICS
    GridPane mapGrid = new GridPane();
    Label player = new Label("Player");

    public void updateMap(){
        mapGrid.getChildren().clear();
        mapGrid.setAlignment(Pos.CENTER);

        for(int i = 0; i < grid.length; i++){
            Rectangle tile = new Rectangle(45,45);
            tile.setFill(Color.BLUE);
            mapGrid.add(tile, i, i);
        }

        mapGrid.add(player,playerPos[0],playerPos[1]);
    }

    public GridPane getGP(){
        return this.mapGrid;
    }
}
