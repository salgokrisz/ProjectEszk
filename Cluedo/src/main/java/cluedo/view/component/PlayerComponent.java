package cluedo.view.component;

import cluedo.view.RoleChooserWindow;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * This class is more like a wrapper class for helping the appearance of the 
 * role chooser window. Encapsulates the name, role, difficulty level and the 
 * human or artificially intelligent player properties.
 */
public final class PlayerComponent {
    private final JComboBox jcbPlayerPersonality;
    private final JTextField jtfName;
    private final JComboBox jcbPlayerRole;
    private final JComboBox jcbDifficultyLevel;
    private final JLabel jlPlayerNumberText;
    private String previouslySelectedjcbPlayerRole;
    public PlayerComponent(JComboBox jcbPlayerPersonality, JTextField jtfName, JComboBox jcbPlayerRole, JComboBox jcbDifficultyLevel, JLabel jlPlayerNumberText){
        this.jcbPlayerPersonality=jcbPlayerPersonality;
        this.jtfName=jtfName;
        this.jcbPlayerRole=jcbPlayerRole;
        this.jcbDifficultyLevel=jcbDifficultyLevel;
        this.jlPlayerNumberText=jlPlayerNumberText;
        previouslySelectedjcbPlayerRole=RoleChooserWindow.RANDOM_CONST;
    }

    public String getPreviouslySelectedjcbPlayerRole() {
        return previouslySelectedjcbPlayerRole;
    }

    public void setPreviouslySelectedjcbPlayerRole(String previouslySelectedjcbPlayerRole) {
        this.previouslySelectedjcbPlayerRole = previouslySelectedjcbPlayerRole;
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
    
    public JLabel getJlPlayerNumberText(){
        return jlPlayerNumberText;
    } 
}
