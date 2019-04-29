package cluedo.Tools.LanguageString;

import cluedo.tools.languagestring.LanguageStrings;
import cluedo.tools.languagestring.Language;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class LanguageStringsTest {    
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
    
    private void CheckGetString (Language L) {
        assertEquals(LanguageStrings.getCurrentLanguage(), L);
    
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
        
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        
        boolean t1_bool = false;
        boolean t2_bool = false;
        boolean t3_bool = false;
        boolean t4_bool = false;
        boolean t5_bool = false;
        
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int n = rand.nextInt(l.size());
            assertFalse (n >= l.size());
            
            int index = l.get(n);
            l.remove(n);
            
            switch (index) {
                case 1 : {
                    assertFalse(t1_bool);
                    t1_bool = true;
                    assertEquals(t1, LanguageStrings.getString("Test.1"));
                } break;
                case 2 : {
                    assertFalse(t2_bool);
                    t2_bool = true;
                    assertEquals(t2, LanguageStrings.getString("Test.2"));
                } break;
                case 3 : {
                    assertFalse(t3_bool);
                    t3_bool = true;
                    assertEquals(t3, LanguageStrings.getString("Test.3"));
                } break;
                case 4 : {
                    assertFalse(t4_bool);
                    t4_bool = true;
                    assertEquals(t4, LanguageStrings.getString("Test.4"));
                } break;
                case 5 : {
                    assertFalse(t5_bool);
                    t5_bool = true;
                    assertEquals(t5, LanguageStrings.getString("Test.5"));
                } break;
                default : assertTrue(false);
            }
        }
        
        assertTrue(t1_bool && t2_bool && t3_bool && t4_bool && t5_bool);
    }
    
    @Test
    public void GetCurrentLanguageTest(){
        LanguageStrings.changeLanguage (Language.HUN);
        assertEquals("ChangeLanguage to HUN.", Language.HUN, LanguageStrings.getCurrentLanguage());
        LanguageStrings.changeLanguage (Language.HUN);
        assertEquals("ChangeLanguage to the same with the current.", Language.HUN, LanguageStrings.getCurrentLanguage());
        LanguageStrings.changeLanguage (Language.ENG);
        assertEquals("ChangeLanguage to ENG.", Language.ENG, LanguageStrings.getCurrentLanguage());
    }
    
	@Test
    public void GetStringWithWrongGivenKeyTest(){
		assertNull(LanguageStrings.getString(null));
		assertNull(LanguageStrings.getString(""));
	}
	
    @Test    
    public void GetStringTest(){
        CheckGetString(Language.ENG);
    }
    
    @Test    
    public void ChangeLanguageTest(){
        LanguageStrings.changeLanguage (Language.HUN);
        CheckGetString(Language.HUN);
        
        LanguageStrings.changeLanguage (Language.ENG);
        CheckGetString(Language.ENG);
        
        LanguageStrings.changeLanguage (Language.HUN);
        CheckGetString(Language.HUN);
        
        LanguageStrings.changeLanguage (Language.ENG);
        LanguageStrings.changeLanguage (Language.HUN);
        LanguageStrings.changeLanguage (Language.HUN);
        LanguageStrings.changeLanguage (Language.ENG);
        LanguageStrings.changeLanguage (Language.HUN);
        LanguageStrings.changeLanguage (Language.ENG);
        CheckGetString(Language.ENG);
    
    }
    
    @Test    
    public void ChangeLanguageWithSameLanguageTest(){
        LanguageStrings.changeLanguage (Language.ENG);
        CheckGetString(Language.ENG);
        LanguageStrings.changeLanguage (Language.ENG);
        CheckGetString(Language.ENG);
        CheckGetString(Language.ENG);
        LanguageStrings.changeLanguage (Language.ENG);
        
        CheckGetString(Language.ENG);
        LanguageStrings.changeLanguage (Language.HUN);
        CheckGetString(Language.HUN);
        LanguageStrings.changeLanguage (Language.HUN);
        CheckGetString(Language.HUN);
        CheckGetString(Language.HUN);
        LanguageStrings.changeLanguage (Language.HUN);
    }
}
    