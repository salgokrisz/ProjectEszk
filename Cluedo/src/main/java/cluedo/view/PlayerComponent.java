/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.view;

import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Barby
 */
public class PlayerComponent {
    private final JComboBox jcbPlayerPersonality;
    private final JTextField jtfName;
    private final JComboBox jcbPlayerRole;
    private final JComboBox jcbDifficultyLevel;
    public PlayerComponent(JComboBox jcbPlayerPersonality, JTextField jtfName, JComboBox jcbPlayerRole, JComboBox jcbDifficultyLevel){
        this.jcbPlayerPersonality=jcbPlayerPersonality;
        this.jtfName=jtfName;
        this.jcbPlayerRole=jcbPlayerRole;
        this.jcbDifficultyLevel=jcbDifficultyLevel;
    }

    public JComboBox getJcbPlayerPersonality() {
        return jcbPlayerPersonality;
    }

  

    public JTextField getJtfName() {
        return jtfName;
    }

 

    public JComboBox getJcbPlayerRole() {
        return jcbPlayerRole;
    }

   

    public JComboBox getJcbDifficultyLevel() {
        return jcbDifficultyLevel;
    }

  
    
}
