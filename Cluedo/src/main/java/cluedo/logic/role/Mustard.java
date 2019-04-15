
package cluedo.logic.role;

import static cluedo.logic.role.Role.image;
import javax.swing.ImageIcon;

/**
  This class represents a character called Mustard.
 * Every character have a special ability.
 * This class extends the Role class.
 */
public class Mustard extends Role{

    public Mustard(String playerName) {
        super(playerName);
        this.color=Color.ORANGE;
        abilityDescription="Mustard.description";
        image=new ImageIcon(getClass().getResource("/settings/mustard.png"));
    }
    public Mustard(Mustard other){
        super(other.getName());
        this.color=other.getColor();
        this.abilityIsAvailable=other.getAbilityIsAvailable();
    }
      public Object cloneObject(){
        return new Mustard(this);
    }
    @Override
    public void useSpecialAbility() {
        //TODO: write Mustard's special ability
    }
    
}
