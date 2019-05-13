package cluedo.logic.player;

import cluedo.logic.cards.Card;
import cluedo.logic.player.level.ExperienceLevel;
import cluedo.logic.player.aiDataManager.AiDataManager;
import cluedo.logic.player.aiDataManager.AiRoundData;
import cluedo.logic.player.role.Role;
import cluedo.logic.room.Point;
import cluedo.logic.room.SecretCorridoredRoom;
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
    //atgondolni hogy minden adat megjoin e akkor ha én gyanusitok és akkor is ha nem
    // valamit hogy a módszer amivel jönnek az adatok biztos jó ne
    //megnezni hogy minden asetben jön e adat pl ha emberi player is bele kerűl a képbe
    
    
    //TODO másik játékos gynúsít megcsinálni a raound datat
    // a databaól kiszedni a megoldast ha nem beginner
    // beginner adatokat is a databan csinaljuk meg 
    // okosítani ha más kérdezett akkor ha már mutattam neki a lapot akkor ugyanazt mutassam neki ujra stb
    private AiDataManager dataManager;
    private AiRoundData actualRoundData;
    private List<Card> allMurderCards_Murder;
    private List<Card> allMurderCards_Weapon;
    private List<Card> allMurderCards_Room;
    private List<Player> playersWhoTiredToProveThisRound;
    
    private final ExperienceLevel experienceLevel;
    private List<Player> allPlayer;
    private List<Point> availablePositionsToMove=new ArrayList<>();
    private StringBuilder sbInformation;
    private List<Card> alreadyKnownCards;
  
    private Card sureMurder;
    private Card sureMurderWeapon;
    private Card sureMurderRoom;
    
    public Ai(Role role, boolean isComputer, ExperienceLevel experienceLevel){
        super(role,isComputer);
        this.allPlayer = null;
        this.actualRoundData = new AiRoundData();
        this.dataManager = null;
        this.experienceLevel=experienceLevel;
        sbInformation=new StringBuilder();
        alreadyKnownCards=new ArrayList<>();
        
        this.sureMurder=null;
        this.sureMurderRoom=null;
        this.sureMurderWeapon=null;
    }
    public Ai(Ai other){
        super(other);
        this.allPlayer = other.allPlayer;
        this.actualRoundData = new AiRoundData();
        this.dataManager = other.dataManager;
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

    public void initializeAiDataManager (List<Player> allPlayer,
                                        List<Card> allMurderCards_Murder,
                                        List<Card> allMurderCards_Weapon,
                                        List<Card> allMurderCards_Room,
                                        int publicCardsNumber){
        this.allPlayer = allPlayer;
        this.allMurderCards_Murder = allMurderCards_Murder;
        this.allMurderCards_Weapon = allMurderCards_Weapon;
        this.allMurderCards_Room = allMurderCards_Room;
        
        this.dataManager = new AiDataManager (allPlayer.size(),
                                              allPlayer,
                                              this,
                                              suspectCards,
                                              publicCardsNumber,
                                              suspectCards.size(),
                                              allMurderCards_Murder,
                                              allMurderCards_Weapon,
                                              allMurderCards_Room);
    }
    
    public void addToAlreadyKnownCards(Player playerWhoProved, Card card){
        if(!alreadyKnownCards.contains(card)){
            alreadyKnownCards.add(card);
        }
        
        actualRoundData.setProvedCard (card);
        actualRoundData.setPlayerWhoProved (playerWhoProved);
        
        List<Player> beforPlayers = actualRoundData.getBeforPlayers();
        for (Player player : allPlayer) {
            if (! beforPlayers.contains(player) && 
                ! playerWhoProved.equals(player) &&
                ! actualRoundData.getPlayerWhoSuspected().equals(player))
            {
                actualRoundData.addAfterPlayers (player);
            }
        }
        
        dataManager.SaveRoundData(actualRoundData);
        actualRoundData = new AiRoundData();
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
        if (experienceLevel == ExperienceLevel.BEGINNER) {
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
        } else {
            suspectedMurderInActualRound = dataManager.GetNextSuspectMurder();
            suspectedMurderWeaponInActualRound = dataManager.GetNextSuspectWeapon();
        }
        
        suspectedMurderRoomInActualRound = findMurderRoomAccordingToPosition ();
    
        actualRoundData.setSuspectedMurder(suspectedMurderInActualRound);
        actualRoundData.setSuspectedWeapon(suspectedMurderWeaponInActualRound);
        actualRoundData.setSuspectedRoom(suspectedMurderRoomInActualRound);
        actualRoundData.setPlayerWhoSuspected (this);
    }

    public Card findMurderRoomAccordingToPosition () {
        int i=0;
        Card card=null;
        while(i<allMurderCards_Room.size() && !allMurderCards_Room.get(i).getUiStringKey().equals(actualRoomName)){
            i+=1;
        }
        if(i<allMurderCards_Room.size()){
            card=allMurderCards_Room.get(i);
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

    public boolean wantsToUseSecretCorridorFromRoom(SecretCorridoredRoom actRoom) {
        String toRoomName=actRoom.getToRoomName();
        int i=0;
        while(i<alreadyKnownCards.size() && (!alreadyKnownCards.get(i).getUiStringKey().equals(toRoomName) || !(sureMurderRoom!=null && sureMurderRoom.getUiStringKey().equals(toRoomName)))){     
            i+=1;
        }
        return i<alreadyKnownCards.size();
    }
    
    public void addSuspectedRoomData (Card card) {
        actualRoundData.setSuspectedRoom (card);
    }
    public void addSuspectedWeaponData (Card card) {
        actualRoundData.setSuspectedWeapon (card);
    }
    public void addSuspectedMurderData (Card card) {
        actualRoundData.setSuspectedMurder (card);
    }
    public void addPlayerWhoTiredToProveData (Player player) {
        actualRoundData.addBeforPlayers (player);
    }
    public void addPlayerWhoShowedForOtherPlayerData (Player player) {
        actualRoundData.setPlayerWhoProved(player);
        actualRoundData.setProvedCard (null);
        List<Player> beforPlayers = actualRoundData.getBeforPlayers();
        for (Player p : allPlayer) {
            if (! beforPlayers.contains(p) && 
                ! actualRoundData.getPlayerWhoSuspected().equals(p) &&
                ! player.equals(p))
            {
                actualRoundData.addAfterPlayers (p);
            }
        }
    }
    public void addPlayerWhoSuspectedData (Player player) {
        actualRoundData.setPlayerWhoSuspected(player);
    }
    public void setNobodyProvedData() {
        actualRoundData.setProvedCard (null);
        actualRoundData.setPlayerWhoProved (null);
        
        List<Player> beforPlayers = actualRoundData.getBeforPlayers();
         for (Player player : allPlayer) {
            if (! beforPlayers.contains(player) && 
                ! actualRoundData.getPlayerWhoSuspected().equals(player))
            {
                actualRoundData.addBeforPlayers (player);
            }
        }
        
        dataManager.SaveRoundData(actualRoundData);
        actualRoundData = new AiRoundData();
    }
}
