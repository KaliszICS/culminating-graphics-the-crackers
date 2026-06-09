//Just something quick and crappy because i needed something that at least worked

import CharacterSystem.Player;

public class TempBattleSystem {
    private Player player;
    private Character enemy;
    private String state;

    //Getters
    public Player getPlayer(){
        return this.player;
    }

    public Character getEnemy(){
        return this.enemy;
    }

    public String getState(){
        return this.state;
    }

    //Setters
    public void setPlayer(Player p){
        this.player = p;
    }

    public void setEnemy(Character c){
        this.enemy = c;
    }

    
}