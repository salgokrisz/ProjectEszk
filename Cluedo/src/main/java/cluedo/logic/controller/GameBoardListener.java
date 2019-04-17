
package cluedo.logic.controller;

import cluedo.logic.player.Player;

/**
 *This interface is responsible for helping data flow between the backgound logic
 * and the GameBoard class.
 */
public interface GameBoardListener {
    public void showWhatToDo(String message);
    public void showAllSuspectCardInformations(Player player);

    public void showInformation(String message);
}
