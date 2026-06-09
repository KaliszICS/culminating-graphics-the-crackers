package Graphics.GUIs;

import MapSystem.GameMap;
import MapSystem.Interactables.Boss.Boss;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class BossController {
    private GameMap map;
    private Boss boss;
    
    @FXML
    private ImageView background;

    @FXML
    private ImageView playerSprite;
    
    @FXML
    private ImageView bossSprite;

    @FXML
    private Button attackButton;

    @FXML
    private Button defendButton;

    @FXML
    private Button invButton;

    @FXML
    private Label playerHP;

    @FXML
    private Label bossHP;

    @FXML
    private AnchorPane inventoryView;

    @FXML
    private ListView<String> inventoryList;

    @FXML
    private TextField invSearch;

    @FXML
    private Button useButton;

    @FXML
    public void attack(ActionEvent e){

    }

    @FXML
    public void defend(ActionEvent e){

    }

    @FXML
    public void openInv(ActionEvent e){
        this.inventoryView.setVisible(!this.inventoryView.isVisible());
    }

    @FXML
    public void typed(ActionEvent e){

    }

    @FXML
    public void tryUse(ActionEvent e){

    }

    //actual methods

    public void setMap(GameMap map){
        this.map = map;
    }

    public void setBoss(Boss boss){
        this.boss = boss;
    }


    public void closeInv(){
        this.inventoryView.setVisible(false);
    }

}
