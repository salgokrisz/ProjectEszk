
package cluedo.logic.room;

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
     public Room(String name, List<Point> coordinates){
         this.name=name;
         this.coordinates=coordinates;
         height=calculateHeight();
         width=calculateWidth();
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
       return maxX-minX;
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
       return maxY-minY;
    }
}
