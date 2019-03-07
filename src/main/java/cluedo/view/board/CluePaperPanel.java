/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.view.board;

import javax.swing.JCheckBox;

/**
 *
 * @author Barby
 */
public class CluePaperPanel extends javax.swing.JPanel {

    /**
     * Creates new form CluePaperPanel
     */
    public CluePaperPanel() {
        initComponents();
    }
private void customizeCheckBox(JCheckBox checkBox, String title){
    checkBox.setBackground(new java.awt.Color(255, 255, 255));

    checkBox.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

    checkBox.setText(title);
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlGuests = new javax.swing.JLabel();
        jlRooms = new javax.swing.JLabel();
        jlWeapons = new javax.swing.JLabel();
        jcMustard = new javax.swing.JCheckBox();
        jcPlum = new javax.swing.JCheckBox();
        jcGreen = new javax.swing.JCheckBox();
        jcPeacock = new javax.swing.JCheckBox();
        jcScarlet = new javax.swing.JCheckBox();
        jcWhite = new javax.swing.JCheckBox();
        jcRoom1 = new javax.swing.JCheckBox();
        jcRoom2 = new javax.swing.JCheckBox();
        jcRoom3 = new javax.swing.JCheckBox();
        jcRoom4 = new javax.swing.JCheckBox();
        jcRoom5 = new javax.swing.JCheckBox();
        jcRoom6 = new javax.swing.JCheckBox();
        jcRoom7 = new javax.swing.JCheckBox();
        jcRoom8 = new javax.swing.JCheckBox();
        jcRoom9 = new javax.swing.JCheckBox();
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

        jlGuests.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlGuests.setText("Vendégek");

        jlRooms.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlRooms.setText("Helyiségek");

        jlWeapons.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlWeapons.setText("Fegyverek");

        customizeCheckBox(jcMustard, "Mustard");

        customizeCheckBox(jcPlum, "Plum");

        customizeCheckBox(jcGreen, "Green");

        customizeCheckBox(jcPeacock, "Peacock");

        customizeCheckBox(jcScarlet, "Scarlet");

        customizeCheckBox(jcWhite, "White");

        customizeCheckBox(jcRoom1, "Room1");

        customizeCheckBox(jcRoom2, "Room2");

        customizeCheckBox(jcRoom3, "Room3");

        customizeCheckBox(jcRoom4, "Room4");

        customizeCheckBox(jcRoom5, "Room5");

        customizeCheckBox(jcRoom6, "Room6");

        customizeCheckBox(jcRoom7, "Room7");

        customizeCheckBox(jcRoom8, "Room8");

        customizeCheckBox(jcRoom9, "Room9");

        customizeCheckBox(jcKnife, "Kés");

        customizeCheckBox(jcCandleHolder, "Gyertyatartó");

        customizeCheckBox(jcGun, "Pisztoly");

        customizeCheckBox(jcPoison, "Méreg");

        customizeCheckBox(jcTrophy, "Trófea");

        customizeCheckBox(jcRope, "Kötél");

        customizeCheckBox(jcHammer, "Ütő");

        customizeCheckBox(jcAxe, "Balta");

        customizeCheckBox(jcWeight, "Súlyzó");

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
    private javax.swing.JCheckBox jcGreen;
    private javax.swing.JCheckBox jcGun;
    private javax.swing.JCheckBox jcHammer;
    private javax.swing.JCheckBox jcKnife;
    private javax.swing.JCheckBox jcMustard;
    private javax.swing.JCheckBox jcPeacock;
    private javax.swing.JCheckBox jcPlum;
    private javax.swing.JCheckBox jcPoison;
    private javax.swing.JCheckBox jcRoom1;
    private javax.swing.JCheckBox jcRoom2;
    private javax.swing.JCheckBox jcRoom3;
    private javax.swing.JCheckBox jcRoom4;
    private javax.swing.JCheckBox jcRoom5;
    private javax.swing.JCheckBox jcRoom6;
    private javax.swing.JCheckBox jcRoom7;
    private javax.swing.JCheckBox jcRoom8;
    private javax.swing.JCheckBox jcRoom9;
    private javax.swing.JCheckBox jcRope;
    private javax.swing.JCheckBox jcScarlet;
    private javax.swing.JCheckBox jcTrophy;
    private javax.swing.JCheckBox jcWeight;
    private javax.swing.JCheckBox jcWhite;
    private javax.swing.JLabel jlGuests;
    private javax.swing.JLabel jlRooms;
    private javax.swing.JLabel jlWeapons;
    // End of variables declaration//GEN-END:variables
}
