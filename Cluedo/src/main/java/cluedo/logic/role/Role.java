/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.logic.role;

import javax.swing.ImageIcon;

/**
 *
 * @author Barby
 */
public abstract class Role {
   
    protected Color color;
    protected boolean abilityIsAvailable;
    protected final String name;
    public static String abilityDescription;
    public static ImageIcon image;
    public Role( String name){
        abilityIsAvailable=true;
        this.name=name;
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

    

    public String getPlayerName() {
        return name;
    }
    
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(name).append("; ").append(color.toString()).append(System.lineSeparator());
        sb.append("Képesség: ").append(System.lineSeparator()).append(abilityDescription).append(System.lineSeparator()).append("Képessége elérhető: ").append(System.lineSeparator());
        appendBooleanValue(sb, abilityIsAvailable);
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
