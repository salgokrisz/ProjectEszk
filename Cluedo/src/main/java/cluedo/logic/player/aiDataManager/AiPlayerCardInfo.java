package cluedo.logic.player.aiDataManager;

import cluedo.logic.cards.Card;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Szaya
 */
public class AiPlayerCardInfo {
    public enum Type {
        OWNED,
        NOTOWNED,
        UNKNOWN,
        
    };
    private Map<Card, Type> allMurderCards_Murder;
    private Map<Card, Type> allMurderCards_Weapon;
    private Map<Card, Type> allMurderCards_Room;
    
    private final int numberOfCardsInHand;

    public AiPlayerCardInfo(List<Card> allMurderCards_Murder, 
                            List<Card> allMurderCards_Weapon,
                            List<Card> allMurderCards_Room,
                            int numberOfCardsInHeand) {
        this. numberOfCardsInHand = numberOfCardsInHeand;
        this.allMurderCards_Murder = new HashMap<>();
        this.allMurderCards_Weapon = new HashMap<>();
        this.allMurderCards_Room = new HashMap<>();
        for (Card c: allMurderCards_Murder)
            this.allMurderCards_Murder.put(c, Type.UNKNOWN);
        for (Card c: allMurderCards_Weapon)
            this.allMurderCards_Weapon.put(c, Type.UNKNOWN);
        for (Card c: allMurderCards_Room)
            this.allMurderCards_Room.put(c, Type.UNKNOWN);
    }
    
   public void setCardType (Card card, Type type){
       switch (card.type) {
           case PERSON:
               allMurderCards_Murder.replace(card, type);
               break;
           case WEAPON:
               allMurderCards_Weapon.replace(card, type);
               break;
           case ROOM:
               allMurderCards_Room.replace(card, type);
               break;
           default:
               throw new AssertionError();
       }
   }
   public void setAllCardType (Type type) {
       allMurderCards_Murder.replaceAll((key, oldValue) -> type);
   }
   
   public Type getCardType (Card card){
       switch (card.type) {
           case PERSON: return allMurderCards_Murder.get(card);
           case WEAPON: return allMurderCards_Weapon.get(card);
           case ROOM:   return allMurderCards_Room.get(card);
           default:
               throw new AssertionError();
       }
   }
   
   public boolean isOwned (Card card) {
       switch (card.type) {
           case PERSON: return allMurderCards_Murder.get(card) == Type.OWNED;
           case WEAPON: return allMurderCards_Weapon.get(card) == Type.OWNED;
           case ROOM:   return allMurderCards_Room.get(card) == Type.OWNED;
           default:
               throw new AssertionError();
       }
   }
   
   public boolean isNotOwned (Card card) {
       switch (card.type) {
           case PERSON: return allMurderCards_Murder.get(card) == Type.NOTOWNED;
           case WEAPON: return allMurderCards_Weapon.get(card) == Type.NOTOWNED;
           case ROOM:   return allMurderCards_Room.get(card) == Type.NOTOWNED;
           default:
               throw new AssertionError();
       }
   }
   
   public boolean isEveryCardKnown (){
       int count = 0;
       for(Map.Entry<Card, Type> entry : allMurderCards_Murder.entrySet())
            if (entry.getValue() == Type.OWNED) count++;
        for(Map.Entry<Card, Type> entry : allMurderCards_Weapon.entrySet())
            if (entry.getValue() == Type.OWNED) count++;
        for(Map.Entry<Card, Type> entry : allMurderCards_Room.entrySet())
            if (entry.getValue() == Type.OWNED) count++;
        
        if (count == numberOfCardsInHand) {
            return true;
        } else if (count > numberOfCardsInHand) {
            throw new AssertionError();
        }
        return false;
   }
}
