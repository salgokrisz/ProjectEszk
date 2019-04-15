
package cluedo.logic.fields;

import cluedo.logic.cards.Card;
import cluedo.logic.fields.FieldType.Type;

/**
 *This field is responsible for storing the final informations about the killer,
 * the killer weapon and the room.
 */
public class EndField extends Field{
    
    private Card murderWeapon;
    private Card murderRoom;
    private Card murderer;
    
    public EndField(int x,int y, boolean walkeAble,boolean someOneOn,Card murderWeapon,Card murderRoom,Card murderer){
        super(x,y,Type.END,walkeAble,someOneOn);
        this.murderWeapon = murderWeapon;
        this.murderRoom = murderRoom;
        this.murderer = murderer;
    }

    public Card getMurderWeapon() {
        return murderWeapon;
    }

    public Card getMurderRoom() {
        return murderRoom;
    }

    public Card getMurderer() {
        return murderer;
    }

    public void setMurderWeapon(Card murderWeapon) {
        this.murderWeapon = murderWeapon;
    }

    public void setMurderRoom(Card murderRoom) {
        this.murderRoom = murderRoom;
    }

    public void setMurderer(Card murderer) {
        this.murderer = murderer;
    }
    
    public boolean checkSuspectation(Card suspectedMurderWeapon,Card suspectedMurderRoom,Card suspectedMurderer){
        return(this.murderWeapon.equals(suspectedMurderWeapon) && this.murderRoom.equals(suspectedMurderRoom) && this.murderer.equals(suspectedMurderer));
    }
    @Override
    public boolean equals(Object obj){
        if(obj.getClass()!=EndField.class){
            return false;
        }else{
        return super.equals(obj);
        }
    }
    @Override
    public int hashCode(){
        return super.hashCode();
    }
}
