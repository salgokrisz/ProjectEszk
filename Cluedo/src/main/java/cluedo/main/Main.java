/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.main;

import cluedo.view.MainAppWindow;
import javax.swing.SwingUtilities;

/**
 *
 * @author Barby
 */
public class Main {
   public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
   

            MainAppWindow mainWindow = new MainAppWindow();
            mainWindow.setVisible(true);
        });
    }  
}

