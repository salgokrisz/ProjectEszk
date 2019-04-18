
package cluedo.logic.factories;


import cluedo.logic.fields.Field;
import cluedo.logic.fields.EntranceField;
import cluedo.logic.fields.FieldType;
import cluedo.logic.fields.RoomField;
import cluedo.logic.fields.StartField;
import cluedo.logic.map.MapParser;
import java.util.ArrayList;
import java.util.List;

/**
 * This class get the list from the mapParser and it will
 * create the Fields from the Strings. Finally it will
 * create a two dimensional matrix from Fields with different
 * sub classes.
 * 
 */
public class FieldFactory {
    protected List<List<Field>> generatedMap;
    protected List<List<String>> mapStrings;
    protected MapParser mp = new MapParser();
    
    public FieldFactory(String fileName){
        getDataFromParser(fileName);
    }
    
    private void getDataFromParser(String fileName){
        mp.openFile(fileName);
        mapStrings = MapParser.getMapList();
        createFields();
    }
    private void processField(int row, int column){
        String[] helper = mapStrings.get(row).get(column).split(":");
                 if(mapStrings.get(row).get(column).contains(":")){
                    
                    if(helper[0].equals("E")){
                        addEntranceField(helper,row,column);
                        String secretCorridorTo="";
                            secretCorridorTo=helper[3];
                        Field e = new EntranceField(row,column,true,false,helper[1],hasSecret, secretCorridorTo);
                        generatedMap.get(row).add(e);
                    }else if(helper[0].equals("St")){
                        Field st = new StartField(row,column,true,false,helper[1]);
                        generatedMap.get(row).add(st);
                    }else if(helper[0].equals("R")){
                        Field r = new RoomField(row,column,FieldType.ROOM, true,false,helper[1],false);
                        generatedMap.get(row).add(r);
                    }
                }else{
                     if(helper[0].equals("F")){
                     Field e = new Field(row,column,FieldType.FIELD,true,false);
                     generatedMap.get(row).add(e);
                     }else if(helper[0].equals("En")){
                         Field e = new Field(row,column,FieldType.END,true,false);
                     generatedMap.get(row).add(e);
                     }else if(helper[0].equals("I")){
                         Field intric = new Field(row,column,FieldType.INTRIC, true,false);
                        generatedMap.get(row).add(intric);
                     }
                }
    }
    
    private void addEntranceField(String[] data,int row,int column){
        boolean hasSecret = false;
                        if (data[2].equals("1")){
                            hasSecret = true;
                        }
                        Field e = new EntranceField(row,column,true,false,data[1],hasSecret);
                        generatedMap.get(row).add(e);
    }
    
    private void addSecretField(String[] data,int row,int column){
        boolean hasSecret = false;
                        if (data[2].equals("1")){
                            hasSecret = true;
                        }
                        Field s = new SecretField(row,column,Type.SECRET, true,false,data[1],hasSecret,Integer.parseInt(data[2]),Integer.parseInt(data[3]),Integer.parseInt(data[4]),Integer.parseInt(data[5]));
                        generatedMap.get(row).add(s);
    }
    
    public void addRoomField(String[] data,int row,int column){
         boolean hasSecretPath = false;
                        if (data[2].equals("1")){
                            hasSecretPath = true;
                        }
                        Field r = new RoomField(row,column,Type.ROOM, true,false,data[1],hasSecretPath);
                        generatedMap.get(row).add(r);
    }
    
    private void createFields(){
        generatedMap = new ArrayList<>();
        for(int i = 0; i< mapStrings.size();i++){
            generatedMap.add(new ArrayList<>());
            for(int j = 0; j < mapStrings.get(i).size();j++){
                processField(i, j);             
            }
        }
    }

    public List<List<Field>> getGeneratedMap() {
        return generatedMap;
    }
    
    
    
}
