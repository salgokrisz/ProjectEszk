
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
    
      public EndRoom(String name, List<Point> coordinates){
          super(name, coordinates);
      }   

    public Card getMurderWeapon() {
        if(murderWeapon!=null){
            return (Card)murderWeapon.cloneObject();
        }else{
            return null;
        }
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
        return(this.murderWeapon.equals(suspectedMurderWeapon) && this.murderRoom.equals(suspectedMurderRoom) && this.murderer.equals(suspectedMurderer));
    }
}
