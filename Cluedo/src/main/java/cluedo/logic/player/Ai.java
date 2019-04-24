
package cluedo.logic.player;

import cluedo.logic.cards.Card;
import cluedo.logic.player.level.ExperienceLevel;
import cluedo.logic.role.Role;
import cluedo.logic.room.Point;
import cluedo.tools.Tools;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * This class represents an artificial Player which is
 * the child of the Player class. It will do special ai
 * operations.
 * 
 */
public class Ai extends Player {
    private final ExperienceLevel experienceLevel;
    private List<Point> availablePositionsToMove=new ArrayList<>();
    private StringBuilder sbInformation;
    private List<Card> alreadyKnownCards;
    public Ai(Role role,boolean isComputer, ExperienceLevel experienceLevel){
        super(role,isComputer);
        this.experienceLevel=experienceLevel;
        sbInformation=new StringBuilder();
        alreadyKnownCards=new ArrayList<>();
    }
    
    public Ai(Ai other){
        super(other);
        this.experienceLevel=other.getExperienceLevel();
        this.availablePositionsToMove=other.getAvailablePositionsToMove();
        this.sbInformation=other.getSbInformation();
        this.alreadyKnownCards=other.getAlreadyKnownCards();
    }
    public List<Card> getAlreadyKnownCards(){
        List<Card> copy=new ArrayList<>();
        for(Card c:alreadyKnownCards){
            copy.add((Card)c.cloneObject());
        }
        return copy;
    }
    public void addToAlreadyKnownCards(Card card){
        if(!alreadyKnownCards.contains(card)){
            alreadyKnownCards.add(card);
        }
    }
    public StringBuilder getSbInformation() {
        return sbInformation;
    }
    public String getInformationsAboutMovement(){
        return sbInformation.toString();
    }
    public ExperienceLevel getExperienceLevel() {
        return experienceLevel;
    }
    @Override
    public boolean equals(Object obj){
        boolean equals=super.equals(obj);
        if(obj==null){
            return false;
        }
        if(obj.getClass()!=Ai.class){
            return false;
        }
        return equals;
    }
    @Override
    public int hashCode(){
        return Objects.hash(role);
    }
@Override
public void drawSuspectCard(Card card){
    super.drawSuspectCard(card);
    if(!alreadyKnownCards.contains(card)){
    alreadyKnownCards.add(card);
    }
}
    public List<Point> getAvailablePositionsToMove() {
        List<Point> copy=new ArrayList<Point>();
        for(Point p: availablePositionsToMove){
            copy.add((Point)p.cloneObject());
        }
        return copy;
    }

    public void setAvailablePositionsToMove(List<Point> availablePositionsToMove) {
        this.availablePositionsToMove=new ArrayList<>();
        for(Point p: availablePositionsToMove){
            this.availablePositionsToMove.add((Point)p.cloneObject());
        }
    }

    public void appendToInformation(String text) {
        sbInformation.append(text);
    }

    public Card selectSuspect(List<Card> allMurderCards) {
        List<Card> notOwnedCards=new ArrayList<>();
        for(Card c:notOwnedCards){
            if(!alreadyKnownCards.contains(c)){
                notOwnedCards.add(c);
            }
        }
        return notOwnedCards.get(Tools.randomizeNumber(notOwnedCards.size()));
    }

    public Card findMurderRoomAccordingToPosition(List<Card> allMurderRoomCards) {
        int i=0;
        Card card=null;
        while(i<allMurderRoomCards.size() && !allMurderRoomCards.get(i).getNameForUI().equals(actualRoomName)){
            i+=1;
        }
        if(i<allMurderRoomCards.size()){
            card=allMurderRoomCards.get(i);
        }
        return card;
    }

    public void resetInformationsAboutMovement() {
        sbInformation=new StringBuilder();
    }
    
}
