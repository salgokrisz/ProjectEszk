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
        currentPath += "\\src\\test\\Resources";
        
        String JSONPath = currentPath + "\\Cards.json";
        try (InputStream is = new FileInputStream(new File(JSONPath))){
            JsonReader reader = Json.createReader(is);
            JsonObject cardsObj = reader.readObject();
            reader.close();
            
            JsonObject personsObj = cardsObj.getJsonObject("Persons");
            List<Card> personsList = new ArrayList();
            JsonArray personsName = personsObj.getJsonArray("names");
            for (int i = 0; i < personsObj.getInt("nums"); i++) {
                JsonObject person = personsObj.getJsonObject (personsName.getString(i));
                personsList.add (new PersonCard (person.getString("name"),
                                                 person.getString("image"),
                                                 person.getString("key"),
                                                 person.getString("color")));
            }
                
            JsonObject weaponsObj = cardsObj.getJsonObject("Weapons");
            List<Card> weaponsList = new ArrayList();
            JsonArray weaponsName = weaponsObj.getJsonArray("names");
            for (int i = 0; i < weaponsObj.getInt("nums"); i++) {
                JsonObject weapon = weaponsObj.getJsonObject (weaponsName.getString(i));
                weaponsList.add (new Card (weapon.getString("name"),
                                           weapon.getString("image"),
                                           weapon.getString("key")));
            }
            JsonObject roomsObj = cardsObj.getJsonObject("Rooms");
            List<Card> roomsList = new ArrayList();
            JsonArray roomsName = roomsObj.getJsonArray("names");
            for (int i = 0; i < roomsObj.getInt("nums"); i++) {
                JsonObject room = roomsObj.getJsonObject (roomsName.getString(i));
                roomsList.add (new Card (room.getString("name"),
                                         room.getString("image"),
                                         room.getString("key")));
            }
            
            List<List<Card>> cards = new ArrayList<List<Card>> ();
            cards.add(personsList);
            cards.add(weaponsList);
            cards.add(roomsList);
            return cards; 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
