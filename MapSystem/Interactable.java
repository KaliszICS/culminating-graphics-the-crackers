package MapSystem;

import javafx.scene.Node;
import javafx.scene.control.Label;

public class Interactable {
    protected String name;
    protected int[] position;
    protected Node art; //LABEL FOR PLACEHOLDER, CHANGE FOR REAL SPRITE

    public Interactable(String name, int[] pos){
        this.name = name;
        this.art = new Label(name);
        this.position = pos;
    }

    public Interactable(String name,int[] pos, Node art){
        this.name = name;
        this.art = art;
        this.position = pos;
    }

    //gettersSetters
    public String getName(){
        return this.name;
    }

    public int[] getPos(){
        return this.position;
    }

    public Node getArt(){
        return this.art;
    }

    //Methods
    public boolean interact(GameMap map){
        //Generic interaction
        return true;
    }

}
