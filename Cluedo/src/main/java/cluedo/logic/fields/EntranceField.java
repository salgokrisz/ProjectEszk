/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.fields;

import cluedo.logic.fields.FieldType.Type;

/**
 * This class represents the entrance points of
 * the rooms, and can tell if it's room has a secret
 * connection or not.
 * 
 */
public class EntranceField extends Field {
    private String roomName;
    private boolean roomHasSecret;
    
    public EntranceField(int x,int y,Type type,boolean walkeAble,boolean someOneOn,String roomName,boolean roomHasSecret){
        super(x,y,type,walkeAble,someOneOn);
        this.roomName = roomName;
        this.roomHasSecret = roomHasSecret;
    }

    public String getRoomName() {
        return roomName;
    }

    public boolean isRoomHasSecret() {
        return roomHasSecret;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setRoomHasSecret(boolean roomHasSecret) {
        this.roomHasSecret = roomHasSecret;
    }

    @Override
    public String toString() {
        return this.toString()+" roomName:" + roomName + " roomHasSecret:" + roomHasSecret;
    }
    
    
    
}
