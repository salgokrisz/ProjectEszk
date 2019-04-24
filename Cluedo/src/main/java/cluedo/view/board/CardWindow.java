package cluedo.view.board;

import cluedo.logic.cards.Card;
import cluedo.logic.intrics.Intrics;
import cluedo.logic.intrics.IntricsType;
import cluedo.logic.player.Player;
import cluedo.tools.languagestring.LanguageStrings;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.net.URL;
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
   private JPanel card;  
   private List<JButton> cardButtons;
//private final String cardTypeToShow; //commented out because of the PMD, later it will be used
    public CardWindow(Player player, String cardTypeToShow){ 
       // this.cardTypeToShow=cardTypeToShow; //commented out because of the PMD, later it will be used
        JPanel jpBase = new JPanel();
        jpBase.setLayout(new BoxLayout(jpBase, BoxLayout.Y_AXIS));
        setTitle(LanguageStrings.getString("GameBoard.MySuspectCards"));
        card=new JPanel(new CardLayout(60,30));  
//create CardLayout object with 40 hor space and 30 ver space      
      if(cardTypeToShow.equals("suspects")){
          cardButtons=getSuspectCardsOfPlayerInButtons(player);
      }else{
          cardButtons=getIntricCardsOfPlayerInButtons(player);
      }
        for (JButton b : cardButtons) {
            card.add(b);
        }
        jpBase.add(card);
        if(cardButtons.size()>1){
        JButton next=new JButton(LanguageStrings.getString("CardWindow.Next"));
         next.addActionListener((ActionEvent evt) -> {
            actionPerformed();
        });
         jpBase.add(next);
        }
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().add(jpBase);
    } 
    public final List<JButton> getIntricCardsOfPlayerInButtons(Player player){
         List<Intrics> intricCards=player.getOwnedIntricCards();
         List<JButton> cardButtonsList=new ArrayList<>();
        for(Intrics c: intricCards){
            String text="";
            URL url=getClass().getResource("/cards/intrics/card_intric.png");
            if(c.getType()!=IntricsType.CLOCK){
            text = c.toStringForPanel();
            url=getClass().getResource("/cards/intrics/basic_intric.png");
            }
            JButton button=new JButton(text, new ImageIcon(url));
            button.setVerticalTextPosition(SwingConstants.BOTTOM);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            cardButtonsList.add(button);
        }
        return cardButtonsList;
    }
    public final List<JButton> getSuspectCardsOfPlayerInButtons(Player player){
         List<Card> suspectCards=player.getSuspectCards();
         List<JButton> cardButtonsList=new ArrayList<>();
        for(Card c: suspectCards){
            JButton button=new JButton(c.getNameForUI(), new ImageIcon(getClass().getResource(c.getImageName())));
            button.setVerticalTextPosition(SwingConstants.BOTTOM);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            cardButtonsList.add(button);
        }
        return cardButtonsList;
    }
    public void actionPerformed() {
        ((CardLayout) card.getLayout()).next(card);
    }

    public boolean hasCardToShow() {
        return !cardButtons.isEmpty();
    }

}
