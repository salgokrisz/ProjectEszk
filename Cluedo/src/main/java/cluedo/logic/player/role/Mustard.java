
package cluedo.logic.player.role;

import static cluedo.logic.player.role.Role.image;
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
        puppetImage=new ImageIcon(getClass().getResource("/board/mustard_puppet.png"));
        roleTypeInString="Mustard";
    }
    public Mustard(Mustard other){
        super(other.getName());
        this.color=other.getColor();
        this.abilityIsAvailable=other.getAbilityIsAvailable();
        this.puppetImage=other.getPuppetImage();
        roleTypeInString=other.getRoleTypeInString();
    }
      public Object cloneObject(){
        return new Mustard(this);
    }
    @Override
    public void useSpecialAbility() {
        //TODO: write Mustard's special ability
    }
     @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(name).append(" (").append("Mustard").append(")");
        return sb.toString();
    }
}
