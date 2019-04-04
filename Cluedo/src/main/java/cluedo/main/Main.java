
package cluedo.main;

import cluedo.view.MainAppWindow;
import javax.swing.SwingUtilities;

/**
 * The main class (entry point) of the application.
 * @author bornemis
 */
public class Main {
   public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
   

            MainAppWindow mainWindow = new MainAppWindow();
            mainWindow.setVisible(true);
        });
    }  
}

