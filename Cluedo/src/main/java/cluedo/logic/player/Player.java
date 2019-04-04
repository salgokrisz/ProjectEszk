/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.player;

import cluedo.logic.role.Role;

/**
 * This class represents the Players, and can tell
 * the role which the player plays.
 * This class is the parent class of the Ai class.
 * 
 */
public class Player {
    protected Role role;
    protected final boolean isComputer;
     
    public Player(Role role,boolean isComputer){
        this.isComputer=isComputer;
        this.role = role;
    }
    
    public boolean getIsComputer() {
        return isComputer;
    }
    
    public Role getRole(){
        return role;
    }
}
