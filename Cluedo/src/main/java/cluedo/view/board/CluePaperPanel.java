
package cluedo.view.board;

import cluedo.logic.cards.Card;
import cluedo.tools.languagestring.LanguageStrings;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JCheckBox;

/**
 * This class represents the clue paper for the game. On it the players can mark
 * the clues which are known by them.
 */
public class CluePaperPanel extends javax.swing.JPanel {
    private Map<String, JCheckBox> checkBoxMap;
    private final String fontType="Times New Roman";
    private final String knifeKey="Cards.Weapons.Knife";
    private final String candleStickKey="Cards.Weapons.Candlestick";
    private final String revolverKey="Cards.Weapons.Revolver";
    private final String poisonKey="Cards.Weapons.Poison";
    private final String trophyKey="Cards.Weapons.Trophy";
    private final String ropeKey="Cards.Weapons.Rope";
    private final String batKey="Cards.Weapons.Bat";
    private final String axeKey="Cards.Weapons.Axe";
    private final String dumbbellKey="Cards.Weapons.Dumbbell";
    private final String hallKey="Cards.Rooms.Hall";
    private final String eateryKey="Cards.Rooms.Eatery";
    private final String kitchenKey="Cards.Rooms.Kitchen";
    private final String terraceKey="Cards.Rooms.Terrace";
    private final String planetariumKey="Cards.Rooms.Planetarium";
    private final String cinemaKey="Cards.Rooms.Cinema";
    private final String livingRoomKey="Cards.Rooms.LivingRoom";
    private final String bathKey="Cards.Rooms.Bath";
    private final String guestHouseKey="Cards.Rooms.GuestHouse";
    public CluePaperPanel() {
        initComponents();
        fillUpCheckBoxMap();
    }
private void customizeCheckBox(JCheckBox checkBox, String title){
    checkBox.setBackground(new java.awt.Color(255, 255, 255));

    checkBox.setFont(new java.awt.Font(fontType, 0, 12)); // NOI18N

    checkBox.setText(title);
}

private void fillUpCheckBoxMap(){
    checkBoxMap=new HashMap<>();
    checkBoxMap.put(knifeKey, jcKnife);
    checkBoxMap.put(candleStickKey, jcCandlestick);
    checkBoxMap.put(revolverKey, jcRevolver);
    checkBoxMap.put(poisonKey, jcPoison);
    checkBoxMap.put(trophyKey, jcTrophy);
    checkBoxMap.put(ropeKey, jcRope);
    checkBoxMap.put(batKey, jcBat);
    checkBoxMap.put(axeKey, jcAxe);
    checkBoxMap.put(dumbbellKey, jcDumbbell);
    checkBoxMap.put(hallKey, jcHall);
    checkBoxMap.put(eateryKey, jcEatery);
    checkBoxMap.put(kitchenKey, jcKitchen);
    checkBoxMap.put(terraceKey, jcTerrace);
    checkBoxMap.put(planetariumKey, jcPlanetarium);
    checkBoxMap.put(cinemaKey, jcCinema);
    checkBoxMap.put(livingRoomKey, jcLivingRoom);
    checkBoxMap.put(bathKey, jcBath);
    checkBoxMap.put(guestHouseKey, jcGuestHouse);
    checkBoxMap.put("Cards.Persons.Mustard", jcMustard);
    checkBoxMap.put("Cards.Persons.Peacock", jcPeacock);
    checkBoxMap.put("Cards.Persons.Scarlet", jcScarlet);
    checkBoxMap.put("Cards.Persons.Green", jcGreen);
    checkBoxMap.put("Cards.Persons.White", jcWhite);
    checkBoxMap.put("Cards.Persons.Plum", jcPlum);
    
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
        jcWhite = new JCheckBox();
        jcKnife = new JCheckBox();
        jcCandlestick = new JCheckBox();
        jcRevolver = new JCheckBox();
        jcPoison = new JCheckBox();
        jcTrophy = new JCheckBox();
        jcRope = new JCheckBox();
        jcBat = new JCheckBox();
        jcAxe = new JCheckBox();
        jcDumbbell = new JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(403, 259));

        jlGuests.setFont(new java.awt.Font(fontType, 1, 14)); // NOI18N
        jlGuests.setText(LanguageStrings.getString("GameBoard.Guests"));

        jlRooms.setFont(new java.awt.Font(fontType, 1, 14)); // NOI18N
        jlRooms.setText(LanguageStrings.getString("GameBoard.Rooms"));

        jlWeapons.setFont(new java.awt.Font(fontType, 1, 14)); // NOI18N
        jlWeapons.setText(LanguageStrings.getString("GameBoard.Weapons"));
        jcMustard = new JCheckBox();
        customizeCheckBox(jcMustard, "Mustard");
        jcPlum = new JCheckBox();
        customizeCheckBox(jcPlum, "Plum");
        jcGreen = new JCheckBox();
        customizeCheckBox(jcGreen, "Green");
        jcPeacock = new JCheckBox();
        customizeCheckBox(jcPeacock, "Peacock");
        jcScarlet = new JCheckBox();
        customizeCheckBox(jcScarlet, "Scarlet");

        customizeCheckBox(jcWhite, "White");
        customizeCheckBox(jcHall, LanguageStrings.getString(hallKey));
        customizeCheckBox(jcEatery, LanguageStrings.getString(eateryKey));
        customizeCheckBox(jcKitchen, LanguageStrings.getString(kitchenKey));
        customizeCheckBox(jcTerrace, LanguageStrings.getString(terraceKey));
        customizeCheckBox(jcPlanetarium, LanguageStrings.getString(planetariumKey));
        customizeCheckBox(jcCinema, LanguageStrings.getString(cinemaKey));
        customizeCheckBox(jcLivingRoom, LanguageStrings.getString(livingRoomKey));
        customizeCheckBox(jcBath, LanguageStrings.getString(bathKey));
        customizeCheckBox(jcGuestHouse, LanguageStrings.getString(guestHouseKey));
        
        customizeCheckBox(jcKnife, LanguageStrings.getString(knifeKey));

        customizeCheckBox(jcCandlestick, LanguageStrings.getString(candleStickKey));

        customizeCheckBox(jcRevolver, LanguageStrings.getString(revolverKey));

        customizeCheckBox(jcPoison, LanguageStrings.getString(poisonKey));

        customizeCheckBox(jcTrophy, LanguageStrings.getString(trophyKey));

        customizeCheckBox(jcRope, LanguageStrings.getString(ropeKey));

        customizeCheckBox(jcBat, LanguageStrings.getString(batKey));

        customizeCheckBox(jcAxe, LanguageStrings.getString(axeKey));

        customizeCheckBox(jcDumbbell, LanguageStrings.getString(dumbbellKey));

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
    private JCheckBox jcAxe;
    private JCheckBox jcCandlestick;
    private JCheckBox jcRevolver;
    private JCheckBox jcBat;
    private JCheckBox jcKnife;
    private JCheckBox jcPoison;
    private JCheckBox jcRope;
    private JCheckBox jcTrophy;
    private JCheckBox jcDumbbell;
    private javax.swing.JLabel jlGuests;
    private javax.swing.JLabel jlRooms;
    private javax.swing.JLabel jlWeapons;
    private JCheckBox jcWhite;
    private JCheckBox jcMustard;
    private JCheckBox jcPlum;
    private JCheckBox jcPeacock;
    private JCheckBox jcScarlet;
    private JCheckBox jcGreen;
    // End of variables declaration//GEN-END:variables

   public void resetStrings() {
        jlGuests.setText(LanguageStrings.getString("GameBoard.Guests"));
        jlRooms.setText(LanguageStrings.getString("GameBoard.Rooms"));
        jlWeapons.setText(LanguageStrings.getString("GameBoard.Weapons"));
        jcKnife.setText(LanguageStrings.getString(knifeKey));
        jcCandlestick.setText(LanguageStrings.getString(candleStickKey));
        jcRevolver.setText(LanguageStrings.getString(revolverKey));
        jcPoison.setText(LanguageStrings.getString(poisonKey));
        jcTrophy.setText(LanguageStrings.getString(trophyKey));
        jcRope.setText(LanguageStrings.getString(ropeKey));
        jcBat.setText(LanguageStrings.getString(batKey));
        jcAxe.setText(LanguageStrings.getString(axeKey));
        jcDumbbell.setText(LanguageStrings.getString(dumbbellKey));
        jcHall.setText(LanguageStrings.getString(hallKey));
        jcEatery.setText(LanguageStrings.getString(eateryKey));
        jcKitchen.setText(LanguageStrings.getString(kitchenKey));
        jcTerrace.setText(LanguageStrings.getString(terraceKey));
        jcPlanetarium.setText(LanguageStrings.getString(planetariumKey));
        jcCinema.setText(LanguageStrings.getString(cinemaKey));
        jcLivingRoom.setText(LanguageStrings.getString(livingRoomKey));
        jcBath.setText(LanguageStrings.getString(bathKey));
        jcGuestHouse.setText(LanguageStrings.getString(guestHouseKey));
    }

    public void markOwnedSuspectCards(List<Card> suspectCards) {
        for(Card c:suspectCards){
            JCheckBox checkBox=checkBoxMap.get(c.getUiStringKey());
            checkBox.setSelected(true);
            checkBox.setEnabled(false);
            
        }
    }
}