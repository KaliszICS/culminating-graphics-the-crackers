
import CharacterSystem.Player;
import Graphics.ViewManager;
import ItemSystem.Item;
import MapSystem.GameMap;
import MapSystem.MapData;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HelloFX extends Application {
    public GameMap map;
    public Player player;

    @Override
    public void start(Stage stage) {
        player = new Player("Player", 1000, 100, 0, 500);

        map = new GameMap(MapData.GRASSLANDS_GRID, new int[]{5,8}, player, MapData.grasInteractables);
        map.updateMap();

        Parent mapRoot = map.getRoot();

        Scene scene = new Scene(mapRoot, 640,480, Color.AQUA);

        ViewManager.setMapRoot(mapRoot);
        ViewManager.setScene(scene);
        ViewManager.init();

        player.getInventory().getItems().add(new Item("A"));
        player.getInventory().getItems().add(new Item("AB"));
        player.getInventory().getItems().add(new Item("ABC"));
        player.getInventory().getItems().add(new Item("ABCD"));
        player.getInventory().getItems().add(new Item("ABCDE"));
        player.getInventory().getItems().add(new Item("ABCDEF"));

        stage.setResizable(false); //sorry, but i physically CAN'T get the scenes to stay centered when resized, also noVNC still has the maximize button, whyyy
        stage.setScene(scene);
        stage.setTitle("Epicness game");
        stage.show();
        
        scene.setOnKeyPressed(event -> {
            map.doKeyBehaviour(event.getCode());
        });
    }

    public static void main(String[] args) {
        launch();
    }

}