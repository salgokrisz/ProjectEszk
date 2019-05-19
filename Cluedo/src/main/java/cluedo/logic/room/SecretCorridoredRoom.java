
package cluedo.logic.room;

import java.awt.Color;
import java.util.List;

/**
 *This class represents the secret rooms as a whole in the program.
 */
public class SecretCorridoredRoom extends Room{
    private String toRoomName;
    private boolean wasSetSecretEntranceImage ; 
    private Point secretFieldPosition;
    public SecretCorridoredRoom(String name, List<Point> coordinates,Color color){
        super(name, coordinates,color);
        wasSetSecretEntranceImage=false;
    }
    public void setSecretFieldPosition(Point secretFieldPosition){
        this.secretFieldPosition=null;
        if(secretFieldPosition!=null){
        this.secretFieldPosition=(Point)secretFieldPosition.cloneObject();
        } 
        
    }
    public Point getSecretFieldPosition(){
        Point aClone=null;
        if(secretFieldPosition!=null){
            aClone=(Point)secretFieldPosition.cloneObject();
        }
        return aClone;
    }
    public SecretCorridoredRoom(SecretCorridoredRoom other){
        super(other);
        this.toRoomName=other.getToRoomName();
        this.wasSetSecretEntranceImage=other.getWasSetSecretEntranceImage();
        this.secretFieldPosition=other.getSecretFieldPosition();
    }
    public void setWasSetSecretEntranceImage(boolean wasSetSecretEntranceImage){
        this.wasSetSecretEntranceImage=wasSetSecretEntranceImage;
    }
    @Override
    public Object cloneObject(){
        return new SecretCorridoredRoom(this);
    }
    public boolean getWasSetSecretEntranceImage(){
        return wasSetSecretEntranceImage;
    }
    public String getToRoomName(){
        return toRoomName;
    }
    public void setToRoomName(String toRoomName){
        this.toRoomName=toRoomName;
    }
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder(super.toString());
        sb.append(System.lineSeparator()).append("Secret corridor to room: ").append(toRoomName);
        return sb.toString();
    }
}
