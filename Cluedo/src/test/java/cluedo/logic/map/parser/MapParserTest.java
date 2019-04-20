package cluedo.logic.map.parser;

import cluedo.logic.map.MapParser;
import cluedo.exceptions.*;

import java.util.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MapParserTest{
    
    @Test
    public void ParserTest(){
        MapParser mp1 = new MapParser();
        mp1.openFile("test1.txt");
        assertEquals(0, mp1.getMapList().size());
        
        MapParser mp2 = new MapParser();
        mp2.openFile("test2.txt");
        assertEquals(0,MapParser.getMapList().size());
        assertFalse("F".equals( MapParser.getMapList().toString()));
        assertFalse("R".equals(MapParser.getMapList().toString()));
        assertFalse("E".equals(MapParser.getMapList().toString()));
        //assertTrue(testMapString == mp2.getMapList().toString());

        MapParser mp3 = new MapParser();
        mp3.openFile("test3.txt");
        assertTrue(MapParser.getMapList().isEmpty());
        
    }
}