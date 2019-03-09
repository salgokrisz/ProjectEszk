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
public class Mustard extends Player{

    public Mustard(boolean isComputer, String playerName) {
        super(isComputer, playerName);
        this.color=Color.ORANGE;
    }
    public Mustard(Mustard other){
        super(other.getIsComputer(), other.getPlayerName());
        this.color=other.getColor();
        this.abilityIsAvailable=other.getAbilityIsAvailable();
    }
      public Object clone(){
        return new Mustard(this);
    }
    @Override
    public void useSpecialAbility() {
        //TODO: write Mustard's special ability
    }
    
}
