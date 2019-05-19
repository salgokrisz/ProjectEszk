
package cluedo.logic.map;

import cluedo.logic.factories.FieldFactory;
import cluedo.logic.fields.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * This class will get the data from the FieldFactory. It will work
 * with a two dimensional matrix from Fields. This class will do the
 * operations on the map.
 * 
 */
public class GameMap {
    private List<List<Field>> map;
    private final int rows;
    public GameMap(String fileName){
        FieldFactory fieldFactory = new FieldFactory(fileName);
        map=fieldFactory.getGeneratedMap();
        rows=map.size();
    }

    public List<List<Field>> getMap() {
        List<List<Field>> copyGameMap=new ArrayList<>();
        for(List<Field> row:map){
            List<Field> copyRow=new ArrayList<>();
            for(Field column: row){
                copyRow.add((Field)column.cloneObject());
            }
            copyGameMap.add(copyRow);
        }
        return copyGameMap;
    }

    public int getRows() {
        return rows;
    }
    
    
}
