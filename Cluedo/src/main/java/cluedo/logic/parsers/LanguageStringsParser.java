package cluedo.logic.parsers;

import static cluedo.tools.Tools.LOG;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import cluedo.tools.languagestring.Language;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.nio.file.InvalidPathException;

public class LanguageStringsParser {
    private LanguageStringsParser(){}
    
    public static Map<String, String> parse (Language l, boolean test, String testTXT) {
        String txtPath = getTXTPath (l);
        if (test) {
            txtPath = testTXT;
        } 
        if (txtPath == null) return null;
        HashMap<String, String> data = new HashMap<>();
        try(BufferedReader br=new BufferedReader(new InputStreamReader(LanguageStringsParser.class.getResourceAsStream(txtPath), StandardCharsets.UTF_8));){
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineParts = line.split("=");
                if (lineParts.length == 2) {
                    data.put (lineParts[0], lineParts[1]);
                    
                } else if (lineParts.length > 2) {
                    StringBuilder sb = new StringBuilder();
                    for (int i  = 1; i < lineParts.length; ++i) {
                        sb.append (lineParts[i]);
                        sb.append ('=');
                    }                    
                    data.put (lineParts[0], sb.toString ());
                } 
            }
        } catch (Exception e) {
            LOG.warning(e.getMessage());
            data.clear();
        }
        return data;
    }
    
    private static String getTXTPath (Language l) {
        String currentPath=null;
        try{
        currentPath = "/languages/";
        switch (l) {
            case HUN : return currentPath + "StringsHUN.txt";
            case ENG : return currentPath + "StringsENG.txt";
            default  : return null; 
        }
    }catch(InvalidPathException e){
        LOG.log(Level.SEVERE,e.getMessage());
    }
        return currentPath;  
}
}
