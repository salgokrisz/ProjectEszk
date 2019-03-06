/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.fields;

/**
 *
 * @author Bence
 */
public class SecretField extends RoomField {
    private RoomField fromRoom;
    private RoomField toRoom;
    
    public SecretField(int x,int y,String type,boolean walkeAble,boolean someOneOn,String roomName, boolean hasSecretPath,RoomField fromRoom,RoomField toRoom){
        super(x,y,type,walkeAble,someOneOn,roomName,hasSecretPath);
        this.fromRoom = fromRoom; //leaking, change when FieldFactory usable
        this.toRoom = toRoom; //leaking, change when FieldFactory usable
    }

    public RoomField getFromRoom() {
        return fromRoom;
    }

    public RoomField getToRoom() {
        return toRoom;
    }

    public void setFromRoom(RoomField fromRoom) {
        this.fromRoom = fromRoom;
    }

    public void setToRoom(RoomField toRoom) {
        this.toRoom = toRoom;
    }

    @Override
    public String toString() {
        return super.toString()+" fromRoom:" + fromRoom + " toRoom:" + toRoom;
    }
    
    
}
