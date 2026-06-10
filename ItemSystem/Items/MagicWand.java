package ItemSystem.Items;

import CharacterSystem.Player;
import ItemSystem.Item;

    /**
     * Class for the Magic Wand
     * @author Dorian Goobie
     * @param HP
     * @param MP
     */

public class MagicWand extends Item{

    public MagicWand(String name) {
        super(name);
    }

    @Override
    public void use(Player p){
        p.heal(Math.min(50, p.getCurrentMP()));
        p.useMP(Math.min(50, p.getCurrentMP()));
    }
    
}
