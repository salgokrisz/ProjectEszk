/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.map;

import cluedo.logic.factories.FieldFactory;
import cluedo.logic.fields.Field;
import java.util.ArrayList;

/**
 *
 * @author Bence
 */
public class Map {
    ArrayList<ArrayList<Field>> map;
    FieldFactory fieldFactory;
    
    public Map(String fileName){
        fieldFactory = new FieldFactory(fileName);
        fieldFactory.getGeneratedMap();
    }
    
}
