package cluedo.logic.player.aiDataManager;

import cluedo.logic.player.Player;
import cluedo.logic.cards.Card;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Szaya
 */
public class AiDataManager {
    private final List<AiRoundData> roundData;
    private boolean newData;
    private final List<Player> players;
    
    private final Player me;

    private final List<Card> allMurderCards_Murder;
    private final List<Card> allMurderCards_Weapon;
    
    private Card finalMurder;
    private Card finalWeapon;
    private Card finalRoom;
  
    private final int publicCardsNum;
    private List<Card> publicCards;
    
    private final Map<Player, AiPlayerCardInfo> cardInfoOfThePlayers;

    public AiDataManager (List<Player> players, 
                        Player me, 
                        List<Card> myCards,
                        int publicCardsNum, 
                        int numberOfCardsInHands,
                        List<Card> allMurderCards_Murder,
                        List<Card> allMurderCards_Weapon,
                        List<Card> allMurderCards_Room) {
        this.newData = false;
        this.roundData = new ArrayList<>();
        this.players = players;
        this.me = me;
        this.publicCardsNum = publicCardsNum;     
        this.allMurderCards_Murder = allMurderCards_Murder;
        this.allMurderCards_Weapon = allMurderCards_Weapon;
        this.finalMurder = null;
        this.finalWeapon = null;
        this.finalRoom = null;
        this.publicCards = new ArrayList<>();
        this.cardInfoOfThePlayers = new HashMap<>();
        for (Player p : this.players) {
            AiPlayerCardInfo playerInfo = new AiPlayerCardInfo (allMurderCards_Murder,
                                                                allMurderCards_Weapon,
                                                                allMurderCards_Room,
                                                                numberOfCardsInHands);
            cardInfoOfThePlayers.put (p, playerInfo);
        }
        AiPlayerCardInfo myInfo = cardInfoOfThePlayers.get (me);
        myInfo.setAllCardType (AiPlayerCardInfo.Type.NOTOWNED);
        for (Card card: myCards) {
            setPlayerCardToOwned (me, card);
        }
    }
    
    public Card getNextSuspectWeapon () {
        return getNextSuspect (finalWeapon, allMurderCards_Weapon);
    }
    public Card getNextSuspectMurder () {
        return getNextSuspect (finalMurder, allMurderCards_Murder);
    }
    private Card getNextSuspect (Card finalCard, List<Card> allMurderCards) {
        //todo randomize???
        Card suspect = null;
        for (Card actualCard: allMurderCards) {
            if (actualCard.equals (finalCard) || doIKnowThePublicCards() && publicCards.contains (actualCard)){
                continue;
            }
            
            boolean owned = false;
            for (Player player : players) {
                AiPlayerCardInfo info = cardInfoOfThePlayers.get(player);
                if (info.isOwned (actualCard)) {
                    owned = true;
                    break;
                }
            }
            
            if (!owned) {
                suspect = actualCard;
                break;
            }
        }
        
        if (suspect == null) {
            suspect = finalCard;
        } 
        
        return suspect;
    }
    
    public boolean isFinished(){
        return finalMurder != null && finalWeapon != null && finalRoom != null;
    }
    public List<Card> getFinalCards () {
        List<Card> finalCards = new ArrayList<>();
        finalCards.add ((Card)finalMurder.cloneObject());
        finalCards.add ((Card)finalWeapon.cloneObject());
        finalCards.add ((Card)finalRoom.cloneObject());
        return finalCards;
    }
    
    public void addPublicCards (List<Card> publicCards) {
        if (publicCards.size() != publicCardsNum) {
            throw new AssertionError();
        }
        
        this.publicCards = publicCards;
        checkRounds ();
    }
    public void saveRoundData (AiRoundData data) {
        if ( ! check(data)) {
            this.roundData.add(data);
        }
        if (newData) {
            checkRounds ();
        }
    }
    
    private boolean check (AiRoundData data) {
        //TODO:
        //should I save the if a card is surely not final card??players
        setPlayersWhoWasBeforeTheProveCardsToNotOwned (data);
        if (iWasSuspectingInThisRound (data)) {
            if (someoneProvedInThisRound (data)) {
                setPlayersWhoProvedCardToOwned (data);
                if (doIKnowThePublicCards()) {
                    List<Card> suspectedCardsIDontKnow = getTheSuspectedCardIDontKnow (data);
                    switch (suspectedCardsIDontKnow.size ()) {
                        case 2:
                            boolean firstCardFound = findSuspectedCardAndSave (suspectedCardsIDontKnow.get(0));
                            return firstCardFound && findSuspectedCardAndSave (suspectedCardsIDontKnow.get(1));
                        case 1:
                            return findSuspectedCardAndSave (suspectedCardsIDontKnow.get(0));
                        case 0:
                            return true; //I know every suspected card
                        default:
                            throw new AssertionError();
                    }
                } else {
                    return false;
                }
            } else if (intricaWasUsedInThisRound (data)) {
                return true; //I know everything from this round 
            } else {
                if (doIKnowThePublicCards()) {
                    List<Card> suspectedCardsIDontKnow = getTheSuspectedCardIDontKnow (data);
                    for (Card c : suspectedCardsIDontKnow) {
                        setFinalCard (c);
                    }
                    return true; //I know every suspected card
                } else {
                    return false;
                }
            }
        } else {
            if (someoneProvedInThisRound (data)) {
                if (doIKnowThePublicCards()) {
                    List<Card> suspectedCardsIDontKnow = getTheSuspectedCardIDontKnow (data);
                    switch (suspectedCardsIDontKnow.size ()) {
                        case 3:
                            boolean cardFound = true;
                            for (int i = 0; i < 3; i++) {
                            cardFound &= findSuspectedCardAndSave (suspectedCardsIDontKnow.get(i));
                            }
                            return cardFound;
                        case 2:
                            boolean firstCardFound = findSuspectedCardAndSave (suspectedCardsIDontKnow.get(0));
                            return firstCardFound && findSuspectedCardAndSave (suspectedCardsIDontKnow.get(1));
                        case 1:
                            return findSuspectedCardAndSave (suspectedCardsIDontKnow.get(0));
                        case 0:
                            return true; //I know every suspected card
                        default:
                            throw new AssertionError();
                    }
                } else {
                    return false;
                }
            } else if (intricaWasUsedInThisRound (data)) {
                return true; //I know everything from this round 
            } else {
                if (doIKnowThePublicCards()) {
                    List<Card> suspectedCardsIDontKnow = getTheSuspectedCardIDontKnow (data);
                    Player suspecter = data.getPlayerWhoSuspected();
                    for (Card c : suspectedCardsIDontKnow) {
                        setPlayerCardToOwned (suspecter, c);
                    }
                    return true; //I know every suspected card
                } else {
                    return false;
                }
            }
        }
    }
    private void checkRounds () {
        while (!newData) {
            newData = false;
            for (AiRoundData data : roundData) {
                if (check(data)) {
                    roundData.remove(data);
                }
                findNewData();
                if (newData) {
                    break;
                }
            }
        }
    }
    private void findNewData () {
        if (!doIKnowThePublicCards()) {
            return;
        }
        for (Card card : allMurderCards_Murder) {
            boolean multipleUnknown = false;
            Player possibleOwner = null;
            boolean owned = false;
            for (Player p : players) {
                AiPlayerCardInfo cardInfo = cardInfoOfThePlayers.get (p);
                if (cardInfo.isOwned(card)) {
                    if (owned) {
                        throw new AssertionError();
                    }
                    owned = true;
                } else if (! cardInfo.isNotOwned(card)) { //UNKNON
                    if (owned) {
                        setPlayerCardToNotOwned (p, card);
                    } else {
                        if (possibleOwner == null) {
                            possibleOwner = p;
                        } else {
                            multipleUnknown = true;
                        }
                    }
                }
            }
            
            if (!owned && possibleOwner == null && !publicCards.contains(card)) {
                setFinalCard(card);
                return;
            }
            
            if (!multipleUnknown && 
                !owned && 
                doIKnowTheFinalCardFromTheTypeOfTheCard(card) &&
                !publicCards.contains(card)) 
            {
                setPlayerCardToOwned (possibleOwner, card);
            }
        }
        
    }
    
    //------------------------------------------------------------------------------
    
    //default data
    private boolean iWasSuspectingInThisRound (AiRoundData data) {
        return data.getPlayerWhoSuspected().equals (me);
    }
    private boolean doIKnowThePublicCards () {
        return !publicCards.isEmpty();
    }
    private boolean intricaWasUsedInThisRound (AiRoundData data) {
        return data.isIntricaWasUsed();
    }
    
    //prove
    private boolean someoneProvedInThisRound (AiRoundData data) {
        return data.getPlayerWhoProved() != null;
    }
    private boolean doIKwonEveryCardFromThatPlayer (Player player) {
        AiPlayerCardInfo cardInfo = cardInfoOfThePlayers.get (player);
        return cardInfo.isEveryCardKnown ();
    }
    
    //player Cards
    private boolean findSuspectedCardAndSave (Card suspectedCard){
        if (suspectedCard == null){
            throw new AssertionError();
        }
        List<Player> possibleCardOwners = findPossibleCardOwners (suspectedCard);
        if (doIKnowTheFinalCardFromTheTypeOfTheCard (suspectedCard)) {
            if (possibleCardOwners.size () == 1) {
                setPlayerCardToOwned (possibleCardOwners.get (0), suspectedCard);
                return true;
            } else {
                return false;
            }
        } else {
            if (possibleCardOwners.isEmpty()) {
                setFinalCard (suspectedCard);
                return true;
            } else {
               return false;
            }
        }
    }
   
    private void setEveryPlayerCardToNotOwned (Card card) {
        for (Player p: players) {
            setPlayerCardToNotOwned (p, card);
        } 
    }
    private void setPlayersWhoWasBeforeTheProveCardsToNotOwned (AiRoundData data) {
        for (Player p : data.getBeforePlayers ()) {
            setPlayerCardToNotOwned (p, data.getSuspectedMurder ());
            setPlayerCardToNotOwned (p, data.getSuspectedWeapon ());
            setPlayerCardToNotOwned (p, data.getSuspectedRoom ());
        }
    }
    private void setPlayersWhoProvedCardToOwned (AiRoundData data) {
        Card provedCard = data.getProvedCard ();
        if (provedCard == null || ! iWasSuspectingInThisRound (data)) {
            throw new AssertionError();
        }
        setPlayerCardToOwned (data.getPlayerWhoProved (), provedCard);
    }
    private void setPlayerCardToOwned (Player player, Card card) {
        setEveryPlayerCardToNotOwned (card);
        AiPlayerCardInfo cardInfo = cardInfoOfThePlayers.get (player);
        cardInfo.setCardType (card, AiPlayerCardInfo.Type.OWNED);
    }
    private void setPlayerCardToNotOwned (Player player, Card card) {
        newData = true;
        AiPlayerCardInfo cardInfo = cardInfoOfThePlayers.get (player);
        cardInfo.setCardType (card, AiPlayerCardInfo.Type.NOTOWNED);
    }
    private boolean isPlayerCardOwned (Player player, Card card) {
        AiPlayerCardInfo cardInfo = cardInfoOfThePlayers.get (player);
        return cardInfo.isOwned (card);
    }
    
    //final cards
    private boolean doIKnowTheFinalCardFromTheTypeOfTheCard (Card card) {
        switch (card.type) {
            case PERSON: return finalMurder != null;
            case WEAPON: return finalWeapon != null;
            case ROOM: return finalRoom != null;
            default:
                throw new AssertionError();
        }
    }
    private void setFinalCard (Card card) {
        setEveryPlayerCardToNotOwned (card);
        switch (card.type) {
            case PERSON: {
                if (finalMurder != null) {
                    throw new AssertionError();
                }
                finalMurder = card;  
            } break;
            case WEAPON: {
                if (finalWeapon != null) {
                    throw new AssertionError();
                }
                finalWeapon = card;  
            } break;
            case ROOM: {
                if (finalRoom != null) {
                    throw new AssertionError();
                }
                finalRoom = card;  
            } break;
            default:
                throw new AssertionError();
        }
    }
    
    //other
    private List<Card> getTheSuspectedCardIDontKnow (AiRoundData data) {
        if (! doIKnowThePublicCards()) {
            throw new AssertionError();
        }
        
        Card murder = data.getSuspectedMurder ();
        Card weapon = data.getSuspectedWeapon ();
        Card room = data.getSuspectedRoom ();
        boolean isMurderKnownFromPlayers = false;
        boolean isWeaponKnownFromPlayers = false;
        boolean isRoomKnownFromPlayers = false;
        for (Player p : players) {
            AiPlayerCardInfo cardInfo = cardInfoOfThePlayers.get (p);
            if (!isMurderKnownFromPlayers && cardInfo.isOwned (murder)) {
                isMurderKnownFromPlayers = true;
            }
            if (!isWeaponKnownFromPlayers && cardInfo.isOwned (weapon)) {
                isWeaponKnownFromPlayers = true;
            }
            if (!isRoomKnownFromPlayers && cardInfo.isOwned (room)) {
                isRoomKnownFromPlayers = true;
            }
        }
        List<Card> cardsWhichIDontKnow = new ArrayList<>();
        if (! isMurderKnownFromPlayers && ! murder.equals (finalMurder) && !publicCards.contains(murder)) {
            cardsWhichIDontKnow.add(murder);
        }
        if (! isWeaponKnownFromPlayers && ! weapon.equals (finalWeapon) && !publicCards.contains(weapon)) {
            cardsWhichIDontKnow.add(weapon);
        }
        if (! isRoomKnownFromPlayers && ! room.equals (finalRoom) && !publicCards.contains(room)) {
            cardsWhichIDontKnow.add(room);
        }
        
        return cardsWhichIDontKnow;
    }
    private List<Player> findPossibleCardOwners (Card card) {
        List<Player> possibleCardOwners = new ArrayList<>();
        for (Player p :players){
            if (! doIKwonEveryCardFromThatPlayer (p) &&  ! isPlayerCardOwned (p, card)){
                possibleCardOwners.add (p);
            }
        }
            
        return possibleCardOwners;     
    }
}
