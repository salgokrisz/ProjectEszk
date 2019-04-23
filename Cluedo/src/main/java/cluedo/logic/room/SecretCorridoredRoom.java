
package cluedo.logic.room;

import java.awt.Color;
import java.util.List;

/**
 *This class represents the secret rooms as a whole in the program.
 */
public class SecretCorridoredRoom extends Room{
    private Room toRoom;
            
    public SecretCorridoredRoom(String name, List<Point> coordinates,Color color){
        super(name, coordinates,color);
    }
    
    public SecretCorridoredRoom(SecretCorridoredRoom other){
        super(other);
        this.toRoom=other.getToRoom();
    }
    @Override
    public Object cloneObject(){
        return new SecretCorridoredRoom(this);
    }
    
    public Room getToRoom(){
        if(toRoom==null){
            return null;
        }else{
        return (Room)toRoom.cloneObject();
        }
    }
    public void setToRoom(Room toRoom){
        this.toRoom=null;
        if(toRoom!=null){
            this.toRoom=(Room)toRoom.cloneObject();
        }
    }
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder(super.toString());
        sb.append(System.lineSeparator()).append("Secret corridor to room: ").append(toRoom.getName());
        return sb.toString();
    }
}
