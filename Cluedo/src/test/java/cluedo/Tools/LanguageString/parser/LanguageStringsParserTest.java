package cluedo.Tools.LanguageString.parser;

import cluedo.tools.languagestring.parser.LanguageStringsParser;
import cluedo.tools.languagestring.Language;

import java.util.HashMap;
import java.nio.file.Paths;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class LanguageStringsParserTest {   
    private final String t1_eng = "test1_eng";
    private final String t2_eng = "test2_eng";
    private final String t3_eng = "test3_eng";
    private final String t4_eng = "test4_eng";
    private final String t5_eng = "test5_eng";
    
    private final String t1_hun = "test1_hun";
    private final String t2_hun = "test2_hun";
    private final String t3_hun = "test3_hun";
    private final String t4_hun = "test4_hun";
    private final String t5_hun = "test5_hun";
    
    private final String t1_key = "Test.1";
    private final String t2_key = "Test.2";
    private final String t3_key = "Test.3";
    private final String t4_key = "Test.4";
    private final String t5_key = "Test.5";
        
    @Test
    public void TestParser_ENG() {
        TestParser (Language.ENG);
    }
    @Test
    public void TestParser_HUN() {
        TestParser (Language.HUN);
    }
    
    private void TestParser(Language L) {
        String t1 = "";
        String t2 = "";
        String t3 = "";
        String t4 = "";
        String t5 = "";
        if (L == Language.HUN) {
            t1 = t1_hun;
            t2 = t2_hun;
            t3 = t3_hun;
            t4 = t4_hun;
            t5 = t5_hun;
        } else  if (L == Language.ENG) {
            t1 = t1_eng;
            t2 = t2_eng;
            t3 = t3_eng;
            t4 = t4_eng;
            t5 = t5_eng;
        } else {
            assertTrue(false);
        }
        Map<String, String> strings = null;
        strings = LanguageStringsParser.parse (L, true, GetTXTPath_forTest(L));
        
        assertNotNull(strings);
        assertEquals(5, strings.size());
        
        assertEquals(t1, strings.get(t1_key));
        assertEquals(t2, strings.get(t2_key));
        assertEquals(t3, strings.get(t3_key));
        assertEquals(t4, strings.get(t4_key));
        assertEquals(t5, strings.get(t5_key));
        
    }
            
    private String GetTXTPath_forTest (Language L) {
        String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        currentPath += "/src/main/java/cluedo/Resources/";
        switch (L) {
            case HUN : return currentPath + "StringsHUN_test.txt";
            case ENG : return currentPath + "StringsENG_test.txt";
            default  : return null; 
        }
    }
}
