
package cluedo.logic.factories;

import cluedo.logic.fields.EntranceField;
import cluedo.logic.fields.Field;
import cluedo.logic.fields.FieldType;
import cluedo.logic.fields.RoomField;
import cluedo.logic.room.EndRoom;
import cluedo.logic.room.Point;
import cluedo.logic.room.Room;
import cluedo.logic.room.RoomColor;
import cluedo.logic.room.SecretCorridoredRoom;
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
                    if(entranceInfos.containsKey(roomField.getRoomName())){
                        r=new SecretCorridoredRoom(roomField.getRoomName(),coordinates,RoomColor.DEFAULT);
                    }else{
                       r=new Room(roomField.getRoomName(), coordinates,RoomColor.DEFAULT);
                    }
                    rooms.put(roomField.getRoomName(),r);
                }else if(field.getType()==FieldType.END && !rooms.containsKey("EndRoom")){
                    coordinates=determineCoordinates(field);
                    Room r=new EndRoom("EndRoom", coordinates,RoomColor.DEFAULT);
                    rooms.put("EndRoom", r);
                }
            }
        }
        Set<String> corridorsFrom=entranceInfos.keySet();
        for(String s: corridorsFrom){
            SecretCorridoredRoom se=(SecretCorridoredRoom)rooms.get(s);
            se.setToRoom(rooms.get(entranceInfos.get(s)));
        }
        return rooms;
    }
    public boolean isEntranceOrEndOrRoomField(Field mapField, Field actField){
        return actField.getType()==FieldType.ROOM && mapField.getType()==FieldType.ROOM && ((RoomField)mapField).getRoomName().equals(((RoomField)actField).getRoomName())||mapField.getType()==FieldType.END && actField.getType()==FieldType.END
                || mapField.getType()==FieldType.ENTRANCE && actField.getType()==FieldType.ROOM && ((EntranceField)mapField).getRoomName().equals(((RoomField)actField).getRoomName())||actField.getType()==FieldType.END && ((EntranceField)mapField).getRoomName().equals("End");
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
