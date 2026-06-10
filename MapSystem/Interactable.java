package MapSystem;

import javafx.scene.Node;
import javafx.scene.control.Label;


/**
 * Interactable superclass, does interacting, and also is coupling hell
 * @author Eric Chen
 * @version v-0.067
 */
public class Interactable {
    protected String name;
    protected int[] position;
    protected Node art; //LABEL FOR PLACEHOLDER, CHANGE FOR REAL SPRITE

    /**
     * Constructor for Interactable object
     * @param name name/default art of interactable
     * @param pos position on map (this system sucks I know)
     */
    public Interactable(String name, int[] pos){
        this.name = name;
        this.art = new Label(name);
        this.position = pos;
    }

    //Interactable constructor with set art sprite
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

    /**
     * Generic interact behaviour
     * @param map Pointer to map with interactable (because i suck at coding)
     * @return (Supposed to determine whether or not this is deleted after interaction, but it's kind of irrelevant)
     */
    public boolean interact(GameMap map){
        //Generic interaction
        return true;
    }

}
