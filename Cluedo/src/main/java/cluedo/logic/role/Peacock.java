
package cluedo.logic.role;

import static cluedo.logic.role.Role.image;
import javax.swing.ImageIcon;

/**
  This class represents a character called Peacock.
 * Every character have a special ability.
 * This class extends the Role class.
 */
public class Peacock extends Role{

    public Peacock(String playerName) {
        super(playerName);
        this.color=Color.BLUE;
        abilityDescription="Peacock.description";
        image=new ImageIcon(getClass().getResource("/settings/peacock.png"));
    }
    public Peacock(Peacock other){
        super( other.getName());
        this.color=other.getColor();
        this.abilityIsAvailable=other.getAbilityIsAvailable();
    }
      public Object cloneObject(){
        return new Peacock(this);
    }
    @Override
    public void useSpecialAbility() {
        //TODO: write Peacock's special ability
    }
    
}
