/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.players;

/**
 *
 * @author Barby
 */
public class White extends Player{
    
    public White(boolean isComputer, String playerName) {
        super(isComputer, playerName);
        color=Color.WHITE;
    }
    public White(White other){
        super(other.getIsComputer(), other.getPlayerName());
        this.abilityIsAvailable=other.getAbilityIsAvailable();
        this.color=other.getColor();
    }
      public Object clone(){
        return new White(this);
    }
    @Override
    public void useSpecialAbility() {
        //TODO: implement White's ability
    }
    
}
