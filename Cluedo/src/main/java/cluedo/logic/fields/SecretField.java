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
    private int fromRoomX;
    private int fromRoomY;
    private int toRoomX;
    private int toRoomY;
    
    public SecretField(int x,int y,String type,boolean walkeAble,boolean someOneOn,String roomName, boolean hasSecretPath,int fromRoomX,int fromRoomY,int toRoomX, int toRoomY){
        super(x,y,type,walkeAble,someOneOn,roomName,hasSecretPath);
        this.fromRoomX = fromRoomX;
        this.fromRoomY = fromRoomY;
        this.toRoomX = toRoomX; 
        this.toRoomY = toRoomY; 
    }

    public int getFromRoomX() {
        return fromRoomX;
    }

    public int getFromRoomY() {
        return fromRoomY;
    }

    public int getToRoomX() {
        return toRoomX;
    }

    public int getToRoomY() {
        return toRoomY;
    }

    public void setFromRoomX(int fromRoomX) {
        this.fromRoomX = fromRoomX;
    }

    public void setFromRoomY(int fromRoomY) {
        this.fromRoomY = fromRoomY;
    }

    public void setToRoomX(int toRoomX) {
        this.toRoomX = toRoomX;
    }

    public void setToRoomY(int toRoomY) {
        this.toRoomY = toRoomY;
    }
    

    @Override
    public String toString() {
        return super.toString()+" fromRoom:" + fromRoomX+","+fromRoomY + " toRoom:" + toRoomX+","+toRoomY;
    }
    
    
}
