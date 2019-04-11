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

/**
 * This class get the list from the mapParser and it will
 * create the Fields from the Strings. Finally it will
 * create a two dimensional matrix from Fields with different
 * sub classes.
 * 
 */
public class FieldFactory {
    protected ArrayList<ArrayList<Field>> generatedMap;
    protected ArrayList<ArrayList<String>> mapStrings;
    protected MapParser mp = new MapParser();
    
    public FieldFactory(String fileName){
        getDataFromParser(fileName);
    }
    
    private void getDataFromParser(String fileName){
        mp.openFile(fileName);
        mapStrings = MapParser.getMapList();
        createFields();
    }
    
    private void createFields(){
        generatedMap = new ArrayList<>();
        String[] helper;
        for(int i = 0; i< mapStrings.size();i++){
            generatedMap.add(new ArrayList<>());
            for(int j = 0; j < mapStrings.get(i).size();j++){
                if(mapStrings.get(i).get(j).contains(":")){
                    helper = mapStrings.get(i).get(j).split(":");
                    if(helper[0].equals('E')){
                        boolean hasSecret = false;
                        if (helper[2].equals(1)){
                            hasSecret = true;
                        }
                        Field e = new EntranceField(i,j,Type.ENTRANCE,true,false,helper[1],hasSecret);
                        generatedMap.get(i).add(e);
                    }else if(helper[0].equals("Se")){
                        boolean hasSecret = false;
                        if (helper[2].equals(1)){
                            hasSecret = true;
                        }
                        Field s = new SecretField(i,j,Type.SECRET,true,false,helper[1],hasSecret,Integer.parseInt(helper[2]),Integer.parseInt(helper[3]),Integer.parseInt(helper[4]),Integer.parseInt(helper[5]));
                        generatedMap.get(i).add(s);
                    }else if(helper[0].equals("St")){
                        Field st = new StartField(i,j,Type.START,true,false,helper[1]);
                        generatedMap.get(i).add(st);
                    }else if(helper[0].equals("R")){
                        boolean hasSecretPath = false;
                        if (helper[2].equals(1)){
                            hasSecretPath = true;
                        }
                        Field r = new RoomField(i,j,Type.ROOM,true,false,helper[1],hasSecretPath);
                        generatedMap.get(i).add(r);
                    }else if(helper[0].equals("En")){
                        Field en = new EndField(i,j,Type.END,true,false,null,null,null);
                        generatedMap.get(i).add(en);
                    }else if(helper[0].equals("I")){
                        Field intric = new IntricField(i,j,Type.END,true,false);
                        generatedMap.get(i).add(intric);
                    }
                }else{
                     Field e = new Field(i,j,Type.FIELD,true,false);
                     generatedMap.get(i).add(e);
                }
                
            }
        }
    }

    public ArrayList<ArrayList<Field>> getGeneratedMap() {
        return generatedMap;
    }
    
    
    
}
