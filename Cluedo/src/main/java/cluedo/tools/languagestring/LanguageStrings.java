package cluedo.tools.languagestring;

import cluedo.logic.parsers.LanguageStringsParser;
import java.util.HashMap;
import java.util.Map;

public class LanguageStrings {
    private static Map<String, String> strings = new HashMap<>();
    private static Language l = Language.ENG;
    private LanguageStrings(){}
    public static Language getCurrentLanguage () {
        if (l == Language.ENG) return Language.ENG;
        else return Language.HUN;
    }
    
    public static String getString (String key) {
        if (key == null) 
            return null;
        if (strings.isEmpty())
            strings = LanguageStringsParser.parse (l, false, "");  
        return strings.get (key);
    }
    
    public static void changeLanguage (Language l) {
        if (LanguageStrings.l != l) {
            LanguageStrings.l = l;
            strings = LanguageStringsParser.parse (l, false, "");  
        }
    }

    
}
    