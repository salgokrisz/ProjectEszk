package cluedo.logic.parsers;

import cluedo.logic.cards.*;
import static cluedo.tools.Tools.LOG;
import java.io.BufferedReader;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.InvalidPathException;
 


import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonArray;
 
public class CardParser {
    private CardParser(){}
    private static List<List<Card>> readJson(InputStream is){
        List<List<Card>> cards = new ArrayList<> ();
        try (JsonReader reader = Json.createReader(new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8)))){
      
            JsonObject cardsObj = reader.readObject();

            
            JsonObject personsObj = cardsObj.getJsonObject("Persons");
            JsonObject weaponsObj = cardsObj.getJsonObject("Weapons");
            JsonObject roomsObj = cardsObj.getJsonObject("Rooms");
            
            List<Card> persons = getCardsFromJsonObj(personsObj, Card.Type.PERSON);
            List<Card> weapons = getCardsFromJsonObj(weaponsObj, Card.Type.WEAPON);
            List<Card> rooms = getCardsFromJsonObj(roomsObj, Card.Type.ROOM);
            
            
            cards.add(persons);
            cards.add(weapons);
            cards.add(rooms); 
        }catch (Exception e) {
            LOG.warning(e.getMessage());
            cards.clear();
        }
        return cards;
    }
    public static List<List<Card>> parse (InputStream is) {
        List<List<Card>> cards = new ArrayList<> ();
        try{
         cards=readJson(is);
        }catch(InvalidPathException e){
            LOG.log(Level.SEVERE, e.getMessage());
            cards.clear();
        }
        return cards;
    }
    
    private static List<Card> getCardsFromJsonObj (JsonObject cardsObj, Card.Type type ) {      
        List<Card> cardList = new ArrayList();
        JsonArray cardsName = cardsObj.getJsonArray("names");
        for (int i = 0; i < cardsObj.getInt("num"); i++) {
            JsonObject card = cardsObj.getJsonObject (cardsName.getString(i));
            cardList.add (new Card (card.getString("name"),
                                    card.getString("image"),
                                    card.getString("key"),
                                    type));
        }
        return cardList;
    }
}
