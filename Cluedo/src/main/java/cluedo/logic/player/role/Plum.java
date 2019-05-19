
package cluedo.logic.player.role;

import cluedo.logic.controller.GameController;
import cluedo.logic.player.Player;
import static cluedo.logic.player.role.Role.image;
import cluedo.logic.room.Room;
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
        roleTypeInString="Plum";
    }
    public Plum(Plum other){
        super(other.getName());
         this.color=other.getColor();
        this.abilityIsAvailable=other.getAbilityIsAvailable();
        this.puppetImage=other.getPuppetImage();
        roleTypeInString=other.getRoleTypeInString();
    }
      public Object cloneObject(){
        return new Plum(this);
    }

      

  

    public void startTwoRummors(GameController gameController, String roomName, int playerIndex){
        if (gameController.getRoomMap().get(roomName) != null){
            Room room = gameController.getRoomMap().get(roomName);
                    gameController.enterRoom(room, playerIndex, false); 
        }
    }
     @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(name).append(" (").append("Plum").append(")");
        return sb.toString();
    }

    @Override
    public void useSpecialAbility(GameController gameController) {
        Player actualPlayer=gameController.getActualPlayer();
          startTwoRummors(gameController, actualPlayer.getActualRoomName(), gameController.getActualPlayerIndex());
        gameController.getActualPlayer().getRole().setAbilityIsAvailable(false);
    }
}
