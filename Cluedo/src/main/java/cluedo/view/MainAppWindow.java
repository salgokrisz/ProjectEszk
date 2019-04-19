
package cluedo.view;

import cluedo.logic.controller.GameController;
import cluedo.tools.languagestring.Language;
import cluedo.tools.languagestring.LanguageStrings;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

/**
 * This class is the main window of the application. From here you can start new
 * game and select number of players and language options.
 */
public class MainAppWindow extends AbstractBaseWindow {
    private GameController gameController;
    
    public MainAppWindow() {
        gameController=new GameController();
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jbNewGame = new javax.swing.JButton();
        jlLanguageChooser = new JLabel();
        jrbEnglish = new JRadioButton();
        jrbHungarian = new JRadioButton();
        jlPlayers = new JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(new java.awt.Dimension(1366, 770));
        JPanel jpBase = new JPanel();
        jpBase.setBackground(new java.awt.Color(255, 30, 21));
        jpBase.setForeground(new java.awt.Color(180, 0, 0));
        JLabel jlTitle = new JLabel();
        jlTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/title.JPG"))); // NOI18N
        jbNewGame.setBackground(new java.awt.Color(180, 0, 0));
        jbNewGame.setFont(new java.awt.Font(FONT_TYPE, 1, 18)); // NOI18N
        jbNewGame.setText(LanguageStrings.getString("Menu.NewGame"));
        jbNewGame.setEnabled(false);
        jbNewGame.addActionListener((java.awt.event.ActionEvent evt) -> {
            jbNewGameActionPerformed();
        });
        JLabel jlPicture = new JLabel();
        jlPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mystery.png"))); // NOI18N
        jlLanguageChooser.setFont(new java.awt.Font(FONT_TYPE, 1, 14)); // NOI18N
        jlLanguageChooser.setText(LanguageStrings.getString("Menu.Language"));
        jrbEnglish.setBackground(new java.awt.Color(255, 30, 21));
        ButtonGroup bgLanguage = new ButtonGroup();
        bgLanguage.add(jrbEnglish);
        jrbEnglish.setFont(new java.awt.Font(FONT_TYPE, 1, 12)); // NOI18N
        jrbEnglish.setText(LanguageStrings.getString("Menu.English"));
        jrbEnglish.setSelected(true);
        jrbEnglish.addActionListener((java.awt.event.ActionEvent evt) -> {
            jrbEnglishActionPerformed();
        });
        jrbHungarian.setBackground(new java.awt.Color(255, 30, 21));
        bgLanguage.add(jrbHungarian);
        jrbHungarian.setFont(new java.awt.Font(FONT_TYPE, 1, 12)); // NOI18N
        jrbHungarian.setText(LanguageStrings.getString("Menu.Hungarian"));
        jrbHungarian.addActionListener((java.awt.event.ActionEvent evt) -> {
            jrbHungarianActionPerformed();
        });
        jlPlayers.setFont(new java.awt.Font(FONT_TYPE, 1, 14)); // NOI18N
        jlPlayers.setText(LanguageStrings.getString("Menu.PlayerNumber"));
       JRadioButton jrbTwo = new JRadioButton();
       jrbTwo.setBackground(new java.awt.Color(255, 30, 21));
        ButtonGroup bgPlayers = new ButtonGroup();
        bgPlayers.add(jrbTwo);
        jrbTwo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jrbTwo.setText("2");
        jrbTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTwoActionPerformed();
            }
        });
        JRadioButton jrbThree = new JRadioButton();
        jrbThree.setBackground(new java.awt.Color(255, 30, 21));
        bgPlayers.add(jrbThree);
        jrbThree.setFont(new java.awt.Font(FONT_TYPE, 1, 12)); // NOI18N
        jrbThree.setText("3");
        jrbThree.addActionListener((java.awt.event.ActionEvent evt) -> {
            jrbThreeActionPerformed();
        });
        JRadioButton jrbFour = new JRadioButton();
        jrbFour.setBackground(new java.awt.Color(255, 30, 21));
        bgPlayers.add(jrbFour);
        jrbFour.setFont(new java.awt.Font(FONT_TYPE, 1, 12)); // NOI18N
        jrbFour.setText("4");
        jrbFour.addActionListener((java.awt.event.ActionEvent evt) -> {
            jrbFourActionPerformed();
        });
        JRadioButton jrbFive = new JRadioButton();
        jrbFive.setBackground(new java.awt.Color(255, 30, 21));
        bgPlayers.add(jrbFive);
        jrbFive.setFont(new java.awt.Font(FONT_TYPE, 1, 12)); // NOI18N
        jrbFive.setText("5");
        jrbFive.addActionListener((java.awt.event.ActionEvent evt) -> {
            jrbFiveActionPerformed();
        });
        JRadioButton jrbSix = new JRadioButton();
        jrbSix.setBackground(new java.awt.Color(255, 30, 21));
        bgPlayers.add(jrbSix);
        jrbSix.setFont(new java.awt.Font(FONT_TYPE, 1, 12)); // NOI18N
        jrbSix.setText("6");
        jrbSix.addActionListener((java.awt.event.ActionEvent evt) -> {
            jrbSixActionPerformed();
        });
        javax.swing.GroupLayout jpBaseLayout = new javax.swing.GroupLayout(jpBase);
        jpBase.setLayout(jpBaseLayout);
        jpBaseLayout.setHorizontalGroup(
            jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBaseLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlLanguageChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbEnglish)
                    .addComponent(jrbHungarian))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlTitle)
                .addGap(144, 144, 144)
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlPlayers)
                    .addComponent(jrbTwo)
                    .addComponent(jrbThree)
                    .addComponent(jrbFour)
                    .addComponent(jrbFive)
                    .addComponent(jrbSix))
                .addGap(183, 183, 183))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBaseLayout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBaseLayout.createSequentialGroup()
                        .addComponent(jbNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(480, 480, 480))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBaseLayout.createSequentialGroup()
                        .addComponent(jlPicture)
                        .addGap(69, 69, 69))))
        );
        jpBaseLayout.setVerticalGroup(
            jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBaseLayout.createSequentialGroup()
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBaseLayout.createSequentialGroup()
                        .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpBaseLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jlLanguageChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrbEnglish)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jrbHungarian))
                            .addGroup(jpBaseLayout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(jlPlayers)
                                .addGap(3, 3, 3)
                                .addComponent(jrbTwo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrbThree)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrbFour)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrbFive)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrbSix))
                    .addComponent(jlTitle, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jbNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlPicture)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    @Override
    protected void resetStringsOnWindow(){
        super.resetStringsOnWindow();
        jbNewGame.setText(LanguageStrings.getString("Menu.NewGame"));
        jlLanguageChooser.setText(LanguageStrings.getString("Menu.Language"));
        jrbEnglish.setText(LanguageStrings.getString("Menu.English"));
        jrbHungarian.setText(LanguageStrings.getString("Menu.Hungarian"));
        jlPlayers.setText(LanguageStrings.getString("Menu.PlayerNumber"));
    }
    private void jrbEnglishActionPerformed() {//GEN-FIRST:event_jrbEnglishActionPerformed
        LanguageStrings.changeLanguage(Language.ENG);
        resetStringsOnWindow();

    }//GEN-LAST:event_jrbEnglishActionPerformed

    private void jrbHungarianActionPerformed() {//GEN-FIRST:event_jrbHungarianActionPerformed
         LanguageStrings.changeLanguage(Language.HUN);
         resetStringsOnWindow();

         
    }//GEN-LAST:event_jrbHungarianActionPerformed

    private void jrbTwoActionPerformed() {//GEN-FIRST:event_jrbTwoActionPerformed
        gameController.setNumberOfPlayers(2);
        jbNewGame.setEnabled(true);
        //set players to 2
    }//GEN-LAST:event_jrbTwoActionPerformed

    private void jrbThreeActionPerformed() {//GEN-FIRST:event_jrbThreeActionPerformed
        gameController.setNumberOfPlayers(3);
        jbNewGame.setEnabled(true);
        //set players to 3
    }//GEN-LAST:event_jrbThreeActionPerformed

    private void jrbFourActionPerformed() {//GEN-FIRST:event_jrbFourActionPerformed
        gameController.setNumberOfPlayers(4);
        jbNewGame.setEnabled(true);
        //set players to 4
    }//GEN-LAST:event_jrbFourActionPerformed

    private void jrbFiveActionPerformed() {//GEN-FIRST:event_jrbFiveActionPerformed
        gameController.setNumberOfPlayers(5);
        jbNewGame.setEnabled(true);
        //set players to 5
    }//GEN-LAST:event_jrbFiveActionPerformed

    private void jrbSixActionPerformed() {//GEN-FIRST:event_jrbSixActionPerformed
        gameController.setNumberOfPlayers(6);
        jbNewGame.setEnabled(true);
        //set players to 6
    }//GEN-LAST:event_jrbSixActionPerformed

    private void jbNewGameActionPerformed() {//GEN-FIRST:event_jbNewGameActionPerformed
        int answer=showConfirmation(LanguageStrings.getString("JOptionPane.SettingsApproval"), null);
        if(answer==JOptionPane.YES_OPTION){
              SwingUtilities.invokeLater(() -> {
            RoleChooserWindow roleChooserWindow = new RoleChooserWindow(gameController);
            roleChooserWindow.setVisible(true);
            doUponExit();
        });
        }
    }//GEN-LAST:event_jbNewGameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    
    private javax.swing.JButton jbNewGame;
    private JLabel jlLanguageChooser;
    private JLabel jlPlayers;
    private JRadioButton jrbEnglish;
    private JRadioButton jrbHungarian;
    // End of variables declaration//GEN-END:variables
}
