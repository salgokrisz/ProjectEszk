
package cluedo.logic.fields;


/**
 *  This class represents a room field on the map.
 * This class is the parent of the SecretField class.
 * This class is extends the Field class.
 * 
 */
public class RoomField extends Field{
    protected String roomName;
    
    public RoomField(int x,int y,FieldType type,boolean walkeAble,boolean someOneOn,String roomName){
        super(x,y,type,walkeAble,someOneOn);
        this.roomName = roomName;
    }
    
    public RoomField(RoomField other){
        super(other);
        this.roomName=other.getRoomName();
    }
    
    @Override
    public Object cloneObject(){
        return new RoomField(this);
    }
    public String getRoomName() {
        return roomName;
    }


    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    
    @Override
    public String toString(){
        return super.toString()+" roomName:"+roomName;
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
        return super.hashCode()+roomName.hashCode();
    }
    
}
