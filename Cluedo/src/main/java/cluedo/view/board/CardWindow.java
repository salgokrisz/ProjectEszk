
package cluedo.view.board;

import cluedo.logic.cards.Card;
import cluedo.logic.player.Player;
import cluedo.tools.languagestring.LanguageStrings;
import java.awt.BorderLayout;
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

/**
 *This class is responsible for showing the cards of the given player
 */
public class CardWindow extends JFrame{
    CardLayout card;  
Container c;  
    public CardWindow(Player player){  
        JPanel jpBase=new JPanel();
        jpBase.setLayout(new BoxLayout(jpBase, BoxLayout.Y_AXIS));
        c=getContentPane();  
        card=new CardLayout(60,30);  
//create CardLayout object with 40 hor space and 30 ver space  
        c.setLayout(card);  
        List<Card> suspectCards=player.getSuspectCards();
        List<JButton> cardButtons=new ArrayList<>();
        for(Card c: suspectCards){
            JButton button=new JButton();
            button.setIcon(new ImageIcon(getClass().getResource(c.getImageName())));
            button.setHorizontalTextPosition(SwingConstants.BOTTOM);
            button.setText(c.getNameForUI());
            cardButtons.add(button);
        }
        for(JButton b: cardButtons){
            c.add(b);
        }
        jpBase.add(c);
        JButton next=new JButton(LanguageStrings.getString("CardWindow.Next"));
         next.addActionListener((ActionEvent evt) -> {
            actionPerformed(evt);
        });
          setSize(400,400);
          setDefaultCloseOperation(EXIT_ON_CLOSE);  
          
    }  
    public void actionPerformed(ActionEvent e) {  
    card.next(c);  
    }  
 
}
