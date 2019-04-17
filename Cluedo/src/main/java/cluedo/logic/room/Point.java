
package cluedo.logic.room;

import java.util.Objects;

/**
 *This class represents a point on the map.
 */
public class Point {
   private final int x;
   private final int y;
   public Point(int x, int y){
       this.x=x;
       this.y=y;
   }
public Point(Point other){
    this.x=other.getX();
    this.y=other.getY();
}
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
   public Object cloneObject(){
       return new Point(this);
   }
   @Override
   public boolean equals(Object obj){
       if(obj==null){
           return false;
       }
       if (obj==this){
           return true;
       }
       if(obj.getClass()!=Point.class){
           return false;
       }
       Point that=(Point)obj;
       return x==that.getX() && y==that.getY();
   }
   @Override
   public int hashCode(){
       return Objects.hash(x, y);
   }
   @Override
   public String toString(){
       StringBuilder sb=new StringBuilder();
       sb.append("x: ").append(x).append(", y: ").append(y);
       return sb.toString();
   }
}
