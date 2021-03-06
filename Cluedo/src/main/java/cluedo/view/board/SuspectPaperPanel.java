package cluedo.view.board;


import cluedo.logic.controller.GameController;
import static cluedo.tools.Tools.LOG;
import cluedo.tools.languagestring.LanguageStrings;
import cluedo.view.AbstractBaseWindow;
import static cluedo.view.board.CluePaperPanel.FONT_TYPE;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;


/**
 *This class responsible for the suspect view of the game in case of human player.
 */
public class SuspectPaperPanel extends javax.swing.JPanel {
private String selectedRoomKey;
 private String selectedGuestKey;
    private String selectedWeaponKey;
    private List<String> weaponKeys;
    private List<String> guestKeys;
    private final GameController gameController;

    public SuspectPaperPanel(GameController gameController) {
        this.gameController=gameController;
        selectedRoomKey=this.gameController.getActualPlayer().getActualRoomName();
        fillUpWeaponKeys();
        filUpGuestKeys();
        selectedGuestKey="";
        selectedWeaponKey="";
        initComponents();
    }
     private void filUpGuestKeys(){
        guestKeys=new ArrayList<>();
        guestKeys.add(CluePaperPanel.MUSTARD_CONST);
        guestKeys.add(CluePaperPanel.PEACOCK_CONST);
        guestKeys.add(CluePaperPanel.SCARLET_CONST);
        guestKeys.add(CluePaperPanel.GREEN_CONST);
        guestKeys.add(CluePaperPanel.WHITE_CONST);
        guestKeys.add(CluePaperPanel.PLUM_CONST);
    }
    private void fillUpWeaponKeys(){
        weaponKeys=new ArrayList<>();
        weaponKeys.add(CluePaperPanel.CANDLESTICK_KEY);
        weaponKeys.add(CluePaperPanel.KNIFE_KEY);
        weaponKeys.add(CluePaperPanel.REVOLVER_KEY);
        weaponKeys.add(CluePaperPanel.POISON_KEY);
        weaponKeys.add(CluePaperPanel.ROPE_KEY);
        weaponKeys.add(CluePaperPanel.TROPHY_KEY);
        weaponKeys.add(CluePaperPanel.BAT_KEY);
        weaponKeys.add(CluePaperPanel.AXE_KEY);
        weaponKeys.add(CluePaperPanel.DUMBBELL_KEY);
    }
private void customizeRadioButton(JRadioButton radioButton, String title){
    radioButton.setBackground(new Color(180, 0, 0));
    radioButton.setFont(new java.awt.Font(FONT_TYPE, 0, 12)); // NOI18N
    radioButton.setText(title);
    radioButton.addActionListener((ActionEvent evt) -> suspectButtonActionPerformed(evt));
    if(title.equals(LanguageStrings.getString(selectedRoomKey))){
        radioButton.setSelected(true);
    }
}
public void resetStrings(){
    jlGuests.setText(LanguageStrings.getString(CluePaperPanel.GAMEBOARD_GUEST_CONST));
       jlWeapons.setText(LanguageStrings.getString(CluePaperPanel.GAMEBOARD_WEAPON_CONST));
       jlRooms.setText(LanguageStrings.getString(CluePaperPanel.GAMEBOARD_ROOM_CONST));
        jrbKnife.setText(LanguageStrings.getString(CluePaperPanel.KNIFE_KEY));
        jrbCandleStick.setText(LanguageStrings.getString(CluePaperPanel.CANDLESTICK_KEY));
        jrbRevolver.setText(LanguageStrings.getString(CluePaperPanel.REVOLVER_KEY));
        jrbPoison.setText(LanguageStrings.getString(CluePaperPanel.POISON_KEY));
        jrbTrophy.setText(LanguageStrings.getString(CluePaperPanel.TROPHY_KEY));
        jrbRope.setText(LanguageStrings.getString(CluePaperPanel.ROPE_KEY));
        jrbBat.setText(LanguageStrings.getString(CluePaperPanel.BAT_KEY));
        jrbAxe.setText(LanguageStrings.getString(CluePaperPanel.AXE_KEY));
        jrbDumbbell.setText(LanguageStrings.getString(CluePaperPanel.DUMBBELL_KEY));
        jrbHall.setText(LanguageStrings.getString(CluePaperPanel.HALL_KEY));
        jrbEatery.setText(LanguageStrings.getString(CluePaperPanel.EATERY_KEY));
        jrbKitchen.setText(LanguageStrings.getString(CluePaperPanel.KITCHEN_KEY));
        jrbTerrace.setText(LanguageStrings.getString(CluePaperPanel.TERRACE_KEY));
        jrbPlanetarium.setText(LanguageStrings.getString(CluePaperPanel.PLANETARIUM_KEY));
        jrbCinema.setText(LanguageStrings.getString(CluePaperPanel.CINEMA_KEY));
        jrbLivingRoom.setText(LanguageStrings.getString(CluePaperPanel.LIVINGROOM_KEY));
        jrbBath.setText(LanguageStrings.getString(CluePaperPanel.BATH_KEY));
        jrbGuestHouse.setText(LanguageStrings.getString(CluePaperPanel.GUESTHOUSE_KEY));
        chooseButton.setText(LanguageStrings.getString("Suspect.Choose"));
}
private void suspectButtonActionPerformed(ActionEvent evt){
    JRadioButton button=(JRadioButton)evt.getSource();
    String text=button.getText();
    int i=findTextOfButton(text, weaponKeys, true);
    if(i==-1){
        i=findTextOfButton(text, guestKeys, false);
        selectedGuestKey=guestKeys.get(i);
        LOG.log(Level.INFO, "Selected guest to suspect: {0}",selectedGuestKey);
    }else{
        selectedWeaponKey=weaponKeys.get(i);
        LOG.log(Level.INFO, "Selected weapon to suspect: {0}",selectedWeaponKey);
    }
    
}
private int findTextOfButton(String text, List<String> list, boolean isWeapon){
    int i=0;
    boolean found=false;
    while(i<list.size() && !found){
        String value=list.get(i);
        if(isWeapon){
        value=LanguageStrings.getString(list.get(i));
        if(value==null){
            value="";
        }
        }
        found=value.equals(text);
            i+=1;
    }
    int foundIndex=-1;
    if(found){
        foundIndex=i-1;
    }
    return foundIndex;
}
private void jbChooseActionPerformed(){
        String selectedWeapon="";
        if(!selectedWeaponKey.equals("")){
            selectedWeapon=LanguageStrings.getString(selectedWeaponKey);
        }
    String message=LanguageStrings.getString("Suspect.SelectedOptions")+System.lineSeparator()+selectedGuestKey+", "+selectedWeapon+", "+LanguageStrings.getString(selectedRoomKey)+System.lineSeparator();
    if(selectedGuestKey.equals("")||selectedWeaponKey.equals("")){
        
        AbstractBaseWindow.showErrorMessage(message+LanguageStrings.getString("Suspect.MustChooseGuestAndWeapon"));
    }else{
        int answer=AbstractBaseWindow.showConfirmation(message+LanguageStrings.getString("Suspect.SureToChooseTheeseObjects"), null);
        if(answer==JOptionPane.YES_OPTION){
            gameController.humanPlayerSuspectCards(selectedGuestKey, selectedWeaponKey, selectedRoomKey);
        }
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.ButtonGroup bgGuests = new javax.swing.ButtonGroup();
        javax.swing.ButtonGroup bgWeapons = new javax.swing.ButtonGroup();
        javax.swing.JPanel jpBase = new javax.swing.JPanel();
        jlWeapons = new javax.swing.JLabel();
        jlRooms = new javax.swing.JLabel();
        jlGuests = new javax.swing.JLabel();
        JRadioButton jrbMustard = new JRadioButton();
        JRadioButton jrbPlum = new JRadioButton();
        JRadioButton jrbGreen = new JRadioButton();
        JRadioButton jrbPeacock = new JRadioButton();
        JRadioButton jrbScarlet = new JRadioButton();
        JRadioButton jrbWhite = new JRadioButton();
        jrbKnife = new JRadioButton();
        jrbCandleStick = new JRadioButton();
        jrbRevolver = new JRadioButton();
        jrbPoison = new JRadioButton();
        jrbTrophy = new JRadioButton();
        jrbRope = new JRadioButton();
        jrbBat = new JRadioButton();
        jrbAxe = new JRadioButton();
        jrbDumbbell = new JRadioButton();
        jrbHall = new JRadioButton();
        jrbEatery = new JRadioButton();
        jrbKitchen = new JRadioButton();
        jrbTerrace = new JRadioButton();
        jrbPlanetarium = new JRadioButton();
        jrbCinema = new JRadioButton();
        jrbLivingRoom = new JRadioButton();
        jrbBath = new JRadioButton();
        jrbGuestHouse = new JRadioButton();
        chooseButton = new javax.swing.JButton(LanguageStrings.getString("Suspect.Choose"));

        jpBase.setBackground(new Color(180, 0, 0));

        jlWeapons.setFont(new java.awt.Font(FONT_TYPE, 1, 14));
        jlWeapons.setText(LanguageStrings.getString(CluePaperPanel.GAMEBOARD_WEAPON_CONST));

        jlRooms.setFont(new java.awt.Font(FONT_TYPE, 1, 14));
        jlRooms.setText(LanguageStrings.getString("GameBoard.Rooms"));

        jlGuests.setFont(new java.awt.Font(FONT_TYPE, 1, 14));
        jlGuests.setText(LanguageStrings.getString(CluePaperPanel.GAMEBOARD_GUEST_CONST));

        customizeRadioButton(jrbMustard, CluePaperPanel.MUSTARD_CONST);
        bgGuests.add(jrbMustard);

        customizeRadioButton(jrbPlum, CluePaperPanel.PLUM_CONST);
        bgGuests.add(jrbPlum);

        customizeRadioButton(jrbGreen, CluePaperPanel.GREEN_CONST);
        bgGuests.add(jrbGreen);

        customizeRadioButton(jrbPeacock, CluePaperPanel.PEACOCK_CONST);
        bgGuests.add(jrbPeacock);

        customizeRadioButton(jrbScarlet, CluePaperPanel.SCARLET_CONST);
        bgGuests.add(jrbScarlet);

        customizeRadioButton(jrbWhite, CluePaperPanel.WHITE_CONST);
        bgGuests.add(jrbWhite);

        customizeRadioButton(jrbKnife, LanguageStrings.getString(CluePaperPanel.KNIFE_KEY));
        bgWeapons.add(jrbKnife);

        customizeRadioButton(jrbCandleStick, LanguageStrings.getString(CluePaperPanel.CANDLESTICK_KEY));
        bgWeapons.add(jrbCandleStick);

        customizeRadioButton(jrbRevolver, LanguageStrings.getString(CluePaperPanel.REVOLVER_KEY));
        bgWeapons.add(jrbRevolver);

        customizeRadioButton(jrbPoison, LanguageStrings.getString(CluePaperPanel.POISON_KEY));
        bgWeapons.add(jrbPoison);

        customizeRadioButton(jrbTrophy, LanguageStrings.getString(CluePaperPanel.TROPHY_KEY));
        bgWeapons.add(jrbTrophy);

        customizeRadioButton(jrbRope, LanguageStrings.getString(CluePaperPanel.ROPE_KEY));
        bgWeapons.add(jrbRope);

        customizeRadioButton(jrbBat, LanguageStrings.getString(CluePaperPanel.BAT_KEY));
        bgWeapons.add(jrbBat);

        customizeRadioButton(jrbAxe, LanguageStrings.getString(CluePaperPanel.AXE_KEY));
        bgWeapons.add(jrbAxe);

        customizeRadioButton(jrbDumbbell, LanguageStrings.getString(CluePaperPanel.DUMBBELL_KEY));
        bgWeapons.add(jrbDumbbell);

        customizeRadioButton(jrbHall, LanguageStrings.getString(CluePaperPanel.HALL_KEY));
        jrbHall.setEnabled(false);

        customizeRadioButton(jrbEatery, LanguageStrings.getString(CluePaperPanel.EATERY_KEY));
        jrbEatery.setEnabled(false);

        customizeRadioButton(jrbKitchen, LanguageStrings.getString(CluePaperPanel.KITCHEN_KEY));
        jrbKitchen.setEnabled(false);

        customizeRadioButton(jrbTerrace, LanguageStrings.getString(CluePaperPanel.TERRACE_KEY));
        jrbTerrace.setEnabled(false);

        customizeRadioButton(jrbPlanetarium, LanguageStrings.getString(CluePaperPanel.PLANETARIUM_KEY));
        jrbPlanetarium.setEnabled(false);

        customizeRadioButton(jrbCinema, LanguageStrings.getString(CluePaperPanel.CINEMA_KEY));
        jrbCinema.setEnabled(false);

        customizeRadioButton(jrbLivingRoom, LanguageStrings.getString(CluePaperPanel.LIVINGROOM_KEY));
        jrbLivingRoom.setEnabled(false);

        customizeRadioButton(jrbBath, LanguageStrings.getString(CluePaperPanel.BATH_KEY));
        jrbBath.setEnabled(false);

        customizeRadioButton(jrbGuestHouse, LanguageStrings.getString(CluePaperPanel.GUESTHOUSE_KEY));
        jrbGuestHouse.setEnabled(false);

        chooseButton.addActionListener((ActionEvent evt) -> jbChooseActionPerformed());
        chooseButton.setBackground(new Color(255, 30, 21));
        chooseButton.setFont(new java.awt.Font(FONT_TYPE, 1, 12));

        javax.swing.GroupLayout jpBaseLayout = new javax.swing.GroupLayout(jpBase);
        jpBase.setLayout(jpBaseLayout);
        jpBaseLayout.setHorizontalGroup(
            jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBaseLayout.createSequentialGroup()
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBaseLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jrbPeacock, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(jrbScarlet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jrbWhite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jpBaseLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBaseLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbGreen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jrbPlum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jrbMustard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(66, 66, 66)
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpBaseLayout.createSequentialGroup()
                        .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jrbDumbbell, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(jrbAxe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jrbBat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jrbRope, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jrbTrophy, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jrbCinema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jrbLivingRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jrbBath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jrbGuestHouse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jrbPlanetarium, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)))
                    .addGroup(jpBaseLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jrbTerrace, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpBaseLayout.createSequentialGroup()
                        .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpBaseLayout.createSequentialGroup()
                                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jrbPoison, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                    .addComponent(jrbRevolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(90, 90, 90))
                            .addGroup(jpBaseLayout.createSequentialGroup()
                                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jrbKnife, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                        .addComponent(jrbCandleStick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jlWeapons))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlRooms, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jrbKitchen, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                .addComponent(jrbEatery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jrbHall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(55, 55, 55))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBaseLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(chooseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199))
        );
        jpBaseLayout.setVerticalGroup(
            jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlWeapons)
                    .addComponent(jlRooms, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbHall, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jrbMustard)
                        .addComponent(jrbKnife)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbPlum)
                    .addComponent(jrbCandleStick)
                    .addComponent(jrbEatery))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbRevolver)
                    .addComponent(jrbGreen)
                    .addComponent(jrbKitchen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbPeacock)
                    .addComponent(jrbPoison)
                    .addComponent(jrbTerrace))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbTrophy)
                    .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jrbScarlet)
                        .addComponent(jrbPlanetarium)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbWhite)
                    .addComponent(jrbRope)
                    .addComponent(jrbCinema))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbBat)
                    .addComponent(jrbLivingRoom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbBath)
                    .addComponent(jrbAxe, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbGuestHouse)
                    .addComponent(jrbDumbbell))
                .addGap(10, 10, 10)
                .addComponent(chooseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    
    
    private javax.swing.JButton chooseButton;
    private javax.swing.JLabel jlGuests;
    private javax.swing.JLabel jlRooms;
    private javax.swing.JLabel jlWeapons;
    
    private JRadioButton jrbAxe;
    private JRadioButton jrbBat;
    private JRadioButton jrbBath;
    private JRadioButton jrbCandleStick;
    private JRadioButton jrbCinema;
    private JRadioButton jrbDumbbell;
    private JRadioButton jrbEatery;
    
    private JRadioButton jrbGuestHouse;
    private JRadioButton jrbHall;
    private JRadioButton jrbKitchen;
    private JRadioButton jrbKnife;
    private JRadioButton jrbLivingRoom;
    
    
    private JRadioButton jrbPlanetarium;
    
    private JRadioButton jrbPoison;
    private JRadioButton jrbRevolver;
    private JRadioButton jrbRope;
    
    private JRadioButton jrbTerrace;
    private JRadioButton jrbTrophy;
    
    // End of variables declaration//GEN-END:variables
}
