
package cluedo.logic.fields;


/**
 *  This class represents a room field on the map.
 * This class is the parent of the SecretField class.
 * This class is extends the Field class.
 * 
 */
public class RoomField extends Field{
    protected String roomName;
    protected boolean hasSecretPath;
    
    public RoomField(int x,int y,FieldType type,boolean walkeAble,boolean someOneOn,String roomName, boolean hasSecretPath){
        super(x,y,type,walkeAble,someOneOn);
        this.roomName = roomName;
        this.hasSecretPath = hasSecretPath;
    }
    
    public RoomField(RoomField other){
        super(other);
        this.roomName=other.getRoomName();
        this.hasSecretPath=other.getHasSecretPath();
    }
    
    @Override
    public Object cloneObject(){
        return new RoomField(this);
    }
    public String getRoomName() {
        return roomName;
    }

    public boolean getHasSecretPath() {
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
    @Override
    public boolean equals(Object obj){
         if(obj==null){
            return false;
        }
        if(obj.getClass()!=RoomField.class){
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
