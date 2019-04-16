
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
        jcHall=new JCheckBox();
        jcEatery=new JCheckBox();
        jcKitchen=new JCheckBox();
        jcTerrace=new JCheckBox();
        jcPlanetarium=new JCheckBox();
        jcCinema=new JCheckBox();
        jcLivingRoom=new JCheckBox();
        jcBath=new JCheckBox();
        jcGuestHouse=new JCheckBox();
        jlGuests = new javax.swing.JLabel();
        jlRooms = new javax.swing.JLabel();
        jlWeapons = new javax.swing.JLabel();
        JCheckBox jcWhite = new JCheckBox();
        jcKnife = new javax.swing.JCheckBox();
        jcCandlestick = new javax.swing.JCheckBox();
        jcRevolver = new javax.swing.JCheckBox();
        jcPoison = new javax.swing.JCheckBox();
        jcTrophy = new javax.swing.JCheckBox();
        jcRope = new javax.swing.JCheckBox();
        jcBat = new javax.swing.JCheckBox();
        jcAxe = new javax.swing.JCheckBox();
        jcDumbbell = new javax.swing.JCheckBox();

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
        customizeCheckBox(jcHall, LanguageStrings.getString("Cards.Rooms.Hall"));
        customizeCheckBox(jcEatery, LanguageStrings.getString("Cards.Rooms.Eatery"));
        customizeCheckBox(jcKitchen, LanguageStrings.getString("Cards.Rooms.Kitchen"));
        customizeCheckBox(jcTerrace, LanguageStrings.getString("Cards.Rooms.Terrace"));
        customizeCheckBox(jcPlanetarium, LanguageStrings.getString("Cards.Rooms.Planetarium"));
        customizeCheckBox(jcCinema, LanguageStrings.getString("Cards.Rooms.Cinema"));
        customizeCheckBox(jcLivingRoom, LanguageStrings.getString("Cards.Rooms.LivingRoom"));
        customizeCheckBox(jcBath, LanguageStrings.getString("Cards.Rooms.Bath"));
        customizeCheckBox(jcGuestHouse, LanguageStrings.getString("Cards.Rooms.GuestHouse"));
        
        customizeCheckBox(jcKnife, LanguageStrings.getString("Cards.Weapons.Knife"));

        customizeCheckBox(jcCandlestick, LanguageStrings.getString("Cards.Weapons.Candlestick"));

        customizeCheckBox(jcRevolver, LanguageStrings.getString("Cards.Weapons.Revolver"));

        customizeCheckBox(jcPoison, LanguageStrings.getString("Cards.Weapons.Poison"));

        customizeCheckBox(jcTrophy, LanguageStrings.getString("Cards.Weapons.Trophy"));

        customizeCheckBox(jcRope, LanguageStrings.getString("Cards.Weapons.Rope"));

        customizeCheckBox(jcBat, LanguageStrings.getString("Cards.Weapons.Bat"));

        customizeCheckBox(jcAxe, LanguageStrings.getString("Cards.Weapons.Axe"));

        customizeCheckBox(jcDumbbell, LanguageStrings.getString("Cards.Weapons.Dumbbell"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                    .addComponent(jcDumbbell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcAxe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcKnife, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcCandlestick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlWeapons)
                        .addGap(0, 37, Short.MAX_VALUE))
                    .addComponent(jcRevolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcPoison, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcTrophy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcRope, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcBat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcGuestHouse, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jcBath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcLivingRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlRooms)
                    .addComponent(jcHall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcEatery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcKitchen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcTerrace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcPlanetarium, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcCinema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(jcHall)
                            .addComponent(jcKnife))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcMustard)
                    .addComponent(jcEatery)
                    .addComponent(jcCandlestick))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcKitchen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcTerrace)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcPlanetarium)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcCinema)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcLivingRoom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcBath)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcGuestHouse))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jcPlum))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcRevolver)))
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
                                .addComponent(jcBat)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcAxe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcDumbbell)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JCheckBox jcHall;
    private JCheckBox jcEatery;
    private JCheckBox jcKitchen;
    private JCheckBox jcTerrace;
    private JCheckBox jcPlanetarium;
    private JCheckBox jcCinema;
    private JCheckBox jcLivingRoom;
    private JCheckBox jcBath;
    private JCheckBox jcGuestHouse;
    private javax.swing.JCheckBox jcAxe;
    private javax.swing.JCheckBox jcCandlestick;
    private javax.swing.JCheckBox jcRevolver;
    private javax.swing.JCheckBox jcBat;
    private javax.swing.JCheckBox jcKnife;
    private javax.swing.JCheckBox jcPoison;
    private javax.swing.JCheckBox jcRope;
    private javax.swing.JCheckBox jcTrophy;
    private javax.swing.JCheckBox jcDumbbell;
    private javax.swing.JLabel jlGuests;
    private javax.swing.JLabel jlRooms;
    private javax.swing.JLabel jlWeapons;
    // End of variables declaration//GEN-END:variables

   public void resetStrings() {
        jlGuests.setText(LanguageStrings.getString("GameBoard.Guests"));
        jlRooms.setText(LanguageStrings.getString("GameBoard.Rooms"));
        jlWeapons.setText(LanguageStrings.getString("GameBoard.Weapons"));
        jcKnife.setText(LanguageStrings.getString("Cards.Weapons.Knife"));
        jcCandlestick.setText(LanguageStrings.getString("Cards.Weapons.Candlestick"));
        jcRevolver.setText(LanguageStrings.getString("Cards.Weapons.Revolver"));
        jcPoison.setText(LanguageStrings.getString("Cards.Weapons.Poison"));
        jcTrophy.setText(LanguageStrings.getString("Cards.Weapons.Trophy"));
        jcRope.setText(LanguageStrings.getString("Cards.Weapons.Rope"));
        jcBat.setText(LanguageStrings.getString("Cards.Weapons.Bat"));
        jcAxe.setText(LanguageStrings.getString("Cards.Weapons.Axe"));
        jcDumbbell.setText(LanguageStrings.getString("Cards.Weapons.Dumbbell"));
        jcHall.setText(LanguageStrings.getString("Cards.Rooms.Hall"));
        jcEatery.setText(LanguageStrings.getString("Cards.Rooms.Eatery"));
        jcKitchen.setText(LanguageStrings.getString("Cards.Rooms.Kitchen"));
        jcTerrace.setText(LanguageStrings.getString("Cards.Rooms.Terrace"));
        jcPlanetarium.setText(LanguageStrings.getString("Cards.Rooms.Planetarium"));
        jcCinema.setText(LanguageStrings.getString("Cards.Rooms.Cinema"));
        jcLivingRoom.setText(LanguageStrings.getString("Cards.Rooms.LivingRoom"));
        jcBath.setText(LanguageStrings.getString("Cards.Rooms.Bath"));
        jcGuestHouse.setText(LanguageStrings.getString("Cards.Rooms.GuestHouse"));
    }
}
