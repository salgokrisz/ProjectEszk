/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.players;

import javax.swing.ImageIcon;

/**
 *
 * @author Barby
 */
public abstract class Role {
    protected final boolean isComputer;
    protected Color color;
    protected boolean abilityIsAvailable;
    protected final String playerName;
    public static String abilityDescription;
    public static ImageIcon image;
    public Role(boolean isComputer, String playerName){
        abilityIsAvailable=true;
        this.isComputer=isComputer;
        this.playerName=playerName;
    }

    public static ImageIcon getImage() {
        return image;
    }

    public static String getAbilityDescription() {
        return abilityDescription;
    }
   
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean getAbilityIsAvailable() {
        return abilityIsAvailable;
    }

    public void setAbilityIsAvailable(boolean abilityIsAvailable) {
        this.abilityIsAvailable = abilityIsAvailable;
    }

    public boolean getIsComputer() {
        return isComputer;
    }

    public String getPlayerName() {
        return playerName;
    }
    
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(playerName).append("; ").append(color.toString()).append(System.lineSeparator());
        sb.append("Képesség: ").append(System.lineSeparator()).append(abilityDescription).append(System.lineSeparator()).append("Képessége elérhető: ").append(System.lineSeparator());
        appendBooleanValue(sb, abilityIsAvailable);
        sb.append(";").append( "Számítógép játsza: ");
        appendBooleanValue(sb, isComputer);
        return sb.toString();
    }
    private void appendBooleanValue(StringBuilder sb, boolean condition){
        if(condition){
            sb.append("Igen");
        }else{
             sb.append("Nem");
        }
    }
    public abstract void useSpecialAbility();
}
