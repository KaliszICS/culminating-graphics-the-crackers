
import Graphics.ViewManager;
import MapSystem.GameMap;
import MapSystem.MapData;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HelloFX extends Application {
    public GameMap map;

    @Override
    public void start(Stage stage) {
        map = MapData.GRASSLANDS;
        map.updateMap();

        Parent mapRoot = map.getRoot();

        Scene scene = new Scene(mapRoot, 640,480, Color.AQUA);

        ViewManager.setMapRoot(mapRoot);
        ViewManager.setScene(scene);
        ViewManager.init();

        stage.setResizable(false); //sorry, but i physically CAN'T get the scenes to stay centered when resized, also noVNC still has the maximize button, whyyy
        stage.setScene(scene);
        stage.show();
        
        scene.setOnKeyPressed(event -> {
            map.doKeyBehaviour(event.getCode());
        });
    }

    public static void main(String[] args) {
        launch();
    }

}