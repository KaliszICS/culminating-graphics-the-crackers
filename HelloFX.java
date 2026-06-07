
import Graphics.ViewManager;
import MapSystem.GameMap;
import MapSystem.MapControls;
import MapSystem.Interactables.Door.Door;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HelloFX extends Application {
    public GameMap map = new GameMap(new String[][]{
            {"o","o","o","o","o","o","o","o","o","o",},
            {"o","o","o","o","o","o","o","o","o","o",},
            {"o","o","o","o","o","o","o","o","o","o",},
            {"o","o","o","o","o","o","o","o","o","o",},
            {"o","o","o","o","o","o","o","o","o","o",},
            {"o","o","o","o","o","o","o","o","o","o",},
            {"o","o","o","o","o","o","o","o","o","o",},
            {"o","o","o","o","o","o","o","o","o","o",},
            {"o","o","o","o","o","o","o","o","o","o",},
            {"o","o","o","o","o","o","o","o","o","o",},
        }, new int[]{0,0});
    public MapControls mC = new MapControls(map);

    @Override
    public void start(Stage stage) {
        map.addInteractable(new Door("door", new int[]{3,3}, "a"));
        map.updateMap();

        Parent mapRoot = map.getRoot();

        Scene scene = new Scene(mapRoot, 640,480, Color.AQUA);

        ViewManager.setScene(scene);
        stage.setScene(scene);
        stage.show();
        
        //Keystroke functionality
        scene.setOnKeyPressed(event -> {
            mC.doKeyBehaviour(event.getCode());
        });
    }

    public static void main(String[] args) {
        launch();
    }

}