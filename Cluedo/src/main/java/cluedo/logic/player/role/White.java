
package cluedo.logic.player.role;

import cluedo.logic.controller.GameController;
import static cluedo.logic.player.role.Role.image;
import javax.swing.ImageIcon;

/**
  This class represents a character called White.
 * Every character have a special ability.
 * This class extends the Role class.
 */
public class White extends Role {
    String specialAbilityRoomName;
    public White(String playerName) {
        super(playerName);
        color = Color.WHITE;
        abilityDescription="White.description";
        image=new ImageIcon(getClass().getResource("/settings/white.png"));
        puppetImage=new ImageIcon(getClass().getResource("/board/white_puppet.png"));
        roleTypeInString="White";
    }

    public White(White other) {
        super(other.getName());
        this.abilityIsAvailable = other.getAbilityIsAvailable();
        this.color = other.getColor();
        this.puppetImage=other.getPuppetImage();
        roleTypeInString=other.getRoleTypeInString();
    }

    public Object cloneObject() {
        return new White(this);
    }

    public void setSpecialAbilityRoomName(String specialAbilityRoomName) {
        this.specialAbilityRoomName = specialAbilityRoomName;
    }

    @Override
    public void useSpecialAbility(GameController gameController) {
        //TODO: implement White's ability

        gameController.enterRoom(gameController.getRoomMap().get(specialAbilityRoomName), gameController.getActualPlayerIndex(), false);

    }
 @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(name).append(" (").append("White").append(")");
        return sb.toString();
    }
}
