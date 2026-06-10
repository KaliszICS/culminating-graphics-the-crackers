package ItemSystem;

    /**
     * Class for the Magic Wand
     * @author Dorian Goobie
     * @param HP
     * @param MP
     */

public class MagicWand extends Item {
    private int HP;
    protected int MP;

    public MagicWand(String name){
        super(name);
    }

    /**
     * Methods describing the name, heal points and magic points of the healing item
     */

    public String Item(String name){
        this.name = name;
        return name;
    }

    public int Heal(int HP){
        this.HP = HP;
        return HP;
    }

    public int Magic(int MP){
        return MP;
    }

    @Override
    public String toString(){
        return this.name;
    }
    public int returnHP() {
        return this.HP;
    }
}