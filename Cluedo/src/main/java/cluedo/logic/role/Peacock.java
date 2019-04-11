/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.role;

/**
  This class represents a character called Peacock.
 * Every character have a special ability.
 * This class extends the Role class.
 */
public class Peacock extends Role{

    public Peacock(String playerName) {
        super(playerName);
        this.color=Color.BLUE;
    }
    public Peacock(Peacock other){
        super( other.getName());
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