/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.role;

/**
 *
 * @author Barby
 */
public class Mustard extends Role{

    public Mustard(String playerName) {
        super(playerName);
        this.color=Color.ORANGE;
    }
    public Mustard(Mustard other){
        super(other.getPlayerName());
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
