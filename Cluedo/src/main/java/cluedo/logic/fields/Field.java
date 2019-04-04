/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.fields;

import java.util.Objects;

/**
 *
 * @author Bence
 */
public class Field {
    protected int x;
    protected int y;
    protected String type;
    protected boolean walkeable;
    protected boolean someOneOn;
    
    public Field(int x,int y,String type,boolean walkeAble,boolean someOneOn){
        this.x = x;
        this.y = y;
        this.type = type;
        this.walkeable = walkeAble;
        this.someOneOn = someOneOn;
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
        return other.getType().equals(this.type) && other.getX()==this.x && other.getY()==this.y;
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
