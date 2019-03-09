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
public class Peacock extends Player{

    public Peacock(boolean isComputer, String playerName) {
        super(isComputer, playerName);
        this.color=Color.BLUE;
    }
    public Peacock(Peacock other){
        super(other.getIsComputer(), other.getPlayerName());
        this.color=other.getColor();
        this.abilityIsAvailable=other.getAbilityIsAvailable();
    }
      public Object clone(){
        return new Peacock(this);
    }
    @Override
    public void useSpecialAbility() {
        //TODO: write Peacock's special ability
    }
    
}
