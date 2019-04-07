/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.role;

/**
  This class represents a character called Plum.
 * Every character have a special ability.
 * This class extends the Role class.
 */
public class Plum extends Role{

    public Plum(String playerName) {
        super(playerName);
        this.color=Color.PURPLE;
    }
    public Plum(Plum other){
        super(other.getName());
         this.color=other.getColor();
        this.abilityIsAvailable=other.getAbilityIsAvailable();
    }
      public Object clone(){
        return new Plum(this);
    }
    @Override
    public void useSpecialAbility() {
        //TODO: write Plum's special ability
    }
    
}
