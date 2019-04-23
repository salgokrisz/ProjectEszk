
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
        puppetImage=new ImageIcon(getClass().getResource("/board/plum_puppet.png"));
    }
    public Plum(Plum other){
        super(other.getName());
         this.color=other.getColor();
        this.abilityIsAvailable=other.getAbilityIsAvailable();
        this.puppetImage=other.getPuppetImage();
    }
      public Object cloneObject(){
        return new Plum(this);
    }

      
    @Override
    public void useSpecialAbility() {
        //TODO: write Plum's special ability
    }
     @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(name).append(" (").append("Plum").append(")");
        return sb.toString();
    }
}
