
package cluedo.view;

import cluedo.Tools.LanguageString.Language;
import cluedo.Tools.LanguageString.LanguageStrings;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * This class is the main window of the application. From here you can start new
 * game and select number of players and language options.
 * @author bornemis
 */
public class MainAppWindow extends AbstractBaseWindow {

    /**
     * Creates new form Trial
     */
    public MainAppWindow() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgLanguage = new javax.swing.ButtonGroup();
        bgPlayers = new javax.swing.ButtonGroup();
        jpBase = new javax.swing.JPanel();
        jlTitle = new javax.swing.JLabel();
        jbNewGame = new javax.swing.JButton();
        jlPicture = new javax.swing.JLabel();
        jlLanguageChooser = new javax.swing.JLabel();
        jrbEnglish = new javax.swing.JRadioButton();
        jrbHungarian = new javax.swing.JRadioButton();
        jlPlayers = new javax.swing.JLabel();
        jrbTwo = new javax.swing.JRadioButton();
        jrbThree = new javax.swing.JRadioButton();
        jrbFour = new javax.swing.JRadioButton();
        jrbFive = new javax.swing.JRadioButton();
        jrbSix = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(new java.awt.Dimension(1366, 770));

        jpBase.setBackground(new java.awt.Color(255, 30, 21));
        jpBase.setForeground(new java.awt.Color(180, 0, 0));

        jlTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/title.JPG"))); // NOI18N

        jbNewGame.setBackground(new java.awt.Color(180, 0, 0));
        jbNewGame.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jbNewGame.setText(LanguageStrings.getString("Menu.NewGame"));
        jbNewGame.setEnabled(false);
        jbNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNewGameActionPerformed(evt);
            }
        });

        jlPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mystery.png"))); // NOI18N

        jlLanguageChooser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlLanguageChooser.setText(LanguageStrings.getString("Menu.Language"));

        jrbEnglish.setBackground(new java.awt.Color(255, 30, 21));
        bgLanguage.add(jrbEnglish);
        jrbEnglish.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jrbEnglish.setText(LanguageStrings.getString("Menu.English"));
        jrbEnglish.setSelected(true);
        jrbEnglish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbEnglishActionPerformed(evt);
            }
        });

        jrbHungarian.setBackground(new java.awt.Color(255, 30, 21));
        bgLanguage.add(jrbHungarian);
        jrbHungarian.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jrbHungarian.setText(LanguageStrings.getString("Menu.Hungarian"));
        jrbHungarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbHungarianActionPerformed(evt);
            }
        });

        jlPlayers.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlPlayers.setText(LanguageStrings.getString("Menu.PlayerNumber"));

        jrbTwo.setBackground(new java.awt.Color(255, 30, 21));
        bgPlayers.add(jrbTwo);
        jrbTwo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jrbTwo.setText("2");
        jrbTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTwoActionPerformed(evt);
            }
        });

        jrbThree.setBackground(new java.awt.Color(255, 30, 21));
        bgPlayers.add(jrbThree);
        jrbThree.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jrbThree.setText("3");
        jrbThree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbThreeActionPerformed(evt);
            }
        });

        jrbFour.setBackground(new java.awt.Color(255, 30, 21));
        bgPlayers.add(jrbFour);
        jrbFour.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jrbFour.setText("4");
        jrbFour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbFourActionPerformed(evt);
            }
        });

        jrbFive.setBackground(new java.awt.Color(255, 30, 21));
        bgPlayers.add(jrbFive);
        jrbFive.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jrbFive.setText("5");
        jrbFive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbFiveActionPerformed(evt);
            }
        });

        jrbSix.setBackground(new java.awt.Color(255, 30, 21));
        bgPlayers.add(jrbSix);
        jrbSix.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jrbSix.setText("6");
        jrbSix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbSixActionPerformed(evt);
            }
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
    private void jrbEnglishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbEnglishActionPerformed
        LanguageStrings.changeLanguage(Language.ENG);
        resetStringsOnWindow();

    }//GEN-LAST:event_jrbEnglishActionPerformed

    private void jrbHungarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbHungarianActionPerformed
         LanguageStrings.changeLanguage(Language.HUN);
         resetStringsOnWindow();

         
    }//GEN-LAST:event_jrbHungarianActionPerformed

    private void jrbTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTwoActionPerformed
        jbNewGame.setEnabled(true);
        //set players to 2
    }//GEN-LAST:event_jrbTwoActionPerformed

    private void jrbThreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbThreeActionPerformed
        jbNewGame.setEnabled(true);
        //set players to 3
    }//GEN-LAST:event_jrbThreeActionPerformed

    private void jrbFourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbFourActionPerformed
        jbNewGame.setEnabled(true);
        //set players to 4
    }//GEN-LAST:event_jrbFourActionPerformed

    private void jrbFiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbFiveActionPerformed
        jbNewGame.setEnabled(true);
        //set players to 5
    }//GEN-LAST:event_jrbFiveActionPerformed

    private void jrbSixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbSixActionPerformed
        jbNewGame.setEnabled(true);
        //set players to 6
    }//GEN-LAST:event_jrbSixActionPerformed

    private void jbNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNewGameActionPerformed
        int answer=showConfirmation(LanguageStrings.getString("JOptionPane.SettingsApproval"), null); //TODO: write settings here
        if(answer==JOptionPane.YES_OPTION){
              SwingUtilities.invokeLater(() -> {
   

            RoleChooserWindow roleChooserWindow = new RoleChooserWindow();
            roleChooserWindow.setVisible(true);
            doUponExit();
        });
        }
    }//GEN-LAST:event_jbNewGameActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgLanguage;
    private javax.swing.ButtonGroup bgPlayers;
    private javax.swing.JButton jbNewGame;
    private javax.swing.JLabel jlLanguageChooser;
    private javax.swing.JLabel jlPicture;
    private javax.swing.JLabel jlPlayers;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JPanel jpBase;
    private javax.swing.JRadioButton jrbEnglish;
    private javax.swing.JRadioButton jrbFive;
    private javax.swing.JRadioButton jrbFour;
    private javax.swing.JRadioButton jrbHungarian;
    private javax.swing.JRadioButton jrbSix;
    private javax.swing.JRadioButton jrbThree;
    private javax.swing.JRadioButton jrbTwo;
    // End of variables declaration//GEN-END:variables
}
