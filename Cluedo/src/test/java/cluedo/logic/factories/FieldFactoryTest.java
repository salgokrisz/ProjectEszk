
package cluedo.logic.factories;

import cluedo.logic.fields.Field;
import cluedo.logic.fields.FieldType.Type;
import java.util.ArrayList;
import java.util.List;
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
        List<List<Field>> generated = ff.getGeneratedMap();
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
