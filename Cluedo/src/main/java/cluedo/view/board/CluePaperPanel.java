
package cluedo.view.board;

import cluedo.logic.cards.Card;
import cluedo.logic.player.Player;
import static cluedo.tools.Tools.LOG;
import cluedo.tools.languagestring.LanguageStrings;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

/**
 * This class represents the clue paper for the game. On it the players can mark
 * the clues which are known by them.
 */
public class CluePaperPanel extends javax.swing.JPanel {
    private Map<String, JCheckBox> checkBoxMap;
    private static final String FONT_TYPE="Times New Roman";
    public static final String KNIFE_KEY="Cards.Weapons.Knife";
    public static final String CANDLESTICK_KEY="Cards.Weapons.Candlestick";
    public static final String REVOLVER_KEY="Cards.Weapons.Revolver";
    public static final String POISON_KEY="Cards.Weapons.Poison";
    public static final String TROPHY_KEY="Cards.Weapons.Trophy";
    public static final String ROPE_KEY="Cards.Weapons.Rope";
    public static final String BAT_KEY="Cards.Weapons.Bat";
    public static final String AXE_KEY="Cards.Weapons.Axe";
    public static final String DUMBBELL_KEY="Cards.Weapons.Dumbbell";
    public static final String HALL_KEY="Cards.Rooms.Hall";
    public static final String EATERY_KEY="Cards.Rooms.Eatery";
    public static final String KITCHEN_KEY="Cards.Rooms.Kitchen";
    public static final String TERRACE_KEY="Cards.Rooms.Terrace";
    public static final String PLANETARIUM_KEY="Cards.Rooms.Planetarium";
    public static final String CINEMA_KEY="Cards.Rooms.Cinema";
    public static final String LIVINGROOM_KEY="Cards.Rooms.LivingRoom";
    public static final String BATH_KEY="Cards.Rooms.Bath";
    public static final String GUESTHOUSE_KEY="Cards.Rooms.GuestHouse";
    private final boolean suspect;
    private JRadioButton jrbWhite;
    private JRadioButton jrbKnife;
    private JRadioButton jrbCandlestick;
    private JRadioButton jrbRevolver;
    private JRadioButton jrbPoison;
    private JRadioButton jrbTrophy;
    private JRadioButton jrbRope;
    private JRadioButton jrbBat;
    private JRadioButton jrbAxe;
    private JRadioButton jrbDumbbell;
    private JRadioButton jrbMustard;
    private JRadioButton jrbPlum;
    private JRadioButton jrbGreen;
    private JRadioButton jrbPeacock;
    private JRadioButton jrbScarlet;
    private List<String> weaponKeys;
    private List<String> guestKeys;
    private String selectedGuestKey;
    private String selectedWeaponKey;
    public CluePaperPanel(boolean suspect) {
        this.suspect=suspect;
        fillUpWeaponKeys();
        filUpGuestKeys();
        initComponents();
        if(!suspect){
        fillUpCheckBoxMap();
        }
        selectedGuestKey="";
        selectedWeaponKey="";
    }
    private void filUpGuestKeys(){
        guestKeys=new ArrayList<>();
        guestKeys.add("Mustard");
        guestKeys.add("Peacock");
        guestKeys.add("Scarlet");
        guestKeys.add("Green");
        guestKeys.add("White");
        guestKeys.add("Plum");
    }
    private void fillUpWeaponKeys(){
        weaponKeys=new ArrayList<>();
        weaponKeys.add(CANDLESTICK_KEY);
        weaponKeys.add(KNIFE_KEY);
        weaponKeys.add(REVOLVER_KEY);
        weaponKeys.add(POISON_KEY);
        weaponKeys.add(ROPE_KEY);
        weaponKeys.add(TROPHY_KEY);
        weaponKeys.add(BAT_KEY);
        weaponKeys.add(AXE_KEY);
        weaponKeys.add(DUMBBELL_KEY);
    }
private void customizeCheckBox(JCheckBox checkBox, String title){
    checkBox.setBackground(new java.awt.Color(255, 255, 255));

    checkBox.setFont(new java.awt.Font(FONT_TYPE, 0, 12)); // NOI18N

    checkBox.setText(title);
}
private void customizeRadioButton(JRadioButton radioButton, String title){
    radioButton.setBackground(new java.awt.Color(180, 0, 0));
    radioButton.setFont(new java.awt.Font(FONT_TYPE, 0, 12)); // NOI18N
    radioButton.setText(title);
    radioButton.addActionListener((ActionEvent evt) -> {
            suspectButtonActionPerformed(evt);
        });
}
private int findTextOfButton(String text, List<String> list){
    int i=0;
    boolean found=false;
    while(i<list.size() && !found){
        String value=LanguageStrings.getString(list.get(i));
        if(value==null){
            value=text;
        }
        found=value.equals(list.get(i));
            i+=1;
    }
    int foundIndex=-1;
    if(found){
        foundIndex=i-1;
    }
    return foundIndex;
}
private void suspectButtonActionPerformed(ActionEvent evt){
    JRadioButton button=(JRadioButton)evt.getSource();
    String text=button.getText();
    int i=findTextOfButton(text, weaponKeys);
    if(i==-1){
        i=findTextOfButton(text, guestKeys);
        selectedGuestKey=guestKeys.get(i);
        LOG.log(Level.INFO, "Selected guest to suspect: "+selectedGuestKey);
    }else{
        selectedWeaponKey=weaponKeys.get(i);
        LOG.log(Level.INFO, "Selected weapon to suspect: "+selectedWeaponKey);
    }
    
}
private void fillUpCheckBoxMap(){
    checkBoxMap=new HashMap<>();
    checkBoxMap.put(KNIFE_KEY, jcKnife);
    checkBoxMap.put(CANDLESTICK_KEY, jcCandlestick);
    checkBoxMap.put(REVOLVER_KEY, jcRevolver);
    checkBoxMap.put(POISON_KEY, jcPoison);
    checkBoxMap.put(TROPHY_KEY, jcTrophy);
    checkBoxMap.put(ROPE_KEY, jcRope);
    checkBoxMap.put(BAT_KEY, jcBat);
    checkBoxMap.put(AXE_KEY, jcAxe);
    checkBoxMap.put(DUMBBELL_KEY, jcDumbbell);
    checkBoxMap.put(HALL_KEY, jcHall);
    checkBoxMap.put(EATERY_KEY, jcEatery);
    checkBoxMap.put(KITCHEN_KEY, jcKitchen);
    checkBoxMap.put(TERRACE_KEY, jcTerrace);
    checkBoxMap.put(PLANETARIUM_KEY, jcPlanetarium);
    checkBoxMap.put(CINEMA_KEY, jcCinema);
    checkBoxMap.put(LIVINGROOM_KEY, jcLivingRoom);
    checkBoxMap.put(BATH_KEY, jcBath);
    checkBoxMap.put(GUESTHOUSE_KEY, jcGuestHouse);
    checkBoxMap.put("Cards.Persons.Mustard", jcMustard);
    checkBoxMap.put("Cards.Persons.Peacock", jcPeacock);
    checkBoxMap.put("Cards.Persons.Scarlet", jcScarlet);
    checkBoxMap.put("Cards.Persons.Green", jcGreen);
    checkBoxMap.put("Cards.Persons.White", jcWhite);
    checkBoxMap.put("Cards.Persons.Plum", jcPlum);
}
private void initRealCluePaper(){
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

        jlGuests.setFont(new java.awt.Font(FONT_TYPE, 1, 14)); // NOI18N
        jlGuests.setText(LanguageStrings.getString("GameBoard.Guests"));

        jlRooms.setFont(new java.awt.Font(FONT_TYPE, 1, 14)); // NOI18N
        jlRooms.setText(LanguageStrings.getString("GameBoard.Rooms"));

        jlWeapons.setFont(new java.awt.Font(FONT_TYPE, 1, 14)); // NOI18N
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
        customizeCheckBox(jcHall, LanguageStrings.getString(HALL_KEY));
        customizeCheckBox(jcEatery, LanguageStrings.getString(EATERY_KEY));
        customizeCheckBox(jcKitchen, LanguageStrings.getString(KITCHEN_KEY));
        customizeCheckBox(jcTerrace, LanguageStrings.getString(TERRACE_KEY));
        customizeCheckBox(jcPlanetarium, LanguageStrings.getString(PLANETARIUM_KEY));
        customizeCheckBox(jcCinema, LanguageStrings.getString(CINEMA_KEY));
        customizeCheckBox(jcLivingRoom, LanguageStrings.getString(LIVINGROOM_KEY));
        customizeCheckBox(jcBath, LanguageStrings.getString(BATH_KEY));
        customizeCheckBox(jcGuestHouse, LanguageStrings.getString(GUESTHOUSE_KEY));
        
        customizeCheckBox(jcKnife, LanguageStrings.getString(KNIFE_KEY));

        customizeCheckBox(jcCandlestick, LanguageStrings.getString(CANDLESTICK_KEY));

        customizeCheckBox(jcRevolver, LanguageStrings.getString(REVOLVER_KEY));

        customizeCheckBox(jcPoison, LanguageStrings.getString(POISON_KEY));

        customizeCheckBox(jcTrophy, LanguageStrings.getString(TROPHY_KEY));

        customizeCheckBox(jcRope, LanguageStrings.getString(ROPE_KEY));

        customizeCheckBox(jcBat, LanguageStrings.getString(BAT_KEY));

        customizeCheckBox(jcAxe, LanguageStrings.getString(AXE_KEY));

        customizeCheckBox(jcDumbbell, LanguageStrings.getString(DUMBBELL_KEY));

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
}

private void initSuspectationPaper(){
    
        jlGuests = new javax.swing.JLabel();
        jlWeapons = new javax.swing.JLabel();
        jrbWhite = new JRadioButton();
        jrbKnife = new JRadioButton();
        jrbCandlestick = new JRadioButton();
        jrbRevolver = new JRadioButton();
        jrbPoison = new JRadioButton();
        jrbTrophy = new JRadioButton();
        jrbRope = new JRadioButton();
        jrbBat = new JRadioButton();
        jrbAxe = new JRadioButton();
        jrbDumbbell = new JRadioButton();

            setBackground(new java.awt.Color(180,0, 0));

  
        setMaximumSize(new java.awt.Dimension(403, 259));

        jlGuests.setFont(new java.awt.Font(FONT_TYPE, 1, 14)); // NOI18N
        jlGuests.setText(LanguageStrings.getString("GameBoard.Guests"));

        jlWeapons.setFont(new java.awt.Font(FONT_TYPE, 1, 14)); // NOI18N
        jlWeapons.setText(LanguageStrings.getString("GameBoard.Weapons"));
        jrbMustard = new JRadioButton();
        customizeRadioButton(jrbMustard, "Mustard");
        jrbPlum = new JRadioButton();
        customizeRadioButton(jrbPlum, "Plum");
        jrbGreen = new JRadioButton();
        customizeRadioButton(jrbGreen, "Green");
        jrbPeacock = new JRadioButton();
        customizeRadioButton(jrbPeacock, "Peacock");
        jrbScarlet = new JRadioButton();
        customizeRadioButton(jrbScarlet, "Scarlet");

        customizeRadioButton(jrbWhite, "White");
        
        customizeRadioButton(jrbKnife, LanguageStrings.getString(KNIFE_KEY));

        customizeRadioButton(jrbCandlestick, LanguageStrings.getString(CANDLESTICK_KEY));

        customizeRadioButton(jrbRevolver, LanguageStrings.getString(REVOLVER_KEY));

        customizeRadioButton(jrbPoison, LanguageStrings.getString(POISON_KEY));

        customizeRadioButton(jrbTrophy, LanguageStrings.getString(TROPHY_KEY));

        customizeRadioButton(jrbRope, LanguageStrings.getString(ROPE_KEY));

        customizeRadioButton(jrbBat, LanguageStrings.getString(BAT_KEY));

        customizeRadioButton(jrbAxe, LanguageStrings.getString(AXE_KEY));

        customizeRadioButton(jrbDumbbell, LanguageStrings.getString(DUMBBELL_KEY));
        bgGuests.add(jrbPeacock);
        bgGuests.add(jrbScarlet);
        bgGuests.add(jrbPlum);
        bgGuests.add(jrbGreen);
        bgGuests.add(jrbWhite);
        bgGuests.add(jrbMustard);
        bgWeapons.add(jrbAxe);
        bgWeapons.add(jrbDumbbell);
        bgWeapons.add(jrbCandlestick);
        bgWeapons.add(jrbRevolver);
        bgWeapons.add(jrbRope);
        bgWeapons.add(jrbPoison);
        bgWeapons.add(jrbBat);
        bgWeapons.add(jrbTrophy);
        bgWeapons.add(jrbKnife);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jrbWhite, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jrbScarlet, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jrbPlum, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                .addComponent(jrbGreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jrbPeacock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jlGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbMustard, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbDumbbell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jrbAxe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jrbKnife, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jrbCandlestick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlWeapons)
                        .addGap(0, 37, Short.MAX_VALUE))
                    .addComponent(jrbRevolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jrbPoison, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jrbTrophy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jrbRope, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jrbBat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))      
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
                            .addComponent(jlWeapons))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jrbKnife))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbMustard)
                    .addComponent(jrbCandlestick))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jrbPlum))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrbRevolver)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jrbGreen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrbPeacock)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrbScarlet)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrbWhite))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jrbPoison)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrbTrophy)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrbRope)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrbBat)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrbAxe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrbDumbbell)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        if(!suspect){
            initRealCluePaper();
        }else{
            initSuspectationPaper();
        }
        
    }// </editor-fold>//GEN-END:initComponents
    public void enableCheckBoxes(boolean enabled, Player player){
        if(!suspect){
        jcHall.setEnabled(enabled);
        jcEatery.setEnabled(enabled);
        jcKitchen.setEnabled(enabled);
        jcTerrace.setEnabled(enabled);
        jcPlanetarium.setEnabled(enabled);
        jcCinema.setEnabled(enabled);
        jcLivingRoom.setEnabled(enabled);
        jcBath.setEnabled(enabled);
        jcGuestHouse.setEnabled(enabled);
        jcAxe.setEnabled(enabled);
        jcCandlestick.setEnabled(enabled);
        jcRevolver.setEnabled(enabled);
        jcBat.setEnabled(enabled);
        jcKnife.setEnabled(enabled);
        jcPoison.setEnabled(enabled);
        jcRope.setEnabled(enabled);
        jcTrophy.setEnabled(enabled);
        jcDumbbell.setEnabled(enabled);
        jcWhite.setEnabled(enabled);
        jcMustard.setEnabled(enabled);
        jcPlum.setEnabled(enabled);
        jcPeacock.setEnabled(enabled);
        jcScarlet.setEnabled(enabled);
        jcGreen.setEnabled(enabled);
        if(enabled){
            markOwnedSuspectCards(player.getSuspectCards());
        }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ButtonGroup bgGuests=new ButtonGroup();
    private ButtonGroup bgWeapons=new ButtonGroup();
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
       jlWeapons.setText(LanguageStrings.getString("GameBoard.Weapons"));
       if(suspect){
           jrbKnife.setText(LanguageStrings.getString(KNIFE_KEY));
        jrbCandlestick.setText(LanguageStrings.getString(CANDLESTICK_KEY));
        jrbRevolver.setText(LanguageStrings.getString(REVOLVER_KEY));
        jrbPoison.setText(LanguageStrings.getString(POISON_KEY));
        jrbTrophy.setText(LanguageStrings.getString(TROPHY_KEY));
        jrbRope.setText(LanguageStrings.getString(ROPE_KEY));
        jrbBat.setText(LanguageStrings.getString(BAT_KEY));
        jrbAxe.setText(LanguageStrings.getString(AXE_KEY));
        jrbDumbbell.setText(LanguageStrings.getString(DUMBBELL_KEY));
       }else{ 
        jlRooms.setText(LanguageStrings.getString("GameBoard.Rooms"));
        jcKnife.setText(LanguageStrings.getString(KNIFE_KEY));
        jcCandlestick.setText(LanguageStrings.getString(CANDLESTICK_KEY));
        jcRevolver.setText(LanguageStrings.getString(REVOLVER_KEY));
        jcPoison.setText(LanguageStrings.getString(POISON_KEY));
        jcTrophy.setText(LanguageStrings.getString(TROPHY_KEY));
        jcRope.setText(LanguageStrings.getString(ROPE_KEY));
        jcBat.setText(LanguageStrings.getString(BAT_KEY));
        jcAxe.setText(LanguageStrings.getString(AXE_KEY));
        jcDumbbell.setText(LanguageStrings.getString(DUMBBELL_KEY));
        jcHall.setText(LanguageStrings.getString(HALL_KEY));
        jcEatery.setText(LanguageStrings.getString(EATERY_KEY));
        jcKitchen.setText(LanguageStrings.getString(KITCHEN_KEY));
        jcTerrace.setText(LanguageStrings.getString(TERRACE_KEY));
        jcPlanetarium.setText(LanguageStrings.getString(PLANETARIUM_KEY));
        jcCinema.setText(LanguageStrings.getString(CINEMA_KEY));
        jcLivingRoom.setText(LanguageStrings.getString(LIVINGROOM_KEY));
        jcBath.setText(LanguageStrings.getString(BATH_KEY));
        jcGuestHouse.setText(LanguageStrings.getString(GUESTHOUSE_KEY));
       }
    }

    public void markOwnedSuspectCards(List<Card> suspectCards) {
        for(Card c:suspectCards){
            JCheckBox checkBox=checkBoxMap.get(c.getUiStringKey());
            checkBox.setSelected(true);
            checkBox.setEnabled(false);
            
        }
    }
}