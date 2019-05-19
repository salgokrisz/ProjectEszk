package cluedo.logic.player.role;

import cluedo.logic.controller.GameController;
import java.util.Objects;
import javax.swing.ImageIcon;

/**
 * This class represents the Role in the game which 
 * the player will play during the game. All of the 
 * characters like Green and Scarlet and the others are extends
 * from this class.
 * 
 */
public abstract class Role {
   
    protected Color color;
    protected boolean abilityIsAvailable;
    protected final String name;
    protected static String abilityDescription;
    protected static ImageIcon image;
    protected ImageIcon puppetImage;
    protected String roleTypeInString;
    
    public Role( String name){
        abilityIsAvailable=true;
        this.name=name;
    }

    public ImageIcon getPuppetImage() {
        return puppetImage;
    }

    public boolean getAbilityIsAvailable() {
        return abilityIsAvailable;
    }

    public static ImageIcon getImage() {
        return image;
    }

    public static String getAbilityDescription() {
        return abilityDescription;
    }

    public String getRoleTypeInString() {
        return roleTypeInString;
    }

   
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    public void setAbilityIsAvailable(boolean abilityIsAvailable) {
        this.abilityIsAvailable = abilityIsAvailable;
    }    

    public String getName() {
        return name;
    }
    
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(name).append("; ").append(color.toString()).append(System.lineSeparator());
        sb.append("Képesség: ").append(System.lineSeparator()).append(abilityDescription).append(System.lineSeparator()).append("Képessége elérhető: ").append(System.lineSeparator());
        appendBooleanValue(sb, abilityIsAvailable);
        return sb.toString();
    }
    private void appendBooleanValue(StringBuilder sb, boolean condition){
        if(condition){
            sb.append("Igen");
        }else{
             sb.append("Nem");
        }
    }
    @Override
    public boolean equals(Object obj){
        if(obj==null){
            return false;
        }
        if(obj==this){
            return true;
        }
        if(!(obj instanceof Role)){
            return false;
        }
        Role other=(Role) obj;
        return other.getColor()==color;
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(color);
    }
    
    public abstract void useSpecialAbility(GameController gameController);
}
