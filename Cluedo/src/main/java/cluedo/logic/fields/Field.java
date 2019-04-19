
package cluedo.logic.fields;


import java.util.Objects;

/**
 * This field represents a field on the map. This is the
 * most basic field. This is the parent class of the futher
 * specialized fields.
 * 
 */
public class Field {
    protected int x;
    protected int y;
    protected FieldType type;
    protected boolean walkeable;
    protected boolean someOneOn;
    
    public Field(int x,int y,FieldType type,boolean walkeAble,boolean someOneOn){
        this.x = x;
        this.y = y;
        this.type = type;
        this.walkeable = walkeAble;
        this.someOneOn = someOneOn;
    }
    public Field(Field other){
        this.x=other.getX();
        this.y=other.getY();
        this.type=other.getType();
        this.walkeable=other.getWalkeable();
        this.someOneOn=other.getSomeOneOn();
    }

    public Object cloneObject(){
        return new Field(this);
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setType(FieldType type) {
        this.type = type;
    }

    public FieldType getType() {
        return type;
    }
    
    public void setWalkeable(boolean walkeable) {
        this.walkeable = walkeable;
    }

    public boolean getWalkeable() {
        return walkeable;
    }
    
    public void setSomeOneOn(boolean someOneOn) {
        this.someOneOn = someOneOn;
    }

    public boolean getSomeOneOn() {
        return someOneOn;
    }
    @Override
    public boolean equals(Object obj){
        if(obj==null){
            return false;
        }
        if(obj==this){
            return true;
        }
        if(!(obj instanceof Field)){
        return false;
    }
        Field other=(Field)obj;
        return other.getType()==this.type && other.getX()==this.x && other.getY()==this.y;
    }
    @Override
    public int hashCode(){
        return Objects.hash(type, x, y);
    }
    @Override
    public String toString(){
        return "The field properties is: "+"pos_x:"+x+" pos_y:"+y+" type:"+type+" walkeable:"+walkeable+" someOneOn:"+someOneOn;
    }     
}
