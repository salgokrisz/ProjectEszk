
package cluedo.logic.role;

/**
 * 
 * This class stores an enum which represents the color of the characters.
 */
public enum Color {
    RED, ORANGE, WHITE, GREEN, PURPLE, BLUE;
    @Override
    public String toString(){
        switch(this){
            case RED:
                return "Piros";
            case ORANGE:
                return "Narancssárga";
            case WHITE:
                return "Fehér";
            case GREEN:
                return "Zöld";
            case PURPLE:
                return "Lila";
            case BLUE:
                return "Kék";
            default:
                return "";
        }
    }
}
