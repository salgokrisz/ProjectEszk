package cluedo.logic.player;

import cluedo.logic.cards.Card;
import cluedo.logic.intrics.Intrics;
import cluedo.logic.role.Role;
import cluedo.logic.room.Point;
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
    protected Point startFieldLocation;
    protected List<Intrics> ownedIntricCards=new ArrayList<>();
    protected Point position;
    protected boolean isInRoom;
    protected String actualRoomName;
    public Player(Role role,boolean isComputer){
        this.isComputer=isComputer;
        this.role = role;
        isInRoom=false;
        actualRoomName="";
    }
    public Player(Player other){
        role=other.getRole();
        isComputer=other.getIsComputer();
        suspectCards=other.getSuspectCards();
        ownedIntricCards=other.getOwnedIntricCards();
        position=other.getPosition();
        isInRoom=other.getIsInRoom();
    }
    public void setActualRoomName(String actualRoomName){
        this.actualRoomName=actualRoomName;
    }

    public String getActualRoomName() {
        return actualRoomName;
    }
    
    public boolean getIsInRoom() {
        return isInRoom;
    }

    public void setIsInRoom(boolean isInRoom) {
        this.isInRoom = isInRoom;
    }
    
    public boolean getIsComputer() {
        return isComputer;
    }
    public Point getPosition(){
        Point aClone=null;
        if(position!=null){
            aClone=(Point)position.cloneObject();
        }
        return aClone;
    }
    public void setPosition(Point position){
        this.position=null;
        if(position!=null){
            this.position=(Point)position.cloneObject();
        }
    }
    public List<Intrics> getOwnedIntricCards(){
        List<Intrics> copy=new ArrayList<>();
        for(Intrics i: ownedIntricCards){
            copy.add((Intrics)i.cloneObject());
        }
        return copy;
    }
    public Role getRole(){
        return role;
    }
    
    public void setStartFieldLocation(Point startFieldLocation){
        this.startFieldLocation=null;
        if(startFieldLocation!=null){
        this.startFieldLocation = (Point)startFieldLocation.cloneObject();
        }
    }
    
    public Point getStartFieldLocation(){
        Point aClone=null;
        if(startFieldLocation!=null){
            aClone=(Point)startFieldLocation.cloneObject();
        }
        return aClone;
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
        return role.equals(other.getRole());
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
    @Override
    public String toString(){
       return role.toString();
    }

    public void addIntricCard(Intrics intric) {
        ownedIntricCards.add(intric);
    }
}
