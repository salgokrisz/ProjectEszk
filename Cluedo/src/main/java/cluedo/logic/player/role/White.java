
package cluedo.logic.player.role;

import static cluedo.logic.player.role.Role.image;
import javax.swing.ImageIcon;

/**
  This class represents a character called White.
 * Every character have a special ability.
 * This class extends the Role class.
 */
public class White extends Role {

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

    @Override
    public void useSpecialAbility(GameController gameController, String roomName) {
        //TODO: implement White's ability
        Room room;
        if(gameController.getRoomMap().get(roomName) != null){
            room = gameController.getRoomMap().get(roomName);
        }
        gameController.enterRoom(room, gameController.getActualPlayerIndex(), false);

    }
 @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(name).append(" (").append("White").append(")");
        return sb.toString();
    }
}
