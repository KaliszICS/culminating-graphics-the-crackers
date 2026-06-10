package ItemSystem.Items;

import CharacterSystem.Player;
import ItemSystem.Item;

public class GoodBread extends Item{

    public GoodBread(String name) {
        super(name);
    }

    @Override
    public void use(Player p){
        p.heal(30);

        p.getInventory().getItems().remove(this);
    }
    
}
