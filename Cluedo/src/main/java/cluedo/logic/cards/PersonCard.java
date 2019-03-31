package cluedo.logic.cards;

public class PersonCard extends Card {
    public final String color;
    
    
    public PersonCard ( String name, 
                        String image, 
                        String UIStringKey,
                        String color) {
        super (name, image, UIStringKey);
        this.color = color;
    }
}
