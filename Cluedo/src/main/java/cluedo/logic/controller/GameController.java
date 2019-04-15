
package cluedo.logic.controller;

import cluedo.logic.factories.PlayerFactory;
import cluedo.logic.player.Player;
import java.util.List;

/**
 *This class is responsible for controlling the game.
 */
public class GameController {
   private int numberOfPlayers;
   private int numberOfComputerPlayers;
   private List<Player> players;

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getNumberOfComputerPlayers() {
        return numberOfComputerPlayers;
    }

    public void setNumberOfComputerPlayers(int numberOfComputerPlayers) {
        this.numberOfComputerPlayers = numberOfComputerPlayers;
    }
    
   public void initializePlayers(List<String> playerInformations){
       PlayerFactory pf=new PlayerFactory();
       players=pf.createPlayers(playerInformations);
   }

    public boolean isCorrectPlayerName(String playerName) {
        return playerName == null ? false : playerName.matches("^[A-Za-zÖöÜüÓóŐőÚúÁáÉéÍíŰű].*$");
    }
}
