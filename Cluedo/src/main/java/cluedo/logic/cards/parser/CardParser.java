package cluedo.logic.cards.parser;

import cluedo.logic.cards.*;
import static cluedo.tools.Tools.LOG;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
 
import java.nio.file.Paths;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonArray;
 
public class CardParser {
    private CardParser(){}
    private static List<List<Card>> readJson(String jsonPath){
        List<List<Card>> cards = new ArrayList<> ();
        try (InputStream is = new FileInputStream(new File(jsonPath));JsonReader reader = Json.createReader(is)){
      
            JsonObject cardsObj = reader.readObject();
            reader.close();
            
            JsonObject personsObj = cardsObj.getJsonObject("Persons");
            JsonObject weaponsObj = cardsObj.getJsonObject("Weapons");
            JsonObject roomsObj = cardsObj.getJsonObject("Rooms");
            
            List<Card> persons = getCardsFromJsonObj(personsObj, Card.Type.PERSON);
            List<Card> weapons = getCardsFromJsonObj(weaponsObj, Card.Type.WEAPON);
            List<Card> rooms = getCardsFromJsonObj(roomsObj, Card.Type.ROOM);
            
            
            cards.add(persons);
            cards.add(weapons);
            cards.add(rooms); 
        }catch (FileNotFoundException e) {
            LOG.warning(e.getMessage());
            cards.clear();
        } catch (IOException e) {
            LOG.warning(e.getMessage());
            cards.clear();
        }
        return cards;
    }
    public static List<List<Card>> parse () {
        List<List<Card>> cards = new ArrayList<> ();
        try{
            
        String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        currentPath += "/src/main/java/cluedo/resources/";
        String jsonPath = currentPath + "Cards.json";
         cards=readJson(jsonPath);
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
