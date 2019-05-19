package cluedo.logic.cards;

/**
 *
 * @author Szaya
 */
public class Suspect {
    public final Card murder;
    public final Card weapon;
    public final Card room;
    
    public Suspect (Card murder, Card weapon, Card room) {
        this.murder = (Card) murder.cloneObject();
        this.weapon = (Card) weapon.cloneObject();
        this.room = (Card) room.cloneObject();
    }
}
