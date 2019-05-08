package cluedo.logic.player.aiDataManager;

import cluedo.logic.player.Player;
import cluedo.logic.cards.Card;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Szaya
 */
public class AiDataManager {
    private final List<AiRoundData> roundData;
    
    private final int playersNum;
    private final List<Player> players;
    private final Player me;

    private List<Card> allMurderCards_Murder;
    private List<Card> allMurderCards_Weapon;
    private List<Card> allMurderCards_Room;
    
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
                        int publicCardsNum, 
                        int numberOfCardsInHands,
                        List<Card> allMurderCards_Murder,
                        List<Card> allMurderCards_Weapon,
                        List<Card> allMurderCards_Room) {
        this.roundData = new ArrayList<>();
        this.playersNum = playersNum;
        this.players = players;
        this.me = me;
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
    }
    
    public void saveRoundData (AiRoundData data) {
        if (check(data)) {
            this.roundData.add(data);
        }
    }
    
    public boolean check (AiRoundData data) {
        //TODO:
        //should I save the if a card is surely not final card??
        if (IWasSuspectingInThisRound (data)) {
            if (SomeoneProvedInThisRound (data)) {
                SetPlayersWhoProvedCardToOwned (data);
                if (ThereWasSomeBodyWhoWasBeforTheProve (data)) {
                    SetPlayersWhoWasBeforTheProveCardsToNotOwned (data);
                }
                
                List<Card> suspectedCardsIDontKwon = GetTheSuspectedCardIDontKnow (data);
                switch (suspectedCardsIDontKwon.size ()) {
                    case 2:
                        //TODO
                        break;
                    case 1:
                        return FindThe3thCardAndSave (data, suspectedCardsIDontKwon.get(0));
                    case 0:
                        return true; //I know every suspected card
                    default:
                        throw new AssertionError();
                }
            } else if (IntricaWasUsedInThisRound (data)) {
                if (ThereWasSomeBodyWhoWasBeforTheProve (data)) {
                    //TODO
                } else {
                    //TODO
                }
            } else {
                //TODO
            }
        } else {
            //TODO
        }
        return false;
    }
    
    private boolean IWasSuspectingInThisRound (AiRoundData data) {
        return data.getPlayerWhoSuspected().equals (me);
    }
    private boolean SomeoneProvedInThisRound (AiRoundData data) {
        return data.getPlayerWhoProved() != null;
    }
    private boolean IntricaWasUsedInThisRound (AiRoundData data) {
        return data.isIntricaWasUsed();
    }
    private boolean ThereWasSomeBodyWhoWasBeforTheProve (AiRoundData data) {
        return data.getBeforPlayers().size() != 0;
    }
    private boolean ThereWasSomeBodyWhoWasAfterTheProve (AiRoundData data) {
        return data.getAfterPlayers().size() != 0;
    }
    private boolean IKnowTheFinalCardFromTheTypeOfTheCard (Card card) {
        switch (card.type) {
            case PERSON: return finalMurder != null;
            case WEAPON: return finalWeapon != null;
            case ROOM: return finalRoom != null;
            default:
                throw new AssertionError();
        }
    }
    private boolean IKwonEveryCardFromThatPlayer (Player player) {
        AiPlayerCardInfo cardInfo = cardInfoOfThePlayers.get (player);
        return cardInfo.isKnwonEveryCard ();
    }
    private boolean FindThe3thCardAndSave (AiRoundData data, Card thirdSuspectedCard){
        // the 3th suspected card should be on the :
        // final cards or 
        // the player who proved or
        // those players who came after the proving
        if (IKnowTheFinalCardFromTheTypeOfTheCard (thirdSuspectedCard)) {
            int possibleplayerNum = HowManyPlayerWasAfterTheProving (data);
            
            Player playerWhoProved = data.getPlayerWhoProved();
            if (possibleplayerNum == 0) {
                SetPlayerCardToOwned (playerWhoProved, thirdSuspectedCard);
                return true;
            }
            
            possibleplayerNum++;// + the player who proved
            boolean[] knowEveryCard = new boolean[possibleplayerNum];
            if (IKwonEveryCardFromThatPlayer (playerWhoProved)){
                knowEveryCard[0] = true;
            }
            int i = 1;
            for (Player p :data.getAfterPlayers()){
                if (IKwonEveryCardFromThatPlayer (p)){
                    knowEveryCard[i] = true;
                } else {
                    knowEveryCard[i] = false;
                }
                i++;
            }
            i = 0;
            int countOfPlayersWithUnknownCards = 0; 
            int indexOfBoolWithFalse = 0;
            for (boolean b : knowEveryCard) {
                if (!b) {
                    countOfPlayersWithUnknownCards++;
                    indexOfBoolWithFalse = i;
                }
                i++;
            } 
            if (countOfPlayersWithUnknownCards == 1) {
                if (indexOfBoolWithFalse == 0) {
                     SetPlayerCardToOwned (playerWhoProved, thirdSuspectedCard);
                     return true;
                } else {
                    Player playerWhoWasAfterTheProve = data.getAfterPlayers().get(indexOfBoolWithFalse);
                    SetPlayerCardToOwned (playerWhoWasAfterTheProve, thirdSuspectedCard);
                     return true;
                }
            } else {
                return false;
            }
        }
       return false;
    }
    
    private void SetPlayersWhoWasBeforTheProveCardsToNotOwned (AiRoundData data) {
        for (Player p : data.getBeforPlayers ()) {
            AiPlayerCardInfo cardInfo = cardInfoOfThePlayers.get (p);
            cardInfo.setCardType (data.getSuspectedMurder (), AiPlayerCardInfo.Type.NOTOWNED);
            cardInfo.setCardType (data.getSuspectedWeapon (), AiPlayerCardInfo.Type.NOTOWNED);
            cardInfo.setCardType (data.getSuspectedRoom (), AiPlayerCardInfo.Type.NOTOWNED);
        }
    }
    private void SetPlayersWhoProvedCardToOwned (AiRoundData data) {
        AiPlayerCardInfo cardInfo = cardInfoOfThePlayers.get (data.getPlayerWhoProved ());
        cardInfo.setCardType (data.getProvedCard (), AiPlayerCardInfo.Type.OWNED);
    }
    private void SetPlayerCardToOwned (Player player, Card card){
        AiPlayerCardInfo cardInfo = cardInfoOfThePlayers.get (player);
        cardInfo.setCardType (card, AiPlayerCardInfo.Type.OWNED);
    }
    
    private List<Card> GetTheSuspectedCardIDontKnow (AiRoundData data) {
        Card murder = data.getSuspectedMurder ();
        Card weapon = data.getSuspectedWeapon ();
        Card room = data.getSuspectedRoom ();
        boolean isMurderKnown = false;
        boolean isWeaponKnown = false;
        boolean isRoomKnown = false;
        for (Player p : players) {
            AiPlayerCardInfo cardInfo = cardInfoOfThePlayers.get (p);
            if (!isMurderKnown && cardInfo.isOwned (murder)) {
                isMurderKnown = true;
            }
            if (!isWeaponKnown && cardInfo.isOwned (weapon)) {
                isWeaponKnown = true;
            }
            if (!isRoomKnown && cardInfo.isOwned (room)) {
                isRoomKnown = true;
            }
        }
        List<Card> cards = new ArrayList<>();
        if (!isMurderKnown) cards.add(murder);
        if (!isWeaponKnown) cards.add(weapon);
        if (!isRoomKnown) cards.add(room);
        
        return cards;
    }

    private int HowManyPlayerWasAfterTheProving (AiRoundData data) {
        return data.getAfterPlayers().size();
    }










}
