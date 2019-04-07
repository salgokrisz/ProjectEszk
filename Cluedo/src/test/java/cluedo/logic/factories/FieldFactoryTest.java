/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.factories;

import cluedo.logic.fields.Field;
import cluedo.logic.fields.FieldType.Type;
import java.util.ArrayList;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Bence
 */
public class FieldFactoryTest {
    
    @Test
    public void testFieldFactoryWithFullyFieldTypeFields(){
        FieldFactory ff = new FieldFactory("test1ForFieldFactoryParserTest.txt");
        ArrayList<ArrayList<Field>> generated = ff.getGeneratedMap();
        ArrayList<ArrayList<Field>>expectedResult=new ArrayList<>();
        for(int i=0; i<2; ++i){
            expectedResult.add(new ArrayList<>());
            for(int j=0; j<3; ++j){
                expectedResult.get(i).add(new Field(i, j, Type.FIELD, true, false));
            }
        }
        assertEquals(expectedResult, generated);
    }
}
