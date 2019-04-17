
package cluedo.logic.fields;


/**
 * This class represents the entrance points of
 * the rooms, and can tell if it's room has a secret
 * connection or not.
 * 
 */
public class EntranceField extends Field {
    private String roomName;
    private boolean roomHasSecret;
    
    public EntranceField(int x,int y,boolean walkeAble,boolean someOneOn,String roomName,boolean roomHasSecret){
        super(x,y,FieldType.ENTRANCE,walkeAble,someOneOn);
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
        return super.toString()+" roomName:" + roomName + " roomHasSecret:" + roomHasSecret;
    }
    @Override
    public boolean equals(Object obj){
         if(obj==null){
            return false;
        }
        if(obj.getClass()!=EntranceField.class){
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
