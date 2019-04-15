
package cluedo.view.board;

import cluedo.tools.languagestring.LanguageStrings;
import javax.swing.JCheckBox;

/**
 * This class represents the clue paper for the game. On it the players can mark
 * the clues which are known by them.
 */
public class CluePaperPanel extends javax.swing.JPanel {

    private static final String FONT_TYPE="Times New Roman";
    public CluePaperPanel() {
        initComponents();
    }
private void customizeCheckBox(JCheckBox checkBox, String title){
    checkBox.setBackground(new java.awt.Color(255, 255, 255));

    checkBox.setFont(new java.awt.Font(FONT_TYPE, 0, 12)); // NOI18N

    checkBox.setText(title);
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlGuests = new javax.swing.JLabel();
        jlRooms = new javax.swing.JLabel();
        jlWeapons = new javax.swing.JLabel();
        JCheckBox jcWhite = new JCheckBox();
        jcKnife = new javax.swing.JCheckBox();
        jcCandleHolder = new javax.swing.JCheckBox();
        jcGun = new javax.swing.JCheckBox();
        jcPoison = new javax.swing.JCheckBox();
        jcTrophy = new javax.swing.JCheckBox();
        jcRope = new javax.swing.JCheckBox();
        jcHammer = new javax.swing.JCheckBox();
        jcAxe = new javax.swing.JCheckBox();
        jcWeight = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(403, 259));

        jlGuests.setFont(new java.awt.Font(FONT_TYPE, 1, 14)); // NOI18N
        jlGuests.setText(LanguageStrings.getString("GameBoard.Guests"));

        jlRooms.setFont(new java.awt.Font(FONT_TYPE, 1, 14)); // NOI18N
        jlRooms.setText(LanguageStrings.getString("GameBoard.Rooms"));

        jlWeapons.setFont(new java.awt.Font(FONT_TYPE, 1, 14)); // NOI18N
        jlWeapons.setText(LanguageStrings.getString("GameBoard.Weapons"));
        JCheckBox jcMustard = new JCheckBox();
        customizeCheckBox(jcMustard, "Mustard");
        JCheckBox jcPlum = new JCheckBox();
        customizeCheckBox(jcPlum, "Plum");
        JCheckBox jcGreen = new JCheckBox();
        customizeCheckBox(jcGreen, "Green");
        JCheckBox jcPeacock = new JCheckBox();
        customizeCheckBox(jcPeacock, "Peacock");
        JCheckBox jcScarlet = new JCheckBox();
        customizeCheckBox(jcScarlet, "Scarlet");

        customizeCheckBox(jcWhite, "White");
        JCheckBox jcRoom1 = new JCheckBox();
        customizeCheckBox(jcRoom1, "Room1");
        JCheckBox jcRoom2 = new JCheckBox();
        customizeCheckBox(jcRoom2, "Room2");
        JCheckBox jcRoom3 = new JCheckBox();
        customizeCheckBox(jcRoom3, "Room3");
        JCheckBox jcRoom4 = new JCheckBox();
        customizeCheckBox(jcRoom4, "Room4");
        JCheckBox jcRoom5 = new JCheckBox();
        customizeCheckBox(jcRoom5, "Room5");
        JCheckBox jcRoom6 = new JCheckBox();
        customizeCheckBox(jcRoom6, "Room6");
        JCheckBox jcRoom7 = new JCheckBox();
        customizeCheckBox(jcRoom7, "Room7");
        JCheckBox jcRoom8 = new JCheckBox();
        customizeCheckBox(jcRoom8, "Room8");
        JCheckBox jcRoom9 = new JCheckBox();
        customizeCheckBox(jcRoom9, "Room9");

        customizeCheckBox(jcKnife, LanguageStrings.getString("GameBoard.Knife"));

        customizeCheckBox(jcCandleHolder, LanguageStrings.getString("GameBoard.CandleHolder"));

        customizeCheckBox(jcGun, LanguageStrings.getString("GameBoard.Gun"));

        customizeCheckBox(jcPoison, LanguageStrings.getString("GameBoard.Poison"));

        customizeCheckBox(jcTrophy, LanguageStrings.getString("GameBoard.Trophy"));

        customizeCheckBox(jcRope, LanguageStrings.getString("GameBoard.Rope"));

        customizeCheckBox(jcHammer, LanguageStrings.getString("GameBoard.Racket"));

        customizeCheckBox(jcAxe, LanguageStrings.getString("GameBoard.Axe"));

        customizeCheckBox(jcWeight, LanguageStrings.getString("GameBoard.Weight"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jcWhite, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jcScarlet, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jcPlum, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                .addComponent(jcGreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jcPeacock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jlGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcMustard, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcWeight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcAxe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcKnife, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcCandleHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlWeapons)
                        .addGap(0, 37, Short.MAX_VALUE))
                    .addComponent(jcGun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcPoison, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcTrophy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcRope, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcHammer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcRoom9, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jcRoom8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcRoom7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlRooms)
                    .addComponent(jcRoom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcRoom2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcRoom3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcRoom4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcRoom5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcRoom6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jlGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlRooms, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlWeapons))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jcRoom1)
                            .addComponent(jcKnife))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcMustard)
                    .addComponent(jcRoom2)
                    .addComponent(jcCandleHolder))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcRoom3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcRoom4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcRoom5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcRoom6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcRoom7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcRoom8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcRoom9))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jcPlum))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcGun)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jcGreen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcPeacock)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcScarlet)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcWhite))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jcPoison)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcTrophy)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcRope)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcHammer)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcAxe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcWeight)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jcAxe;
    private javax.swing.JCheckBox jcCandleHolder;
    private javax.swing.JCheckBox jcGun;
    private javax.swing.JCheckBox jcHammer;
    private javax.swing.JCheckBox jcKnife;
    private javax.swing.JCheckBox jcPoison;
    private javax.swing.JCheckBox jcRope;
    private javax.swing.JCheckBox jcTrophy;
    private javax.swing.JCheckBox jcWeight;
    private javax.swing.JLabel jlGuests;
    private javax.swing.JLabel jlRooms;
    private javax.swing.JLabel jlWeapons;
    // End of variables declaration//GEN-END:variables

   public void resetStrings() {
        jlGuests.setText(LanguageStrings.getString("GameBoard.Guests"));
        jlRooms.setText(LanguageStrings.getString("GameBoard.Rooms"));
        jlWeapons.setText(LanguageStrings.getString("GameBoard.Weapons"));
        jcKnife.setText(LanguageStrings.getString("GameBoard.Knife"));
        jcCandleHolder.setText(LanguageStrings.getString("GameBoard.CandleHolder"));
        jcGun.setText(LanguageStrings.getString("GameBoard.Gun"));
        jcPoison.setText(LanguageStrings.getString("GameBoard.Poison"));
        jcTrophy.setText(LanguageStrings.getString("GameBoard.Trophy"));
        jcRope.setText(LanguageStrings.getString("GameBoard.Rope"));
        jcHammer.setText(LanguageStrings.getString("GameBoard.Racket"));
        jcAxe.setText(LanguageStrings.getString("GameBoard.Axe"));
        jcWeight.setText(LanguageStrings.getString("GameBoard.Weight"));
    }
}
