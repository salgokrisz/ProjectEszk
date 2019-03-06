/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.fields;

/**
 *
 * @author Bence
 */
public abstract class Field {
    protected int x;
    protected int y;
    protected String type;
    protected boolean walkeable;
    protected boolean someOneOn;
    
    public Field(){
        
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
    
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    
    public void setWalkeable(boolean walkeable) {
        this.walkeable = walkeable;
    }

    public boolean isWalkeable() {
        return walkeable;
    }
    
    public void setSomeOneOn(boolean someOneOn) {
        this.someOneOn = someOneOn;
    }

    public boolean isSomeOneOn() {
        return someOneOn;
    }
    
    @Override
    public String toString(){
        return "The field properties is: "+"pos_x:"+x+" pos_y:"+y+" type:"+type+" walkeable:"+walkeable+" someOneOn:"+someOneOn;
    }     
}
