package cluedo.logic.player;

import cluedo.logic.cards.Card;
import cluedo.logic.role.Role;
import java.util.ArrayList;
import java.util.List;
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
    protected List<Card> suspectCards=new ArrayList<>();
     
    public Player(Role role,boolean isComputer){
        this.isComputer=isComputer;
        this.role = role;
    }
    public Player(Player other){
        this.role=other.getRole();
        isComputer=other.getIsComputer();
        suspectCards=other.getSuspectCards();
    }
    public boolean getIsComputer() {
        return isComputer;
    }
    
    public Role getRole(){
        return role;
    }

    public List<Card> getSuspectCards() {
        List<Card> copy=new ArrayList<>();
        for(Card c: suspectCards){
            copy.add((Card)c.cloneObject());
        }
        return copy;
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
    public void drawSuspectCard(Card card){
        if(!suspectCards.contains(card)){
            suspectCards.add(card);
        }
    }
}
