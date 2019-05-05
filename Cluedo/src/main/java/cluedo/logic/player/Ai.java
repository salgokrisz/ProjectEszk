
package cluedo.logic.player;

import cluedo.logic.cards.Card;
import cluedo.logic.player.level.ExperienceLevel;
import cluedo.logic.player.role.Role;
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
    private List<Card> allMurderCards_Murder;
    private List<Card> allMurderCards_Weapon;
    private List<Card> allMurderCards_Room;
    private final Integer numOfPlayers;
    
    private final ExperienceLevel experienceLevel;
    private List<Point> availablePositionsToMove=new ArrayList<>();
    private StringBuilder sbInformation;
    private List<Card> alreadyKnownCards;
  
    private Card sureMurder;
    private Card sureMurderWeapon;
    private Card sureMurderRoom;
    public Ai(Role role, boolean isComputer, ExperienceLevel experienceLevel, Integer numOfPlayers){
        super(role,isComputer);
        this.experienceLevel=experienceLevel;
        sbInformation=new StringBuilder();
        alreadyKnownCards=new ArrayList<>();
        this.numOfPlayers = numOfPlayers;
        
        this.sureMurder=null;
        this.sureMurderRoom=null;
        this.sureMurderWeapon=null;
    }
    
    public Ai(Ai other){
        super(other);
        this.experienceLevel=other.getExperienceLevel();
        this.availablePositionsToMove=other.getAvailablePositionsToMove();
        this.sbInformation=other.getSbInformation();
        this.alreadyKnownCards=other.getAlreadyKnownCards();
        
        this.sureMurder=other.getSureMurder();
        this.sureMurderRoom=other.getSureMurderRoom();
        this.sureMurderWeapon=other.getSureMurderWeapon();
        
        this.allMurderCards_Murder = other.allMurderCards_Murder;
        this.allMurderCards_Weapon = other.allMurderCards_Weapon;
        this.allMurderCards_Room = other.allMurderCards_Room;
        
        this.numOfPlayers = other.numOfPlayers;
    }
    public List<Card> getAlreadyKnownCards(){
        List<Card> copy=new ArrayList<>();
        for(Card c:alreadyKnownCards){
            copy.add((Card)c.cloneObject());
        }
        return copy;
    }

    public Card getSureMurder() {
        Card aClone=null;
        if(sureMurder!=null){
            aClone=(Card)sureMurder.cloneObject();
        }
        return aClone;
    }


    public Card getSureMurderWeapon() {
         Card aClone=null;
        if(sureMurderWeapon!=null){
            aClone=(Card)sureMurderWeapon.cloneObject();
        }
        return aClone;
    }



    public Card getSureMurderRoom() {
        Card aClone=null;
         if(sureMurderRoom!=null){
            aClone=(Card)sureMurderRoom.cloneObject();
        }
         return aClone;
    }


    public void setAllMurderCards (List<Card> allMurderCards_Murder,
                                   List<Card> allMurderCards_Weapon,
                                   List<Card> allMurderCards_Room){
        this.allMurderCards_Murder = allMurderCards_Murder;
        this.allMurderCards_Weapon = allMurderCards_Weapon;
        this.allMurderCards_Room = allMurderCards_Room;
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
        List<Point> copy=new ArrayList<>();
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

    public void selectSuspect() {
        List<Card> notOwnedCards=new ArrayList<>();
        for(Card c:allMurderCards_Murder){
            if(!alreadyKnownCards.contains(c)){
                notOwnedCards.add(c);
            }
        }
        suspectedMurderInActualRound = notOwnedCards.get(Tools.randomizeNumber(notOwnedCards.size()));
        
        notOwnedCards=new ArrayList<>();
        for(Card c:allMurderCards_Weapon){
            if(!alreadyKnownCards.contains(c)){
                notOwnedCards.add(c);
            }
        }
        suspectedMurderWeaponInActualRound = notOwnedCards.get(Tools.randomizeNumber(notOwnedCards.size()));
        
        notOwnedCards=new ArrayList<>();
        for(Card c:allMurderCards_Room){
            if(!alreadyKnownCards.contains(c)){
                notOwnedCards.add(c);
            }
        }
        suspectedMurderRoomInActualRound = notOwnedCards.get(Tools.randomizeNumber(notOwnedCards.size()));
    }

    public Card findMurderRoomAccordingToPosition(List<Card> allMurderRoomCards) {
        int i=0;
        Card card=null;
        while(i<allMurderRoomCards.size() && !allMurderRoomCards.get(i).getUiStringKey().equals(actualRoomName)){
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

    public List<Card> determineOwnedSuspectCardsFromSuspects(Card murder, Card murderWeapon, Card murderRoom) {
        List<Card> ownedSuspectCards=new ArrayList<>();
        if(ownsSuspectCardAccordingToTitle(murder.getNameForUI())){
            ownedSuspectCards.add(murder);
        }
        if(ownsSuspectCardAccordingToTitle(murderWeapon.getNameForUI())){
            ownedSuspectCards.add(murder);
        }
        if(ownsSuspectCardAccordingToTitle(murderRoom.getNameForUI())){
            ownedSuspectCards.add(murder);
        }
        return ownedSuspectCards;
    }

    public void setSureAttributesForSolvingTheClue() {
        if(!ownsSuspectCardAccordingToTitle(suspectedMurderInActualRound.getNameForUI()) && sureMurder==null){
            sureMurder=(Card)suspectedMurderInActualRound.cloneObject();
        }
        if(!ownsSuspectCardAccordingToTitle(suspectedMurderWeaponInActualRound.getNameForUI()) && sureMurderWeapon==null){
            sureMurderWeapon=(Card)suspectedMurderWeaponInActualRound.cloneObject();
        }
        if(!ownsSuspectCardAccordingToTitle(suspectedMurderWeaponInActualRound.getNameForUI()) && sureMurderRoom==null){
            sureMurderRoom=(Card)suspectedMurderRoomInActualRound.cloneObject();
        }
    }
   /* public boolean knowsSolution(){
        return sureMurderRoom!=null && sureMurderWeapon!=null && sureMurder!=null;
    }*///commented out becuase of PMD, later it will be used
    
}
