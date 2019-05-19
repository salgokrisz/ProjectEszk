
package cluedo.logic.room;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;



/**
 *This class collects the room fields into a whole object.
 */
public class Room {
     protected final String name;
     protected final int width;
     protected final int height;
     protected final List<Point> coordinates;
     protected final Color color;
     public Room(String name, List<Point> coordinates,Color color){
         this.name=name;
         this.coordinates=coordinates;
         height=calculateHeight();
         width=calculateWidth();
         this.color = color;
     }
     
     public Room(Room other){
         this.name=other.getName();
         this.width=other.getWidth();
         this.height=other.getHeight();
         this.coordinates=other.getCoordinates();
         this.color = other.getColor();
     }
    public String getName() {
        return name;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Point> getCoordinates() {
        List<Point> copy=new ArrayList<>();
        for(Point p: coordinates){
            copy.add((Point)p.cloneObject());
        }
        return copy;
    }
    
    public Color getColor(){
        return color;
    }
    
    private int calculateHeight(){
        int minX=coordinates.get(0).getX();
        int maxX=coordinates.get(0).getX();
        for(int i=1; i<coordinates.size();++i){
            if(coordinates.get(i).getX()<minX){
                minX=coordinates.get(i).getX();
            }
            if(coordinates.get(i).getX()>maxX){
                maxX=coordinates.get(i).getX();
            }
        }
       return (maxX-minX)+1;
    }
    private int calculateWidth(){
        int minY=coordinates.get(0).getY();
        int maxY=coordinates.get(0).getY();
        for(int i=1; i<coordinates.size();++i){
            if(coordinates.get(i).getY()<minY){
                minY=coordinates.get(i).getY();
            }
            if(coordinates.get(i).getY()>maxY){
                maxY=coordinates.get(i).getY();
            }
        }
       return (maxY-minY)+1;
    }
    public Object cloneObject(){
        return new Room(this);
    }
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("Room name key: ").append(name).append(" height: ").append(height)
        .append(" width: ").append(width).append(System.lineSeparator()).append("coordinates:")
        .append(System.lineSeparator());
        for(Point p: coordinates){
            sb.append(p.toString()).append(";");
        }
        return sb.toString();
    }

    public boolean hasCoordinate(Point point) {
        return coordinates.contains(point);
    }
}
