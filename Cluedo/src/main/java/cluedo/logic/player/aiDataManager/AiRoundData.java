package cluedo.logic.player.aiDataManager;

import cluedo.logic.player.Player;
import cluedo.logic.cards.Card;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Szaya
 */
public class AiRoundData {
    private Card provedCard; //only not null when I was suspecting
    private Card suspectedMurder;
    private Card suspectedWeapon;
    private Card suspectedRoom;
    private Player playerWhoSuspected; 
    private Player playerWhoProved; //null if nobody suspected
    private List<Player> beforePlayers; //those who came befor the proving
    private List<Player> afterPlayers; //those who came after the proving
    private boolean intricaWasUsed;

    public void setSuspectedMurder(Card suspectedMurder) {
        this.suspectedMurder=null;
        if(suspectedMurder!=null){
        this.suspectedMurder = (Card)suspectedMurder.cloneObject();
        }
    }

    public void setSuspectedWeapon(Card suspectedWeapon) {
        this.suspectedWeapon=null;
        if(suspectedWeapon!=null){
        this.suspectedWeapon = (Card)suspectedWeapon.cloneObject();
        }
    }

    public void setSuspectedRoom(Card suspectedRoom) {
        this.suspectedRoom=null;
        if(suspectedRoom!=null){
        this.suspectedRoom = (Card)suspectedRoom.cloneObject();
        }
    }

    public void setPlayerWhoSuspected(Player playerWhoSuspected) {
        this.playerWhoSuspected=null;
        if(playerWhoSuspected!=null){
        this.playerWhoSuspected = (Player)playerWhoSuspected.cloneObject();
        }
    }

    public void setPlayerWhoProved(Player playerWhoProved) {
        this.playerWhoProved=null;
        if(playerWhoProved!=null){
        this.playerWhoProved = (Player)playerWhoProved.cloneObject();
        }
    }

    public void setBeforePlayers(List<Player> beforePlayers) {
        this.beforePlayers=new ArrayList<>();
        for(Player p: beforePlayers){
            this.beforePlayers.add((Player)p.cloneObject());
        }
    }

    public void setAfterPlayers(List<Player> afterPlayers) {
        this.afterPlayers=new ArrayList<>();
        for(Player p: afterPlayers){
            this.afterPlayers.add((Player)p.cloneObject());
        }
    }

    public void addBeforePlayers(Player player) {
        this.beforePlayers.add (player);
    }

    public void addAfterPlayers(Player player) {
        this.afterPlayers.add (player);
    }

    public void setIntricaWasUsed(boolean intricaWasUsed) {
        this.intricaWasUsed = intricaWasUsed;
    }

    public Card getSuspectedMurder() {
        Card aClone=null;
        if(suspectedMurder!=null){
            aClone=(Card)suspectedMurder.cloneObject();
        }
        return aClone;
    }

    public Card getSuspectedWeapon() {
        Card aClone=null;
        if(suspectedWeapon!=null){
            aClone=(Card)suspectedWeapon.cloneObject();
        }
        return aClone;
    }

    public Card getSuspectedRoom() {
            Card aClone=null;
        if(suspectedRoom!=null){
            aClone=(Card)suspectedRoom.cloneObject();
        }
        return aClone;
    }

    public Player getPlayerWhoSuspected() {
        Player aClone=null;
        if(playerWhoSuspected!=null){
            aClone=(Player)playerWhoSuspected.cloneObject();
        }
        return aClone;
    }

    public Player getPlayerWhoProved() {
        Player aClone=null;
        if(playerWhoProved!=null){
            aClone=(Player)playerWhoProved.cloneObject();
        }
        return aClone;
    }

    public List<Player> getBeforePlayers() {
        List<Player> copy=new ArrayList<>();
        for(Player p: beforePlayers){
            copy.add((Player)p.cloneObject());
        }
        return copy;
    }

    public List<Player> getAfterPlayers() {
        List<Player> copy=new ArrayList<>();
        for(Player p: afterPlayers){
            copy.add((Player)p.cloneObject());
        }
        return copy;
    }

    public boolean isIntricaWasUsed() {
        return intricaWasUsed;
    }
    
    public Card getProvedCard() {
        Card aClone=null;
        if(provedCard!=null){
            aClone=(Card)provedCard.cloneObject();
        }
        return aClone;
    }

    public void setProvedCard(Card provedCard) {
        this.provedCard = null;
        if(provedCard!=null){
            this.provedCard=(Card)provedCard.cloneObject();
        }
    }
        
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.suspectedMurder);
        hash = 79 * hash + Objects.hashCode(this.suspectedWeapon);
        hash = 79 * hash + Objects.hashCode(this.suspectedRoom);
        hash = 79 * hash + Objects.hashCode(this.playerWhoSuspected);
        hash = 79 * hash + Objects.hashCode(this.playerWhoProved);
        hash = 79 * hash + (this.intricaWasUsed ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if(obj==this){
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AiRoundData other = (AiRoundData) obj;
        if (!Objects.equals(this.suspectedMurder, other.suspectedMurder)) {
            return false;
        }
        if (!Objects.equals(this.suspectedWeapon, other.suspectedWeapon)) {
            return false;
        }
        if (!Objects.equals(this.suspectedRoom, other.suspectedRoom)) {
            return false;
        }
        if (!Objects.equals(this.playerWhoSuspected, other.playerWhoSuspected)) {
            return false;
        }
        if (!Objects.equals(this.playerWhoProved, other.playerWhoProved)) {
            return false;
        }
        if (this.intricaWasUsed != other.intricaWasUsed) {
            return false;
        }
        return true;
    }
}
