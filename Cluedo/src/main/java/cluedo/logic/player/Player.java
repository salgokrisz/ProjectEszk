/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.player;

import cluedo.logic.role.Role;

/**
 *
 * @author Bence
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
