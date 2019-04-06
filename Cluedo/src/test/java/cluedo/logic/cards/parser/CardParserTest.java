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
        List<List<Card>> cards = CardParser.Parse();
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
                    assertTrue (c.imageName.equals("Mustard.png"));
                    break;
                case "Plum":
                    assertFalse(plum);
                    plum = true;
                    assertTrue (c.imageName.equals("Plum.png"));
                    break;
                case "Green":
                    assertFalse(green);
                    green = true;
                    assertTrue (c.imageName.equals("Green.png"));
                    break;
                case "Peackock":
                    assertFalse(peackock);
                    peackock = true;
                    assertTrue (c.imageName.equals("Peackock.png"));
                    break;
                case "Scarlet":
                    assertFalse(scarlet);
                    scarlet = true;
                    assertTrue (c.imageName.equals("Scarlet.png"));
                    break;
                case "White":
                    assertFalse(white);
                    white = true;
                    assertTrue (c.imageName.equals("White.png"));
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
                    assertTrue (c.imageName.equals("Knife.png"));
                    break;
                case "Candlestick":
                    assertFalse(Candlestick);
                    Candlestick = true;
                    assertTrue (c.imageName.equals("Candlestick.png"));
                    break;
                case "Revolver":
                    assertFalse(Revolver);
                    Revolver = true;
                    assertTrue (c.imageName.equals("Revolver.png"));
                    break;
                case "Poison":
                    assertFalse(Poison);
                    Poison = true;
                    assertTrue (c.imageName.equals("Poison.png"));
                    break;
                case "Trophy":
                    assertFalse(Trophy);
                    Trophy = true;
                    assertTrue (c.imageName.equals("Trophy.png"));
                    break;
                case "Rope":
                    assertFalse(Rope);
                    Rope = true;
                    assertTrue (c.imageName.equals("Rope.png"));
                    break;
                case "Bat":
                    assertFalse(Bat);
                    Bat = true;
                    assertTrue (c.imageName.equals("Bat.png"));
                    break;
                case "Axe":
                    assertFalse(Axe);
                    Axe = true;
                    assertTrue (c.imageName.equals("Axe.png"));
                    break;
                case "Dumbbell":
                    assertFalse(Dumbbell);
                    Dumbbell = true;
                    assertTrue (c.imageName.equals("Dumbbell.png"));
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
                    assertTrue (c.imageName.equals("Hall.png"));
                    break;
                case "Eatery":
                    assertFalse(Eatery);
                    Eatery = true;
                    assertTrue (c.imageName.equals("Eatery.png"));
                    break;
                 case "Kitchen":
                    assertFalse(Kitchen);
                    Kitchen = true;
                    assertTrue (c.imageName.equals("Kitchen.png"));
                    break;
                case "Terrace":
                    assertFalse(Terrace);
                    Terrace = true;
                    assertTrue (c.imageName.equals("Terrace.png"));
                    break;
                case "Planetarium":
                    assertFalse(Planetarium);
                    Planetarium = true;
                    assertTrue (c.imageName.equals("Planetarium.png"));
                    break;
                case "Cinema":
                    assertFalse(Cinema);
                    Cinema = true;
                    assertTrue (c.imageName.equals("Cinema.png"));
                    break;
                case "LivingRoom":
                    assertFalse(LivingRoom);
                    LivingRoom = true;
                    assertTrue (c.imageName.equals("LivingRoom.png"));
                    break;
                case "Bath":
                    assertFalse(Bath);
                    Bath = true;
                    assertTrue (c.imageName.equals("Bath.png"));
                    break;
                case "GuestHouse":
                    assertFalse(GuestHouse);
                    GuestHouse = true;
                    assertTrue (c.imageName.equals("GuestHouse.png"));
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

