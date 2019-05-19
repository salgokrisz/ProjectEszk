package cluedo.logic.controller;

import cluedo.logic.cards.Card;
import cluedo.logic.intrics.Intrics;
import cluedo.logic.player.Player;
import cluedo.logic.room.Point;
import java.util.List;

/**
 * This interface is responsible for helping data flow between the backgound
 * logic and the GameBoard class.
 */
public interface GameBoardListener {

    void showWhatToDo(String message);

    void showAllSuspectCardInformations(Player player);

    void showInformation(String message);

    void showMovement(Point oldPosition, Player player);

    void enableRollDiceButton(boolean enabled);

    void showDrawnIntricCardInfo(Intrics drawnCard);

    void displayRollView(boolean isInSecretRoom);

    void showSuspectView();

    void displayMoveView(List<Point> availablePositions);

    void enableFieldButtons(boolean b);

    void displayComputerView();

    void showSuspectCardsView(Card murder, Card murderWeapon, Card murderRoom,  Player playerWhoProves);

    void removeAiSuspectCardWindow();
    
    void showProofCardView(Card proofCard, Player playerWhoShowed);
    
    void refreshNumberOfDrawnClockCards();
}
