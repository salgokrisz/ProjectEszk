
package cluedo.logic.role;

import static cluedo.logic.role.Role.image;
import javax.swing.ImageIcon;

/**
  This class represents a character called Plum.
 * Every character have a special ability.
 * This class extends the Role class.
 */
public class Plum extends Role{
    
    public Plum(String playerName) {
        super(playerName);
        this.color=Color.PURPLE;
        abilityDescription="Plum.description";
        image=new ImageIcon(getClass().getResource("/settings/plum.png"));
    }
    public Plum(Plum other){
        super(other.getName());
         this.color=other.getColor();
        this.abilityIsAvailable=other.getAbilityIsAvailable();
    }
      public Object cloneObject(){
        return new Plum(this);
    }
    @Override
    public void useSpecialAbility() {
        //TODO: write Plum's special ability
    }
    
}
