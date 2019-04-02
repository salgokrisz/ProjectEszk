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
public class Scarlet extends Role{

    public Scarlet( String playerName) {
        super(playerName);
        this.color=Color.RED;
    }
    public Scarlet(Scarlet other){
        super( other.getPlayerName());
        this.color=other.getColor();
        this.abilityIsAvailable=other.getAbilityIsAvailable();
    }
      public Object clone(){
        return new Scarlet(this);
    }
    @Override
    public void useSpecialAbility() {
       //TODO: write Scarlet's special ability
    }
    
    
}
