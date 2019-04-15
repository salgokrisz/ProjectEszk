
package cluedo.tools;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *This class contains the logger fro the program.
 */
public class Tools {
    public static final Logger LOG = Logger.getLogger( "logger");
    private Tools(){}
    public static void connectLogToFile(){
         try {  
        // This block configure the logger with handler and formatter
        String logPath=Paths.get(".").toAbsolutePath().normalize().toString();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm");
        String logFileName=LocalDateTime.now().format(dateTimeFormatter)+".log";
        new File(logPath+"/log_files/").mkdir();
        logPath+="/log_files/"+logFileName;
        FileHandler fh = new FileHandler(logPath);  
        LOG.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter);  
    } catch (SecurityException | IOException e) {  
        LOG.warning(e.getMessage());
    }  
    }
}
