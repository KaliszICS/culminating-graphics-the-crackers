package Graphics;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class ViewManager {
    public static Scene scene;
    public static String viewState;

    //Setters
    public static void setScene(Scene newScene){
        scene = newScene;
    }

    public static void setRoot(StackPane root){
        scene.setRoot(root);
    }

    public static void setState(String state){
        viewState = state;
    }

    //getters
    public static Scene getScene(){
        return scene;
    }

    public static String getState(){
        return viewState;
    }

}
