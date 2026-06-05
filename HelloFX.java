import java.awt.Paint;

import MapSystem.Map;
import MapSystem.MapControls;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HelloFX extends Application {
    public Map map = new Map(new String[][]{
            {"o","o","o","o","o","o","o","o",},
            {"o","o","o","o","o","o","o","o",},
            {"o","o","o","o","o","o","o","o",},
            {"o","o","o","o","o","o","o","o",},
            {"o","o","o","o","o","o","o","o",},
            {"o","o","o","o","o","o","o","o",},
            {"o","o","o","o","o","o","o","o",},
            {"o","o","o","o","o","o","o","o",},
        }, new int[]{0,0});
    public MapControls mC = new MapControls(map);

    @Override
    public void start(Stage stage) {
        //String javaVersion = System.getProperty("java.version");
        //String javafxVersion = System.getProperty("javafx.version");
        //Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        //Scene scene = new Scene(new StackPane(l), 640, 480);

        GridPane mapGrid = map.getGP();
        map.updateMap();
        
        Scene mapScene = new Scene(mapGrid, 640,480);

        stage.setScene(mapScene);
        stage.show();

        //Keystroke functionality
        mapScene.setOnKeyPressed(event -> {
            stage.setTitle(event.getCode().toString());

            mC.doKeyBehaviour(event.getCode());
        });
    }

    public static void main(String[] args) {
        launch();
    }

}