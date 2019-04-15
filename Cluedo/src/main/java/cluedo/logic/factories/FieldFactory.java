/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.factories;

import cluedo.logic.fields.EndField;
import cluedo.logic.fields.Field;
import cluedo.logic.fields.EntranceField;
import cluedo.logic.fields.FieldType.Type;
import cluedo.logic.fields.IntricField;
import cluedo.logic.fields.RoomField;
import cluedo.logic.fields.SecretField;
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
                 if(mapStrings.get(row).get(column).contains(":")){
                    String[] helper = mapStrings.get(row).get(column).split(":");
                    if(helper[0].equals("E")){
                        addEntranceField(helper,row,column);
                    }else if(helper[0].equals("Se")){
                        addSecretField(helper,row,column);
                    }else if(helper[0].equals("St")){
                        Field st = new StartField(row,column,true,false,helper[1]);
                        generatedMap.get(row).add(st);
                    }else if(helper[0].equals("R")){
                       addRoomField(helper,row,column);
                    }else if(helper[0].equals("En")){
                        Field en = new EndField(row,column,true,false,null,null,null);
                        generatedMap.get(row).add(en);
                    }else if(helper[0].equals("I")){
                        Field intric = new IntricField(row,column,true,false);
                        generatedMap.get(row).add(intric);
                    }
                }else{
                     Field e = new Field(row,column,Type.FIELD,true,false);
                     generatedMap.get(row).add(e);
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
