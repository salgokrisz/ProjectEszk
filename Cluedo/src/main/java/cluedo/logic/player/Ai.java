
package cluedo.logic.player;

import cluedo.logic.player.level.ExperienceLevel;
import cluedo.logic.role.Role;

/**
 * This class represents an artificial Player which is
 * the child of the Player class. It will do special ai
 * operations.
 * 
 */
public class Ai extends Player {
    private final ExperienceLevel experienceLevel;
    public Ai(Role role,boolean isComputer, ExperienceLevel experienceLevel){
        super(role,isComputer);
        this.experienceLevel=experienceLevel;
    }
    
    public Ai(Ai other){
        super(other);
        this.experienceLevel=other.getExperienceLevel();
    }

    public ExperienceLevel getExperienceLevel() {
        return experienceLevel;
    }
    
}
