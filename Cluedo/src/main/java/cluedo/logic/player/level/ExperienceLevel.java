
package cluedo.logic.player.level;

import cluedo.tools.languagestring.LanguageStrings;

/**
 * This enum is defines the experience leve of an artifically intelligenced player.
 */
public enum ExperienceLevel {
    INTERMEDIATE, BEGINNER;
    @Override
    public String toString(){
        switch(this){
            case INTERMEDIATE:
                return LanguageStrings.getString("Menu.LevelOptionIntermediate");
            case BEGINNER:
                return LanguageStrings.getString("Menu.LevelOptionBeginner");
            default:
                return "";
        }
    }
}
