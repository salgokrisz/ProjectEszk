/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.role;

/**
  This class represents a character called White.
 * Every character have a special ability.
 * This class extends the Role class.
 */
public class White extends Role {

    public White(String playerName) {
        super(playerName);
        color = Color.WHITE;
    }

    public White(White other) {
        super(other.getName());
        this.abilityIsAvailable = other.getAbilityIsAvailable();
        this.color = other.getColor();
    }

    public Object clone() {
        return new White(this);
    }

    @Override
    public void useSpecialAbility() {
        //TODO: implement White's ability
    }

}