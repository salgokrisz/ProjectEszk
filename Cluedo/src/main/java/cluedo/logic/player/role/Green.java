
package cluedo.logic.player.role;

import javax.swing.ImageIcon;
import cluedo.logic.controller.GameController;
import cluedo.logic.room.Room;

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
        puppetImage=new ImageIcon(getClass().getResource("/board/green_puppet.png"));
        roleTypeInString="Green";
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
    public void useSpecialAbility(GameController gameController, String roomName, int playerIndex) {
        //TODO: write Green's special ability
        rumor(gameController, roomName, playerIndex);
        gameController.setAbilityIsAvailable(false);
    }

    public void rumor(GameController gameController, String roomName, int playerIndex){
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
        sb.append(name).append(" (").append("Green").append(")");
        return sb.toString();
    }
}
