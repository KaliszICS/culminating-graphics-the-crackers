package MapSystem.Interactables.Door;

import Graphics.ViewManager;
import MapSystem.GameMap;
import MapSystem.Interactable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class Door extends Interactable{
    private String code;
    private StackPane root;

    public Door(String name, int[] pos, String code, Node art){
        super(name, pos, art);
        this.code = code;
    }

    public Door(String name, int[] pos, String code){
        super(name, pos);
        this.code = code;
    }

    //Getters
    public String getCode(){
        return this.code;
    }

    public Parent getRoot(){
        return this.root;
    }

    //Methods

    @Override
    public boolean interact(GameMap map){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DoorUI1.fxml"));

        try{
            root = loader.load();
            
        } catch(Exception e){
            e.printStackTrace();
        }

        root = new StackPane(root);

        DoorController controller = loader.getController();
        controller.setEnd(map);
        controller.setDoor(this);

        root.setBackground(Background.fill(Color.GREEN));
        ViewManager.setRoot(root);
        map.setCanMove(false);

        return false;
    }
}
