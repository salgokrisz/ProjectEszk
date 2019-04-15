package cluedo.logic.player;

import cluedo.logic.role.Role;
import java.util.Objects;

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
    public Player(Player other){
        this.role=other.getRole();
        isComputer=other.getIsComputer();
    }
    public boolean getIsComputer() {
        return isComputer;
    }
    
    public Role getRole(){
        return role;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj==null){
            return false;
        }
        if(this==obj){
            return true;
        }
        if(!(obj instanceof Player)){
            return false;
        }
        Player other=(Player)obj;
        return other.getRole().equals(role);
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(role);
    }

    public Object cloneObject() {
        return new Player(this);
    }
}
