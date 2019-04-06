/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.fields;

import cluedo.logic.fields.FieldType.Type;

/**
 *  This class represents a room field on the map.
 * This calss is the parent of the SecretField class.
 * This class is extends the Field class.
 * 
 */
public class RoomField extends Field{
    protected String roomName;
    protected boolean hasSecretPath;
    
    public RoomField(int x,int y,Type type,boolean walkeAble,boolean someOneOn,String roomName, boolean hasSecretPath){
        super(x,y,type,walkeAble,someOneOn);
        this.roomName = roomName;
        this.hasSecretPath = hasSecretPath;
    }

    public String getRoomName() {
        return roomName;
    }

    public boolean isHasSecretPath() {
        return hasSecretPath;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setHasSecretPath(boolean hasSecretPath) {
        this.hasSecretPath = hasSecretPath;
    }
    
    @Override
    public String toString(){
        return super.toString()+" roomName:"+roomName+" hasSecretPath:"+hasSecretPath;
    }
    
    
}
