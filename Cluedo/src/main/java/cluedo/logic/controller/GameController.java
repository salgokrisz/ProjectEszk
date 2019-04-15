
package cluedo.logic.controller;

import cluedo.logic.cards.Card;
import cluedo.logic.cards.parser.CardParser;
import cluedo.logic.factories.PlayerFactory;
import cluedo.logic.player.Player;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

/**
 *This class is responsible for controlling the game.
 */
public class GameController {
   private int numberOfPlayers;
   private int numberOfComputerPlayers;
   private List<Player> players;


    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getNumberOfComputerPlayers() {
        return numberOfComputerPlayers;
    }

    public void setNumberOfComputerPlayers(int numberOfComputerPlayers) {
        this.numberOfComputerPlayers = numberOfComputerPlayers;
    }
    
   public void initializePlayers(List<String> playerInformations){
       PlayerFactory pf=new PlayerFactory();
       players=pf.createPlayers(playerInformations);
   }
   public List<Player> roleDicesForDecidingStarterPlayer(){
       Map<Player, Integer> droppedNumbers=new HashMap<>();
       for(int i=0; i<numberOfPlayers; ++i){
           droppedNumbers.put(players.get(i), randomizeNumber(6)+1);
       }
       int maximumIndex=chooseMaximumNumber(droppedNumbers);
       return findPlayersWithMaxNumber(maximumIndex, droppedNumbers);
   }
   public void sortPlayers(){
       List<Player> playersWithMaxNumber;
       do{
           playersWithMaxNumber=roleDicesForDecidingStarterPlayer();
       }while(playersWithMaxNumber.size()>1);
       Player starterPlayer=playersWithMaxNumber.get(0);
       Map<Integer, Player> serialNumbers=new TreeMap<>();
       serialNumbers.put(0, starterPlayer);
       int starterIndex=findPlayerIndex(starterPlayer);
       assert starterIndex>=0 && starterIndex<players.size(): "Players must contain starter player.";  
         int  placeCounter=1;
           int i;
           boolean increase=false;
           if(starterIndex==0){
               i=players.size()-1;
           }else if(starterIndex==players.size()-1){
               increase=true;
               i=0;
           }else{
               i=starterIndex-1;
           }
           while(placeCounter!=players.size()-1){
               serialNumbers.put(placeCounter, players.get(i));
               if(increase){
                   i+=1;
                   if(i==players.size()-1){
                       increase=false;
                   }
               }else{
                   i-=1;
                   if(i==0){
                       increase=true;
                   }
               }
               placeCounter+=1;
           }
       players.clear();
       Set<Integer> keys=serialNumbers.keySet();
       for(Integer k: keys){
           players.add(serialNumbers.get(k));
       }
       
   }
   public int findPlayerIndex(Player player){
       int i=0;
       while(i<players.size() && !players.get(i).equals(player)){
           i+=1;
       }
       return i;
   }
   public List<Player> findPlayersWithMaxNumber(int maximumIndex, Map<Player, Integer> droppedNumbers){
       Set<Player> keys=droppedNumbers.keySet();
       List<Player> playersWithSameNumber=new ArrayList<>();
       for(Player k: keys){
           if(droppedNumbers.get(k)==maximumIndex){
               playersWithSameNumber.add(k);
           }
       }
       return playersWithSameNumber;
   }
    public boolean isCorrectPlayerName(String playerName) {
        return playerName == null ? false : playerName.matches("^[A-Za-zÖöÜüÓóŐőÚúÁáÉéÍíŰű].*$");
    }
    public int chooseMaximumNumber(Map<Player, Integer> droppedNumbers){
        assert !droppedNumbers.isEmpty():"Dropped numbers cannot be empty at this point.";
        Set<Player> keys=droppedNumbers.keySet();
        Iterator<Player> iter=keys.iterator();
        int maximum=droppedNumbers.get(iter.next());
        while(iter.hasNext()){
            int actualNumber=droppedNumbers.get(iter.next());
            if(actualNumber>maximum){
                maximum=actualNumber;
            }
        }
        return maximum;
    }
    public int randomizeNumber(int to) {
        Random rand = new Random();
        return rand.nextInt(to);
    }
    private Card chooseKillerCard(List<Card> suspectCards){
        Collections.shuffle(suspectCards);
        return suspectCards.get(0);
    }
    public void initializeSuspectCards(){
        List<List<Card>> cards=CardParser.parse();
        List<Card> suspectCards=new LinkedList<>();
        for(int i=0; i<3; ++i){
            List<Card> parts=cards.get(i);
            Card killer=chooseKillerCard(parts);
            parts.remove(killer);
            suspectCards=fillUpSupsectCardWithCards(parts, suspectCards);
        }
        Collections.shuffle(suspectCards);
        int remainingCardNumber=suspectCards.size()%numberOfPlayers;
        for(int i=0; i<suspectCards.size()-remainingCardNumber; ++i){
            players.get(i).drawSuspectCard(suspectCards.remove(i));
        }
    }
    
    public void initializeGame() {
        initializeSuspectCards();   
        sortPlayers();
    }
    
    private List<Card> fillUpSupsectCardWithCards(List<Card> cards, List<Card> suspectCards) {
        Collections.shuffle(cards);
        suspectCards.addAll(cards);
        return suspectCards;
    }
}
