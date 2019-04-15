
package cluedo.logic.role;

import static cluedo.logic.role.Role.image;
import javax.swing.ImageIcon;

/**
  This class represents a character called Scarlet.
 * Every character have a special ability.
 * This class extends the Role class.
 */
public class Scarlet extends Role{

    public Scarlet( String playerName) {
        super(playerName);
        this.color=Color.RED;
        abilityDescription="Scarlet.description";
        image=new ImageIcon(getClass().getResource("/settings/scarlet.png"));
    }
    public Scarlet(Scarlet other){
        super( other.getName());
        this.color=other.getColor();
        this.abilityIsAvailable=other.getAbilityIsAvailable();
    }
      public Object cloneObject(){
        return new Scarlet(this);
    }
    @Override
    public void useSpecialAbility() {
       //TODO: write Scarlet's special ability
    }
    
    
}
