package cluedo.Tools.LanguageString.parser;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.nio.file.Paths;
import cluedo.Tools.LanguageString.Language;

public class LanguageStringsParser {
    public static HashMap<String, String> Parse (Language L) {
        String txtPath = GetTXTPath (L);
        if (txtPath == null) return null;
        
        try (BufferedReader br = new BufferedReader (new FileReader (new File (txtPath)))) {
            HashMap<String, String> Data = new HashMap<>();
            
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineParts = line.split("=");
                if (lineParts.length == 2) {
                    Data.put (lineParts[0], lineParts[1]);
                    
                } else if (lineParts.length > 2) {
                    StringBuilder sb = new StringBuilder();
                    for (int i  = 1; i < lineParts.length; ++i) {
                        sb.append (lineParts[i]);
                        sb.append ('=');
                    }                    
                    Data.put (lineParts[0], sb.toString ());
                } 
            }
            return Data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private static String GetTXTPath (Language L) {
        String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        currentPath += "\\src\\main\\java\\cluedo\\Resources";
        switch (L) {
            case HUN : return currentPath + "\\StringsHUN.txt";
            case ENG : return currentPath + "\\StringsENG.txt";
            default  : return null; 
        }
    }
}
