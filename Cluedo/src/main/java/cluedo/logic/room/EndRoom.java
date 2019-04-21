
package cluedo.logic.room;

import cluedo.logic.cards.Card;
import java.util.List;

/**
 *This class extends from Room, represents the end room of the game.
 */
public class EndRoom extends Room{
    private Card murderWeapon;
    private Card murderRoom;
    private Card murderer;
    
      public EndRoom(String name, List<Point> coordinates,RoomColor color){
          super(name, coordinates,color);
      } 
      
      public EndRoom(EndRoom other){
          super(other);
          this.murderWeapon=other.getMurderWeapon();
          this.murderRoom=other.getMurderRoom();
          this.murderer=other.getMurderer();
      }
      @Override
      public Object cloneObject(){
          return new EndRoom(this);
      }
    public Card getMurderWeapon() {
        if(murderWeapon!=null){
            return (Card)murderWeapon.cloneObject();
        }else{
            return null;
        }
    }
@Override
public String toString(){
    StringBuilder sb=new StringBuilder(super.toString());
    if(murderWeapon!=null && murderRoom!=null && murderer!=null){
        sb.append("Murder weapon: ").append(murderWeapon.toString()).append(System.lineSeparator());
        sb.append("Murder room: ").append(murderRoom.toString()).append(System.lineSeparator());
        sb.append("Murderer: ").append(murderer.toString());
    }
    return sb.toString();
}
    public void setMurderWeapon(Card murderWeapon) {
        this.murderWeapon=null;
        if(murderWeapon!=null){
        this.murderWeapon = (Card)murderWeapon.cloneObject();
        }
    }

    public Card getMurderRoom() {
        if(murderRoom!=null){
            return (Card)murderRoom.cloneObject();
        }else{
            return null;
        }
    }

    public void setMurderRoom(Card murderRoom) {
        this.murderRoom=null;
        if(murderRoom!=null){
        this.murderRoom = (Card)murderRoom.cloneObject();
        }
    }

    public Card getMurderer() {
       if(murderer!=null){
            return (Card)murderer.cloneObject();
        }else{
            return null;
        }
    }

    public void setMurderer(Card murderer) {
        this.murderer=null;
        if(murderer!=null){
        this.murderer = (Card)murderer.cloneObject();
        }
    }
      
      
      public boolean checkSuspectation(Card suspectedMurderWeapon,Card suspectedMurderRoom,Card suspectedMurderer){
        return this.murderWeapon.equals(suspectedMurderWeapon) && this.murderRoom.equals(suspectedMurderRoom) && this.murderer.equals(suspectedMurderer);
    }
}
