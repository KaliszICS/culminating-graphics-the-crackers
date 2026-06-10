package MapSystem;

import javafx.scene.image.Image;

/**
 * Basic tile class for GameMap
 * @author Eric Chen
 * @version v67
 */

public class Tile {
    private Image sprite;
    private boolean isCollidable;

    public Tile(Image sprite, boolean isCollidable){
        this.sprite = sprite;
        this.isCollidable = isCollidable;
    }

    public Image getSprite(){
        return this.sprite;
    }

    public boolean isCollidable(){
        return this.isCollidable;
    }

    public void setSprite(Image sprite){
        this.sprite = sprite;
    }
}
