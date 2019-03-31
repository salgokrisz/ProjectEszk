/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.factories;

import cluedo.logic.fields.Field;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;

/**
 *
 * @author Bence
 */
public class FieldFactoryTest {
    
    @Test
    public void testFieldFactoryWithFullyFieldTypeFields(){
        FieldFactory ff = new FieldFactory("test1.txt");
        ff.getGeneratedMap();
        ArrayList<ArrayList<Field>> generated = ff.getGeneratedMap();
        String expectedResult = "";
        System.out.println(generated.toString());
        assertEquals(generated.toString(),expectedResult);
    }
}
