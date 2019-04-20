
package cluedo.logic.role;

import javax.swing.ImageIcon;

/**
 * This class represents a character called Green.
 * Every character have a special ability.
 * This class extends the Role class.
 * 
 */
public class Green extends Role{
    public Green(String playerName){
        super( playerName);
        this.color=Color.GREEN;
        abilityDescription="Green.description";
        image=new ImageIcon(getClass().getResource("/settings/green.png"));
    }
    public Green(Green other){
        super(other.getName());
         this.color=other.getColor();
        this.abilityIsAvailable=other.getAbilityIsAvailable();
    }
      public Object cloneObject(){
        return new Green(this);
    }
    @Override
    public void useSpecialAbility() {
        //TODO: write Green's special ability
    }
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(name).append(" (").append("Green").append(")");
        return sb.toString();
    }
}
