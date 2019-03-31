package cluedo.logic.cards;

import cluedo.Tools.LanguageString.LanguageStrings;

public class Card {
    
    public final String name;
    public final String imageName;
    
    private final String UIStringKey;
    
    public Card (String name, String image, String UIStringKey) {
        this.name = name;
        this.imageName = image;
        this.UIStringKey = UIStringKey;
    }
    
    public String GetNameForUI () {
        return LanguageStrings.GetString (UIStringKey);
    }
}
