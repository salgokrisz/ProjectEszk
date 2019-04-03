package cluedo.logic.cards;

import cluedo.Tools.LanguageString.LanguageStrings;

public class Card {
    public static enum Type {
      WEAPON,
      PERSON,
      ROOM
    };
    
    public final String name;
    public final String imageName;
    public final Type type;
    
    private final String UIStringKey;
    
    public Card (String name, String image, String UIStringKey, Type type) {
        this.name = name;
        this.imageName = image;
        this.UIStringKey = UIStringKey;
        this.type = type;
    }
    
    public String GetNameForUI () {
        return LanguageStrings.getString (UIStringKey);
    }
    
    //only for debug 
    public String toString () {
        return  "Type : " + type.toString() + ", " +
                "Name : " + name + ", " +
                "Image : " + imageName + ", " +
                "UIKey : " + UIStringKey + ", " + 
                "UIString : " + GetNameForUI();
    }
}
