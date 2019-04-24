package cluedo.view.board;

import cluedo.logic.cards.Card;
import cluedo.logic.player.Player;
import cluedo.tools.languagestring.LanguageStrings;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 * This class is responsible for showing the cards of the given player
 */
public class CardWindow extends JFrame {

    JPanel card;
    Container container;

    public CardWindow(Player player) {
        JPanel jpBase = new JPanel();
        jpBase.setLayout(new BoxLayout(jpBase, BoxLayout.Y_AXIS));
        setTitle(LanguageStrings.getString("GameBoard.MyCards"));
        card = new JPanel(new CardLayout(60, 30));
//create CardLayout object with 40 hor space and 30 ver space    
        List<Card> suspectCards = player.getSuspectCards();
        List<JButton> cardButtons = new ArrayList<>();
        for (Card c : suspectCards) {
            JButton button = new JButton(c.getNameForUI(), new ImageIcon(getClass().getResource(c.getImageName())));
            button.setVerticalTextPosition(SwingConstants.BOTTOM);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            cardButtons.add(button);
        }
        for (JButton b : cardButtons) {
            card.add(b);
        }
        jpBase.add(card);
        JButton next = new JButton(LanguageStrings.getString("CardWindow.Next"));
        next.addActionListener((ActionEvent evt) -> actionPerformed());
        jpBase.add(next);
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().add(jpBase);
    }

    public void actionPerformed() {
        ((CardLayout) card.getLayout()).next(card);
    }

}
