
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
    private String secretCorridorTo;
    public EntranceField(int x,int y,boolean walkeAble,boolean someOneOn,String roomName,boolean roomHasSecret, String secretCorridorTo){
        super(x,y,FieldType.ENTRANCE,walkeAble,someOneOn);
        this.roomName = roomName;
        this.roomHasSecret = roomHasSecret;
        this.secretCorridorTo=secretCorridorTo;
    }
    
    public EntranceField(EntranceField other){
        super(other);
        this.roomName=other.getRoomName();
        this.roomHasSecret=other.getRoomHasSecret();
        this.secretCorridorTo=other.getSecretCorridorTo();
    }
    @Override
    public Object cloneObject(){
        return new EntranceField(this);
    }
    public String getSecretCorridorTo() {
        return secretCorridorTo;
    }
    
    public void setSecretCorridorTo(String secretCorridorTo) {
        this.secretCorridorTo = secretCorridorTo;
    }

    public String getRoomName() {
        return roomName;
    }

    public boolean getRoomHasSecret() {
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
        return super.hashCode()+roomName.hashCode();
    } 
}
