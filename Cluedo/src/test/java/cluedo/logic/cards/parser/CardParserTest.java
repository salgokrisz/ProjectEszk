package cluedo.logic.cards.parser;

import cluedo.logic.cards.Card;

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 *
 * @author Szaya
 */
public class CardParserTest {
    @Test
    public void ParserTest(){
        List<List<Card>> cards = CardParser.parse();
        assertEquals("We have to get 3 list with 3 type of cards.", 3, cards.size());
        
        boolean persons = false;
        boolean weapons = false;
        boolean rooms = false;
        for (List<Card> cardList : cards) {
            Card.Type firstCardType = Card.Type.UNKNOWN;
            for (int i = 0; i < cardList.size(); i++) {
                Card currentCard = cardList.get(i);
                if (i == 0)  firstCardType = currentCard.type;
                
                assertTrue(firstCardType != Card.Type.UNKNOWN);
                assertEquals("Every type in a list have to be same inside a list.", firstCardType ,currentCard.type);
            }
            
            switch (firstCardType) {
                case PERSON : {
                    assertFalse(persons);
                    persons = true;
                    assertEquals(6 ,cardList.size());
                    CheckPersons (cardList);
                } break ;
                case WEAPON : {
                    assertFalse(weapons);
                    weapons = true;
                    assertEquals(9 ,cardList.size());
                    CheckWeapons (cardList);
                } break ;
                case ROOM   : {
                    assertFalse(rooms);
                    rooms = true;
                    assertEquals(9 ,cardList.size());
                    CheckRooms   (cardList);
                } break ;
                default : assertTrue(false);
            }
        }
        
        assertTrue (persons && weapons && rooms);
    }
    public void CheckPersons(List<Card> cardList) {
        boolean mustard  = false;
        boolean plum     = false;
        boolean green    = false;
        boolean peackock = false;
        boolean scarlet  = false;
        boolean white    = false;
        
        for (Card c : cardList) {
            switch (c.name) {
                case "Mustard":
                    assertFalse(mustard);
                    mustard = true;
                    assertTrue (c.imageName.equals("/cards/guests/mustard.png"));
                    break;
                case "Plum":
                    assertFalse(plum);
                    plum = true;
                    assertTrue (c.imageName.equals("/cards/guests/plum.png"));
                    break;
                case "Green":
                    assertFalse(green);
                    green = true;
                    assertTrue (c.imageName.equals("/cards/guests/green.png"));
                    break;
                case "Peackock":
                    assertFalse(peackock);
                    peackock = true;
                    assertTrue (c.imageName.equals("/cards/guests/peacock.png"));
                    break;
                case "Scarlet":
                    assertFalse(scarlet);
                    scarlet = true;
                    assertTrue (c.imageName.equals("/cards/guests/scarlet.png"));
                    break;
                case "White":
                    assertFalse(white);
                    white = true;
                    assertTrue (c.imageName.equals("/cards/guests/white.png"));
                    break;
                default:
                    assertTrue (false);
                    break;
            }
        }
        
        assertTrue (mustard && plum && green && peackock && scarlet && white);
    }
    
    public void CheckWeapons(List<Card> cardList) {
        boolean Knife       = false;
        boolean Candlestick = false;
        boolean Revolver    = false;
        boolean Poison      = false;
        boolean Trophy      = false;
        boolean Rope        = false;
        boolean Bat         = false;
        boolean Axe         = false;
        boolean Dumbbell    = false;
        
        for (Card c : cardList) {
            switch (c.name) {
                case "Knife":
                    assertFalse(Knife);
                    Knife = true;
                    assertTrue (c.imageName.equals("/cards/weapons/knife.png"));
                    break;
                case "Candlestick":
                    assertFalse(Candlestick);
                    Candlestick = true;
                    assertTrue (c.imageName.equals("/cards/weapons/candlestick.png"));
                    break;
                case "Revolver":
                    assertFalse(Revolver);
                    Revolver = true;
                    assertTrue (c.imageName.equals("/cards/weapons/revolver.png"));
                    break;
                case "Poison":
                    assertFalse(Poison);
                    Poison = true;
                    assertTrue (c.imageName.equals("/cards/weapons/poison.png"));
                    break;
                case "Trophy":
                    assertFalse(Trophy);
                    Trophy = true;
                    assertTrue (c.imageName.equals("/cards/weapons/trophy.png"));
                    break;
                case "Rope":
                    assertFalse(Rope);
                    Rope = true;
                    assertTrue (c.imageName.equals("/cards/weapons/rope.png"));
                    break;
                case "Bat":
                    assertFalse(Bat);
                    Bat = true;
                    assertTrue (c.imageName.equals("/cards/weapons/bat.png"));
                    break;
                case "Axe":
                    assertFalse(Axe);
                    Axe = true;
                    assertTrue (c.imageName.equals("/cards/weapons/axe.png"));
                    break;
                case "Dumbbell":
                    assertFalse(Dumbbell);
                    Dumbbell = true;
                    assertTrue (c.imageName.equals("/cards/weapons/dumbbell.png"));
                    break;
                default:
                    assertTrue (false);
                    break;
            }
        }
       
        assertTrue (Knife && 
                    Candlestick && 
                    Revolver && 
                    Poison && 
                    Trophy && 
                    Rope && 
                    Bat && 
                    Axe && 
                    Dumbbell);
    }
    
    public void CheckRooms(List<Card> cardList) {
        boolean Hall  = false;
        boolean Eatery     = false;
        boolean Kitchen    = false;
        boolean Terrace = false;
        boolean Planetarium  = false;
        boolean Cinema    = false;
        boolean LivingRoom  = false;
        boolean Bath    = false;
        boolean GuestHouse    = false;
        
        for (Card c : cardList) {
            switch (c.name) {
                case "Hall":
                    assertFalse(Hall);
                    Hall = true;
                    assertTrue (c.imageName.equals("/cards/rooms/hall.png"));
                    break;
                case "Eatery":
                    assertFalse(Eatery);
                    Eatery = true;
                    assertTrue (c.imageName.equals("/cards/rooms/eatery.png"));
                    break;
                 case "Kitchen":
                    assertFalse(Kitchen);
                    Kitchen = true;
                    assertTrue (c.imageName.equals("/cards/rooms/kitchen.png"));
                    break;
                case "Terrace":
                    assertFalse(Terrace);
                    Terrace = true;
                    assertTrue (c.imageName.equals("/cards/rooms/terrace.png"));
                    break;
                case "Planetarium":
                    assertFalse(Planetarium);
                    Planetarium = true;
                    assertTrue (c.imageName.equals("/cards/rooms/planetarium.png"));
                    break;
                case "Cinema":
                    assertFalse(Cinema);
                    Cinema = true;
                    assertTrue (c.imageName.equals("/cards/rooms/cinema.png"));
                    break;
                case "LivingRoom":
                    assertFalse(LivingRoom);
                    LivingRoom = true;
                    assertTrue (c.imageName.equals("/cards/rooms/livingroom.png"));
                    break;
                case "Bath":
                    assertFalse(Bath);
                    Bath = true;
                    assertTrue (c.imageName.equals("/cards/rooms/bath.png"));
                    break;
                case "GuestHouse":
                    assertFalse(GuestHouse);
                    GuestHouse = true;
                    assertTrue (c.imageName.equals("/cards/rooms/guesthouse.png"));
                    break;
                default:
                    assertTrue (false);
                    break;
            }
        }
        
        assertTrue (Hall && 
                    Eatery && 
                    Kitchen && 
                    Terrace && 
                    Planetarium && 
                    Cinema && 
                    LivingRoom && 
                    Bath && 
                    GuestHouse);
    }
    
}

