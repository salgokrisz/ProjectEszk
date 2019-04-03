/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.factories;

import cluedo.logic.fields.Field;
import cluedo.logic.fields.EntranceField;
import cluedo.logic.fields.RoomField;
import cluedo.logic.fields.SecretField;
import cluedo.logic.fields.StartField;
import cluedo.logic.map.MapParser;
import java.nio.file.Paths;
//import cluedo.logic.map.MapParser;
import java.util.ArrayList;

/**
 *
 * @author Bence
 */
public class FieldFactory {
    protected ArrayList<ArrayList<Field>> generatedMap;
    //protected MapParser mapParser;
    protected ArrayList<ArrayList<String>> mapStrings;
    
    public FieldFactory(String fileName){
        GetDataFromParser(fileName);
    }
    
    private void GetDataFromParser(String fileName){
        String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        currentPath += "\\src\\main\\java\\cluedo\\Resources\\"+fileName;
        MapParser.openFile(currentPath);
        mapStrings = MapParser.getMapList();
        createFields();
    }
    
    private void createFields(){
        generatedMap = new ArrayList<>();
        String[] helper;
        for(int i = 0; i< mapStrings.size();i++){
            for(int j = 0; j < mapStrings.get(i).size();j++){
                if(mapStrings.get(i).get(j).contains(":")){
                    helper = mapStrings.get(i).get(j).split(":");
                    if(helper[0].equals('E')){
                        boolean hasSecret = false;
                        if (helper[2].equals(1)){
                            hasSecret = true;
                        }
                        EntranceField e = new EntranceField(i,j,"Entrance",true,false,helper[1],hasSecret);
                        generatedMap.get(i).add(e);
                    }else if(helper[0].equals("Se")){
                        boolean hasSecret = false;
                        if (helper[2].equals(1)){
                            hasSecret = true;
                        }
                        SecretField s = new SecretField(i,j,"Secret",true,false,helper[1],hasSecret,Integer.parseInt(helper[2]),Integer.parseInt(helper[3]),Integer.parseInt(helper[4]),Integer.parseInt(helper[5]));
                        generatedMap.get(i).add(s);
                    }else if(helper[0].equals("St")){
                        StartField st = new StartField(i,j,"Start",true,false,helper[1]);
                        generatedMap.get(i).add(st);
                    }else if(helper[0].equals("R")){
                        boolean hasSecretPath = false;
                        if (helper[2].equals(1)){
                            hasSecretPath = true;
                        }
                        RoomField r = new RoomField(i,j,"Room",true,false,helper[1],hasSecretPath);
                        generatedMap.get(i).add(r);
                    }
                }else{
                     Field e = new Field(i,j,"Field",true,false);
                     generatedMap.get(i).add(e);
                }
                
            }
        }
    }

    public ArrayList<ArrayList<Field>> getGeneratedMap() {
        return generatedMap;
    }
    
    
    
}
