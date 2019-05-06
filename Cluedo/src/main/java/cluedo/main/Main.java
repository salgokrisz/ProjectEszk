
package cluedo.main;

import cluedo.view.MainAppWindow;
import cluedo.tools.Tools;

/**
 * The main class (entry point) of the application.
 * @author bornemis
 */
public class Main {
   public static void main(String[] args) {
       Tools.connectLogToFile();

    java.awt.EventQueue.invokeLater(() -> { 
            MainAppWindow mainWindow = new MainAppWindow();
            mainWindow.setVisible(true);
        });
    }  
}

