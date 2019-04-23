
package cluedo.logic.controller;

import cluedo.logic.player.Player;
import cluedo.logic.room.Point;

/**
 *This interface is responsible for helping data flow between the backgound logic
 * and the GameBoard class.
 */
public interface GameBoardListener {
    void showWhatToDo(String message);
    void showAllSuspectCardInformations(Player player);
    void showInformation(String message);
    void showMovement(Point oldPosition, Player player);
}
