
package cluedo.logic.player.role;

import static cluedo.logic.player.role.Role.image;
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
        puppetImage=new ImageIcon(getClass().getResource("/board/peacock_puppet.png"));
        roleTypeInString="Peacock";
    }
    public Peacock(Peacock other){
        super( other.getName());
        this.color=other.getColor();
        this.abilityIsAvailable=other.getAbilityIsAvailable();
        this.puppetImage=other.getPuppetImage();
        roleTypeInString=other.getRoleTypeInString();
    }
      public Object cloneObject(){
        return new Peacock(this);
    }
    @Override
    public void useSpecialAbility() {
        //TODO: write Peacock's special ability
    }
     @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(name).append(" (").append("Peacock").append(")");
        return sb.toString();
    }
}
