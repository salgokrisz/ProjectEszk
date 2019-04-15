
package cluedo.logic.fields;

import cluedo.logic.fields.FieldType.Type;

/**
 * The secret field class originates from the RoomField class.
 * This class represents a connection between two RoomField.
 *
 * 
 */
public class SecretField extends RoomField {
    private int fromRoomX;
    private int fromRoomY;
    private int toRoomX;
    private int toRoomY;
    
    public SecretField(int x,int y, Type type, boolean walkeAble,boolean someOneOn,String roomName, boolean hasSecretPath,int fromRoomX,int fromRoomY,int toRoomX, int toRoomY){
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
    @Override
    public boolean equals(Object obj){
         if(obj==null){
            return false;
        }
        if(obj.getClass()!=SecretField.class){
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
