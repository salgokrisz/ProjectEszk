
package cluedo.logic.player.role;

import static cluedo.logic.player.role.Role.image;
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

      
    @Override
    public void useSpecialAbility(GameController gameController, String roomName, int playerIndex) {
        //TODO: write Plum's special ability
        int counter = 0;
        while (counter < 2){
            startTwoRummors(gameController, roomName, playerIndex);
            counter++;
        }
        gameController.setIsAbilityAvailable(false)
    }

    public void startTwoRummors(GameController gameController, String roomName, int playerIndex){
        int numberOfPlayers = gameController.getNumberOfPlayers();
        List playersList = gameController.getPlayers();
        if (gameController.getRoomMap().get(roomName) != null){
            Room room = gameController.getRoomMap().get(roomName);
            for (int i = 0; i < playersList; i++) {
                if (playerList.get(i) == playerIndex){
                    gameController.enterRoom(room, playerIndex, false);
                }
            }
        }
    }
     @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(name).append(" (").append("Plum").append(")");
        return sb.toString();
    }
}
