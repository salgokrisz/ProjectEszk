package cluedo.logic.cards;

import cluedo.tools.languagestring.LanguageStrings;
import java.util.Objects;

public class Card {
    public enum Type {
      WEAPON,
      PERSON,
      ROOM,
      UNKNOWN
    }
    
    public final String name;
    public final String imageName;
    public final Type type;
    
    private final String uiStringKey;
    
    public Card (String name, String image, String uiStringKey, Type type) {
        this.name = name;
        this.imageName = image;
        this.uiStringKey = uiStringKey;
        this.type = type;
    }
    public Card(Card other){
        this.name=other.getName();
        this.imageName=other.getImageName();
        this.uiStringKey=other.getUiStringKey();
        this.type=other.getType();
    }
    public String getName() {
        return name;
    }

    public String getImageName() {
        return imageName;
    }

    public Type getType() {
        return type;
    }

    public String getUiStringKey() {
        return uiStringKey;
    }
    
    public String getNameForUI () {
        return LanguageStrings.getString (uiStringKey);
    }
    
    //only for debug
    @Override
    public String toString () {
        return  "Type : " + type.toString() + ", " +
                "Name : " + name + ", " +
                "Image : " + imageName + ", " +
                "UIKey : " + uiStringKey + ", " + 
                "UIString : " + getNameForUI();
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj==null){
            return false;
        }
        if(obj==this){
            return true;
        }
        if(obj.getClass()!=Card.class){
            return false;
        }
        Card other=(Card)obj;
        return other.getType()==type && other.getName().equals(name);
    }
    @Override
    public int hashCode(){
        return Objects.hash(type, name);
    }
    public Object cloneObject(){
        return new Card(this);
    }
}
