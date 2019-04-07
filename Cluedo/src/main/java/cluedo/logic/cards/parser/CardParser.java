package cluedo.logic.cards.parser;

import cluedo.logic.cards.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
 
import java.nio.file.Paths;

import java.util.List;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonArray;
 
public class CardParser {
    public static List<List<Card>> Parse () {
        String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        currentPath += "/src/main/java/cluedo/Resources/";
         
        String JSONPath = currentPath + "Cards.json";
        try (InputStream is = new FileInputStream(new File(JSONPath))){
            JsonReader reader = Json.createReader(is);
            JsonObject cardsObj = reader.readObject();
            reader.close();
            
            JsonObject personsObj = cardsObj.getJsonObject("Persons");
            JsonObject weaponsObj = cardsObj.getJsonObject("Weapons");
            JsonObject roomsObj = cardsObj.getJsonObject("Rooms");
            
            List<Card> persons = getCardsFromJsonObj(personsObj, Card.Type.PERSON);
            List<Card> weapons = getCardsFromJsonObj(weaponsObj, Card.Type.WEAPON);
            List<Card> rooms = getCardsFromJsonObj(roomsObj, Card.Type.ROOM);
            
            List<List<Card>> cards = new ArrayList<List<Card>> ();
            cards.add(persons);
            cards.add(weapons);
            cards.add(rooms);
            
            return cards; 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
