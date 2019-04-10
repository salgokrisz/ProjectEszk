/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.fields;

import cluedo.logic.cards.Card;

/**
 *
 * @author Bence
 */
public class EndField extends Field{
    
    private Card murderWeapon;
    private Card murderRoom;
    private Card murderer;
    
    public EndField(int x,int y,FieldType.Type type,boolean walkeAble,boolean someOneOn,Card murderWeapon,Card murderRoom,Card murderer){
        super(x,y,type,walkeAble,someOneOn);
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
}
