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
    
    private final int playersNum;
    private final List<Player> players;
    
    private final Player me;
    private final List<Card> myCards;

    private final List<Card> allMurderCards_Murder;
    private final List<Card> allMurderCards_Weapon;
    private final List<Card> allMurderCards_Room;
    
    private Card finalMurder;
    private Card finalWeapon;
    private Card finalRoom;
  
    private final int publicCardsNum;
    private List<Card> publicCards;
    
    private final int numberOfCardsInHands;
    
    private final Map<Player, AiPlayerCardInfo> cardInfoOfThePlayers;

    public AiDataManager (int playersNum, 
                        List<Player> players, 
                        Player me, 
                        List<Card> myCards,
                        int publicCardsNum, 
                        int numberOfCardsInHands,
                        List<Card> allMurderCards_Murder,
                        List<Card> allMurderCards_Weapon,
                        List<Card> allMurderCards_Room) {
        this.newData = false;
        this.roundData = new ArrayList<>();
        this.playersNum = playersNum;
        this.players = players;
        this.me = me;
        this.myCards = myCards;
        this.publicCardsNum = publicCardsNum;
        this.numberOfCardsInHands = numberOfCardsInHands;
        
        this.allMurderCards_Murder = allMurderCards_Murder;
        this.allMurderCards_Weapon = allMurderCards_Weapon;
        this.allMurderCards_Room = allMurderCards_Room;
    
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
            SetPlayerCardToOwned (me, card);
        }
    }
    
    public Card GetNextSuspectWeapon () {
        return GetNextSuspect (finalWeapon, allMurderCards_Weapon);
    }
    public Card GetNextSuspectMurder () {
        return GetNextSuspect (finalMurder, allMurderCards_Murder);
    }
    private Card GetNextSuspect (Card finalCard, List<Card> allMurderCards) {
        //todo randomize???
        Card suspect = null;
        for (Card actualCard: allMurderCards) {
            if (finalCard.equals (actualCard) || (DoIKnowThePublicCards() && publicCards.contains (actualCard))){
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
    
    public boolean IsFinished(){
        return finalMurder != null && finalWeapon != null && finalRoom != null;
    }
    public List<Card> GetFinalCards () {
        List<Card> finalCards = new ArrayList<>();
        finalCards.add (finalMurder);
        finalCards.add (finalWeapon);
        finalCards.add (finalRoom);
        return finalCards;
    }
    
    public void AddPublicCards (List<Card> publicCards) {
        if (publicCards.size() != publicCardsNum) {
            throw new AssertionError();
        }
        
        this.publicCards = publicCards;
        CheckRounds ();
    }
    public void SaveRoundData (AiRoundData data) {
        if ( ! Check(data)) {
            this.roundData.add(data);
        }
        if (newData) {
            CheckRounds ();
        }
    }
    
    private boolean Check (AiRoundData data) {
        //TODO:
        //should I save the if a card is surely not final card??players
        SetPlayersWhoWasBeforTheProveCardsToNotOwned (data);
        if (IWasSuspectingInThisRound (data)) {
            if (SomeoneProvedInThisRound (data)) {
                SetPlayersWhoProvedCardToOwned (data);
                if (DoIKnowThePublicCards()) {
                    List<Card> suspectedCardsIDontKwon = GetTheSuspectedCardIDontKnow (data);
                    switch (suspectedCardsIDontKwon.size ()) {
                        case 2:
                            boolean firstCardFound = FindSuspectedCardAndSave (data, suspectedCardsIDontKwon.get(0));
                            return firstCardFound && FindSuspectedCardAndSave (data, suspectedCardsIDontKwon.get(1));
                        case 1:
                            return FindSuspectedCardAndSave (data, suspectedCardsIDontKwon.get(0));
                        case 0:
                            return true; //I know every suspected card
                        default:
                            throw new AssertionError();
                    }
                } else {
                    return false;
                }
            } else if (IntricaWasUsedInThisRound (data)) {
                return true; //I know everything from this round 
            } else {
                if (DoIKnowThePublicCards()) {
                    List<Card> suspectedCardsIDontKwon = GetTheSuspectedCardIDontKnow (data);
                    for (Card c : suspectedCardsIDontKwon) {
                        SetFinalCard (c);
                    }
                    return true; //I know every suspected card
                } else {
                    return false;
                }
            }
        } else {
            if (SomeoneProvedInThisRound (data)) {
                if (DoIKnowThePublicCards()) {
                    List<Card> suspectedCardsIDontKwon = GetTheSuspectedCardIDontKnow (data);
                    switch (suspectedCardsIDontKwon.size ()) {
                        case 3:
                            boolean cardFound = true;
                            for (int i = 0; i < 3; i++) {
                            cardFound &= FindSuspectedCardAndSave (data, suspectedCardsIDontKwon.get(i));
                            }
                            return cardFound;
                        case 2:
                            boolean firstCardFound = FindSuspectedCardAndSave (data, suspectedCardsIDontKwon.get(0));
                            return firstCardFound && FindSuspectedCardAndSave (data, suspectedCardsIDontKwon.get(1));
                        case 1:
                            return FindSuspectedCardAndSave (data, suspectedCardsIDontKwon.get(0));
                        case 0:
                            return true; //I know every suspected card
                        default:
                            throw new AssertionError();
                    }
                } else {
                    return false;
                }
            } else if (IntricaWasUsedInThisRound (data)) {
                return true; //I know everything from this round 
            } else {
                if (DoIKnowThePublicCards()) {
                    List<Card> suspectedCardsIDontKwon = GetTheSuspectedCardIDontKnow (data);
                    Player suspecter = data.getPlayerWhoSuspected();
                    for (Card c : suspectedCardsIDontKwon) {
                        SetPlayerCardToOwned (suspecter, c);
                    }
                    return true; //I know every suspected card
                } else {
                    return false;
                }
            }
        }
    }
    private void CheckRounds () {
        while (!newData) {
            newData = false;
            for (AiRoundData data : roundData) {
                if (Check(data)) {
                    roundData.remove(data);
                }
                FindNewData();
                
                if (newData) {
                    break;
                }
            }
        }
    }
    private void FindNewData () {
        if (!DoIKnowThePublicCards()) {
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
                        SetPlayerCardToNotOwned (p, card);
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
                SetFinalCard(card);
                return;
            }
            
            if (!multipleUnknown && 
                !owned && 
                DoIKnowTheFinalCardFromTheTypeOfTheCard (card) &&
                !publicCards.contains(card)) 
            {
                SetPlayerCardToOwned (possibleOwner, card);
            }
        }
        
    }
    
    //------------------------------------------------------------------------------
    
    //default data
    private boolean IWasSuspectingInThisRound (AiRoundData data) {
        return data.getPlayerWhoSuspected().equals (me);
    }
    private boolean DoIKnowThePublicCards () {
        return !publicCards.isEmpty();
    }
    private boolean IntricaWasUsedInThisRound (AiRoundData data) {
        return data.isIntricaWasUsed();
    }
    
    //prove
    private boolean SomeoneProvedInThisRound (AiRoundData data) {
        return data.getPlayerWhoProved() != null;
    }
    private boolean ThereWasSomeBodyWhoWasBeforTheProve (AiRoundData data) {
        return !data.getBeforPlayers().isEmpty();
    }
    private boolean ThereWasSomeBodyWhoWasAfterTheProve (AiRoundData data) {
        return !data.getAfterPlayers().isEmpty();
    }
    private boolean DoIKwonEveryCardFromThatPlayer (Player player) {
        AiPlayerCardInfo cardInfo = cardInfoOfThePlayers.get (player);
        return cardInfo.isKnwonEveryCard ();
    }
    private int HowManyPlayerWasAfterTheProving (AiRoundData data) {
        return data.getAfterPlayers().size();
    }
    
    //player Cards
    private boolean FindSuspectedCardAndSave (AiRoundData data, Card suspectedCard){
        if (suspectedCard == null){
            throw new AssertionError();
        }
        
        List<Player> possibleCardOwners = new ArrayList<>();
        possibleCardOwners = FindPossibleCardOwners (suspectedCard);

        if (DoIKnowTheFinalCardFromTheTypeOfTheCard (suspectedCard)) {
            if (possibleCardOwners.size () == 1) {
                SetPlayerCardToOwned (possibleCardOwners.get (0), suspectedCard);
                return true;
            } else {
                return false;
            }
        } else {
            if (possibleCardOwners.isEmpty()) {
                SetFinalCard (suspectedCard);
                return true;
            } else {
               return false;
            }
        }
    }
   
    private void SetEveryPlayerCardToNotOwned (Card card) {
        for (Player p: players) {
            AiPlayerCardInfo cardInfo = cardInfoOfThePlayers.get (p);
            SetPlayerCardToNotOwned (p, card);
        } 
    }
    private void SetPlayersWhoWasBeforTheProveCardsToNotOwned (AiRoundData data) {
        for (Player p : data.getBeforPlayers ()) {
            AiPlayerCardInfo cardInfo = cardInfoOfThePlayers.get (p);
            SetPlayerCardToNotOwned (p, data.getSuspectedMurder ());
            SetPlayerCardToNotOwned (p, data.getSuspectedWeapon ());
            SetPlayerCardToNotOwned (p, data.getSuspectedRoom ());
        }
    }
    private void SetPlayersWhoProvedCardToOwned (AiRoundData data) {
        Card provedCard = data.getProvedCard ();
        if (provedCard == null || ! IWasSuspectingInThisRound (data)) {
            throw new AssertionError();
        }
        SetPlayerCardToOwned (data.getPlayerWhoProved (), provedCard);
    }
    private void SetPlayerCardToOwned (Player player, Card card) {
        SetEveryPlayerCardToNotOwned (card);
        AiPlayerCardInfo cardInfo = cardInfoOfThePlayers.get (player);
        cardInfo.setCardType (card, AiPlayerCardInfo.Type.OWNED);
    }
    private void SetPlayerCardToNotOwned (Player player, Card card) {
        newData = true;
        AiPlayerCardInfo cardInfo = cardInfoOfThePlayers.get (player);
        cardInfo.setCardType (card, AiPlayerCardInfo.Type.NOTOWNED);
    }
    private boolean IsPlayerCardOwned (Player player, Card card) {
        AiPlayerCardInfo cardInfo = cardInfoOfThePlayers.get (player);
        return cardInfo.isOwned (card);
    }
    
    //final cards
    private boolean DoIKnowTheFinalCardFromTheTypeOfTheCard (Card card) {
        switch (card.type) {
            case PERSON: return finalMurder != null;
            case WEAPON: return finalWeapon != null;
            case ROOM: return finalRoom != null;
            default:
                throw new AssertionError();
        }
    }
    private void SetFinalCard (Card card) {
        SetEveryPlayerCardToNotOwned (card);
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
    private List<Card> GetTheSuspectedCardIDontKnow (AiRoundData data) {
        if (! DoIKnowThePublicCards()) {
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
        if (! isMurderKnownFromPlayers && ! finalMurder.equals (murder) && !publicCards.contains(murder)) {
            cardsWhichIDontKnow.add(murder);
        }
        if (! isWeaponKnownFromPlayers && ! finalWeapon.equals (weapon) && !publicCards.contains(weapon)) {
            cardsWhichIDontKnow.add(weapon);
        }
        if (! isRoomKnownFromPlayers && ! finalRoom.equals (room) && !publicCards.contains(room)) {
            cardsWhichIDontKnow.add(room);
        }
        
        return cardsWhichIDontKnow;
    }
    private List<Player> FindPossibleCardOwners (Card card) {
        List<Player> possibleCardOwners = new ArrayList<>();
        
        for (Player p :players){
            if (! DoIKwonEveryCardFromThatPlayer (p) &&  ! IsPlayerCardOwned (p, card)){
                possibleCardOwners.add (p);
            }
        }
            
        return possibleCardOwners;     
    }
}
