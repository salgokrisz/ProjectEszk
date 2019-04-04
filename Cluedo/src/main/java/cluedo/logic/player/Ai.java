/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.player;

import cluedo.logic.role.Role;

/**
 * This class represents an artificial Player which is
 * the child of the Player class. It will do special ai
 * operations.
 * 
 */
public class Ai extends Player {
    
    public Ai(Role role,boolean isComputer){
        super(role,isComputer);
    }
    
}
