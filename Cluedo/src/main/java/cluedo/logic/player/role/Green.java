
package cluedo.logic.player.role;

import javax.swing.ImageIcon;
import cluedo.logic.controller.GameController;

/**
 * This class represents a character called Green.
 * Every character have a special ability.
 * This class extends the Role class.
 * 
 */
public class Green extends Role{
    private String specialAbilityRoomName;
    public Green(String playerName){
        super( playerName);
        this.color=Color.GREEN;
        abilityDescription="Green.description";
        image=new ImageIcon(getClass().getResource("/settings/green.png"));
        puppetImage=new ImageIcon(getClass().getResource("/board/green_puppet.png"));
        roleTypeInString="Green";
    }

    public void setSpecialAbilityRoomName(String specialAbilityRoomName) {
        this.specialAbilityRoomName = specialAbilityRoomName;
    }
    
    public Green(Green other){
        super(other.getName());
         this.color=other.getColor();
        this.abilityIsAvailable=other.getAbilityIsAvailable();
        this.puppetImage=other.getPuppetImage();
        roleTypeInString=other.getRoleTypeInString();
    }
      public Object cloneObject(){
        return new Green(this);
    }
    @Override
    public void useSpecialAbility(GameController gameController) {
        //TODO: write Green's special ability
        rumor(gameController, gameController.getActualPlayerIndex());
        gameController.getActualPlayer().getRole().setAbilityIsAvailable(false);
    }

    public void rumor(GameController gameController, int playerIndex){
        gameController.enterRoom(gameController.getRoomMap().get(specialAbilityRoomName), playerIndex, false);     
        }
        
    
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(name).append(" (").append("Green").append(")");
        return sb.toString();
    }
}
