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
public class Green extends Role{
    public Green(String playerName){
        super( playerName);
        this.color=Color.GREEN;
    }
    public Green(Green other){
        super(other.getPlayerName());
         this.color=other.getColor();
        this.abilityIsAvailable=other.getAbilityIsAvailable();
    }
      public Object clone(){
        return new Green(this);
    }
    @Override
    public void useSpecialAbility() {
        //TODO: write Green's special ability
    }
    
}
