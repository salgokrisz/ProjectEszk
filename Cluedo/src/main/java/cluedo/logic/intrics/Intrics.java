package cluedo.logic.intrics;

import java.util.Objects;


public class Intrics{
    private String text;
    private String type;

    public Intrics(String text, String type){
        this.text = text;
        this.type = type;
    }

    public String getText(){
        return this.text;
    }

    public String getType(){
        return this.type;
    }

    public void setText(String text){
        this.text = text;
    }

    public void setType(String type){
        this.type = type;
    }

    @Override
    public int hashCode(){
        return Objects.hash(text, type);
    }
    
    @Override
    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        if(!o.getClass().equals(this.getClass())){
            return false;
        }
        Intrics other = (Intrics) o;
        return text.equals(other.getText()) && type.equals(other.getType());
    }

}