package cluedo.logic.player.aiDataManager;

import cluedo.logic.player.Player;
import cluedo.logic.cards.Card;
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
    private List<Player> beforPlayers; //those who came befor the proving
    private List<Player> afterPlayers; //those who came after the proving

    private boolean intricaWasUsed;

    public void setSuspectedMurder(Card suspectedMurder) {
        this.suspectedMurder = suspectedMurder;
    }

    public void setSuspectedWeapon(Card suspectedWeapon) {
        this.suspectedWeapon = suspectedWeapon;
    }

    public void setSuspectedRoom(Card suspectedRoom) {
        this.suspectedRoom = suspectedRoom;
    }

    public void setPlayerWhoSuspected(Player playerWhoSuspected) {
        this.playerWhoSuspected = playerWhoSuspected;
    }

    public void setPlayerWhoProved(Player playerWhoProved) {
        this.playerWhoProved = playerWhoProved;
    }

    public void setBeforPlayers(List<Player> beforPlayers) {
        this.beforPlayers = beforPlayers;
    }

    public void setAfterPlayers(List<Player> afterPlayers) {
        this.afterPlayers = afterPlayers;
    }

    public void addBeforPlayers(Player player) {
        this.beforPlayers.add (player);
    }

    public void addAfterPlayers(Player player) {
        this.afterPlayers.add (player);
    }

    public void setIntricaWasUsed(boolean intricaWasUsed) {
        this.intricaWasUsed = intricaWasUsed;
    }

    public Card getSuspectedMurder() {
        return suspectedMurder;
    }

    public Card getSuspectedWeapon() {
        return suspectedWeapon;
    }

    public Card getSuspectedRoom() {
        return suspectedRoom;
    }

    public Player getPlayerWhoSuspected() {
        return playerWhoSuspected;
    }

    public Player getPlayerWhoProved() {
        return playerWhoProved;
    }

    public List<Player> getBeforPlayers() {
        return beforPlayers;
    }

    public List<Player> getAfterPlayers() {
        return afterPlayers;
    }

    public boolean isIntricaWasUsed() {
        return intricaWasUsed;
    }
    
    public Card getProvedCard() {
        return provedCard;
    }

    public void setProvedCard(Card provedCard) {
        this.provedCard = provedCard;
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
