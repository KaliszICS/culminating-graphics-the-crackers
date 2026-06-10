package Graphics.GUIs;

import java.util.ArrayList;

import CharacterSystem.Boss;
import CharacterSystem.Player;
import Graphics.ViewManager;
import ItemSystem.Inventory;
import ItemSystem.Item;
import MapSystem.GameMap;
import MapSystem.Interactables.Boss.MapBoss;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

//Sadly this is going to have to be where all the battle stuff is because the battle system is wraps

public class BossController {
    private Player player;
    private Boss boss;
    private Inventory inv;
    private ArrayList<String> itemList;
    private double xDamage = 1; //damage multiplier to be set when defending, should probably be a value of Player but whatever

    private GameMap map;
    private MapBoss mapBoss;
    
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
    private Label playerMP;

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
        boss.takeDamage(player.getAttackDMG());
        passTurn();
    }

    @FXML
    public void defend(ActionEvent e){
        //funnily enough, this is never worth it, 
        this.xDamage = 0.2;
        passTurn();
    }

    @FXML
    public void openInv(ActionEvent e){
        this.inventoryView.setVisible(!this.inventoryView.isVisible());
    }

    @FXML
    public void typed(KeyEvent e){
        update();
    }

    @FXML
    public void tryUse(ActionEvent e){
        String temp = invSearch.getText().toLowerCase();

        for(Item i : inv.getItems()){
            if(i.toString().toLowerCase().equals(temp)){
                i.use(player);
                update();
                return;
            }
        }
    }

    //actual methods

    public void setMap(GameMap map){
        this.map = map;
    }

    public void setMapBoss(MapBoss boss){
        this.mapBoss = boss;
    }

    public void init(){
        closeInv();

        this.player = this.map.getPlayer();
        this.boss = this.mapBoss.getBoss();
        this.inv = player.getInventory();
        this.itemList = new ArrayList<>();
        ImageView temp = (ImageView) mapBoss.getArt();
        bossSprite.setImage(temp.getImage());

        update();
    }

    public void update(){
        playerHP.setText("HP: " + Integer.toString(player.getCurrentHP()));
        playerMP.setText("MP: " + Integer.toString(player.getCurrentMP()));

        bossHP.setText("HP: " + Integer.toString(boss.getCurrentHP()));

        itemList.clear();
        inventoryList.getItems().clear();

        for(Item i : inv.getItems()){
            if(i.toString().toLowerCase().contains(invSearch.getText().toLowerCase())){
                itemList.add(i.toString());
            }
        }

        inventoryList.getItems().addAll(itemList);
    }

    public void closeInv(){
        this.inventoryView.setVisible(false);
    }

    public void passTurn(){
        player.takeDamage((int) (boss.getAttackDMG()*xDamage));
        
        if(player.getCurrentMP() < 100){
            player.setCurrentMP(player.getCurrentMP() + Math.min(20,100-player.getCurrentMP()));//Set mana regen here ig
        }

        xDamage = 1;
        update();

        if(player.getCurrentHP() <= 0){
            ViewManager.getScene().setRoot(new StackPane(new Label("Dead (uh oh, not enough budget for a real game over screen)")));
        }

        if(boss.getCurrentHP() <= 0){
            map.setCanMove(true);
            map.removeInteractable(mapBoss);
            boss.defeat(map);
            map.updateMap();
        }
    }

}
