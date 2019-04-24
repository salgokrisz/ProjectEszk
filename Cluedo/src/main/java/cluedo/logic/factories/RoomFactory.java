
package cluedo.logic.factories;

import cluedo.logic.fields.EntranceField;
import cluedo.logic.fields.Field;
import cluedo.logic.fields.FieldType;
import cluedo.logic.fields.RoomField;
import cluedo.logic.room.EndRoom;
import cluedo.logic.room.Point;
import cluedo.logic.room.Room;
import cluedo.logic.room.SecretCorridoredRoom;
import cluedo.view.board.CluePaperPanel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *This class is responsible for creating whole rooms from fields.
 */
public class RoomFactory {
    private final List<List<Field>> gameMap;
    public static final String ENDROOM_KEY="EndRoom";
    public RoomFactory(List<List<Field>> gameMap){
        this.gameMap=gameMap;
    }
    public Map<String, Room> generateRooms(){
        Map<String, Room> rooms=new HashMap<>();
        Map<String, String> entranceInfos=determineSecretEntranceInfos();
        List<Point> coordinates;
        for(List<Field> row: gameMap){
            for(Field field: row){
                if(field.getType()==FieldType.ROOM && !rooms.containsKey(((RoomField)field).getRoomName())){
                    RoomField roomField=(RoomField)field;
                    coordinates=determineCoordinates(roomField);
                    Room r;
                    Color color=determineColorForRoom(roomField.getRoomName());
                    if(entranceInfos.containsKey(roomField.getRoomName())){
                        r=new SecretCorridoredRoom(roomField.getRoomName(),coordinates, color);
                    }else{
                       r=new Room(roomField.getRoomName(), coordinates, color);
                    }
                    rooms.put(roomField.getRoomName(),r);
                }else if(field.getType()==FieldType.END && !rooms.containsKey(ENDROOM_KEY)){
                    coordinates=determineCoordinates(field);
                    Room r=new EndRoom(ENDROOM_KEY, coordinates,new Color(204, 255, 255));
                    rooms.put(ENDROOM_KEY, r);
                }
            }
        }
        Set<String> corridorsFrom=entranceInfos.keySet();
        for(String s: corridorsFrom){
            SecretCorridoredRoom se=(SecretCorridoredRoom)rooms.get(s);
            se.setToRoomName(entranceInfos.get(s));
        }
        return rooms;
    }
    public Color determineColorForRoom(String roomName){
        Color color;
        switch(roomName){
            case CluePaperPanel.BATH_KEY:
                color=new Color(73,52,208);
                break;
            case CluePaperPanel.CINEMA_KEY:
                color=new Color(255,0,0);
                break;
            case CluePaperPanel.EATERY_KEY:
                color=new Color(142,91,65);
                break;
            case CluePaperPanel.GUESTHOUSE_KEY:
                color=new Color(249,154,106);
                break;
            case CluePaperPanel.HALL_KEY:
                color=new Color(106,249,140);
                break;
            case CluePaperPanel.KITCHEN_KEY:
                color=new Color(255,241,44);
                break;
            case CluePaperPanel.LIVINGROOM_KEY:
                color=new Color(255,149,10);
                break;
            case CluePaperPanel.PLANETARIUM_KEY:
                color=new Color(10,190,255);
                break;
            case CluePaperPanel.TERRACE_KEY:
                color=new Color(218,96,16);
                break;
            default:
                color=new Color(162,162,162);
        }
        return color;
    }
    
    public boolean isEntranceOrEndOrRoomField(Field mapField, Field actField){
        return actField.getType()==FieldType.ROOM && mapField.getType()==FieldType.ROOM && ((RoomField)mapField).getRoomName().equals(((RoomField)actField).getRoomName())||mapField.getType()==FieldType.END && actField.getType()==FieldType.END
                || mapField.getType()==FieldType.ENTRANCE && actField.getType()==FieldType.ROOM && ((EntranceField)mapField).getRoomName().equals(((RoomField)actField).getRoomName())|| actField.getType()==FieldType.END && mapField.getType()==FieldType.ENTRANCE && ((EntranceField)mapField).getRoomName().equals("End");
    }
    private List<Point> determineCoordinates(Field field){
        List<Point> coordinates=new ArrayList<>();
        int i=0;
        while(i<gameMap.size()){
            int j=0;
            while(j<gameMap.get(i).size() && !isEntranceOrEndOrRoomField(gameMap.get(i).get(j), field)){               
                j+=1;               
            }
            if(j<gameMap.get(i).size()){
                while(j<gameMap.get(i).size() &&isEntranceOrEndOrRoomField(gameMap.get(i).get(j), field)){
                coordinates.add(new Point(i,j));
                j+=1;
                }
            }
            i+=1;
        }
        return coordinates;
    }
    private Map<String, String> determineSecretEntranceInfos(){
        Map<String, String> entranceInfos=new HashMap<>();
        for(List<Field> row: gameMap){
            for(Field field: row){
                if(field.getType()==FieldType.ENTRANCE && ((EntranceField)field).getRoomHasSecret()){
                    EntranceField entrance=(EntranceField)field;
                    entranceInfos.put(entrance.getRoomName(), entrance.getSecretCorridorTo());
                }
            }
        }
        return entranceInfos;
        
    }
   
}
